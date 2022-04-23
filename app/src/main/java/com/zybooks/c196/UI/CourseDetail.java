package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Course;
import com.zybooks.c196.Entity.Term;
import com.zybooks.c196.R;

import java.util.List;

public class CourseDetail extends AppCompatActivity {

    //    Declare our edit text
    int courseID, courseCredits;
    EditText editCourseName;
    EditText editCourseCredits;
    EditText editCourseStartDate;
    EditText editCourseEndDate;
    EditText editCourseStatus;
    EditText editCourseNote;
    String name, start, end, status, note;
    Repository repo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        editCourseName = findViewById(R.id.editCourseName);
        editCourseCredits = findViewById(R.id.editCourseCredits);
        editCourseStartDate = findViewById(R.id.editCourseStart);
        editCourseEndDate = findViewById(R.id.editCourseEnd);
        editCourseStatus = findViewById(R.id.editCourseStatus);
        editCourseNote = findViewById(R.id.editCourseNote);

        // getting these extras from the adapter
        courseID = getIntent().getIntExtra("id", -1);
        courseCredits = getIntent().getIntExtra("credits", -1);
        name = getIntent().getStringExtra("name");
        start = getIntent().getStringExtra("startDate");
        end = getIntent().getStringExtra("endDate");
        status = getIntent().getStringExtra("status");
        note = getIntent().getStringExtra("note");

        editCourseName.setText(name);
        editCourseCredits.setText(courseCredits);
        editCourseStartDate.setText(start);
        editCourseEndDate.setText(end);
        editCourseStatus.setText(status);
        editCourseNote.setText(note);


        // have to actually put the items on the CourseListRecyclerView in the CoursesList activity
        RecyclerView recyclerView = findViewById(R.id.currentTermCoursesRecyclerView);
        repo = new Repository(getApplication());
        // need to retrieve course id from last screen
        List<Course> courses = repo.getAllCourses();
        final CourseAdapter adapter = new CourseAdapter(this);
        // need to set the layout manager in this
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // need to set the adapter to the courselistRecyclerView as well for the handoff to complete
        recyclerView.setAdapter(adapter);
        adapter.setCourses(courses);
    }



//    TODO: Update function is not working
//    TODO: replace startDate and endDate textfields with data pickers using COHORT 4

    public void saveCourseDetailButton(View view) {
        Course course;
        Intent intent = new Intent(CourseDetail.this, CourseList.class);
        if(courseID == -1){
            int newID = repo.getAllCourses().get(repo.getAllCourses().size() - 1).getCourseID() + 1;
                course = new Course(newID, editCourseName.getText().toString(), editCourseCredits.getInputType(),editCourseStartDate.getText().toString(), editCourseEndDate.getText().toString(), editCourseStatus.getText().toString(), editCourseNote.getText().toString());
            repo.insertCourse(course);
            startActivity(intent);
        } else {
            course = new Course(courseID, editCourseName.getText().toString(),editCourseCredits.getInputType(),editCourseStartDate.getText().toString(), editCourseEndDate.getText().toString(),editCourseStatus.getText().toString(),editCourseNote.getText().toString());
            repo.updateCourse(course);
            startActivity(intent);
        }


    }


}