package com.example.mynotes.database

import com.example.mynotes.domain.model.ColorModel
import com.example.mynotes.domain.model.NEW_NOTE_ID
import com.example.mynotes.domain.model.NoteModel
import com.example.mynotes.domain.model.TagModel

class DbMapper {
    // Create list of NoteModels by pairing each note with a color
    fun mapNotes(
        noteDbModels: List<NoteDbModel>,
        colorDbModels: Map<Long, ColorDbModel>,
        tagDbModels: Map<Long, TagDbModel>,
    ): List<NoteModel> = noteDbModels.map {
        val colorDbModel = colorDbModels[it.colorId]
            ?: throw RuntimeException("Color for colorId: ${it.colorId} was not found. Make sure that all colors are passed to this method")

        val tagDbModel = tagDbModels[it.tagId]
            ?: throw RuntimeException("Tag for tagId: ${it.tagId} was not found. Make sure that all tags are passed to this method")

        mapNote(it, colorDbModel, tagDbModel,)
    }

    // convert NoteDbModel to NoteModel
    fun mapNote(noteDbModel: NoteDbModel, colorDbModel: ColorDbModel, tagDbModel: TagDbModel): NoteModel {
        val color = mapColor(colorDbModel)
        val tag = mapTag(tagDbModel)
        val isCheckedOff = with(noteDbModel) { if (canBeCheckedOff) isCheckedOff else null }
        return with(noteDbModel) { NoteModel(id ,phone, firstname, lastname, title, content, isCheckedOff, color, tag) }
    }

    // convert list of ColorDdModels to list of ColorModels
    fun mapColors(colorDbModels: List<ColorDbModel>): List<ColorModel> =
        colorDbModels.map { mapColor(it) }

    // convert ColorDbModel to ColorModel
    fun mapColor(colorDbModel: ColorDbModel): ColorModel =
        with(colorDbModel) { ColorModel(id, name, hex) }

    fun mapTag(tagDbModel: TagDbModel): TagModel =
        with(tagDbModel) { TagModel(id, name, hex) }

    fun mapTags(tagDbModels: List<TagDbModel>): List<TagModel> =
        tagDbModels.map { mapTag(it) }

    // convert NoteModel back to NoteDbModel
    fun mapDbNote(note: NoteModel): NoteDbModel =
        with(note) {
            val canBeCheckedOff = isCheckedOff != null
            val isCheckedOff = isCheckedOff ?: false
            if (id == NEW_NOTE_ID)
                NoteDbModel(
                    title = title,
                    phone = phone,
                    firstname = firstname,
                    lastname= lastname,
                    content = content,
                    canBeCheckedOff = canBeCheckedOff,
                    isCheckedOff = isCheckedOff,
                    colorId = color.id,
                    tagId = tag.id,
                    isInTrash = false
                )
            else
                NoteDbModel(id, phone, firstname, lastname,title, content, canBeCheckedOff, isCheckedOff, false,color.id, tag.id)
        }
}