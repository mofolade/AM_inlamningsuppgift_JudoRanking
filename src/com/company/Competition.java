package com.company;

import java.io.Serializable;

/**
 * Competition object with compaName, country, year, month and competitionID.
 */
public class Competition  implements Serializable, Comparable<Competition> {
    private String compName;
    private String country;
    private int year;
    private int month;
    private int competitionID;
    private static Competition.SortBy sortBy = SortBy.COMPETITIONID;

    public Competition(String compName, String country, int year, int month, int competitionID) {
        this.compName = compName;
        this.country = country;
        this.year = year;
        this.month = month;
        this.competitionID = competitionID;
    }

    public void Competition(String compName, String country, int year, int month, int competitionID){
        this.compName = compName;
        this.country = country;
        this.year = year;
        this.month = month;
    }

    public String getCompName(){
        return this.compName;
    }

    public String getCountry(){
        return this.country;
    }

    public Integer getYear(){
        return this.year;
    }

    public Integer getMonth(){
        return this.month;
    }

    public Integer getCompetitionID(){
        return this.competitionID;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String toString(){
        return "ID: "+competitionID+" "+compName + ", country: "+country+" "+year+"-"+month;
    }

    enum SortBy{
        COMPETITIONID,
        COMPNAME,
    }

    public static void setSortBy(Competition.SortBy sortBy) {
        Competition.sortBy = sortBy;
    }

    /*public String toString(){
        return super.toString();
    }*/

    @Override
    public int compareTo(Competition competition) {
        switch (sortBy) {
            case COMPETITIONID:
                return this.getCompetitionID() - competition.getCompetitionID();
            case COMPNAME:
                return this.getCompName().compareTo(competition.getCompName());
            default:
                return 0;
        }
    }
}
