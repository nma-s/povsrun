package com.cbfacademy.povsrun_group.runners;

public enum Gender {
    FEMALE("F"),
    MALE("M"),
    OTHER("O"),
    PREFER_NOT_TO_SAY("Prefer Not To Say");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public static Gender convertInput(String value) {
        if (value == null)
            return PREFER_NOT_TO_SAY;
        String v = value.trim().toUpperCase();
        switch (v) {
            case "F":
            case "FEMALE":
                return FEMALE;
            case "M":
            case "MALE":
                return MALE;
            case "O":
            case "OTHER":
                return OTHER;
            default:
                throw new IllegalArgumentException("Invalid Gender Input");
        }
    }

    public String getGender() {
        return gender;
    }

}
