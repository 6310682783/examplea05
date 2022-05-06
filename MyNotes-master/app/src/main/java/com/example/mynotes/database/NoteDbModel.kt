package com.example.mynotes.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteDbModel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "firstname") val firstname: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "can_be_checked_off") val canBeCheckedOff: Boolean,
    @ColumnInfo(name = "is_checked_off") val isCheckedOff: Boolean,
    @ColumnInfo(name = "in_trash") val isInTrash: Boolean,
    @ColumnInfo(name = "color_id") val colorId: Long,
    @ColumnInfo(name = "tag_id") val tagId: Long

) {
    companion object {

        val DEFAULT_NOTES = listOf(
            NoteDbModel(1, "0123456789", "John", "Kotlin","RW Meeting", "Prepare sample project", false, false, false,1, 1),
            NoteDbModel(2, "0123456789", "John", "Kotlin", "Bills", "Pay by tomorrow", false, false, false,1, 1),
            NoteDbModel(3, "0123456789", "John", "Kotlin", "Pancake recipe", "Milk, eggs, salt, flour...", false, false, false,1, 1),
            NoteDbModel(4, "0123456789", "John", "Kotlin", "Workout", "Running, push ups, pull ups, squats...", false, false, false,1, 1),
            NoteDbModel(5, "0123456789", "John", "Kotlin", "Title 5", "Content 5", false, false, false,1, 1),
            NoteDbModel(6, "0123456789", "John", "Kotlin", "Title 6", "Content 6", false, false, false,1, 1),
            NoteDbModel(7, "0123456789", "John", "Kotlin", "Title 7", "Content 7", false, false, false,1, 1),

            //NoteDbModel(8,"0123456789", "John", "Kotlin", "Title 8", "Content 8", false, false, 8, false),
            //NoteDbModel(9,"0123456789", "John", "Kotlin", "Title 9", "Content 9", false, false, 9, false),
            //NoteDbModel(10,"0123456789", "John", "Kotlin","Title 10", "Content 10", false, false, 10, false),
            //NoteDbModel(11,"0123456789", "John", "Kotlin", "Title 11", "Content 11", true, false, 11, false),
            //NoteDbModel(12,"0123456789", "John", "Kotlin", "Title 12", "Content 12", true, false, 12, false)
        )
    }
}
