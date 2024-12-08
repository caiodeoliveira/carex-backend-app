package com.carex.backend.dto;

public class TerapyDTO {

    private String name;
    private String description;
    private String image;
    private boolean isAlternative;

    public TerapyDTO() {
    }

    public TerapyDTO(String name, String description, String image, boolean isAlternative) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.isAlternative = isAlternative;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAlternative() {
        return isAlternative;
    }

    public void setIsAlternative(boolean alternative) {
        isAlternative = alternative;
    }
}
