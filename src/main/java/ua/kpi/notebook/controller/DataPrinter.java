package ua.kpi.notebook.controller;

import ua.kpi.notebook.model.entity.note.Note;
import ua.kpi.notebook.view.View;

import java.util.List;

public class DataPrinter {

    private View view;

    DataPrinter(View view) {
        this.view = view;
    }

    void printNotes(List<Note> notes) {
        notes.forEach(this::printNote);
    }

    void printNote(Note note) {
        view.printResult(note.toString());
    }
}
