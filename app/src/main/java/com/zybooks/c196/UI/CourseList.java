package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.zybooks.c196.R;

public class CourseList extends AppCompatActivity {
    //    Declare our edit text
    EditText editTermName;
    EditText editTermStart;
    EditText editTermEnd;
    String name, start, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);
        editTermName = findViewById(R.id.editTermName);
        editTermStart = findViewById(R.id.editTermStart);
        editTermEnd = findViewById(R.id.editTermEnd);

        name = getIntent().getStringExtra("editTermName");
        start = getIntent().getStringExtra("editTermStart");
        end = getIntent().getStringExtra("editTermEnd");

//        editTermName


    }


    public void goToCourseDetail(View view){
        Intent intent = new Intent(CourseList.this, CourseDetail.class);
        startActivity(intent);
    }




}