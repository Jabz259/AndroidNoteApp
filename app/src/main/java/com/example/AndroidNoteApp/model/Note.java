package com.example.AndroidNoteApp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "note_subject")
    public String noteSubject;

    @ColumnInfo(name = "note_description")
    public String noteDesc;

//    creating a constructor

    private String text;
    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }





}
