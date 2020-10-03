package com.example.taskandroidapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.taskandroidapp.database.AppDatabase;
import com.example.taskandroidapp.database.TaskEntry;

public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> task;

    public AddTaskViewModel(AppDatabase database, int taskId) {
        task = database.taskDao().loadTaskById(taskId);
    }

    public LiveData<TaskEntry> getTask() {
        return task;
    }
}
