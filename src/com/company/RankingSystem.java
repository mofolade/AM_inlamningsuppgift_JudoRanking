package com.company;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * This class is a judo ranking system. You can add referee, competition, assessor and classification in the system.
 * referee: who receives classification in a competition.
 * assessor: who gives classification for the referees in competition.
 * @author Aniko.
 * @version 1.0,  &nbsp;
 */
public class RankingSystem {

    private List<Referee> refereeArrayList = new ArrayList<>();
    private List<Assessor> assessorArrayList = new ArrayList<>();
    private List<Competition> competitionArrayList = new ArrayList<>();
    private ArrayList<Classification> classificationArrayList = new ArrayList<>();


    private Integer refereeID = 1;
    private Integer assessorID = 1;
    private Integer competitionID = 0;
    private Integer classificationID = 0;

    private final static Integer objectTypeIdReferee = 1;
    private final static Integer objectTypeIdCompetition = 2;
    private final static Integer objectTypeIdClassification = 3;
    private final static Integer objectTypeIdAssessor = 4;

    View view = View.getInstance();
    /**
     * This method print mainMenu and call method by menu choose.
     **/
    public void showMainmenu(){
        Integer mainMenuChoice = 0;
        Integer subMenuChoice = 0;

        Data.addCountries();

        /**** TEST DATA ***/
        addDataFromFile("data_referee.txt", 1);
        addDataFromFile("data_competition.txt", 2);
        addDataFromFile("data_assessor.txt", 4);
        addDataFromFile("data_classification.txt", 3);


        Integer userChoice;
        do{
            view.showMenu();
            Scanner scanner = new Scanner(System.in);
            try {
                userChoice = scanner.nextInt();
            }
            catch (Exception e){
                userChoice = 0;
            }

            subMenuChoice = 0;

            List<Integer> addMenuItems = Arrays.asList(1, 11, 12, 13, 14);
            List<Integer> showMenuItems = Arrays.asList(2, 21, 22, 23, 24);
            List<Integer> editMenuItems = Arrays.asList(3, 31, 32, 33, 34);
            List<Integer> searchMenuItems = Arrays.asList(4, 41, 42, 43, 44);
            List<Integer> orderByMenuItems = Arrays.asList(5, 51, 52, 53, 54);
            List<Integer> deleteMenuItems = Arrays.asList(6, 61, 62, 63, 64);
            List<Integer> addFromFileMenuItems = Arrays.asList(7, 71, 72, 73, 74);

            if (addMenuItems.contains(userChoice)){
                mainMenuChoice = 1;
                if (userChoice > 1){
                    subMenuChoice = userChoice;
                }
            }
            else if(showMenuItems.contains(userChoice)){
                mainMenuChoice = 2;
                if (userChoice > 20){
                    subMenuChoice = userChoice;
                }
            }
            else if (editMenuItems.contains(userChoice)){
                mainMenuChoice = 3;
                if (userChoice > 30){
                    subMenuChoice = userChoice;
                }
            }
            else if (searchMenuItems.contains(userChoice)){
                mainMenuChoice = 4;
                if (userChoice > 40){
                    subMenuChoice = userChoice;
                }
            }
            else if (orderByMenuItems.contains(userChoice)){
                mainMenuChoice = 5;
                if (userChoice > 50){
                    subMenuChoice = userChoice;
                }
            }
            else if (deleteMenuItems.contains(userChoice)){
                mainMenuChoice = 6;
                if (userChoice > 60){
                    subMenuChoice = userChoice;
                }
            }
            else if (addFromFileMenuItems.contains(userChoice)){
                mainMenuChoice = 7;
                if (userChoice > 70){
                    subMenuChoice = userChoice;
                }
            }
            else{
                mainMenuChoice = userChoice;
            }

            switch (mainMenuChoice){
                case 1:
                    do{
                        if (subMenuChoice == 0) {
                            Task.showMenuAndGetChoice(AddMenuView.values());
                            subMenuChoice = addSubMenuChoice();
                        }
                        switch (subMenuChoice){
                            case 11:
                                addPerson(objectTypeIdReferee);
                                subMenuChoice = 0;
                                break;
                            case 12:
                                addCompetition();
                                subMenuChoice = 0;
                                break;
                            case 13:
                                addClassification();
                                subMenuChoice = 0;
                                break;
                            case 14:
                                addPerson(objectTypeIdAssessor);
                                subMenuChoice = 0;
                                break;
                            case 99:
                                System.out.println("Mainmenu");
                                break;
                            default:
                                subMenuChoice = 99;
                                break;
                        }
                    }while(subMenuChoice != 99);
                    break;
                case 2:
                    do{
                        if (subMenuChoice == 0) {
                            Task.showMenuAndGetChoice(ShowMenuView.values());
                            subMenuChoice = addSubMenuChoice();
                        }
                        switch (subMenuChoice){
                            case 21:
                                showPersonList(objectTypeIdReferee);
                                subMenuChoice = 0;
                                break;
                            case 22:
                                showCompetition();
                                subMenuChoice = 0;
                                break;
                            case 23:
                                showClassification();
                                subMenuChoice = 0;
                                break;
                            case 24:
                                showPersonList(objectTypeIdAssessor);
                                subMenuChoice = 0;
                                break;
                            case 99:
                                System.out.println("Mainmenu");
                                break;
                            default:
                                subMenuChoice = 99;
                                break;
                        }
                    }while(subMenuChoice != 99);
                    break;
                case 3:
                    do{
                        if (subMenuChoice == 0) {
                            Task.showMenuAndGetChoice(EditMenuView.values());
                            subMenuChoice = addSubMenuChoice();
                        }
                        switch (subMenuChoice){
                            case 31:
                                editObject(objectTypeIdReferee);
                                subMenuChoice=0;
                                break;
                            case 32:
                                editObject(objectTypeIdCompetition);
                                subMenuChoice=0;
                                break;
                            case 33:
                                editObject(objectTypeIdClassification);
                                subMenuChoice=0;
                                break;
                            case 34:
                                editObject(objectTypeIdAssessor);
                                subMenuChoice=0;
                                break;
                            case 99:
                                System.out.println("Mainmenu");
                                break;
                            default:
                                subMenuChoice=99;
                                break;
                        }
                    }while(subMenuChoice != 99);
                    break;
                case 4:
                    do{
                        if (subMenuChoice == 0) {
                            Task.showMenuAndGetChoice(SearchMenuView.values());
                            subMenuChoice = addSubMenuChoice();
                        }
                        switch (subMenuChoice){
                            case 41:
                                searchPersonByData(objectTypeIdReferee);
                                subMenuChoice = 0;
                                break;
                            case 42:
                                searchCompetition();
                                subMenuChoice = 0;
                                break;
                            case 43:
                                searchClassification();
                                subMenuChoice = 0;
                                break;
                            case 44:
                                searchPersonByData(objectTypeIdAssessor);
                                subMenuChoice = 0;
                                break;
                            case 99:
                                System.out.println("Mainmenu");
                                break;
                            default:
                                subMenuChoice = 99;
                                break;
                        }

                    }while(subMenuChoice != 99);
                    break;
                case 5:
                    do{
                        if (subMenuChoice == 0) {
                            Task.showMenuAndGetChoice(OrderByMenuView.values());
                            subMenuChoice = addSubMenuChoice();
                        }
                        switch (subMenuChoice){
                            case 51:
                                orderByList(objectTypeIdReferee);
                                subMenuChoice = 0;
                                break;
                            case 52:
                                orderByList(objectTypeIdCompetition);
                                subMenuChoice = 0;
                                break;
                            case 53:
                                orderByList(objectTypeIdClassification);
                                subMenuChoice = 0;
                                break;
                            case 54:
                                orderByList(objectTypeIdAssessor);
                                subMenuChoice = 0;
                                break;
                            case 99:
                                System.out.println("Mainmenu");
                                break;
                            default:
                                subMenuChoice = 99;
                                break;
                        }
                    }while(subMenuChoice != 99);
                    break;
                case 6:
                    do{
                        if (subMenuChoice == 0) {
                            Task.showMenuAndGetChoice(DeleteMenuView.values());
                            subMenuChoice = addSubMenuChoice();
                        }
                        switch (subMenuChoice){
                            case 61:
                                deleteObject(objectTypeIdReferee);
                                subMenuChoice = 0;
                                break;
                            case 62:
                                deleteObject(objectTypeIdCompetition);
                                subMenuChoice = 0;
                                break;
                            case 63:
                                deleteObject(objectTypeIdClassification);
                                subMenuChoice = 0;
                                break;
                            case 64:
                                deleteObject(objectTypeIdAssessor);
                                subMenuChoice = 0;
                                break;
                            case 99:
                                System.out.println("Mainmenu");
                                break;
                            default:
                                subMenuChoice = 99;
                                break;
                        }
                    }while(subMenuChoice != 99);
                    break;
                case 7:
                    do{
                        if (subMenuChoice == 0) {
                            Task.showMenuAndGetChoice(AddFromFileMenuView.values());
                            subMenuChoice = addSubMenuChoice();
                        }
                        switch (subMenuChoice){
                            case 71:
                                addDataFromFile("data_referee.txt", objectTypeIdReferee);
                                subMenuChoice = 0;
                                break;
                            case 72:
                                addDataFromFile("data_competition.txt", objectTypeIdCompetition);
                                subMenuChoice = 0;
                                break;
                            case 73:
                                addDataFromFile("data_classification.txt", objectTypeIdClassification);
                                subMenuChoice = 0;
                                break;
                            case 74:
                                addDataFromFile("data_assessor.txt", objectTypeIdAssessor);
                                subMenuChoice = 0;
                                break;
                            case 99:
                                System.out.println("Mainmenu");
                                break;
                            default:
                                subMenuChoice = 99;
                                break;
                        }
                    }while(subMenuChoice != 99);
                    break;
                case 8:
                    FileUtils.writeObjects(competitionArrayList,refereeArrayList,assessorArrayList);
                    break;
                case 9:
                    readFromFile();
                    break;
                case 10:
                    GameBoard gameBoard = new GameBoard();
                    gameBoard.gameBoard();
                    break;
                case 99:
                    System.out.println("Goodbye!");
                    break;
                default:
                    view.showErrorMessage(view.noSuchMenuitemLabel);
            }

        }while(mainMenuChoice!= 99);

    }

