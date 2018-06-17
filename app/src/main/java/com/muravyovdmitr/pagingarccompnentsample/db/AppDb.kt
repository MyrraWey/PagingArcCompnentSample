package com.muravyovdmitr.pagingarccompnentsample.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.muravyovdmitr.pagingarccompnentsample.paging.Item


/**
 * Created by Dima Muravyov on 18.06.2018.
 */
@Database(
		entities = [Item::class],
		version = 1)
abstract class AppDb : RoomDatabase() {

	companion object {

		fun create(context: Context): AppDb =
				Room
						.databaseBuilder(context, AppDb::class.java, "appDb")
						.fallbackToDestructiveMigration()
						.build()
	}

	abstract fun itemsDao(): ItemsDao
}