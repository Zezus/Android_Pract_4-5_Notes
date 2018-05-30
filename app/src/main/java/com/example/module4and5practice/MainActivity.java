package com.example.module4and5practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        ArrayList<String> notes = intent.getStringArrayListExtra("notes");
        if (notes != null) {
            for (String note : notes) {
                Task task = new Task();
                task.setNote(note);
                tasks.add(task);
            }
        }

        RecyclerView tasksRecyclerView = findViewById(R.id.tasks_recycler_view);
        tasksRecyclerView.setAdapter(new TasksAdapter(getApplicationContext(), tasks));
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addTask(View view) {
        ArrayList<String> notes = new ArrayList<>();
        for (Task task : tasks) {
            notes.add(task.getNote());
        }
        Intent intent = new Intent(this, NewTask.class);
        intent.putStringArrayListExtra("notes", notes);
        startActivity(intent);
    }
}
