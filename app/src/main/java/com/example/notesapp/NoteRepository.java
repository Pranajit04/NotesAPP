package com.example.notesapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {
    private final NoteDAO noteDAO;
    private final LiveData<List<Note>> allNotes;
    private final ExecutorService executor;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDAO = database.getNoteDAO();
        allNotes = noteDAO.getAllNotes();
        executor = Executors.newSingleThreadExecutor();
    }

    public void insertNote(Note note) {
        executor.execute(() -> noteDAO.insert(note));
    }

    public void updateNote(Note note) {
        executor.execute(() -> noteDAO.update(note));
    }

    public void deleteNote(Note note) {
        executor.execute(() -> noteDAO.delete(note));
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
}
