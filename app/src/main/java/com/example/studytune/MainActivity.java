package com.example.studytune;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.studytune.MusicActivity;

public class MainActivity extends AppCompatActivity {

    Button btnAddPlan, btnTimer, btnMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddPlan = findViewById(R.id.btnAddPlan);
        btnTimer = findViewById(R.id.btnTimer);
        btnMusic = findViewById(R.id.btnMusic);

        btnAddPlan.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddPlanActivity.class);
            startActivity(intent);
        });

        btnTimer.setOnClickListener(v -> {
            Intent intent = new Intent(this, TimerActivity.class);
            startActivity(intent);
        });

        // 음악 선택 액티비티로 이동하도록 수정
        btnMusic.setOnClickListener(v -> {
            Intent intent = new Intent(this, MusicActivity.class);
            startActivity(intent);
        });
    }
}
