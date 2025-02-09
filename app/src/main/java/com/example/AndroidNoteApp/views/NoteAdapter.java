package com.example.AndroidNoteApp.views;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.AndroidNoteApp.model.Note;

import java.util.List;

//RecyclerView Adapter to display list of note objects
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    //public field stores the list of notes
    private List<Note> noteList;

    //constructor receives the notes
    public NoteAdapter(List<Note> noteList){
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NoteAdapter.NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteViewHolder holder, int position) {
        Note note = noteList.get(position);
        holder.textView.setText(note.getText());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    static class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public NoteViewHolder (@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);

        }
    }

    public void addNote(Note note) {
        noteList.add(note);
        notifyItemInserted(noteList.size() - 1); // Notify RecyclerView that a new item was added
    }

}
