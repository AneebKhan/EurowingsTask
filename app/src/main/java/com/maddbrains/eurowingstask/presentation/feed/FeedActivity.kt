package com.maddbrains.eurowingstask.presentation.feed

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.maddbrains.eurowingstask.R
import com.maddbrains.eurowingstask.data.api.ImageApi
import com.maddbrains.eurowingstask.data.db.AppDatabase
import com.maddbrains.eurowingstask.data.repository.ImageRepository
import com.maddbrains.eurowingstask.domain.model.Image
import com.maddbrains.eurowingstask.presentation.base.BaseActivity
import com.maddbrains.eurowingstask.presentation.detail.ImageDetailActivity
import com.maddbrains.eurowingstask.presentation.util.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_filter.view.*

class FeedActivity : BaseActivity<FeedViewModel>(R.layout.activity_main), FeedListener {

    private var imageAdapter = ImageAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun createdViewModel(): FeedViewModel {
        val api = ImageApi()
        val db = AppDatabase(this)
        val repository = ImageRepository(api, db)
        val factory = FeedViewModelFactory(repository)

        return ViewModelProviders.of(this, factory).get(FeedViewModel::class.java)
    }

    override fun init() {
        progressBar.show()

        if (NetworkUtil.isConnectedToInternet(applicationContext))
            viewModel.getGalleryImages("hot", "viral", "top")
        else
            viewModel.getCachedGalleryImages()
    }

    override fun setEvents() {
        viewModel.feedListener = this

        val views = resources.getStringArray(R.array.views)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, views)
        spSwitchView.adapter = adapter

        spSwitchView.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                when (views[position]) {
                    Constants.DATA_GRID_VIEW -> populateGridView()
                    Constants.DATA_LIST_VIEW -> populateListView()
                    Constants.DATA_STAGGERED_VIEW -> populateStaggeredGridView()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }

        imageAdapter.setImageClickListener {
            val starter = Intent(this, ImageDetailActivity::class.java)
            starter.putExtra(Constants.BUNDLE_EXTRA_IMAGE, it)
            startActivity(starter)
        }

        btnFilter.setOnClickListener {
            showFilterDialog()
        }
    }

    private fun populateListView() {
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = imageAdapter
    }

    private fun populateGridView() {
        val gridLayoutManager = GridLayoutManager(this, Constants.STAGGERED_GRID_COUNT)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = imageAdapter
    }

    private fun populateStaggeredGridView() {
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        recyclerView.layoutManager = staggeredGridLayoutManager
        recyclerView.adapter = imageAdapter
    }

    override fun onSuccess(imgList: List<Image>) {
        progressBar.hide()
        imageAdapter.setItems(imgList)
    }

    override fun onFailure(message: String) {
        progressBar.hide()
        toast(message)
    }

    private fun showFilterDialog() {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_filter, null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(R.string.title_filter)
        val mAlertDialog = mBuilder.show()

        val sections = resources.getStringArray(R.array.sections)
        val sectionsAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sections)
        mDialogView.spSection.adapter = sectionsAdapter

        val sort = resources.getStringArray(R.array.sort)
        val sortAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sort)
        mDialogView.spSortBy.adapter = sortAdapter

        val window = resources.getStringArray(R.array.window)
        val windowAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, window)
        mDialogView.spWindow.adapter = windowAdapter

        mDialogView.btnFilter.setOnClickListener {
            mAlertDialog.dismiss()
            progressBar.show()
            viewModel.getGalleryImages(mDialogView.spSection.selectedItem.toString(), mDialogView.spSortBy.selectedItem.toString(), mDialogView.spWindow.selectedItem.toString())

        }
    }
}