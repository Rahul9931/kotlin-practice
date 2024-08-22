package com.example.kotlin_practice2.local_database_practice.sql_database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context, Database_Name,null, Database_Version){

    companion object{
        private const val Database_Name="NoteApp"
        private const val Database_Version=1
        private const val Table_Notes="AllNotes"
        private const val Column_ID="Id"
        private const val Column_Title="Title"
        private const val Column_Content="Content"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE $Table_Notes ($Column_ID INTEGER PRIMARY KEY, $Column_Title TEXT, $Column_Content TEXT )")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $Table_Notes")
        onCreate(db)
    }

    fun insertNote(note: Note){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(Column_Title,note.title)
            put(Column_Content,note.content)
        }
        db.insert(Table_Notes,null,values)
    }

    fun getAllNote():List<Note>{
        val noteList = mutableListOf<Note>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $Table_Notes",null)
        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(Column_ID))
            val title = cursor.getString(cursor.getColumnIndexOrThrow(Column_Title))
            val content = cursor.getString(cursor.getColumnIndexOrThrow(Column_Content))
            val note = Note(id, title, content)
            noteList.add(note)
        }
        cursor.close()
        return noteList
    }

    fun updateNote(note: Note){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(Column_Title,note.title)
            put(Column_Content,note.content)
        }
        db.update(Table_Notes,values,"$Column_ID = ?", arrayOf(note.id.toString()))
    }

    fun deleteNote(id:Int){
        val db = writableDatabase
        db.delete(Table_Notes,"$Column_ID = ?", arrayOf(id.toString()))
    }
}