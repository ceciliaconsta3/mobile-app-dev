package com.zybooks.c196.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tests")
public class Test {

    @PrimaryKey(autoGenerate = true)
    private int testID;
    private String testTitle, testType, testEndDate;
//    TODO: Type is either performance or objective


    public Test(int testID, String testTitle, String testType, String testEndDate) {
        this.testID = testID;
        this.testTitle = testTitle;
        this.testType = testType;
        this.testEndDate = testEndDate;
    }

    public int getTestID() {
        return testID;
    }

    public void setTestID(int testID) {
        this.testID = testID;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public String gettestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestEndDate() {
        return testEndDate;
    }

    public void setTestEndDate(String testEndDate) {
        this.testEndDate = testEndDate;
    }
}
