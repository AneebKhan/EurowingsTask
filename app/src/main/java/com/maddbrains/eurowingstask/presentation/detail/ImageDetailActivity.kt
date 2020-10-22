package com.maddbrains.eurowingstask.presentation.detail

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.maddbrains.eurowingstask.R
import com.maddbrains.eurowingstask.domain.model.Image
import com.maddbrains.eurowingstask.presentation.base.BaseActivity
import com.maddbrains.eurowingstask.presentation.util.Constants
import kotlinx.android.synthetic.main.activity_image_details.*

class ImageDetailActivity : BaseActivity<ImageDetailViewModel>(R.layout.activity_image_details) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun observeViewModel() {
        viewModel.getImageLiveData().observe(this, Observer { image ->
            Glide.with(this).load(image.imageUrl).into(imgFeed)
            tvTitle.text = image.title
            tvDesc.text = image.description
            tvUpVote.text = "${image.ups}"
            tvDownVote.text = "${image.downs}"
            tvScore.text = "${image.score}"
        })
    }

    override fun createdViewModel(): ImageDetailViewModel {
        var factory = ImageDetailViewModelFactory()
        val image: Image = intent.getParcelableExtra(Constants.BUNDLE_EXTRA_IMAGE)
        factory.image = image
        return ViewModelProviders.of(this, factory).get(ImageDetailViewModel::class.java)
    }

    override fun init() {
        viewModel.loadData()
        observeViewModel()
    }

    override fun setEvents() {
    }
}