    /**
     *This function checks the type of input.
     * @return Integer
     */
    private Integer addSubMenuChoice(){
        Scanner scanner = new Scanner(System.in);
        Integer subMenuChoice;
        if (scanner.hasNextInt()){
            subMenuChoice = scanner.nextInt();
        }else{
            view.showErrorMessage(view.incorrectDataLabel);
            subMenuChoice = 0;
        }

        return subMenuChoice;
    }

    /**
     * This method return month from localdate.
     * @return month from local date
     */
    private Integer getMonthFromLocalDate(){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return localDate.getMonthValue();
    }

    /**
     *  <p>This function get datas of referee/assessor from referee/assessor ArrayList by personId.
     *  </p>
     *  User can choose short or long version of data. Short: personID, GivenName, FamilyName
     *  Long: personID, GivenName, FamilyName, Nation, YOB (only referee), licence
     * @param objectType 1: Referee, 3: Assessor
     * @param personId RefereeId or AssessorId
     * @param dataLength 1: short, 2: long
     * @return short: [personId] givenName FamilyName long: [personId] givenName FamilyName Nation /YOB/ licence
     */
    private String getDataByPersonId(Integer objectType, Integer personId, Integer dataLength){

        if(objectType.equals(objectTypeIdReferee)){
            //REFEREE
            for(Referee referee: refereeArrayList){
                if(referee.getPersonID().equals(personId)) {
                    if (dataLength == 1){
                        return " [" + referee.getPersonID() + "] " + referee.getGivenName() + " " + referee.getFamilyName();
                    }
                    else {
                        return " [" + referee.getPersonID() + "] " + referee.getGivenName() + " " + referee.getFamilyName() +
                                " (" + referee.getNation() + ") " + referee.getYOB() + " licence: " + referee.getLicence();
                    }
                }
            }
        }else{
            for(Assessor assessor : assessorArrayList){
                if(assessor.getPersonID().equals(personId)) {
                    if (dataLength == 1){
                        return " [" + assessor.getPersonID() + "] " + assessor.getFamilyName() + " " + assessor.getGivenName();
                    }
                    else {
                        return " [" + assessor.getPersonID() + "] " + assessor.getFamilyName() + " " + assessor.getGivenName() +
                                " (" + assessor.getNation() + ") licence: " + assessor.getLicence();
                    }
                }
            }
        }
        return null;
    }

