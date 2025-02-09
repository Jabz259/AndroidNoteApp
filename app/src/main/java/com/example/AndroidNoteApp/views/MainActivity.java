package com.example.AndroidNoteApp.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.AndroidNoteApp.R;
import com.example.AndroidNoteApp.model.AppDatabase;
import com.example.AndroidNoteApp.model.Note;
import com.example.AndroidNoteApp.model.NoteDAO;
import com.example.AndroidNoteApp.viewmodels.NoteViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declare variables for the RecyclerView, Button, ViewModel, and Adapter
    private RecyclerView recyclerView;
    private Button addBtn;
    private NoteAdapter noteAdapter;
    private NoteViewModel noteViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // This links to the activity_main.xml layout
        // Initialize the RecyclerView, Button, and ViewModel
        recyclerView = findViewById(R.id.recyclerView);
        addBtn = findViewById(R.id.addBtn);
        EditText noteField= (EditText) findViewById(R.id.noteTitle);

        //build the database
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "UserNotes").build();


        // Initialize the DAO
        NoteDAO noteDAO = db.noteDAO();



        // Set an onClickListener for the add button
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add a new note to the list and notify the adapter
                String addNote = noteField.getText().toString();
//                Note newNote = new Note(addNote);

                // Create a new note
                Note newNote = new Note(addNote);
                newNote.noteSubject = addNote;
                newNote.noteDesc = "anohter test";

                // Run the database operation in a background thread
                new Thread(() -> {
                    noteDAO.insertAll(newNote); // Insert the new note in the database
                }).start();

                Toast.makeText(MainActivity.this, "Successfully Added a new Note", Toast.LENGTH_SHORT).show();
                noteField.setText("");


            }
        });



//
//        NoteViewModel viewModel = new ViewModelProvider(this).get(NoteViewModel.class);
//        viewModel.addNote(newNote);

        // Fetch data asynchronously
        new Thread(() -> {
            List<Note> storedNotes = noteDAO.getAll();

            // Once the data is fetched, update the UI on the main thread
            runOnUiThread(() -> {
                // Initialize the Adapter and set it to the RecyclerView
                noteAdapter = new NoteAdapter(storedNotes);
                recyclerView.setAdapter(noteAdapter);

                for (Note note: storedNotes) {
                    Log.d("NOTES IN DATABASE", "Subject: " + note.noteSubject + " Description : " + note.noteDesc + " note ID: " + note.uid);
                }
            });
        }).start();



        //styling the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
