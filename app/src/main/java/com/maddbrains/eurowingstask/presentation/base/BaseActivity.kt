package com.maddbrains.eurowingstask.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<VM : BaseViewModel>(
    @LayoutRes private val resId : Int
) : AppCompatActivity() {

    protected lateinit var viewModel :VM

    protected abstract fun createdViewModel() : VM

    protected abstract fun init()

    protected abstract fun setEvents()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =createdViewModel()
        setContentView(resId)
        init()
        setEvents()
    }
}