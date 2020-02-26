package ua.kpi.notebook.model.db;

import ua.kpi.notebook.model.exception.DuplicateFieldException;

public enum DBNotebook {
    FIRST_NOTE("aaa", "a@a.a"),
    SECOND_NOTE("bbb", "b@b.b"),
    THIRD_NOTE("ccc", "c@c.c");

    private String nickname;
    private String email;

    DBNotebook(String nickname, String email) {
        this.nickname = nickname;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public static boolean checkNickname(String nickname) {
        for (DBNotebook note : DBNotebook.values()) {
            if (note.getNickname().equals(nickname)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkEmail(String email) {
        for (DBNotebook note : DBNotebook.values()) {
            if (note.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
}
