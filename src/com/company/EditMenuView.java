package com.company;

public enum EditMenuView implements HasDescription {
    ADD("EDIT  "),
    ADD_REFEREE("Referee (31)   |"),
    ADD_COMPETITION(" Competition (32)   |"),
    ADD_CLASSIFICATION(" Classification (33) |"),
    ADD_ASSESSOR(" Assessor (34) |"),
    QUIT(" Quit the submenu (99)");
    ;

    private String description;

    EditMenuView(String description){
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}