package ua.kpi.notebook.models;

import java.util.List;

public class Note {

    public static String[] getFields() {
        return Fields.fields;
    }

    public static String[] getOptionalFields() {
        return Fields.optionalFields;
    }

    public void setUserData(List<String> data) {
    }
}
