package com.example.pd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Search.class);
                startActivity(intent);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.calendar:
                        Intent intent2 = new Intent(MainActivity.this, CalendarActivity.class);
                        startActivity(intent2);
                        return true;
                    case R.id.dreams:
                        Intent intent3 = new Intent(MainActivity.this, DreamsActivity.class);
                        startActivity(intent3);
                        return true;
                    case R.id.profile:
                        Intent intent4 = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(intent4);
                        return true;
                }
                return true;
            }
        });
    }

    public void experienceDetails(View view) {
        Intent intent = new Intent(MainActivity.this, ExperienceDetailsActivity.class);
        startActivity(intent);
    }

}