    /**
     * <p>This method load datas to referee/competition/classification/assessor ArrayList from file.</p>
     * @param fileName the name of the file for saving data
     * @param objectType 1: referee,2: competition,3: classification, 4: assessor
     */
    private void addDataFromFile(String fileName,Integer objectType){
        List<String> rows = null;
        System.out.print(view.starSeparation+" ADD ");
        if (objectType.equals((objectTypeIdReferee))){
            System.out.print(view.refereeLabel);
        }
        else if (objectType.equals(objectTypeIdCompetition)){
            System.out.print(view.competitionLabel);
        } else if (objectType.equals(objectTypeIdClassification)){
            System.out.print(view.classificationLabel);
        } else if (objectType.equals(objectTypeIdAssessor)){
            System.out.print(view.assessorLabel);
        }
        System.out.println(" "+view.starSeparation);

        try {
            rows = FileUtils.readAllLines(fileName);
            if(objectType.equals(objectTypeIdReferee)) {
                for (String row : rows) {
                    String[] parts = row.split(";");
                    //fname,gname,nation,licence,refereeID
                    refereeArrayList.add(new Referee(parts[0], parts[1], parts[2].toUpperCase(), parts[3].toUpperCase(), refereeID, parseInt(parts[4])));
                    System.out.println("["+refereeID+"] "+parts[1]+" "+parts[0]+" "+parts[2]+" "+parts[3]+" "+parts[4]);
                    refereeID++;
                }
                Collections.shuffle(refereeArrayList);
                Referee.setSortBy(Referee.SortBy.REFEREEID);
                Collections.sort(refereeArrayList);

                System.out.println(view.separation);
            }else if(objectType.equals(2)) {
                for (String row : rows) {
                    String[] parts = row.split(";");
                    //compName,country,year,month,competitionID
                    competitionArrayList.add(new Competition(parts[0], parts[1], parseInt(parts[2]), parseInt(parts[3]), competitionID));
                    System.out.println("["+competitionID+"] "+parts[0]+" "+parts[1]+" "+parts[2]+" "+parts[3]);
                    competitionID++;
                }
                Collections.shuffle(competitionArrayList);
                System.out.println(view.separation);
            }else if(objectType.equals(3)) {
                if (refereeArrayList.size() > 0 && competitionArrayList.size() > 0 && assessorArrayList.size() > 0) {
                    System.out.println("cl.ID-RefereeID-CompetitionID-Classification-AssessorId");
                    for (String row : rows) {
                        String[] parts = row.split(";");
                        //compName,country,year,month,competitionID
                        Float classif = Float.parseFloat(parts[3]);
                        classificationArrayList.add(new Classification(classificationID, parseInt(parts[0]), parseInt(parts[1]),classif, parseInt(parts[2])));
                        System.out.println("["+classificationID + "]    -   " + parts[0] + "    -   " + parts[1] + "    -   " + classif + "    -   " + parts[2]);
                        classificationID++;
                    }
                    Collections.shuffle(classificationArrayList);
                }
                else{
                    System.out.println("Load it first referees, assessors, competitions data.");
                }
                System.out.println(view.separation);
            }else if(objectType.equals(objectTypeIdAssessor)) {
                for (String row : rows) {
                    String[] parts = row.split(";");
                    //compName,country,year,month,competitionID
                    assessorArrayList.add(new Assessor(parts[0], parts[1], parts[2], parts[3], assessorID, parts[4], 1));
                    System.out.println("["+assessorID+"] "+parts[1]+" "+parts[0]+" "+parts[2]+" "+parts[3]+" "+parts[4]);
                    assessorID++;
                }
                Collections.shuffle(assessorArrayList);
                System.out.println(view.separation);
            }
        } catch (Exception e){
            view.showErrorMessage(View.errorReadingFileLabel);
        }
    }

