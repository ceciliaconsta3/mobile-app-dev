package com.zybooks.c196.DAO;

import com.zybooks.c196.Entity.Term;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface TermDAO {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(Term term);

        @Update
        void update(Term term);

        @Delete
        void delete(Term term);

        @Query("SELECT * FROM terms ORDER BY termID ASC")
        List<Term> getAllTerms();
}
