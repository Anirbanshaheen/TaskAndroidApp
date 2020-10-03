package com.example.taskandroidapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Queries to Database.
 *
 * DAO means Data Access Object.
 *
 * LiveData, all the time observe all data since there is any modification.
 */
@Dao
public interface TaskDao {

    @Query("SELECT * FROM task ORDER BY priority")
    LiveData<List<TaskEntry>> loadAllTasks();

    @Insert
    void insertTask(TaskEntry taskEntry);

    // OnConflictStrategy, it replace old data and continue the transaction
    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(TaskEntry taskEntry);

    @Delete
    void deleteTask(TaskEntry taskEntry);

    // The query for this method should get all the data for that id in the task table
    @Query("SELECT * FROM task WHERE id = :id")
    LiveData<TaskEntry> loadTaskById(int id);
}