    /**
     * This method add new referee/assessor object to referee/assessor ArrayList.
     * @param objectType 1: referee, 4: assessor
     */
    private void addPerson(Integer objectType){
        String fName; String objectTypeLabel="";
        String gName;
        String licence; //???char???
        String nation;
        Integer YOB = 0;
        boolean isLicence = false;
        boolean isUserNumber = false;
        Integer addressType = 1; //email
        String address;

        Scanner input = new Scanner(System.in);

        //Scanner inputInt = new Scanner(System.in);
        if (objectType.equals(objectTypeIdReferee)){
            objectTypeLabel = "referee´s";
        }
        else if(objectType.equals(objectTypeIdAssessor)){
            objectTypeLabel = "assessor´s";
        }

        System.out.println("Enter "+objectTypeLabel+" givenname:");
        gName = input.nextLine();
        System.out.println("Enter  "+objectTypeLabel+" familyname:");
        fName = input.nextLine();
        System.out.println("Enter nation (ISO-code) SWE/ITA/HUN/GBR");
        nation = input.nextLine();
        if (nation.length() != 3){
            nation="";
            do{
                view.showErrorMessage(view.wrongDataLabel);
                printListCountries();
                System.out.println("Enter nation (ISO-code) SWE/ITA/HUN/GBR/USA");
                nation = input.nextLine();
            }while(nation.length() != 3);
        }
        System.out.println("Enter licence A or B:");
        licence = input.nextLine();
        if((!licence.toUpperCase().equals("A")) && (!licence.toUpperCase().equals("B"))){
            do{
                view.showErrorMessage(view.wrongDataLabel);
                System.out.println("Enter licence A or B:");
                licence = input.nextLine();
                if (licence.toUpperCase().equals("A") ||
                    licence.toUpperCase().equals("B")
                ){
                    isLicence = true;
                }
            }while(isLicence == false);
        }

        if (objectType.equals(objectTypeIdReferee)){

            do {
                //Only referee
                System.out.println("Enter years of birth:");
                try {
                    YOB = Integer.parseInt(input.nextLine());
                    isUserNumber = true;
                } catch (NumberFormatException e) {
                    view.showErrorMessage(View.wrongDataLabel);
                }
            }while(isUserNumber == false);

            //ADD new referee to refereeArrayList.
            refereeArrayList.add(new Referee(fName, gName, nation.toUpperCase(), licence.toUpperCase(), refereeID,YOB));
            refereeID++;
            System.out.println(view.separation);
            view.showSavedMessage(view.refereeLabel);
            System.out.println();
            System.out.println(view.separation);
            //Order by refereeID
            Referee.setSortBy(Referee.SortBy.REFEREEID);
            Collections.sort(refereeArrayList);
        }else if (objectType.equals(objectTypeIdAssessor)){

            //Only assessor
            System.out.println("Enter email address:");
            address = input.nextLine();
            //ADD new assessor to refereeArrayList.
            assessorArrayList.add(new Assessor(fName, gName, nation, licence, assessorID, address, addressType));
            assessorID++;
            System.out.println(view.separation);
            view.showSavedMessage(view.assessorLabel);
            System.out.println(view.separation);
        }
    }

    /**
     * This method add new competition object to competition ArrayList.
     */
    private void addCompetition(){
        String compName;
        Scanner input = new Scanner(System.in);
        int year;
        int month;

        System.out.println("Enter name of competition:");
        compName = input.nextLine();
        System.out.println("Enter country:");
        String country = input.nextLine();
        System.out.println("Enter year:");
        if(input.hasNextInt()){
            year = input.nextInt();
        }else {
            view.showErrorMessage(view.wrongDataLabel);
            year = Calendar.getInstance().get(Calendar.YEAR);
            System.out.println("Year is set to localdate.");
        }
        System.out.println("Enter month:");
        input.nextLine();
        if(input.hasNextInt()){
            month = input.nextInt();
        }else{
            view.showErrorMessage(view.wrongDataLabel);
            month = getMonthFromLocalDate();
            System.out.println("Month is set to localdate.");
        }
        //ADD new competition to refereeArrayList.
        competitionArrayList.add(new Competition(compName, country, year, month, competitionID));
        competitionID++;
        System.out.println(view.separation);
        view.showSavedMessage(view.competitionLabel);
        System.out.println(view.separation);
    }

    /**
     * This method add new classification object to classification ArrayList.
     *
     */
    private void addClassification(){
        Scanner input = new Scanner(System.in);
        try {
            showPersonList(objectTypeIdReferee);
            System.out.println("Enter refereeID:");
            int inputRefereeID = input.nextInt();
            showCompetition();
            System.out.println("Enter competition ID:");
            int inputCompetitionID = input.nextInt();
            showPersonList(objectTypeIdAssessor);
            System.out.println("Enter assessor ID:");
            int inputAssessorID = input.nextInt();
            System.out.println("Enter classification ("+view.floatMaskLabel+"):");
            Float classification = input.nextFloat();
            //ADD new classification to refereeArrayList.
            classificationArrayList.add(new Classification(classificationID, inputRefereeID, inputCompetitionID, classification,inputAssessorID));
            classificationID++;
            System.out.println(view.separation);
            view.showSavedMessage(view.classificationLabel);
            System.out.println(view.separation);
        }catch(Exception e){
            view.showErrorMessage(view.wrongDataLabel);
        }
    }

