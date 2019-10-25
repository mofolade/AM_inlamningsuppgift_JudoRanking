package com.company;

public enum MainMenuView implements HasDescription {
        ADD("(1) ADD                  | Referee (11)          | Competition (12)      | Classification (13)       | Assessor (14) \n"),
        SHOW("(2) SHOW                 | All referee (21)      | All competition (22)  | All classification (23)   | All assessor (24) \n"),
        EDIT("(3) EDIT                 | Referee (31)          | Competition (32)      | Classification (33)       | Assessor (34) \n"),
        SEARCH("(4) SEARCH               | Referee (41)          | Competition (42)      | Classification (43)       | Assessor (44) \n"),
        ORDER_BY("(5) ORDER BY             | Referee list (51)     | Competition list (52) | Classification list (53)  | Assessor list (54) \n"),
        DELETE("(6) DELETE               | Referee (61)          | Competition (62)      | Classification (63)       | Assessor (64) \n"),
        ADD_FROM_FILE("(7) ADD FROM TXT FILE    | Referee (71)          | Competition (72)      | Classification (73)       | Assessor (74) \n"),
        WRITE_TO_FILE("(8) WRITE TO SER FILE    | Referee list          | Competition list  \n"),
        READ_FROM_FILE("(9) READ FROM SER FILE   | Referee list          | Competition list \n"),
        GAME("(10) GAME \n"),
        QUIT("(99) Quit the program"),
        ;

    private String description;

    MainMenuView(String description){
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }
    }