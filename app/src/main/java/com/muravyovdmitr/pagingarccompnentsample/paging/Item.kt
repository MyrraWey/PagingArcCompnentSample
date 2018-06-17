package com.muravyovdmitr.pagingarccompnentsample.paging

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by Dima Muravyov on 17.06.2018.
 */
@Entity(tableName = "items")
class Item(
		@PrimaryKey val id: Int,
		val name: String)