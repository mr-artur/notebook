package ua.kpi.notebook.controllers;

import ua.kpi.notebook.models.Note;
import ua.kpi.notebook.views.View;

import java.util.Scanner;

public class Controller {

    private DataScanner dataScanner;
    private DataPrinter dataPrinter;
    private Note note;

    public Controller(Note note, View view) {
        this.note = note;
        dataScanner = new DataScanner(view);
        dataPrinter = new DataPrinter(view);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        note.setNoteData(dataScanner.getNoteData(scanner));
        dataPrinter.printNote(note);
    }
}
