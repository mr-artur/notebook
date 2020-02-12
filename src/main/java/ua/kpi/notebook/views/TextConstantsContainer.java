package ua.kpi.notebook.views;

import java.util.ResourceBundle;

public class TextConstantsContainer {

    private final String PREFIX = "input.text.";

    private ResourceBundle bundle;

    public TextConstantsContainer() {
        bundle = ResourceBundle.getBundle("messages");
    }

    public String buildHintMessage(String regex, String field) {
        return String.format("%s '%s' %s %s :",
                getStartHint(), getFieldName(field), getInFormat(), regex);
    }

    public String getInFormat() {
        return bundle.getString(getKey("inFormat"));
    }

    public String getFieldName(String field) {
        return bundle.getString(getKey(field));
    }

    public String getStartHint() {
        return String.format("%s %s", bundle.getString(getKey("startHint")), getField());
    }

    public String getField() {
        return bundle.getString(getKey("field"));
    }

    public String getSkipHint() {
        return bundle.getString(getKey("skipHint"));
    }

    private String getKey(String field) {
        return PREFIX + field;
    }


}
