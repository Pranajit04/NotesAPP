package com.example.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;
    private ActivityMainBinding binding;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        binding.setClickHandlers(this);

        setupRecyclerView();

        noteViewModel.getAllNotes().observe(this, notes -> {
            adapter.setNotes(notes);
        });
    }

    public void onFabClick(View view) {
        Intent intent = new Intent(MainActivity.this, AddEditNoteActivity.class);
        startActivity(intent);
    }

    private void setupRecyclerView() {
        adapter = new NoteAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);

        // Swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Note noteToDelete = adapter.getNoteAt(viewHolder.getAdapterPosition());
                noteViewModel.deleteNote(noteToDelete);
            }
        }).attachToRecyclerView(binding.recyclerView);

        // Click to update
        adapter.setOnItemClickListener(note -> {
            Intent intent = new Intent(MainActivity.this, AddEditNoteActivity.class);
            intent.putExtra("note_id", note.getId());
            intent.putExtra("note_title", note.getTitle());
            intent.putExtra("note_description", note.getDescription());
            startActivity(intent);
        });
    }
}
