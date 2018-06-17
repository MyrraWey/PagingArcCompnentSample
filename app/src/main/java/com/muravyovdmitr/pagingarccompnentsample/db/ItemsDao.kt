package com.muravyovdmitr.pagingarccompnentsample.db

import android.arch.paging.DataSource
import android.arch.persistence.room.*
import com.muravyovdmitr.pagingarccompnentsample.paging.Item


/**
 * Created by Dima Muravyov on 18.06.2018.
 */
@Dao
interface ItemsDao {

	@Insert
	fun insert(vararg item: Item)

	@Update
	fun update(vararg item: Item)

	@Delete
	fun delete(vararg item: Item)

	@Query("SELECT * FROM items")
	fun getAllItems(): DataSource.Factory<Int, Item>

	@Query("DELETE FROM items WHERE id = :id")
	fun delete(id: Int)

	@Query("SELECT MAX(id) FROM items")
	fun getMaxItemId(): Int
}

fun ItemsDao.generateNext100Items() {
	var id = getMaxItemId()
	val maxId = id + 100
	val items = mutableListOf<Item>()
	while (++id <= maxId) {
		items += Item(id, "Item #$id")
	}
	insert(*items.toTypedArray())
}

fun ItemsDao.deleteLast100Items() {
	val lastId = getMaxItemId().let { if (it > 0) it else 0 }
	var startId = (lastId - 100).let { if (it > 0) it else 0 }
	val items = mutableListOf<Item>()
	while (startId <= lastId) {
		delete(startId++)
	}
	insert(*items.toTypedArray())
}