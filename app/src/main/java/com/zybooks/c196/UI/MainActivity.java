package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.zybooks.c196.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // make an "intent" to add eventlistener that redirects to a new screen
    public void enterHere(View view) {
        Intent intent = new Intent(MainActivity.this,TermList.class);
        startActivity(intent);

    }
}