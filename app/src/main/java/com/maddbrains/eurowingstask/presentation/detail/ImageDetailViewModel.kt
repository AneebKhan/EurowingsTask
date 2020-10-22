package com.maddbrains.eurowingstask.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.maddbrains.eurowingstask.domain.model.Image
import com.maddbrains.eurowingstask.presentation.base.BaseViewModel

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