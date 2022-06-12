package com.example.pd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ProgressBar bar;
    TextView percentage;
    TextView lilText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.profile);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.calendar:
                        Intent intent2 = new Intent(ProfileActivity.this, CalendarActivity.class);
                        startActivity(intent2);
                        return true;
                    case R.id.dreams:
                        Intent intent3 = new Intent(ProfileActivity.this, DreamsActivity.class);
                        startActivity(intent3);
                        return true;
                    case R.id.profile:
                        Intent intent4 = new Intent(ProfileActivity.this, ProfileActivity.class);
                        startActivity(intent4);
                        return true;
                }
                return true;
            }
        });
        int num;
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            num = 0;
        }else{
            num = extras.getInt("dreamsDone");
        }
        Log.d("dreamsDone", Integer.toString(num));

        bar = (ProgressBar) findViewById(R.id.progressBar);
        bar.setProgress(num);
        percentage = (TextView) findViewById(R.id.textView34);
        lilText = (TextView) findViewById(R.id.textView35);
        if (num == 0){
            percentage.setText("0%");
        }else{
            int perc = 100/num;
            percentage.setText(Integer.toString(perc)+"%");
            lilText.setText(perc+"% of your dreams are complete");
        }
    }

    public void settings(View view) {
        Intent intent = new Intent(ProfileActivity.this, Settings.class);
        startActivity(intent);
    }
}