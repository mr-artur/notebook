package ua.kpi.notebook.controller;

import ua.kpi.notebook.model.entity.note.Note;
import ua.kpi.notebook.view.View;

public class DataPrinter {

    private View view;

    DataPrinter(View view) {
        this.view = view;
    }

    void printNote(Note note) {
        view.printResult(note.toString());
    }
}
