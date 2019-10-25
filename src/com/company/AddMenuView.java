package com.company;

public enum AddMenuView implements HasDescription {
    ADD("ADD  "),
    ADD_REFEREE("Referee (11)   |"),
    ADD_COMPETITION(" Competition (12)   |"),
    ADD_CLASSIFICATION(" Classification (13) |"),
    ADD_ASSESSOR(" Assessor (14) |"),
    QUIT(" Quit the submenu (99)");
    ;

    private String description;

    AddMenuView(String description){
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}