package com.muravyovdmitr.pagingarccompnentsample.ui.main

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.muravyovdmitr.pagingarccompnentsample.db.ItemsDao

class MainViewModelFactory(private val itemsDao: ItemsDao) : ViewModelProvider.NewInstanceFactory() {

	override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainViewModel(itemsDao) as T
}
