package com.company;

public enum DeleteMenuView implements HasDescription {
    DELETE("DELETE  "),
    DELETE_REFEREE(" Referee (61)   |"),
    DELETE_COMPETITION(" Competition (62)   |"),
    DELETE_CLASSIFICATION(" Classification (63) |"),
    DELETE_ASSESSOR(" Assessor (64) "),
    QUIT(" Quit the submenu (99)");
    ;

    private String description;

    DeleteMenuView(String description){
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

