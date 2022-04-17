package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Term;
import com.zybooks.c196.R;

public class CourseDetail extends AppCompatActivity {


//    Declare our edit course info
    int courseID;
    int credits;
    EditText editCourseName;
    EditText editCourseCredits;
    EditText editCourseStart;
    EditText editCourseEnd;
    String name, start, end;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course_detail);

        editCourseName = findViewById(R.id.editTermName);
        editCourseCredits = findViewById(R.id.editCourseCredits);
        editCourseStart = findViewById(R.id.editCourseStart);
        editCourseEnd = findViewById(R.id.editCourseEnd);

        name = getIntent().getStringExtra("editCourseName");
        credits = getIntent().getIntExtra("editCourseCredits", 3);
        start = getIntent().getStringExtra("editCourseStart");
        end = getIntent().getStringExtra("editCourseEnd");

        editCourseName.setText(name);
        editCourseCredits.setText(Integer.toString(credits));
        editCourseStart.setText(start);
        editCourseEnd.setText(end);

    }


    public void saveCourseButton(View view) {
        Term term;
        Intent intent = new Intent(CourseDetail.this, CourseList.class);
        if (courseID == -1) {
            int newID = repo.getAllTerms().get(repo.getAllTerms().size() - 1).getTermID() + 1;
            term = new Term(newID, editCourseName.getText().toString(), editCourseStart.getText().toString(), editCourseEnd.getText().toString());
            repo.insertTerm(term);
            startActivity(intent);
        } else {
            term = new Term(courseID, editCourseName.getText().toString(), editCourseStart.getText().toString(), editCourseEnd.getText().toString());
            repo.updateTerm(term);
            startActivity(intent);
        }
    }
}