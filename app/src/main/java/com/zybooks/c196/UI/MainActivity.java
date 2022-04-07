package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Course;
import com.zybooks.c196.Entity.Term;
import com.zybooks.c196.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // make an "intent" to add eventlistener that redirects to a new screen
    public void enterHere(View view) {
        // insert test data into database
        Repository repo = new Repository(getApplication());
        Term term = new Term(1,"Spring","03-01-2022","03-31-2022");
        Course course = new Course(1,"Mobile Application Development",4,"04-01-2022", "04-30-2022","In Progress");
        repo.insertTerm(term);
        repo.insertCourse(course);

        Intent intent = new Intent(MainActivity.this,TermList.class);
        startActivity(intent);
    }
}