package ua.kpi.notebook.view;

public class View {

    private TextConstantsContainer container = new TextConstantsContainer();

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printHint(String regex, String field) {
        printMessage(container.buildHintMessage(regex, field));
    }

    public void printSkipHint() {
        printMessage(container.getSkipHint());
    }

    public void printResult(String result) {
        printMessage(container.buildResultMessage(result));
    }

    public void printError(String field, String value) {
        String message = container.getErrorMessage(field, value);
        printMessage(message);
    }
}
