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
    Button btnSave, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        editSubject = findViewById(R.id.editSubject);
        editGoalTime = findViewById(R.id.editGoalTime);
        datePicker = findViewById(R.id.datePicker);
        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack); // 추가

        btnSave.setOnClickListener(v -> {
            String subject = editSubject.getText().toString().trim();
            String goalTime = editGoalTime.getText().toString().trim();

            int year = datePicker.getYear();
            int month = datePicker.getMonth() + 1;
            int day = datePicker.getDayOfMonth();
            String date = year + "-" + month + "-" + day;

            if (subject.isEmpty() || goalTime.isEmpty()) {
                Toast.makeText(this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                return;
            }

            String result = "과목: " + subject + "\n 목표 시간: " + goalTime + "시간\n 날짜: " + date;
            Toast.makeText(this, result, Toast.LENGTH_LONG).show();

            finish();
        });

        btnBack.setOnClickListener(v -> {
            finish(); // MainActivity로 돌아가기
        });
    }
}
