package com.example.studytune;

import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddPlanActivity extends AppCompatActivity {

    EditText editSubject, editGoalTime;
    DatePicker datePicker;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        editSubject = findViewById(R.id.editSubject);
        editGoalTime = findViewById(R.id.editGoalTime);
        datePicker = findViewById(R.id.datePicker);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String subject = editSubject.getText().toString();
            String time = editGoalTime.getText().toString();

            Toast.makeText(this,
                    "과목: " + subject + ", 목표: " + time + "시간",
                    Toast.LENGTH_LONG).show();

            finish(); // 화면 종료
        });
    }
}
