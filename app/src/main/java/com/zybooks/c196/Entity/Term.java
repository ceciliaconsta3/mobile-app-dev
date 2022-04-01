package com.zybooks.c196.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "terms")
public class Term {

    @PrimaryKey(autoGenerate = true)
    private int termID;
    private String termName;

    public Term(int termID, String termName, double termPrice) {
        this.termID = termID;
        this.termName = termName;
        // just view + follow the task directions
        // add start/end date to term
        // go to live session sat 1-3pm with Carolyn and sun with Richard
    }


    @Override
    public String toString() {
        return "Term{" +
                "termID=" + termID +
                ", termName=' " + termName + '\'' +
                '}';
    }


    public int getTermID() {
        return termID;
    }

    public void setTermID(int termID) {
        this.termID = termID;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

}

