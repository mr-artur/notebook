package ua.kpi.notebook.controller;

import ua.kpi.notebook.model.exception.DuplicateFieldException;
import ua.kpi.notebook.model.service.NoteService;
import ua.kpi.notebook.view.View;

import java.util.Scanner;

public class Controller {

    private View view;
    private DataScanner dataScanner;
    private DataPrinter dataPrinter;
    private NoteService noteService;

    public Controller(NoteService noteService, View view) {
        this.view = view;
        this.noteService = noteService;
        dataScanner = new DataScanner(view);
        dataPrinter = new DataPrinter(view);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean isDuplicate = true;
        do {
            try {
                noteService.createNote(dataScanner.getNoteData(scanner));
                isDuplicate = false;
            } catch (DuplicateFieldException e) {
                view.printError(e.getField(), e.getValue());
            }
        } while (isDuplicate);

        dataPrinter.printNotes(noteService.getNotes());
    }
}
