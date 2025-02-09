package com.example.AndroidNoteApp.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDAO {
    @Query("SELECT * FROM note ")
    List<Note> getAll();

    @Query("SELECT * FROM note WHERE uid IN (:noteIds)")
    List<Note> loadAllByIds(int[] noteIds);

    @Query("SELECT * FROM note WHERE note_subject LIKE :first AND " +
            "note_description LIKE :last LIMIT 1")
    Note findBySubject(String first, String last);

    @Insert
    void insertAll(Note... notes);

    @Delete
    void delete(Note note);


}
