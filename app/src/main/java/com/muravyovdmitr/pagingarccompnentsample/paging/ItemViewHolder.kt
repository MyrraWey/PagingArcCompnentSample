package com.muravyovdmitr.pagingarccompnentsample.paging

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


/**
 * Created by Dima Muravyov on 17.06.2018.
 */
class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

	companion object {

		fun create(parent: ViewGroup): ItemViewHolder =
				LayoutInflater
						.from(parent.context)
						.inflate(android.R.layout.simple_list_item_1, parent, false)
						.let { view -> ItemViewHolder(view) }
	}

	private lateinit var tvTitle: TextView

	fun bind(item: Item?) {
		tvTitle = itemView.findViewById(android.R.id.text1)

		update(item)
	}

	fun update(item: Item?) {
		tvTitle.text = item?.name ?: "Item is NULL:("
	}
}