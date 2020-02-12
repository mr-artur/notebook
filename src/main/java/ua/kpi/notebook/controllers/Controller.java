package ua.kpi.notebook.controllers;

import ua.kpi.notebook.models.Note;
import ua.kpi.notebook.views.View;

import java.util.Scanner;

public class Controller {

    private DataScanner dataScanner;
    private Note note;

    public Controller(Note note, View view) {
        this.note = note;
        dataScanner = new DataScanner(view);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        note.setUserData(dataScanner.getUserData(scanner));
    }
}
