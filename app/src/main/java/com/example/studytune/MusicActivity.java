package com.example.studytune;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MusicActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        findViewById(R.id.btnAfterYou).setOnClickListener(v -> playMusic(R.raw.after_you));
        findViewById(R.id.btnBurkinelectric).setOnClickListener(v -> playMusic(R.raw.burkinelectric));
        findViewById(R.id.btnFarApart).setOnClickListener(v -> playMusic(R.raw.far_apart));
        findViewById(R.id.btnUnavailable).setOnClickListener(v -> playMusic(R.raw.unavailable));
        findViewById(R.id.btnValleyOfSpies).setOnClickListener(v -> playMusic(R.raw.valley_of_spies));
        findViewById(R.id.btnWinnerWinner).setOnClickListener(v -> playMusic(R.raw.winner_winner_funky_chicken_dinner));
        findViewById(R.id.btnFocusMusic).setOnClickListener(v -> playMusic(R.raw.focus_music));
        findViewById(R.id.btnStudyMusic).setOnClickListener(v -> playMusic(R.raw.study_music));

        findViewById(R.id.btnStop).setOnClickListener(v -> stopMusic());

        findViewById(R.id.btnBack).setOnClickListener(v -> {
            stopMusic();
            finish();
        });

    }

    private void playMusic(int resId) {
        stopMusic();
        mediaPlayer = MediaPlayer.create(this, resId);
        mediaPlayer.start();
        Toast.makeText(this, "음악 재생 시작", Toast.LENGTH_SHORT).show();
    }

    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            Toast.makeText(this, "음악 정지", Toast.LENGTH_SHORT).show();
        }
    }
}
