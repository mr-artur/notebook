package ua.kpi.notebook.views;

public class View {

    private TextConstantsContainer container;

    public View() {
        container = new TextConstantsContainer();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printHint(String regex, String field) {
        printMessage(container.buildHintMessage(regex, field));
    }

    public void printSkipHint() {
        printMessage(container.getSkipHint());
    }
}
