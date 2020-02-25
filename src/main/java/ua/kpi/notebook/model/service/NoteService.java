package ua.kpi.notebook.model.service;

import ua.kpi.notebook.model.db.ExistingEmails;
import ua.kpi.notebook.model.db.ExistingNicknames;
import ua.kpi.notebook.model.entity.note.Note;
import ua.kpi.notebook.model.exception.DuplicateFieldException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NoteService {

    private final List<Note> notes = new ArrayList<>();

    public void createNote(Map<String, String> data) throws DuplicateFieldException {
        checkNickname(data.get("nickname"));
        checkEmail(data.get("email"));
        Note note = new Note();
        note.setNoteData(data);
    }

    private void checkEmail(String email) throws DuplicateFieldException {
        for (ExistingEmails existingEmail : ExistingEmails.values()) {
            if (email.equals(existingEmail.getEmail())) {
                throw new DuplicateFieldException("email", email);
            }
        }
    }

    private void checkNickname(String nickname) throws DuplicateFieldException {
        for (ExistingNicknames existingNickname : ExistingNicknames.values()) {
            if (nickname.equals(existingNickname.getNickname())) {
                throw new DuplicateFieldException("nickname", nickname);
            }
        }
    }

    public List<Note> getNotes() {
        return notes;
    }
}
