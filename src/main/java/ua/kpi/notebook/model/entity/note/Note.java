package ua.kpi.notebook.model.entity.note;

import ua.kpi.notebook.model.db.DBNotebook;
import ua.kpi.notebook.model.exception.DuplicateFieldException;

import java.util.Map;
import java.util.StringJoiner;

public class Note {

    private Identity identity;
    private Contacts contacts;
    private Meta meta;

    public Note() {
        this.identity = new Identity();
        this.contacts = new Contacts();
        this.meta = new Meta();
    }

    public static String[] getFields() {
        return Fields.fields;
    }

    public static String[] getOptionalFields() {
        return Fields.optionalFields;
    }

    public void setNoteData(Map<String, String> data) throws DuplicateFieldException {
        checkNoteData(data);
        meta.setUpdateTimeStamp();
        setIdentityData(data);
        setContactsData(data);
    }

    private void checkNoteData(Map<String, String> data) throws DuplicateFieldException {
        if (DBNotebook.checkNickname(data.get("nickname"))) {
            throw new DuplicateFieldException("nickname", data.get("nickname"));
        }
        if (DBNotebook.checkEmail(data.get("email"))) {
            throw new DuplicateFieldException("email", data.get("email"));
        }
    }

    private void setIdentityData(Map<String, String> data) {
        identity.setIdentityData(
                data.get("firstName"),
                data.get("lastName"),
                data.get("patronymic"),
                data.get("nickname"),
                data.get("comment"),
                data.get("group")
                                );
    }

    private void setContactsData(Map<String, String> data) {
        contacts.setContactsData(
                data.get("homePhoneNumber"),
                data.get("mobilePhoneNumber1"),
                data.get("mobilePhoneNumber2"),
                data.get("email"),
                data.get("skype"),
                data.get("index"),
                data.get("city"),
                data.get("street"),
                data.get("houseNumber"),
                data.get("flatNumber")
                                );
    }

    @Override
    public String toString() {
        String delimiter = "\n\t";
        return new StringJoiner(delimiter, delimiter + Note.class
                .getSimpleName() + delimiter + "[", "]")
                .add("identity=" + identity)
                .add("contacts=" + contacts)
                .add("meta=" + meta)
                .toString();
    }
}
