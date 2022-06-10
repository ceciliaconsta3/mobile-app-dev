package com.zybooks.c196.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.zybooks.c196.Database.Repository;
import com.zybooks.c196.Entity.Course;
import com.zybooks.c196.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//    TODO: Update function is not working
//    TODO: replace startDate and endDate textfields with data pickers using COHORT 4

public class CourseDetail extends AppCompatActivity {
    //    Declare our edit text
    int courseID, courseCredits;
    EditText editCourseName;
    EditText editCourseCredits;
    EditText editCourseStatus;
    EditText editCourseNote;
    String name, start, end, status, note;
    Repository repo;

    // TODO: Make these two conversions to dates
    EditText editCourseStartDate; // equivalent to EditText editDate
    EditText editCourseEndDate;
    DatePickerDialog.OnDateSetListener startDate;
    final Calendar myCalStart = Calendar.getInstance();
    String myFormat = "MM/dd/yy";
    SimpleDateFormat formatter = new SimpleDateFormat(myFormat, Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

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


        //        setOnClickListener(new View.onClickListener(){
//            @Override
//            public void onClick(View view) {
//                Date date;
//                String info = editCourseStartDate.getText().toString();
//                if (info.equals("")) {
//                    info = "05/23/2022";
//
//                    try {
//                        myCalStart.setTime(formatter.parse(info));
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                    new DatePickerDialog(CourseDetail.this.editCourseStartDate, myCalStart
//                            .get(Calendar.YEAR), myCalStart
//                            .get(Calendar.MONTH), myCalStart
//                            .get(Calendar.DAY_OF_MONTH)).show();
//                }
//            }
//        });
//        editCourseStartDate = new DatePickerDialog.OnDateSetListener();
//        }


        startDate = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalStart.set(Calendar.YEAR,year);
                myCalStart.set(Calendar.MONTH,monthOfYear);
                myCalStart.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                updateLabelStart();
            }
        };
    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_course_detail,menu);
        return true;
    }

    public boolean onOptionsItemsSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"Course Note text");
                sendIntent.putExtra(Intent.EXTRA_TITLE,"Course Note title");
                sendIntent.setType("text/plain");
               Intent shareIntent = Intent.createChooser(sendIntent, null);
               startActivity(shareIntent);
               return true;
            case R.id.notify:
//                Overview:
//                Converted object to date obj
//                then the date obj to the label and now
//                the label back into the date obj
//                 this is the date we want to trigger our alert to go off on
                String courseDetailDate = editCourseStartDate.getText().toString(); // aka dateFromScreen
                Date myDate = null;
                try{
                    myDate = formatter.parse(courseDetailDate);
                } catch(ParseException e){
                    e.printStackTrace();
                }
                Long trigger = myDate.getTime();
//                Intent intent = CourseDetail.this, MyReceiver.class);
                Intent intent = new Intent(CourseDetail.this, MyReceiver.class);
                // TODO: need to build a process receiver
                intent.putExtra("key","Outgoing Notification Message"); // example: CourseCode + " starts today"
                // numAlert has to be unique in the entire app, create it inside the mainActivity
                PendingIntent sender = PendingIntent.getBroadcast(CourseDetail.this,MainActivity.numAlert++, intent, 0);
                AlarmManager almgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                // wakes up the app and sends the pending intent
                almgr.set(AlarmManager.RTC_WAKEUP,trigger,sender);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateLabelStart(){
        editCourseStartDate.setText(formatter.format(myCalStart.getTime()));
    }

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