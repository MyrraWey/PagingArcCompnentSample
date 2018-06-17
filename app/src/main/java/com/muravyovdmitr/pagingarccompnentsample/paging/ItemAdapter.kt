package com.muravyovdmitr.pagingarccompnentsample.paging

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.ViewGroup


/**
 * Created by Dima Muravyov on 17.06.2018.
 */
class ItemAdapter(diffCallback: DiffUtil.ItemCallback<Item> = DIFF_CALLBACK)
	: PagedListAdapter<Item, ItemViewHolder>(diffCallback) {

	companion object {

		private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {

			override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.id == newItem.id

			override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem.name == newItem.name
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
			ItemViewHolder.create(parent)

	override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
		getItem(position)
				?.let { holder.bind(it) }
	}

	override fun onBindViewHolder(holder: ItemViewHolder, position: Int, payloads: MutableList<Any>) {
		if (payloads.isNotEmpty()) {
			holder.update(getItem(position))
		} else {
			onBindViewHolder(holder, position)
		}
	}
}