package com.tematihonov.testpizza.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tematihonov.testpizza.utils.RoomConstants.PRODUCTS_TABLE

@Entity(tableName = PRODUCTS_TABLE)
data class ProductEntity(
    @ColumnInfo(name ="category")
    val category: String,
    @ColumnInfo(name ="description")
    val description: String,
    @PrimaryKey
    @ColumnInfo(name ="id")
    val id: Int,
    @ColumnInfo(name ="img")
    val img: String,
    @ColumnInfo(name ="name")
    val name: String,
    @ColumnInfo(name ="price")
    val price: Int
)