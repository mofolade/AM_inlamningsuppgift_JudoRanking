package com.company;

public enum SearchMenuView implements HasDescription{
    SHOW("SEARCH  "),
    SHOW_REFEREE(" Referee (41)   |"),
    SHOW_COMPETITION(" Competition (42)   |"),
    SHOW_CLASSIFICATION(" Classification (43) |"),
    SHOW_ASSESSOR(" Assessor (44) |"),
    QUIT(" Quit the submenu (99)");
    ;

    private String description;

    SearchMenuView(String description){
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
