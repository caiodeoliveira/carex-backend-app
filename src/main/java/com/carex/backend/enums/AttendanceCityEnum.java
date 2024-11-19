package com.carex.backend.enums;

public enum AttendanceCityEnum {
    PAULISTA("Paulista", "36"),
    OLINDA("Olinda", "52"),
    RECIFE("Recife", "72"),
    BOA_VIAGEM("Boa Viagem", "72"),
    ABREU_E_LIMA("Abreu e Lima", "52"),
    IGARASSU("Igarassu", "52"),
    ITAPISSUMA("Itapissuma", "62"),
    ITAMARACA("Itamaracá", "62");

    private String city;
    private String fee;

    private AttendanceCityEnum(String city, String fee) {
        this.city = city;
        this.fee = fee;
    };
    private AttendanceCityEnum(String city) {
        this.city = city;
    };

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
