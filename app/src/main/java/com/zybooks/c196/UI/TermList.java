package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Term;
import com.zybooks.c196.R;

import java.util.List;


//TODO: need to be able to add as many terms as we want
//TODO: Add logic, term cannot be deleted if there are courses assigned to it

public class TermList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // have to actually put the items on the recyclerview in the TermsList activity
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        Repository repo = new Repository(getApplication());
        List<Term> terms = repo.getAllTerms();
//        final TermAdapter adapter = new TermAdapter(getApplicationContext());
        final TermAdapter adapter = new TermAdapter(this);

        // need to set the layout manager in this
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // need to set the adapter to the recyclerview as well for the handoff to complete
        recyclerView.setAdapter(adapter);
        adapter.setTerms(terms);
        // now actually getting our list of products to put on the recyclerview

    }


//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.menu_termlist,menu);
//        return true;
//    }

//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case android.R.id.home:
//                this.finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    public void goToCourseList(View view){
        Intent intent = new Intent(TermList.this, CourseList.class);
        startActivity(intent);
    }
}