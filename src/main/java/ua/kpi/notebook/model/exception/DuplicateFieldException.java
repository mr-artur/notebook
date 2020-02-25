package ua.kpi.notebook.model.exception;

public class DuplicateFieldException extends Exception {

    private final String field;
    private final String value;

    public DuplicateFieldException(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }
}
