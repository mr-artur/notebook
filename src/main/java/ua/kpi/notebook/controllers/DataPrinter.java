package ua.kpi.notebook.controllers;

import ua.kpi.notebook.models.Note;
import ua.kpi.notebook.views.View;

public class DataPrinter {

    private View view;

    DataPrinter(View view) {
        this.view = view;
    }

    void printNote(Note note) {
        view.printResult(note.toString());
    }
}
