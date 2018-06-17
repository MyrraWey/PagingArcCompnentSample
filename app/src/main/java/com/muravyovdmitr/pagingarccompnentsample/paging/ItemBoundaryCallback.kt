package com.muravyovdmitr.pagingarccompnentsample.paging

import android.arch.paging.PagedList


/**
 * Created by Dima Muravyov on 18.06.2018.
 */
class ItemBoundaryCallback : PagedList.BoundaryCallback<Item>() {

	override fun onZeroItemsLoaded() {
		super.onZeroItemsLoaded()
	}

	override fun onItemAtEndLoaded(itemAtEnd: Item) {
		super.onItemAtEndLoaded(itemAtEnd)
	}

	override fun onItemAtFrontLoaded(itemAtFront: Item) {
		super.onItemAtFrontLoaded(itemAtFront)
	}
}