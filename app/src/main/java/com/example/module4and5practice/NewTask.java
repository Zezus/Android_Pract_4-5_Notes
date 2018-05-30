package com.example.module4and5practice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class NewTask extends AppCompatActivity {

    private ArrayList<String> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        Intent intent = getIntent();
        notes = intent.getStringArrayListExtra("notes");
    }

    public void addTask(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = findViewById(R.id.note_edit_text);
        notes.add(editText.getText().toString());
        intent.putStringArrayListExtra("notes", notes);
        startActivity(intent);
    }
}
