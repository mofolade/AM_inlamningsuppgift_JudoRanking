package com.company;

public enum OrderByMenuView implements HasDescription {
    SHOW("ORDER BY  "),
    SHOW_REFEREE(" Referee list (51)   |"),
    SHOW_COMPETITION(" Competition list(52)   |"),
    SHOW_CLASSIFICATION(" Classification list (53) |"),
    SHOW_ASSESSOR(" Assessor list (54) |"),
    QUIT(" Quit the submenu (99)");
    ;

    private String description;

    OrderByMenuView(String description){
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

