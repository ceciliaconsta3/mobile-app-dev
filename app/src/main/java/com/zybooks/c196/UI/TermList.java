package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Term;
import com.zybooks.c196.R;

import java.util.List;


//TODO: Add logic, term cannot be deleted if there are courses assigned to it

public class TermList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

//        don't know what this function is for
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // have to actually put the items on the termListRecyclerView in the TermsList activity
        RecyclerView recyclerView = findViewById(R.id.termListRecyclerView);
        Repository repo = new Repository(getApplication());
        List<Term> terms = repo.getAllTerms();
//        final TermAdapter adapter = new TermAdapter(getApplicationContext());
//        changed to address error: Calling startActivity() from outside of an Activity context requires the
//        FLAG_ACTIVITY_NEW_TASK flag. Is this really what?
        final TermAdapter adapter = new TermAdapter(this);

        // need to set the layout manager in this
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // need to set the adapter to the termlistRecyclerView as well for the handoff to complete
        recyclerView.setAdapter(adapter);
        adapter.setTerms(terms);
        // now actually getting our list of products to put on the termlistRecyclerView

    }


//    public boolean onOptionsItemSelected(MenuItem item){
//        switch (item.getItemId()){
//            case android.R.id.home:
//                this.finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    public void goToNewTermDetail(View view){
        Intent intent = new Intent(TermList.this, NewTermDetail.class);
        startActivity(intent);
    }

}