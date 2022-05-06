package com.example.mynotes.domain.model

import android.nfc.Tag
import com.example.mynotes.database.ColorDbModel
import com.example.mynotes.database.TagDbModel

data class TagModel(
    val id: Long,
    val name: String,
    val hex: String
) {
    companion object {
        val DEFAULT = with(TagDbModel.DEFAULT_TAG) { TagModel(id, name, hex) }
    }
}
