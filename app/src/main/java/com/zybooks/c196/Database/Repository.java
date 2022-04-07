package com.zybooks.c196.Database;


import android.app.Application;

import com.zybooks.c196.DAO.CourseDAO;
import com.zybooks.c196.DAO.TermDAO;
import com.zybooks.c196.Entity.Course;
import com.zybooks.c196.Entity.Term;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Dao;

@Dao
public class Repository {
    private CourseDAO mCourseDAO;
    private TermDAO mTermDAO;
    private List<Term> mAllTerms;
    private List<Course> mAllCourses;
    // creates thread in repo class by creating an executor service
    private static int NUMBER_OF_THREADS=4;
    static final ExecutorService databaseExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // constructor
    public Repository(Application application){
        DatabaseBuilder db = DatabaseBuilder.getDatabase(application);
        mCourseDAO = db.classDAO();
        mTermDAO = db.termDAO();
    }


    // creates an insert statement
    public void insertTerm(Term term){
        databaseExecutor.execute(() -> {
            mTermDAO.insert(term);
        }); // done on the second thread

        try{
            Thread.sleep(1000); // need a delay since thread is run asynchronously
        } catch(InterruptedException e){
            e.printStackTrace();}

    }

    public void insertCourse(Course course){
        databaseExecutor.execute(() -> {
            mCourseDAO.insert(course);
        }); // done on the second thread

        try{
            Thread.sleep(1000); // need a delay since thread is run asynchronously
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    // retrieve all terms from db
    public List<Term> getAllTerms(){
        databaseExecutor.execute(() -> {
            mAllTerms = mTermDAO.getAllTerms();
        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return mAllTerms;
    }

    public List<Course> getAllCourses(){
        databaseExecutor.execute(() -> {
            mAllCourses = mCourseDAO.getAllCourses();
        });

        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return mAllCourses;
    }

}
