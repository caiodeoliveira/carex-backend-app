package com.carex.backend.enums;

public enum GenderEnum {
    MALE("Masculino"),
    FEMALE("Feminino");

    private String gender;

    private GenderEnum(String gender) {
        this.gender = gender;
    };

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
