package com.zybooks.c196.Entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "courses")
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int courseID;
    private int courseCredits;
    private String courseName, courseStartDate, courseEndDate, courseStatus, courseNote;
//  private ArrayList<Instructor> instructors;
//  TODO: Create array of instructor objects that includes their: name, email, phone number
//  TODO: Minimum 1 optional note


    // optional class note
    public Course(int courseID, String courseName, int courseCredits, String courseStartDate, String courseEndDate, String courseStatus, String courseNote) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
        this.courseStatus = courseStatus;
        this.courseNote = courseNote;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName=' " + courseName +
                ", courseCredits=" + courseCredits +
                ", courseStartDate=' " + courseStartDate +
                ", courseEndDate=' " + courseEndDate +
                ", courseStatus=' " + courseStatus + '\'' +
                '}';
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseName = courseTitle;
    }

    public String getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(String courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public String getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(String courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseNote() {
        return courseNote;
    }

    public void setCourseNote(String courseNote) {
        this.courseNote = courseNote;
    }
}
