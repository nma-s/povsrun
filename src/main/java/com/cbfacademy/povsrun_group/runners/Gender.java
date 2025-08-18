package com.cbfacademy.povsrun_group.runners;

public enum Gender {
FEMALE("F"),
MALE("M"),
OTHER("O")

private final String gender;

Gender(String gender) {
    this.gender = gender;
}

public String getGender(){
    return gender;
}

}
