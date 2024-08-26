package com.example.provamobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class ActivityAdd extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextDescription;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemaddlayout);

        editTextTitle = findViewById(R.id.novaTarefa);
        editTextDescription = findViewById(R.id.novaDescricao);
        buttonSave = findViewById(R.id.salvar);

        buttonSave.setOnClickListener(v -> {
            String title = editTextTitle.getText().toString();
            String description = editTextDescription.getText().toString();

            Item newItem = new Item(title, description);
            AppDatabase db = AppDatabase.getInstance(getApplicationContext());
            db.itemDao().insertAll(newItem);

            finish();
        });
    }
}