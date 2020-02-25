package ua.kpi.notebook.model.db;

public enum ExistingEmails {
    AAA("a@a.a"),
    BBB("b@b.b"),
    CCC("c@c.c");

    private final String email;

    ExistingEmails(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
