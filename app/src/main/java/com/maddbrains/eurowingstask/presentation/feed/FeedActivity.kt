package com.maddbrains.eurowingstask.presentation.feed

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.maddbrains.eurowingstask.R
import com.maddbrains.eurowingstask.data.api.ImageApi
import com.maddbrains.eurowingstask.data.db.AppDatabase
import com.maddbrains.eurowingstask.data.repository.ImageRepository
import com.maddbrains.eurowingstask.presentation.base.BaseActivity
import com.maddbrains.eurowingstask.presentation.util.NetworkUtil
import com.maddbrains.eurowingstask.presentation.util.show
import kotlinx.android.synthetic.main.activity_main.*

class FeedActivity : BaseActivity<FeedViewModel>(R.layout.activity_main) {

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
    }
}