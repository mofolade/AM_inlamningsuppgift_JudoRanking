package com.company;

/**
 * Classification object with classificationID, refereeID (gets classification), competitionID, classification, , assessorID (gives classification).
 */
public class Classification implements Comparable<Classification> {
    private int refereeID;
    private int competitionID;
    private Float classification;
    private int classificationID;
    private int assessorID;
    private static SortBy sortBy = SortBy.COMPETITIONID;


    enum SortBy{
        REFEREEID,
        COMPETITIONID,
        ASSESSORID,
        CLASSIFICATION,
    }

    public static void setSortBy(SortBy sortBy) {
        Classification.sortBy = sortBy;
    }

    @Override
    public int compareTo(Classification classification) {
        switch (sortBy){
            case REFEREEID:
                return this.getRefereeID() - classification.getRefereeID();
            case COMPETITIONID:
                return this.getCompetitionID() - classification.getCompetitionID();
            case CLASSIFICATION:
                if (Math.round(this.getClassification()*10) < Math.round(classification.getClassification()*10)) {
                    return 1;
                }else if (Math.round(this.getClassification()*10) > Math.round(classification.getClassification()*10)){
                    return -1;
                }else {
                    return 0;
                }
            case ASSESSORID:
                return this.getAssessorID() - classification.getAssessorID();
            default:
                return this.getAssessorID() - classification.getAssessorID();
        }
    }

    /**
     * Class construtor.
     * @param classificationID id of classfication.
     * @param refereeID id of referee.
     * @param competitionID id of competition.
     * @param classification classification
     * @param assessorID id of assessor.
     */
    public Classification(Integer classificationID, Integer refereeID, Integer competitionID, Float classification, Integer assessorID) {
        this.classificationID = classificationID;
        this.refereeID = refereeID;
        this.classification = classification;
        this.competitionID = competitionID;
        this.assessorID = assessorID;
    }

    public Integer getClassificationID(){
        return this.classificationID;
    }

    public Integer getCompetitionID() {
        return this.competitionID;
    }

    public Float getClassification() {
        return this.classification;
    }

    public Integer getRefereeID() {
        return this.refereeID;
    }

    public Integer getAssessorID(){return this.assessorID; }

    public void setClassification(Float newClassification) {
        this.classification = newClassification;
    }
}
