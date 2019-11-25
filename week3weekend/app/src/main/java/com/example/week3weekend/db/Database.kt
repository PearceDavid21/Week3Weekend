package com.example.week3weekend.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.week3weekend.model.Notes

class Database(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION, null){


    companion object{
        const val DATABASE_NAME = "my_notes.db"
        const val DATABASE_VERSION = 3
        const val TABLE_NAME = "Notes"
        const val NOTE_ID = "Note_ID"
        const val COLUMN_NAME = "Note"

    }



    override fun onCreate(db: SQLiteDatabase) {
        val createStatement =
            "CREATE TABLE $TABLE_NAME ($NOTE_ID INTEGER PRIMARY KEY, $COLUMN_NAME TEXT)"
        db.execSQL(createStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }


    fun insertNote(newNote: Notes){
        val noteValues = ContentValues()
        noteValues.put(COLUMN_NAME, newNote.note)
        val db = writableDatabase
        db.insert(TABLE_NAME, null, noteValues)
        db.close()
    }

    fun readAllNotes(): Cursor {
        val query = "SELECT * FROM $TABLE_NAME"
        val db = readableDatabase
        return db.rawQuery(query, null)
        Log.d("TAG", db.rawQuery(query, null).toString())
    }
}