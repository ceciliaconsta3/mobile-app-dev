package com.zybooks.c196.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Course;
import com.zybooks.c196.R;

import androidx.appcompat.app.AppCompatActivity;

public class NewCourseDetail extends AppCompatActivity {
    //    Declare our edit course info
    int courseID;
    int credits;
    EditText editCourseName;
    EditText editCourseCredits;
    EditText editCourseStart;
    EditText editCourseEnd;
    EditText editCourseStatus;
    EditText editCourseNote;
    String name,status, start, end, note;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_course_detail);

        editCourseName = findViewById(R.id.editCourseName);
        editCourseCredits = findViewById(R.id.editCourseCredits);
        editCourseStatus = findViewById(R.id.editCourseStatus);
        editCourseStart = findViewById(R.id.editCourseStart);
        editCourseEnd = findViewById(R.id.editCourseEnd);
        editCourseNote = findViewById(R.id.editCourseNote);

        name = getIntent().getStringExtra("editCourseName");
        credits = getIntent().getIntExtra("editCourseCredits", 3);
        status = getIntent().getStringExtra("editCourseStatus");
        start = getIntent().getStringExtra("editCourseStart");
        end = getIntent().getStringExtra("editCourseEnd");
        note = getIntent().getStringExtra("editCourseNote");


        editCourseName.setText(name);
        editCourseCredits.setText(Integer.toString(credits));
        editCourseStatus.setText(status);
        editCourseStart.setText(start);
        editCourseEnd.setText(end);
        editCourseNote.setText(note);

    }


    public void saveCourseButton(View view) {
        Course course;
        Intent intent = new Intent(NewCourseDetail.this, CourseList.class);
        if (courseID == -1) {
            int newID = repo.getAllTerms().get(repo.getAllTerms().size() - 1).getTermID() + 1;
            course = new Course(newID,editCourseName.getText().toString(),credits, editCourseStart.getText().toString(), editCourseEnd.getText().toString(),editCourseStatus.getText().toString(), editCourseNote.getText().toString()
            );
            repo.insertCourse(course);
            startActivity(intent);
        } else {
            course = new Course(courseID,editCourseName.getText().toString(),credits, editCourseStart.getText().toString(), editCourseEnd.getText().toString(),editCourseStatus.getText().toString(), editCourseNote.getText().toString()
            );
            repo.updateCourse(course);
            startActivity(intent);
        }
    }
}
