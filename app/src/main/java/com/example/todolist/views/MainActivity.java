package com.example.todolist.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.model.Note;
import com.example.todolist.viewmodels.NoteViewModel;

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

        // Initialize the ViewModel
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        // Initialize the Adapter and set it to the RecyclerView
        noteAdapter = new NoteAdapter(noteViewModel.getNoteList());
        recyclerView.setAdapter(noteAdapter);

        //styling the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Set an onClickListener for the add button
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add a new note to the list and notify the adapter
                String addNote = noteField.getText().toString();
                Note newNote = new Note(addNote);
                noteField.setText("");
//
//
//                noteViewModel.addNote(newNote); // Update the ViewModel
                noteAdapter.addNote(newNote);  // Update the Adapter


                Toast.makeText(MainActivity.this, "Successfully Added a new Note", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
