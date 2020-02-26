package ua.kpi.notebook.controller;

import ua.kpi.notebook.model.entity.note.Note;
import ua.kpi.notebook.model.exception.DuplicateFieldException;
import ua.kpi.notebook.view.View;

import java.util.Scanner;

public class Controller {

    private View view;
    private DataScanner dataScanner;
    private DataPrinter dataPrinter;
    private Note note;

    public Controller(Note note, View view) {
        this.view = view;
        this.note = note;
        dataScanner = new DataScanner(view);
        dataPrinter = new DataPrinter(view);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean isDuplicate = true;
        do {
            try {
                note.setNoteData(dataScanner.getNoteData(scanner));
                isDuplicate = false;
            } catch (DuplicateFieldException e) {
                view.printError(e.getField(), e.getValue());
            }
        } while (isDuplicate);

        dataPrinter.printNote(note);
    }
}
