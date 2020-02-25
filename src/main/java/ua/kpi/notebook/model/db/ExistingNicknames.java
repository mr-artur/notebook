package ua.kpi.notebook.model.db;

public enum ExistingNicknames {
    AAA("aaa"),
    BBB("bbb"),
    CCC("bbb");

    private final String nickname;

    ExistingNicknames(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
