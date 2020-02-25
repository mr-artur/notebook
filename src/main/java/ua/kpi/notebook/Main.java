package ua.kpi.notebook;

import ua.kpi.notebook.controller.Controller;
import ua.kpi.notebook.model.service.NoteService;
import ua.kpi.notebook.view.View;

import java.util.Locale;

public class Main {

    public static void main(String... args) {
        //Locale.setDefault(new Locale("en"));
        Locale.setDefault(new Locale("uk", "UA"));
        Controller controller = new Controller(new NoteService(), new View());
        controller.start();
    }
}
