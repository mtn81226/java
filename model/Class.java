package model;

public class Class {
    private int classID;
    private String description;
    private int numberOfCredits;

    public Class(int classID, String description, int numberOfCredits) {
        this.classID = classID;
        this.description = description;
        this.numberOfCredits = numberOfCredits;
    }

    public int getClassID() { return classID; }
    public String getDescription() { return description; }
    public int getNumberOfCredits() { return numberOfCredits; }

    @Override
    public String toString() {
        return "ClassID: " + classID + ", Description: " + description + ", Credits: " + numberOfCredits;
    }
}