    /**
     * This method print referee/assessor list from referee/assessor ArrayList.
     * @param objectType 1: Referee, 4: Assessor
     */
    private void showPersonList(Integer objectType){
        System.out.println(view.separation);
        System.out.print(view.starSeparation+" ");
        if (objectType.equals(objectTypeIdReferee)){
            System.out.print(view.refereeLabel);
        } else if(objectType.equals(objectTypeIdAssessor)){
            System.out.print(view.assessorLabel);
        }
        System.out.println(" LIST "+view.starSeparation);
        if (objectType.equals(objectTypeIdReferee)) {
            refereeArrayList.forEach((System.out::println));
        }
        else if(objectType.equals(objectTypeIdAssessor)){
            assessorArrayList.forEach((System.out::println));
        }

        System.out.println(view.separation);
    }

    /**
     * This method print competition list from competition ArrayList.
     */
    private void showCompetition(){
        System.out.println(view.starSeparation+" "+view.competitionLabel+" LIST "+view.starSeparation);
        System.out.println(view.separation);
        for(Competition competition : competitionArrayList){
            System.out.print(" ["+competition.getCompetitionID()+"] "+competition.getCompName()+" - "+competition.getCountry()+" - ");
            System.out.println(competition.getYear()+"-"+competition.getMonth());
        }
        System.out.println(view.separation);
    }

    /**
     * This method print classification list from classification ArrayList.
     */
    public void showClassification(){
        System.out.println(view.starSeparation+" "+view.classificationLabel+" LIST "+view.starSeparation);
        System.out.println(view.separation);
        System.out.println("Cl.Id [RefereeID] Referee   |  Competition   |  AssessorId | Classification");
        System.out.println(view.separation);
        for(Classification classification : classificationArrayList){
            System.out.print(classification.getClassificationID()+". ");
            //Referee's data
            System.out.print(getDataByPersonId(1,classification.getRefereeID(),1)+" | ");

            for(Competition competition : competitionArrayList) {
                if(competition.getCompetitionID().equals(classification.getCompetitionID()) ){
                    System.out.print(" ["+competition.getCompetitionID()+"] "+competition.getCompName()+" "+competition.getCountry()+" | ");
                }
            }

            //Assessor's data
            System.out.print("["+classification.getAssessorID()+"] | ");

            System.out.println(" "+classification.getClassification());
        }
        System.out.println(view.separation);
    }

    /**
     * This metod calls metod för edit by objectType.
     * @param objectType  1: referee, 2: competition, 3: classification, 4: assessor
     */
    private void editObject(Integer objectType){
        Integer personId;
        Scanner input = new Scanner(System.in);
        System.out.println(view.starSeparation+" EDIT "+view.starSeparation);
        //Referee
        if(objectType.equals(objectTypeIdReferee)) {
            if(refereeArrayList.size() == 0) {
                System.out.println(view.separation);
                view.showMessage(view.noRefereeFoundLabel);
                System.out.println(view.separation);
            }else {
                showPersonList(objectTypeIdReferee);
                System.out.println("Enter  refereeID:");
                if(input.hasNextInt()){
                    personId = input.nextInt();
                    editPerson(objectType, personId);
                }else{
                    view.showErrorMessage(view.wrongDataLabel);
                }

            }
        }else if(objectType.equals(objectTypeIdCompetition)){
            if(competitionArrayList.size() == 0) {
                System.out.println(view.separation);
                view.showMessage(view.noCompetitionFoundLabel);
                System.out.println(view.separation);
            }else {
                showCompetition();
                System.out.println("Enter  competition ID:");
                Integer compID = input.nextInt();
                editCompetition(compID);
            }
        }else if(objectType.equals(objectTypeIdClassification)){
            if(classificationArrayList.size() == 0) {
                System.out.println(view.separation);
                view.showMessage(view.noClassificationFoundLabel);
                System.out.println(view.separation);
            }else {
                showClassification();
                System.out.println("Enter classification ID:");
                Integer userInput = input.nextInt();
                editClassification(userInput);
            }

        }else {
            if(assessorArrayList.size() == 0) {
                System.out.println(view.separation);
                view.showMessage(view.noAssessorFoundLabel);
                System.out.println(view.separation);
            }else {
                showPersonList(objectTypeIdAssessor);
                System.out.println("Enter  assessorID:");
                if(input.hasNextInt()){
                    personId = input.nextInt();
                    editPerson(objectType, personId);
                }else{
                    view.showErrorMessage(view.wrongDataLabel);
                }
            }
        }
    }

    /**
     * This metod edit attributs (Familyname/GivenName/Nation) of referee/assessor object.
     * @param objectType  1: referee, 4: assessor
     * @param personID ID of person
     */
    private void editPerson (Integer objectType, int personID){
        String userString="";
        Scanner scanner = new Scanner(System.in);

        System.out.println(view.editPersonMenu);
        view.showMessage(view.makeAChoiceLabel);
        Integer editMenuChoice = addSubMenuChoice();

        if (editMenuChoice.equals(1)){
            System.out.println("Enter new familyname:");
            userString = scanner.nextLine();
        }
        else if (editMenuChoice.equals(2)){
            System.out.println("Enter new givenname:");
            userString = scanner.nextLine();
        }
        else if (editMenuChoice.equals(3)){
            System.out.println("Enter new nation:");
            userString = scanner.nextLine();
        }

        if (objectType.equals(objectTypeIdReferee)) {
            for (Referee referee : refereeArrayList) {
                if (referee.getPersonID() == personID) {
                    if (editMenuChoice.equals(1)) {
                        referee.setFamilyName(userString);
                        view.showSavedMessage("");
                    } else if (editMenuChoice.equals(2)) {
                        referee.setGivenName(userString);
                        view.showSavedMessage("");
                    } else if (editMenuChoice.equals(3)) {
                        referee.setNation(userString);
                        view.showSavedMessage("");
                    }
                }
            }
        } else if (objectType.equals(objectTypeIdAssessor)){
            for (Assessor assessor : assessorArrayList) {
                if (assessor.getPersonID().equals(personID)) {
                    if (editMenuChoice.equals(1)) {
                        assessor.setFamilyName(userString);
                        view.showSavedMessage("");
                    } else if (editMenuChoice.equals(2)) {
                        assessor.setGivenName(userString);
                        view.showSavedMessage("");
                    } else if (editMenuChoice.equals(3)) {
                        assessor.setNation(userString);
                        view.showSavedMessage("");
                    }
                }
            }
        }
    }

