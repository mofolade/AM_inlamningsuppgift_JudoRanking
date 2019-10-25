package com.company;

public enum ShowMenuView implements HasDescription {
    SHOW("SHOW  "),
    SHOW_REFEREE(" All referee (21)   |"),
    SHOW_COMPETITION(" All competition (22)   |"),
    SHOW_CLASSIFICATION(" All classification (23) |"),
    SHOW_ASSESSOR(" All assessor (24) |"),
    QUIT(" Quit the submenu (99)");
    ;

    private String description;

    ShowMenuView(String description){
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
