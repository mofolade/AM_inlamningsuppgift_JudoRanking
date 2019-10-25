package com.company;

public class View {

    protected static String separation = "-----------------------------------------------------------------------------";
    protected static String starSeparation = "***********";
    protected static String errorReadingFileLabel = "Error reading file.";
    protected static final String noSuchMenuitemLabel= "No such menuitem.";
    protected static final String incorrectDataLabel= "Incorrect data entry.";
    protected static final String wrongDataLabel = "Wrong data.";
    protected static final String notFoundLabel = "Not Found.";
    protected static final String noRefereeFoundLabel = "No referee found.";
    protected static final String noCompetitionFoundLabel = "No competition found.";
    protected static final String noClassificationFoundLabel = "No classification found.";
    protected static final String noAssessorFoundLabel = "No assessor found.";
    protected static final String doneLabel = "Done.";
    protected static final String deletedLabel = "Deleted.";
    protected static final String enterLabel = "Enter ";
    protected static final String makeAChoiceLabel = "Make a choice:";
    protected static final String refereeLabel = "Referee";
    protected static final String competitionLabel = "Competition";
    protected static final String classificationLabel = "Classification";
    protected static final String assessorLabel = "Assessor";
    protected static final String floatMaskLabel = " x,x";
    protected static final String orderByCompetitionMenu = "ORDER by ID (1)  |   name (2)";
    protected static final String orderByClassificationMenu = "ORDER by RefereeID (1)  |   competitionID (2)  |   Classification (3)   |   AsessorID (4)";
    protected static final String editPersonMenu = "Edit familyName (1) givenName (2) nation (3)";
    protected static final String orderByPersonMenu = "ORDER by ID (1)  |   order by Familyname (2)";
    protected static final String congratulationLabel = "CONGRATULATIONS!";
    protected static final String enterCoordinatesLabel = "Enter x and y coordinates, e.g. 5,7!";
    protected static final String numerIsLabel = "The number is: ";
    protected static final String yourTipsLabel = "Your tips:";

    public class MenuItem{

    }
    private static View instance = null;

    public class ConsoleColors {
        public static final String RESET = "\033[0m";  // Text Reset
        public static final String RED = "\033[0;31m";     // RED
        public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
        public static final String GREEN_BOLD = "\033[1;32m";  // GREEN BOLD
        public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    }

    private View(){
    }

    public static View getInstance(){
        if (instance == null){
            instance = new View();
        }
        return instance;
    }


    public void showErrorMessage(String errorMessage){
        System.out.println(ConsoleColors.RED+"Error: "+errorMessage+ ConsoleColors.RESET);
    }

    public void showSavedMessage(String message){
        System.out.println(ConsoleColors.BLUE_BOLD+message+" SAVED"+ ConsoleColors.RESET);
    }

    public void showMessage(String message){
        System.out.println(ConsoleColors.BLUE_BOLD+message+ ConsoleColors.RESET);
    }

    public void showText(String text){
        System.out.println(text);
    }

    public void showMenu(){

        System.out.println(ConsoleColors.GREEN_BOLD+"          *********************************************");
        System.out.println("           *    Welcome to the JUDO rankingsystem    *");
        System.out.println("             *                Hajime                *");
        System.out.println("                *********************************  "+ ConsoleColors.RESET);
        Task.showMenuAndGetChoice(MainMenuView.values());
    }

}
