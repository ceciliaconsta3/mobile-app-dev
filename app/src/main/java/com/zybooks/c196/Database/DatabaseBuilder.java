package com.zybooks.c196.Database;


import android.content.Context;

import com.zybooks.c196.DAO.CourseDAO;
import com.zybooks.c196.DAO.TermDAO;
import com.zybooks.c196.Entity.Course;
import com.zybooks.c196.Entity.Term;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// needs to know what entities to build the database from
@Database(entities={Term.class, Course.class}, version = 2, exportSchema = false)
public abstract class DatabaseBuilder extends RoomDatabase {
        public abstract TermDAO termDAO();
        public abstract CourseDAO courseDAO();
        // makes an instance of the db
        private static volatile DatabaseBuilder INSTANCE;

        // context is part of android, Room uses it. Tells you where you are in the flow of the program
        static DatabaseBuilder getDatabase(final Context context) {
            if (INSTANCE==null){
                synchronized (DatabaseBuilder.class) {
                    // if you don't have a DB yet it will build one for you)
                    if (INSTANCE==null) {
                        INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DatabaseBuilder.class, "C868DB")
                        .fallbackToDestructiveMigration() // this is where you would allow Main thread queries
                        .build();
                    }
                }
            }
            return INSTANCE;
        }
}
