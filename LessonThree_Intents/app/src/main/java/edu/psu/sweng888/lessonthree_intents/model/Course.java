package edu.psu.sweng888.lessonthree_intents.model;

import java.io.Serializable;

public class Course implements Serializable {

    private int ID;
    private int credits;
    private String description;

    public Course(int ID, int credits, String description) {
        this.ID = ID;
        this.credits = credits;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
