package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

// COMPLETED TODO (1) make this class extend AndroidViewModel and implement its default constructor
public class MainViewModel extends AndroidViewModel {

    public static final String TAG = MainViewModel.class.getSimpleName();

    // COMPLETED TODO (2) Add a tasks member variable for a list of TaskEntry objects wrapped in a LiveData

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        // COMPLETED TODO (4) In the constructor use the loadAllTasks of the taskDao to initialize the tasks variable
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Activity retrieving the tasks from the DataBase");
        tasks = database.taskDao().loadAllTasks();
    }

    // COMPLETED TODO (3) Create a getter for the tasks variable
    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }


}
