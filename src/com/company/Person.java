package com.company;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Person has a familyName, givenName, nation, licence and personID.
 */
public abstract class Person implements Serializable {
    private String familyName;
    private String givenName;
    private String licence;
    private String nation;
    private Integer personID;

    public Person(String familyName, String givenName, String nation, String licence, Integer personID){
        this.familyName = familyName;
        this.givenName = givenName;
        this.licence = licence;
        this.nation = nation;
        this.personID = personID;
    }

    //abstract method
    public abstract String role();

    public String getFamilyName(){
        return this.familyName;
    }

    public String getGivenName(){
        return this.givenName;
    }

    public String getLicence(){
        return this.licence;
    }

    public String getNation(){
        return this.nation;
    }

    public Integer getPersonID(){
        return this.personID;
    }

    /**
     * Set the person's familyName.
     * @param familyName new familyName
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * Set the person's givenName.
     * @param givenName new givenName
     */
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    /**
     * Set the person's nation.
     * @param nation The nation to give this Person.
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setPersonID(Integer personID) {
        this.personID = personID;
    }

    public String toString() {
        return "["+personID+"] " + givenName + " " + familyName + " "+nation+" "+licence;
    }
}
