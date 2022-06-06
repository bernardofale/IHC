package com.example.pd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
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
    }
}