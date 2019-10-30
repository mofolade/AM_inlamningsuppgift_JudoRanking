package com.company;

/**
 * Assessor is a person who gives classification for the referee in competition.
 */
public class Assessor extends Person implements Comparable<Assessor>{

    private static Assessor.SortBy sortBy = SortBy.ASSESSORID;
    //composition has-a relationship
    private Address addressObj;
    private String address;
    private Integer addressType;

    Assessor(String familyName, String givenName, String nation, String licence, Integer personID, String address, Integer addressType) {
        super(familyName, givenName, nation, licence, personID);
        this.addressObj= new Address(address, addressType);
    }

    @Override
    public String role() {
        return View.assessorLabel;
    }

    enum SortBy{
        ASSESSORID,
        FAMILYNAME,
    }

    public static void setSortBy(Assessor.SortBy sortBy) {
        Assessor.sortBy = sortBy;
    }

    public String toString(){
        return super.toString()+" "+addressObj.getAddress();
    }

    public String getAddress(){
        return this.addressObj.getAddress();
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
