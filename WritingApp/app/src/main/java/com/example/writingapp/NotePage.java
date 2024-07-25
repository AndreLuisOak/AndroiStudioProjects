package com.example.writingapp;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NotePage extends AppCompatActivity {

    private EditText et_title;
    private EditText et_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notepagelayout);

        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);
    }
}
