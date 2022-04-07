package com.zybooks.c196.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "terms")
public class Term {

    @PrimaryKey(autoGenerate = true)
    private int termID;
    private String termName, startDate, endDate;

    public Term(int termID, String termName, String startDate, String endDate ) {
        this.termID = termID;
        this.termName = termName;
        this.startDate = startDate;
        this.endDate = endDate;
        // TODO: go to live session sat 1-3pm with Carolyn and sun with Richard
    }


    @Override
    public String toString() {
        return "Term{" +
                "termID=" + termID +
                ", termName=' " + termName +
                ", startDate=' " + startDate +
                ", endDate= ' " + endDate + '\'' +
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

