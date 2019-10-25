package com.company;

import java.util.Scanner;

/**
 * Guess My Number Game with 2D gameboard.
 */
public class GameBoard {

    // Create a 2D grid array with start values
    String[][] board;
    NumberBoard numberBoard = new NumberBoard();
    String programBoard[][];
    int randNumber;
    int maxShow = 5;
    int showCount = 0;
    int userScore;
    public static final Integer xMaxValue = 5;
    public static final Integer yMaxValue = 7;
    private boolean isNewGame = false;
    private boolean isCheckNumber = false;
    View view = View.getInstance();
    private Position[] positions;

    public void gameBoard() {
        // Change a value inside the grid
        // Print the grid to console
        Scanner input = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);
        String menuChoice;

        newGame();

         do {
             if(showCount < 5 && isNewGame == false) {
                 System.out.print("Enter field (1) | ");
             }
             if (isCheckNumber == false) {
                 System.out.print(" Enter number (2) | ");
             }
            System.out.print(" New Game (3) | ");
            System.out.println(" Exit (99) ");
            view.showMessage(View.makeAChoiceLabel);
            menuChoice = input.nextLine();

            switch (menuChoice){
                case "1":
                    readUserInput();
                    break;
                case "2":
                    checkUserNumber();
                    newGame();
                    break;
                case "3":
                    newGame();
                    break;
            }
        }while(!menuChoice.equals("99"));
    }

    public void newGame(){
        userScore=0;
        isNewGame = false;
        isCheckNumber = false;
        randNumber = (int)(Math.random() * (10)) + 0;
        programBoard = numberBoard.addNumberBoard(randNumber);
        board = numberBoard.newBoard();
        showCount=0;
        System.out.println(View.starSeparation+" "+View.ConsoleColors.BLUE_BOLD+"NEW GAME"
                                           + View.ConsoleColors.RESET+" "+View.starSeparation);
        System.out.println("    I thought of a number. Guess.");
        System.out.println("    You can view "+maxShow+" fields.");

        System.out.println(View.separation);
        for (int y = 0; y < board.length; y++) {
            System.out.println();
            for (int x = 0; x < board[0].length; x++) {
                System.out.print(board[y][x]);
            }
        }
        System.out.println("\n");
    }

    public void readUserInput(){
        Integer userX=0;
        Integer userY=0;
        Scanner input = new Scanner(System.in);

        if (showCount < 5) {
            Position userCoordinates = getCoordinates();
            userX = userCoordinates.x;
            userY = userCoordinates.y;

            if(programBoard[userY][userX].equals("[X]")) {
                board[userY][userX] = "[X]";
                userScore++;
            }else{
                board[userY][userX] = " . ";
            }

            for (int y = 0; y < board.length; y++) {
                System.out.println();
                for (int x = 0; x < board[0].length; x++) {
                    System.out.print(board[y][x]);
                }
            }
            System.out.println("\n");
            showCount++;
        }else{
            System.out.println("You can't watch anymore.");
        }

    }

    public void checkUserNumber(){

        Scanner scanner = new Scanner(System.in);
        Integer userNumber = 0;
        boolean isUserNumber = false;

        /*do{
            view.showMessage(View.yourTipsLabel);
            userNumber = scanner.nextInt();
        }while(scanner.hasNextInt());*/

        do {
            view.showMessage(View.yourTipsLabel);
            try {
                userNumber = Integer.parseInt(scanner.nextLine());
                isUserNumber = true;
            } catch (NumberFormatException e) {
                view.showErrorMessage(View.wrongDataLabel);
            }

        }while(isUserNumber == false);

        System.out.println(View.separation);
        if(userNumber == randNumber){
            System.out.println(View.ConsoleColors.BLUE_BOLD+"            "+View.congratulationLabel+View.ConsoleColors.RESET);
            if (showCount < 3) {
                userScore=userScore+3;
            }
            userScore=userScore+5;
            System.out.println("            Your score: "+userScore);
            System.out.println("                 ");
        }else{
            System.out.println(View.numerIsLabel+randNumber);
            for (int y = 0; y < programBoard.length; y++) {
                System.out.println();
                for (int x = 0; x < programBoard[0].length; x++) {
                    System.out.print(programBoard[y][x]);
                }
            }
            System.out.println("\n");

        }
        System.out.println(View.separation);
        showCount=0;
        isNewGame = true;
        isCheckNumber = true;
    }

    public Position getCoordinates(){
        Scanner scanner = new Scanner(System.in);
        boolean isPositions = false;
        String[] coordParts;

        do {
            view.showMessage(View.enterCoordinatesLabel);
            String coords = scanner.nextLine();
            coordParts = coords.split(",");
            try{
                Integer.parseInt(coordParts[0]);
                Integer.parseInt(coordParts[1]);
                if((Integer.parseInt(coordParts[0]) > 0 && Integer.parseInt(coordParts[0]) <= xMaxValue)
                        && (Integer.parseInt(coordParts[1]) > 0 && Integer.parseInt(coordParts[0]) <= yMaxValue)
                ){
                    isPositions = true;
                }
                else{
                    view.showErrorMessage(View.wrongDataLabel);
                }
            }catch(Exception e){
                view.showErrorMessage(View.wrongDataLabel);
            }
        }while(isPositions == false);

        return new Position(
                Integer.parseInt(coordParts[0]),
                Integer.parseInt(coordParts[1]));
    }

}
