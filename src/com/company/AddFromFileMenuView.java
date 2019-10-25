package com.company;

public enum AddFromFileMenuView implements HasDescription {
    ADD_FROM_FILE("ADD FROM FILE  "),
    ADD_FROM_FILE_REFEREE(" Referee (71)   |"),
    ADD_FROM_FILE_COMPETITION(" Competition (72)   |"),
    ADD_FROM_FILE_CLASSIFICATION(" Classification (73) |"),
    ADD_FROM_FILE_ASSESSOR(" Assessor (74) |"),
    QUIT(" Quit the submenu (99)");;

    private String description;

    AddFromFileMenuView(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}