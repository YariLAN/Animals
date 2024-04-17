package ru.ygmatveev.puppies.DbModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Animals")
data class AnimalDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "location")
    var location: String,

    @ColumnInfo(name = "fact_1")
    var fact1: String,

    @ColumnInfo(name = "fact_2")
    var fact2: String
)