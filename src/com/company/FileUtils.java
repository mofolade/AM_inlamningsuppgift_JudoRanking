package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * File manager.
 */
public class FileUtils {


    public FileUtils(){

    }

    /**
     * Read from file.
     * @param fileName name of file
     * @return all data
     */
    public static List readAllLines(String fileName) {
        List<String> listOfStrings = null;
        View view = View.getInstance();

        try {
            listOfStrings = Files.readAllLines(Paths.get(fileName));

        } catch (Exception e) {
            view.showErrorMessage(View.errorReadingFileLabel);
        }

        return listOfStrings;
    }

    /**
     * Write the contents of the array to a file.
     * @param listOfCompetition all competitions
     * @param listOfReferee all referees
     * @param listOfAssessor all assessors
     */
    public static void writeObjects(List<Competition> listOfCompetition, List<Referee> listOfReferee, List<Assessor> listOfAssessor){
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;

        try{
            fileOutputStream = new FileOutputStream("CompetitionData.ser", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listOfCompetition);
            objectOutputStream.close();
            fileOutputStream.close();

            fileOutputStream = new FileOutputStream("RefereeData.ser", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listOfReferee);
            objectOutputStream.close();
            fileOutputStream.close();

            fileOutputStream = new FileOutputStream("AssessorData.ser", false);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listOfAssessor);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList<Competition> readCompetitionObjects(String fileName){
        ObjectInputStream objectinputstream = null;
        ArrayList<Competition> competitionFromFile = null;
        //ArrayList<Referee> arraylist= new ArrayList<Referee>();

        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            competitionFromFile = (ArrayList<Competition>) objectinputstream.readObject();
            objectinputstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return referee;
        return competitionFromFile;
    }

    public static ArrayList<Referee> readRefereeObjects(String fileName){
        ObjectInputStream objectinputstream = null;
        ArrayList<Referee> refereeFromFile = null;
        //ArrayList<Referee> arraylist= new ArrayList<Referee>();

        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            refereeFromFile = (ArrayList<Referee>) objectinputstream.readObject();
            objectinputstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return referee;
        return refereeFromFile;
    }

    /*public static ArrayList<Assessor> readAssessorObjects(String fileName){
        ObjectInputStream objectinputstream = null;
        ArrayList<Assessor> assessorFromFile = null;
        //ArrayList<Referee> arraylist= new ArrayList<Referee>();

        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            assessorFromFile = (ArrayList<Assessor>) objectinputstream.readObject();
            objectinputstream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return referee;
        return assessorFromFile;
    }*/


    private static void assertTrue(boolean b) {
    }

}
