package com.example.studytune;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TimerActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private Button btnStart, btnStop, btnBack;

    // static으로 타이머 상태 유지
    private static boolean isRunning = false;
    private static long baseTime = 0;
    private static long pauseOffset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = findViewById(R.id.chronometer);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnBack = findViewById(R.id.btnBack);

        // 타이머 상태 복원
        if (isRunning) {
            chronometer.setBase(baseTime);
            chronometer.start();
        } else {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
        }

        btnStart.setOnClickListener(v -> {
            if (!isRunning) {
                baseTime = SystemClock.elapsedRealtime() - pauseOffset;
                chronometer.setBase(baseTime);
                chronometer.start();
                isRunning = true;
            }
        });

        btnStop.setOnClickListener(v -> {
            if (isRunning) {
                chronometer.stop();
                pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                isRunning = false;

                long seconds = pauseOffset / 1000;
                Toast.makeText(this, "공부 시간: " + seconds + "초", Toast.LENGTH_SHORT).show();
            }
        });

        btnBack.setOnClickListener(v -> {
            finish(); // MainActivity로 복귀
        });
    }
}
