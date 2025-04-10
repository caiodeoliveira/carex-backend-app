package com.carex.backend.enums;

public enum ImagesEnum {
    DRY_NEDLING("../../../assets/img/big/dry-nedling-big.png", "../../../assets/img/regular/dry-nedling-regular.png", "../../../assets/img/small/dry-nedling-small.png", true, "Acupuntura"),
    EAR_ACUNPUTURE("../../../assets/img/big/ear-acupunture-big.png", "../../../assets/img/regular/ear-acupunture-regular.png", "../../../assets/img/small/ear-acupunture-small.png", true, "Auriculoterapia"),
    MYOFACIAL_RELEASE("../../../assets/img/big/myofacial-release-big.png", "../../../assets/img/regular/myofacial-release-regular.png", "../../../assets/img/small/myofacial-release-small.png", true, "Liberação Miofacial"),
    SUCTION_CUP("../../../assets/img/big/suction-cup-big.png", "../../../assets/img/regular/suction-cup-regular.png", "../../../assets/img/small/suction-cup-small.png", true, "Ventosaterapia"),
    OBSTETRIC_PHYSIOTERAPY("../../../assets/img/big/obstetric-physioterapy-big.png", "../../../assets/img/regular/obstetric-physioterapy-regular.png", "../../../assets/img/small/obstetric-physioterapy-small.png", false, "Fisioterapia Obstétrica"),
    PELVIC_PHYSIOTERAPY("../../../assets/img/big/pelvic-physioterapy-big.png", "../../../assets/img/regular/pelvic-physioterapy-regular.png", "../../../assets/img/small/pelvic-physioterapy-small.png", false, "Fisioterapia Pélvica"),
    DOULAGE("../../../assets/img/big/doulage-big.png", "../../../assets/img/regular/doulage-regular.png", "../../../assets/img/small/doulage-small.png", false, "Doulagem");

    private String big;
    private String regular;
    private String small;
    private boolean isAlternative;
    private String identifier;

    ImagesEnum(String big, String regular, String small, boolean isAlternative, String identifier) {
        this.big = big;
        this.regular = regular;
        this.small = small;
        this.isAlternative = isAlternative;
        this.identifier = identifier;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public boolean isAlternative() {
        return isAlternative;
    }

    public void setAlternative(boolean alternative) {
        isAlternative = alternative;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = ImagesEnum.this.identifier;
    }
}
