package com.company;

/**
 * Assessor is a person who gives classification for the referee in competition.
 */
public class Assessor extends Person implements Comparable<Assessor>{

    private static Assessor.SortBy sortBy = SortBy.ASSESSORID;

    Assessor(String familyName, String givenName, String nation, String licence, Integer personID) {
        super(familyName, givenName, nation, licence, personID);

    }

    enum SortBy{
        ASSESSORID,
        FAMILYNAME,
    }

    public static void setSortBy(Assessor.SortBy sortBy) {
        Assessor.sortBy = sortBy;
    }

    public String toString(){
        return super.toString();
    }

    @Override
    public int compareTo(Assessor assessor) {
        switch (sortBy){
            case ASSESSORID:
                return this.getPersonID() - assessor.getPersonID();
            case FAMILYNAME:
                return this.getFamilyName().compareTo(assessor.getFamilyName());
            default:
                return 0;
        }
    }
}
