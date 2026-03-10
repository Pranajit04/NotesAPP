package com.example.notesapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class NoteClickHandler {
    private Context context;
    private Note note;
    private NoteViewModel viewModel;
    private boolean isUpdate;

    public NoteClickHandler(Context context, Note note, NoteViewModel viewModel, boolean isUpdate) {
        this.context = context;
        this.note = note;
        this.viewModel = viewModel;
        this.isUpdate = isUpdate;
    }

    public void onSubmitButtonClick(View view) {
        if (note.getTitle() == null || note.getTitle().trim().isEmpty() ||
            note.getDescription() == null || note.getDescription().trim().isEmpty()) {
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            if (isUpdate) {
                viewModel.updateNote(note);
            } else {
                viewModel.insertNote(note);
            }
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
    }

    public void onBackButtonClicked(View view) {
        if (context instanceof Activity) {
            ((Activity) context).onBackPressed();
        }
    }
}
