package com.muravyovdmitr.pagingarccompnentsample.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muravyovdmitr.pagingarccompnentsample.R
import com.muravyovdmitr.pagingarccompnentsample.app.App
import com.muravyovdmitr.pagingarccompnentsample.db.deleteLast100Items
import com.muravyovdmitr.pagingarccompnentsample.db.generateNext100Items
import com.muravyovdmitr.pagingarccompnentsample.paging.ItemAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.experimental.async

class MainFragment : Fragment() {

	companion object {
		fun newInstance() = MainFragment()
	}

	private lateinit var viewModel: MainViewModel

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
							  savedInstanceState: Bundle?): View {
		return inflater.inflate(R.layout.main_fragment, container, false)
	}

	override fun onActivityCreated(savedInstanceState: Bundle?) {
		super.onActivityCreated(savedInstanceState)
		viewModel = ViewModelProviders
				.of(this, MainViewModelFactory(App.INSTANCE.itemsDao))
				.get(MainViewModel::class.java)

		initList()
		initListeners()
	}

	private fun initList() {
		rvList.layoutManager = LinearLayoutManager(this.context)
		rvList.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))

		val adapter = ItemAdapter()
		viewModel
				.itemsList
				.observe(this, Observer { pagedList -> adapter.submitList(pagedList) })
		rvList.adapter = adapter
	}

	private fun initListeners() {
		bAddItems.setOnClickListener {
			async {
				App.INSTANCE.itemsDao.generateNext100Items()
			}
		}
		bRemoveItems.setOnClickListener {
			async {
				App.INSTANCE.itemsDao.deleteLast100Items()
			}
		}
	}
}