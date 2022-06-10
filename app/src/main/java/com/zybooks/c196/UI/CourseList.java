package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Course;
import com.zybooks.c196.Entity.Term;
import com.zybooks.c196.R;

import java.util.List;

public class CourseList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        RecyclerView recyclerView = findViewById(R.id.courseListRecyclerView);
        Repository repo = new Repository(getApplication());
        List<Course> courses = repo.getAllCourses();
        final CourseAdapter adapter = new CourseAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setCourses(courses);

//        Need to populate courses on the Term Detail screen
        setContentView(R.layout.activity_term_detail);
        RecyclerView recyclerView2 = findViewById(R.id.currentTermCoursesRecyclerView);
        Repository repo2 = new Repository(getApplication());
        List<Course> courses2 = repo2.getAllCourses();
        final CourseAdapter adapter2 = new CourseAdapter(this);

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(adapter2);
        adapter.setCourses(courses2);


    }


//TODO: Find where this belongs
//        for(Term term, repository.getAllTerms()){
//        if(term.getTermID() == termID){
//            currentTerm = term;
//        }
//        numCourses = 0;
//        for(Course course : repository.getAllCourses()){
//            if(course.getTermID() == termID){}
//            ++numCourses;
//        }
//        if(numCourses == 0){
//            repository.deleteTerm(currentTerm);
//            Toast.makeText(CourseList.this,currentTerm.getTermName() +" was deleted", Toast.LENGTH_LONG).show();
//        } else {
//            Toast.makeText(CourseList.this,"Can't delete a term with courses still attached", Toast.LENGTH_LONG).show();
//        }
//        return true;
//    }

    public void goToCourseDetail(View view){
        Intent intent = new Intent(CourseList.this, CourseDetail.class);
        startActivity(intent);
    }


    public void goToNewCourseDetail(View view){
        Intent intent = new Intent(CourseList.this, NewCourseDetail.class);
        startActivity(intent);
    }

}