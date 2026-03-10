package com.example.notesapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.notesapp.databinding.ActivityAddEditNoteBinding;

public class AddEditNoteActivity extends AppCompatActivity {

    private Note note;
    private ActivityAddEditNoteBinding binding;
    private NoteClickHandler handler;
    private NoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_edit_note);
        viewModel = new ViewModelProvider(this).get(NoteViewModel.class);

        boolean isUpdate = false;
        if (getIntent().hasExtra("note_id")) {
            // Update mode
            isUpdate = true;
            note = new Note();
            note.setId(getIntent().getIntExtra("note_id", 0));
            note.setTitle(getIntent().getStringExtra("note_title"));
            note.setDescription(getIntent().getStringExtra("note_description"));
        } else {
            // Insert mode
            note = new Note();
        }

        binding.setNote(note);

        handler = new NoteClickHandler(this, note, viewModel, isUpdate);
        binding.setHandler(handler);
    }
}
