package com.example.todolist.views;
import android.util.Log;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.todolist.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); // This links to the activity_main.xml layout

        Log.d("MyApp","I am here");


    }
}