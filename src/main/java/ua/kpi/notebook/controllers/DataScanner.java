package ua.kpi.notebook.controllers;

import ua.kpi.notebook.models.Note;
import ua.kpi.notebook.views.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DataScanner {

    private View view;
    private RegexContainer regexContainer;

    DataScanner(View view) {
        this.view = view;
        regexContainer = new RegexContainer();
    }

    List<String> getUserData(Scanner scanner) {
        String[] fields = Note.getFields();
        Map<String, String> regexes = regexContainer.getRegexes();
        List<String> data = new ArrayList<>();
        for (String field : fields) {
            data.add(getValidInput(scanner, regexes.get(field), field));
        }
        return data;
    }

    private String getValidInput(Scanner scanner, String regex, String field) {
        String input;
        while (true) {
            String regexWithRequirements = getRequirements(regex, field);
            view.printHint(regexWithRequirements, field);
            input = scanner.nextLine();
            if (input.matches(regexWithRequirements)) {
                return input;
            }
        }
    }

    private String getRequirements(String regex, String field) {
        for (String optionalField : Note.getOptionalFields()) {
            boolean isOptional = optionalField.equals(field);
            if (isOptional) {
                view.printSkipHint();
                return String.format("(%s)|(-)", regex);
            }
        }
        return regex;
    }
}
