package com.company;

import java.io.Serializable;

/**
 * Referee object with familyName, givenName, nation, licence, personID and YOB.
 * Referee is a person who receives classifications in a competition.
 */
public class Referee extends Person implements Serializable, Comparable<Referee> {
    private static SortBy sortBy = SortBy.REFEREEID;
    private int YOB;

    Referee(String familyName, String givenName, String nation, String licence, Integer personID, Integer YOB) {
        super(familyName, givenName, nation, licence, personID);
        this.YOB = YOB;
    }

    enum SortBy{
        REFEREEID,
        FAMILYNAME,
    }

    public static void setSortBy(Referee.SortBy sortBy) {
        Referee.sortBy = sortBy;
    }

    public String toString(){
        return "["+getPersonID()+"] " + getGivenName() + " " + getFamilyName() + " "+getNation()+" "+getLicence()+" "+getYOB();
    }

    public Integer getYOB(){
        return this.YOB;
    }

    @Override
    public int compareTo(Referee referee) {
        switch (sortBy){
            case REFEREEID:
                return this.getPersonID() - referee.getPersonID();
            case FAMILYNAME:
                return this.getFamilyName().compareTo(referee.getFamilyName());
            default:
                return 0;
        }
    }
}
