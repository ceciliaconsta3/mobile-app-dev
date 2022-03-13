package com.example.c196_ceciliaconstantine.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.c196_ceciliaconstantine.R;

public class TermList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_term_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.menu_termlist,menu);
//        return true;
//    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void goToClassList(View view){
        Intent intent = new Intent(TermList.this,ClassList.class);
        startActivity(intent);
    }
}