package ua.rozhkov.springdepdb.entity.core;

public enum Base {
    NINE_CLASS("9 клас"),
    TEN_CLASS("10 клас"),
    KVAL_ORB("кваліфікований робітник");

    private String string;

    private Base(String s) {
        string = s;
    }

    public String getString() {
        return string;
    }
}
