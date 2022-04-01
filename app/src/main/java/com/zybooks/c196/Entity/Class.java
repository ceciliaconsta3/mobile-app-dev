package com.zybooks.c196.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "class")

public class Class {

    @PrimaryKey(autoGenerate = true)
    private int classID,classCredits;
    private String className;

    public Class(int classID, String className, int classCredits) {
            this.classID = classID;
            this.className = className;
            this.classCredits = classCredits;
        }

    @Override
    public String toString(){
        return "Class{" +
                "classID=" + classID +
                ", className=' " + className + '\'' +
                ", classCredits=" + classCredits + '\'' +
//                ", termID=" + termID +
                '}';
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getClassCredits() {
        return classCredits;
    }

    public void setClassCredits(int classCredits) {
        this.classCredits = classCredits;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
