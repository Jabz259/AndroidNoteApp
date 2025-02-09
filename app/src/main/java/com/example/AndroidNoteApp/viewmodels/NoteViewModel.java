package com.example.AndroidNoteApp.viewmodels;

import androidx.lifecycle.ViewModel;


import com.example.AndroidNoteApp.model.Note;

import java.util.ArrayList;

public class NoteViewModel extends ViewModel {

    private ArrayList<Note> noteList;

    //constructor to initialise the note list
    public NoteViewModel(){
        noteList = new ArrayList<>();
    }

    //get notes list
    public ArrayList<Note> getNoteList() {
        return noteList;
    }

    //add a note to the list
    public void addNote(Note note) {
        noteList.add(note);
    }

    //get note count
    public int getNoteCount() {
        return noteList.size();
    }

}
