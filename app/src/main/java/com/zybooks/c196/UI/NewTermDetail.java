package com.zybooks.c196.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Term;
import com.zybooks.c196.R;

import androidx.appcompat.app.AppCompatActivity;

public class NewTermDetail extends AppCompatActivity {
    //    Declare our edit text
    int termID;
    EditText addTermName;
    EditText addTermStart;
    EditText addTermEnd;
    String name, start, end;
    Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_term_detail);

        addTermName = findViewById(R.id.addTermName);
        addTermStart = findViewById(R.id.addTermStart);
        addTermEnd = findViewById(R.id.addTermEnd);

        termID = getIntent().getIntExtra("termID", -1);
        name = getIntent().getStringExtra("addTermName");
        start = getIntent().getStringExtra("editTermStart");
        end = getIntent().getStringExtra("addTermEnd");

        addTermName.setText(name);
        addTermStart.setText(start);
        addTermEnd.setText(end);

        repo = new Repository(getApplication());
    }

//    TODO: Update function is not working
//    TODO: replace startDate and endDate textfields with data pickers using COHORT 4


//    NOTES
//    In your layout = activity park list, put another termlistRecyclerView outside of the scroll view
//    don't forget to give it a unique ID '
//    what part of the app makes the termlistRecyclerView refresh when hitting the save button
//    recommended to use an intent to change the view, it's a mystery
//    put the termlistRecyclerView at the bottom of the scrollview
//    put recycler view with list of courses that are associated with the term = same screen as create new term
//    Pair button with date picker to display information not the textView


    public void saveButton(View view) {
        Term term;
        Intent intent = new Intent(NewTermDetail.this, TermList.class);
        if(termID == -1){
            int newID = repo.getAllTerms().get(repo.getAllTerms().size() - 1).getTermID() + 1;
            term = new Term(newID, addTermName.getText().toString(), addTermStart.getText().toString(), addTermEnd.getText().toString());
            repo.insertTerm(term);
            startActivity(intent);
        } else {
            term = new Term(termID, addTermName.getText().toString(), addTermStart.getText().toString(), addTermEnd.getText().toString());
            repo.updateTerm(term);
            startActivity(intent);
        }


    }
}
