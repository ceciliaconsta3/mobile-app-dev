package com.zybooks.c196.DAO;

import com.zybooks.c196.Entity.Course;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CourseDAO {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(Course course);

        @Update
        void update(Course course);

        @Delete
        void delete(Course course);

        @Query("SELECT * FROM courses ORDER BY courseID ASC")
        List<Course> getAllCourses();
}
