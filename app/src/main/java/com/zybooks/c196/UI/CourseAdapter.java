package com.zybooks.c196.UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zybooks.c196.Entity.Course;
import com.zybooks.c196.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private List<Course> mCourses;
    private Context context;
    private LayoutInflater mInflater;

    public CourseAdapter(Context context){
        mInflater = LayoutInflater.from(context);
        this.context = context;
    }



    class CourseViewHolder extends RecyclerView.ViewHolder {

        private TextView courseItemView;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseItemView = itemView.findViewById(R.id.courseListTextView);
//            courseItemView = itemView.findViewById(R.id.currentTermCoursesRecyclerView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    final Course current = mCourses.get(position);// it wants position in list of items, that means we need to tell it where the items are and create the list
                    Intent intent = new Intent(context, CourseList.class); // now to send information and change it from the current area to another screen
                    intent.putExtra("id", current.getCourseID()); // to receive lots of key/value pairs on that intent
                    intent.putExtra("name", current.getCourseName());
                    intent.putExtra("startDate", current.getCourseStartDate());
                    intent.putExtra("endDate", current.getCourseEndDate());
                    intent.putExtra("status",current.getCourseStatus());
                    intent.putExtra("note", current.getCourseNote());
                    context.startActivity(intent);
                }
            });
        }
    }



    @NonNull
    @Override
    public CourseAdapter.CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.item_course_list, parent, false);
        return new CourseAdapter.CourseViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.CourseViewHolder holder, int position) {
        if(mCourses != null){
            Course current = mCourses.get(position);
            String name = current.getCourseName();

            holder.courseItemView.setText(name);
        } else {
            holder.courseItemView.setText("No course name");
        }
    }



    public void setCourses(List<Course> courses){
        mCourses = courses;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        if(mCourses != null){
            return mCourses.size();
        } else {
            return 0;
        }
    }


}
