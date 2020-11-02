package com.maddbrains.imgur.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maddbrains.imgur.domain.model.Image
import com.maddbrains.imgur.presentation.base.BaseViewModel

class ImageDetailViewModel(
    private val image : Image? = null
) : BaseViewModel() {

    private val imageLiveData = MutableLiveData<Image>()

    fun loadData() {
        image?.let {
            imageLiveData.postValue(it)
        }
    }

    fun getImageLiveData(): LiveData<Image> = imageLiveData

}