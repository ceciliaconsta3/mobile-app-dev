package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zybooks.c196.R;

public class ClassList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_list);
    }

    public void goToClassDetail(View view){
        Intent intent = new Intent(ClassList.this,ClassDetail.class);
        startActivity(intent);
    }
}