    /**
     * This metod edit attributs (name/year/month) of competition object in competition ArrayList.
     * @param competitionID ID of competition.
     */
    private void editCompetition(Integer competitionID){
        String userString="";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Edit "+view.competitionLabel+" name (1) year (2) month (3)");
        view.showMessage(view.makeAChoiceLabel);
        int editMenuChoice = scanner.nextInt();
        //Important!!!
        scanner.nextLine();

        if (editMenuChoice == 1){
            System.out.println("Enter new "+view.competitionLabel+" name:");
            userString = scanner.nextLine();
        }
        else if (editMenuChoice == 2){
            System.out.println("Enter new year:");
            userString = scanner.nextLine();
        }
        else if (editMenuChoice == 3){
            System.out.println("Enter new month:");
            userString = scanner.nextLine();
        }

        for (Competition competition : competitionArrayList) {
            if (competition.getCompetitionID().equals(competitionID)) {
                if (editMenuChoice == 1) {
                    competition.setCompName(userString);
                } else if (editMenuChoice == 2) {
                    competition.setYear(parseInt(userString));
                } else if (editMenuChoice == 3) {
                    competition.setMonth(parseInt(userString));
                }
            }
        }
    }

    /**
     * This metod edit classification in classification ArrayList.
     * @param classificationID Id of classification
     */
    private void editClassification(Integer classificationID){
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("New " + view.classificationLabel + " ("+view.floatMaskLabel+"):");
            Float newClassification = input.nextFloat();

            for (Classification classification : classificationArrayList) {
                if (classification.getClassificationID().equals(classificationID)) {
                    classification.setClassification(newClassification);
                }
            }
            showClassification();
        }catch(Exception e){
            view.showErrorMessage(view.wrongDataLabel);
        }
    }

    /**
     * This metod calls metod för delete by objectType.
     * @param objectType 1: referee, 2: competition, 3: classification, 4: assessor
     */
    private void deleteObject(Integer objectType){
        Scanner input = new Scanner(System.in);
        Integer userInput;
        //Referee
        if(objectType.equals(objectTypeIdReferee)) {
            if(refereeArrayList.size() == 0){
                System.out.println(view.separation);
                view.showMessage(view.noRefereeFoundLabel);
                System.out.println(view.separation);
            }else {
                showPersonList(objectTypeIdReferee);
                view.showMessage(view.enterLabel+view.refereeLabel+" ID:");
                if(input.hasNextInt()) {
                    userInput = input.nextInt();
                    deleteReferee(userInput);
                    showPersonList(objectTypeIdReferee);
                }
                else{
                    view.showErrorMessage(view.wrongDataLabel);
                }
            }
        }else if(objectType.equals(objectTypeIdCompetition)){
            if(competitionArrayList.size() == 0){
                System.out.println(view.separation);
                view.showMessage(view.noCompetitionFoundLabel);
                System.out.println(view.separation);
            }else {
                showCompetition();
                view.showMessage(view.enterLabel+view.competitionLabel+" ID:");
                if(input.hasNextInt()){
                    userInput = input.nextInt();
                    deleteCompetition(userInput);
                    showCompetition();
                } else{
                    view.showErrorMessage(view.wrongDataLabel);
                }
            }
        }else if(objectType.equals(objectTypeIdClassification)){
            if(classificationArrayList.size() == 0){
                System.out.println(view.separation);
                view.showMessage(view.noClassificationFoundLabel);
                System.out.println(view.separation);
            }else {
                showClassification();
                view.showMessage(view.enterLabel+view.classificationLabel+" ID:");
                if(input.hasNextInt()) {
                    userInput = input.nextInt();
                    deleteClassification(userInput);
                    showClassification();
                }else{
                    view.showErrorMessage(view.wrongDataLabel);
                }
            }
        }else {
            if(assessorArrayList.size() == 0){
                System.out.println(view.separation);
                view.showMessage(view.noAssessorFoundLabel);
                System.out.println(view.separation);
            }else {
                showPersonList(objectTypeIdAssessor);
                view.showMessage(view.enterLabel+view.assessorLabel+" ID:");
                if(input.hasNextInt()) {
                    userInput = input.nextInt();
                    deleteAssessor(userInput);
                    showPersonList(objectTypeIdAssessor);
                }else{
                    view.showErrorMessage(view.wrongDataLabel);
                }
            }
        }
    }

    /**
     * This method deletes an referee object from referee Arraylist by refereeID.
     * the classifications related to the referee.
     * @param refereeID Referee's Id
     */
    private void deleteReferee(Integer refereeID){
        boolean isDeleted = false;
        try {
            for (int i = 0; i < classificationArrayList.size(); i++) {
                Classification classification = classificationArrayList.get(i);
                if (classification.getRefereeID() == refereeID) {
                    classificationArrayList.remove(i);
                    isDeleted = true;
                }
            }

            for (int i = 0; i < refereeArrayList.size(); i++) {
                Referee referee = refereeArrayList.get(i);
                if (referee.getPersonID() == refereeID) {
                    refereeArrayList.remove(i);
                    isDeleted = true;
                }
            }
            if (isDeleted == true) {
                view.showMessage(view.deletedLabel);
            }else{
                view.showMessage(view.notFoundLabel);
            }
        } catch (Exception e){
            view.showErrorMessage(view.wrongDataLabel);
        }
    }

    /**
     * This method deletes an assessor object from assessor Arraylist by assessorID.
     * @param assessorID Assessor's ID
     */
    private void deleteAssessor(Integer assessorID){
        boolean isDeleted = false;
        try {
            for (int i = 0; i < assessorArrayList.size(); i++) {
                Assessor assessor = assessorArrayList.get(i);
                if (assessor.getPersonID() == assessorID) {
                    assessorArrayList.remove(i);
                    isDeleted = true;
                }
            }
            if(isDeleted == true) {
                view.showMessage(view.deletedLabel);
            } else {
                view.showMessage(view.notFoundLabel);
            }
        }catch (Exception e){
            view.showErrorMessage(view.wrongDataLabel);
        }
    }

    /**
     * This method deletes an competition object from competition Arraylist by competitionID and
     * the classifications related to the competition.
     * @param competitionID competition's ID
     */
    private void deleteCompetition(Integer competitionID){
        boolean isDeleted = false;
        try {
            for (int i = 0; i < classificationArrayList.size(); i++) {
                Classification classification = classificationArrayList.get(i);
                if (classification.getCompetitionID() == competitionID) {
                    classificationArrayList.remove(i);
                    isDeleted = true;
                }
            }
            for (int i = 0; i < competitionArrayList.size(); i++) {
                Competition competition = competitionArrayList.get(i);
                if (competition.getCompetitionID() == competitionID) {
                    competitionArrayList.remove(i);
                    isDeleted = true;
                }
            }
            if (isDeleted == true) {
                view.showMessage(view.deletedLabel);
            }
            else {
                view.showMessage(view.notFoundLabel);
            }
        }catch (Exception e){
            view.showErrorMessage(view.wrongDataLabel);
        }
    }

    /**
     * This method deletes an classification object from classification Arraylist by classificationID..
     * @param classificationID id of classification
     */
    private void deleteClassification(Integer classificationID){
        boolean isDeleted = false;
        try{
            classificationArrayList.remove(classificationID);
            for(int i = 0; i<classificationArrayList.size(); i++){
                Classification classification = classificationArrayList.get(i);
                if(classification.getClassificationID() == classificationID){
                    classificationArrayList.remove(i);
                    isDeleted = true;
                }
            }
            if(isDeleted == true){
                view.showMessage(view.deletedLabel);
            } else {
                view.showMessage(view.notFoundLabel);
            }
        }
        catch(Exception e){
            view.showErrorMessage(view.wrongDataLabel);
        }
        finally {
            view.showMessage(view.doneLabel);
        }
    }

    /**
     * This metod search referee or assessor in referee or assessor ArrayList. Print resultslist.
     * @param objectType 1: referee, 4: assessor
     */
    private void searchPersonByData(Integer objectType){
        boolean isFound = false;
        boolean isFoundAndWrite = false;
        Scanner input = new Scanner(System.in);
        String searchInput;

        if(objectType.equals(objectTypeIdReferee)){
            if(refereeArrayList.size() == 0) {
                System.out.println(view.separation);
                view.showMessage(view.noRefereeFoundLabel);
            }else {
                System.out.println(view.refereeLabel.toUpperCase());
                view.showMessage(view.enterLabel + "familyName");
                searchInput = input.nextLine();
                System.out.println(view.separation);

                //REFEREE
                for (Referee referee : refereeArrayList) {
                    isFound = referee.getFamilyName().toUpperCase().indexOf(searchInput.toUpperCase()) != -1 ? true : false;
                    if (isFound == true) {
                        System.out.println(getDataByPersonId(objectTypeIdReferee, referee.getPersonID(), 2));
                        isFoundAndWrite = true;
                    }
                }
                if(isFoundAndWrite == false){
                    view.showMessage(view.notFoundLabel);
                }
            }
        }else{
            if(assessorArrayList.size() == 0) {
                System.out.println(view.separation);
                view.showMessage(view.noAssessorFoundLabel);
            }else {
                System.out.println(view.assessorLabel.toUpperCase());
                System.out.println("Search by FamilyName:");
                searchInput = input.nextLine();
                System.out.println(view.separation);

                for (Assessor assessor : assessorArrayList) {
                    isFound = assessor.getFamilyName().toUpperCase().indexOf(searchInput.toUpperCase()) != -1 ? true : false;
                    if (isFound == true) {
                        System.out.println(getDataByPersonId(objectTypeIdAssessor, assessor.getPersonID(), 2));
                        isFoundAndWrite = true;
                    }
                }
                if(isFoundAndWrite == false){
                    view.showMessage(view.notFoundLabel);
                }
            }
        }
        System.out.println(view.separation);
    }

    /**
     * This metod search competition in competition ArrayList by competition name. Print resultslist.
     */
    private void searchCompetition(){
        Scanner input = new Scanner(System.in);

        System.out.println(view.competitionLabel.toUpperCase());
        view.showMessage(view.enterLabel+" :");
        String searchText = input.nextLine();

        System.out.println(view.separation);
        for(Competition competition : competitionArrayList){
            boolean isFound = competition.getCompName().indexOf(searchText) !=-1? true: false;
            if(isFound == true) {
                System.out.print(" ("+competition.getCompetitionID()+") "+competition.getCompName()+" - "+competition.getCountry()+" - ");
                System.out.println(competition.getYear()+"-"+competition.getMonth());
            }
        }
        System.out.println(view.separation);
    }

    /**
     * This metod search classification in classification ArrayList by classification. Print resultslist.
     */
    private void searchClassification(){
        Scanner input = new Scanner(System.in);

        System.out.println(view.separation);
        view.showMessage(view.doneLabel+view.classificationLabel+view.floatMaskLabel+":");
        try {
            Float serachFloat = input.nextFloat();
            for(Classification classification : classificationArrayList){
                if(classification.getClassification().equals(serachFloat)) {
                    System.out.print(getDataByPersonId(objectTypeIdReferee,classification.getRefereeID(),1));
                    System.out.print("  "+classification.getClassification()+" ");
                    System.out.println(getDataByPersonId(objectTypeIdAssessor,classification.getAssessorID(),1));
                }
            }
        }catch (Exception e){
            view.showErrorMessage(view.wrongDataLabel);
        }
        System.out.println(view.separation);
    }

    /**
     * This method order ArrayList by ID/name/Classification.
     * @param objectType 1: referee, 2: competition, 3: classification, 4: assessor
     */
    private void orderByList(Integer objectType){
        Scanner scanner = new Scanner(System.in);
        Integer userInput;

        if(objectType.equals(objectTypeIdReferee) || objectType.equals(objectTypeIdAssessor)){
            view.showText(view.orderByPersonMenu);
        } else if (objectType.equals(objectTypeIdCompetition)){
            view.showText(view.orderByCompetitionMenu);
        } else if (objectType.equals(objectTypeIdClassification)){
            view.showText(view.orderByClassificationMenu);
        }
        view.showMessage(view.makeAChoiceLabel);
        userInput = addSubMenuChoice();

        if(objectType.equals(objectTypeIdReferee)){
            if(userInput.equals(1)){
                Referee.setSortBy(Referee.SortBy.REFEREEID);
                Collections.sort(refereeArrayList);
                showPersonList(objectTypeIdReferee);
            }else if(userInput.equals(2)){
                Referee.setSortBy(Referee.SortBy.FAMILYNAME);
                Collections.sort(refereeArrayList);
                showPersonList(objectTypeIdReferee);
            }else {
                view.showErrorMessage(view.noSuchMenuitemLabel);
            }
        }else if(objectType.equals(objectTypeIdCompetition)){
            if(userInput.equals(1)){
                //order by competition ID
                Competition.setSortBy(Competition.SortBy.COMPETITIONID);
                Collections.sort(competitionArrayList);
                showCompetition();
            }
            else if(userInput.equals(2)){
                //order by name
                Competition.setSortBy(Competition.SortBy.COMPNAME);
                Collections.sort(competitionArrayList);
                showCompetition();
            }
        }else if(objectType.equals(objectTypeIdClassification)){
            if(userInput.equals(1)){
                Classification.setSortBy(Classification.SortBy.REFEREEID);
                Collections.sort(classificationArrayList);
                showClassification();
            }else if(userInput.equals(2)){
                Classification.setSortBy(Classification.SortBy.COMPETITIONID);
                Collections.sort(classificationArrayList);
                showClassification();
            }else if(userInput.equals(3)){
                Classification.setSortBy(Classification.SortBy.CLASSIFICATION);
                Collections.sort(classificationArrayList);
                showClassification();
            }else if(userInput.equals(4)){
                Classification.setSortBy(Classification.SortBy.ASSESSORID);
                Collections.sort(classificationArrayList);
                showClassification();
            }else {
                view.showErrorMessage(view.noSuchMenuitemLabel);
            }
        }else if(objectType.equals(objectTypeIdAssessor)){
            if(userInput.equals(1)){
                Assessor.setSortBy(Assessor.SortBy.ASSESSORID);
                Collections.sort(assessorArrayList);
                showPersonList(objectTypeIdAssessor);
            }else if(userInput.equals(2)){
                Assessor.setSortBy(Assessor.SortBy.FAMILYNAME);
                Collections.sort(assessorArrayList);
                showPersonList(objectTypeIdAssessor);
            }else {
                view.showErrorMessage(view.noSuchMenuitemLabel);
            }
        }

    }

    /**
     * This metod print referees and competitions from file.
     */
    private void  readFromFile(){
        System.out.println(view.starSeparation+" "+view.competitionLabel.toUpperCase()+" LIST FROM FILE "+view.starSeparation);
        System.out.println(view.separation);
        try {
            ArrayList<Competition> competitionFromFile = FileUtils.readCompetitionObjects("CompetitionData.ser");
            for (Competition competition : competitionFromFile) {
                System.out.println(competition);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(view.separation);
        System.out.println(view.starSeparation+" "+view.refereeLabel.toUpperCase()+" LIST FROM FILE "+view.starSeparation);
        System.out.println(view.separation);
        try {
            ArrayList<Referee> refereeFromFile = FileUtils.readRefereeObjects("RefereeData.ser");
            //print list of referees
            refereeArrayList.forEach((System.out::println));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(view.separation);
    }

    /**
     * This metod print all countries from countriesArrayList.
     */
    private void printListCountries(){
        int count = 0;
        // Print list of countries.
        for(int i = 0; i < Data.countriesArrayList.size(); i++){
            System.out.print(Data.countriesArrayList.get(i));
            count++;
            if(count == 5){
                System.out.print("\n");
                count = 0;
            }
        }
        view.showMessage("\n"+View.starSeparation);
    }

}
