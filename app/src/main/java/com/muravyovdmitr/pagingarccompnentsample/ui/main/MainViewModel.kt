package com.muravyovdmitr.pagingarccompnentsample.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.muravyovdmitr.pagingarccompnentsample.db.ItemsDao
import com.muravyovdmitr.pagingarccompnentsample.paging.Item
import com.muravyovdmitr.pagingarccompnentsample.paging.ItemBoundaryCallback

class MainViewModel(private val itemsDao: ItemsDao) : ViewModel() {

	val itemsList: LiveData<PagedList<Item>> = run {
		LivePagedListBuilder(itemsDao.getAllItems(), 40)
				.setBoundaryCallback(ItemBoundaryCallback())
				.build()
	}
}
