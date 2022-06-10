package com.zybooks.c196.UI;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Course;
import com.zybooks.c196.Entity.Term;
import com.zybooks.c196.R;
import com.zybooks.c196.UI.CourseAdapter;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TermDetail extends AppCompatActivity {
    int termID;
    EditText editTermName;
    EditText editTermStart;
    EditText editTermEnd;
    String name, start, end;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_detail);

        // populate course list above term details
        RecyclerView recyclerView2 = findViewById(R.id.currentTermCoursesRecyclerView);
        Repository repo2 = new Repository(getApplication());
        List<Course> courses2 = repo2.getAllCourses();
        final CourseAdapter adapter2 = new CourseAdapter(this);

        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(adapter2);
        adapter2.setCourses(courses2);

        editTermName = findViewById(R.id.editTermName);
        editTermStart = findViewById(R.id.editTermStart);
        editTermEnd = findViewById(R.id.editTermEnd);

        // getting these extras from the adapter
        termID = getIntent().getIntExtra("id", -1);
        name = getIntent().getStringExtra("name");
        start = getIntent().getStringExtra("startDate");
        end = getIntent().getStringExtra("endDate");

        editTermName.setText(name);
        editTermStart.setText(start);
        editTermEnd.setText(end);

    }


//    TODO: Update function is not working
//    TODO: replace startDate and endDate textfields with data pickers using COHORT 4
    public void saveTermDetailButton(View view) {
        Term term;
        Intent intent = new Intent(TermDetail.this, TermList.class);
        if(termID == -1){
            int newID = repo.getAllTerms().get(repo.getAllTerms().size() - 1).getTermID() + 1;
            term = new Term(newID, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
            repo.insertTerm(term);
            startActivity(intent);
        } else {
            term = new Term(termID, editTermName.getText().toString(), editTermStart.getText().toString(), editTermEnd.getText().toString());
            repo.updateTerm(term);
            startActivity(intent);
        }


    }
}
