package com.muravyovdmitr.pagingarccompnentsample.app

import android.app.Application
import com.muravyovdmitr.pagingarccompnentsample.db.AppDb
import com.muravyovdmitr.pagingarccompnentsample.db.ItemsDao


/**
 * Created by Dima Muravyov on 18.06.2018.
 */
class App : Application() {

	companion object {
		lateinit var INSTANCE: App
			private set
	}

	private val db by lazy { AppDb.create(this) }
	val itemsDao: ItemsDao by lazy { db.itemsDao() }

	override fun onCreate() {
		super.onCreate()
		INSTANCE = this
	}
}