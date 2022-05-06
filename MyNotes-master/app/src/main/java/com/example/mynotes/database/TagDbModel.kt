package com.example.mynotes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TagDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "hex") val hex: String,
    @ColumnInfo(name = "name") val name: String
) {
    companion object {
        val DEFAULT_TAGS = listOf(
            TagDbModel(1, "#FFFFFF", "Home"),
            TagDbModel(2, "#FFFFFF", "Family"),
            TagDbModel(3, "#FFFFFF", "Mobile"),
            TagDbModel(4, "#FFFFFF", "Work"),
            TagDbModel(5, "#FFFFFF", "etc"),

        )
        val DEFAULT_TAG = DEFAULT_TAGS[0]
    }
}
