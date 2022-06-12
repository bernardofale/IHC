package com.example.pd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

public class DreamsActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;
    private static LinkedList<String> dreamList = new LinkedList<>();
    private static ArrayList<Integer> dreamsDone = new ArrayList<>();
    //Intent tent = new Intent(this, ProfileActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dreams);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.dreams);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(DreamsActivity.this, MainActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.calendar:
                        Intent intent2 = new Intent(DreamsActivity.this, CalendarActivity.class);
                        startActivity(intent2);
                        return true;
                    case R.id.dreams:
                        Intent intent3 = new Intent(DreamsActivity.this, DreamsActivity.class);
                        startActivity(intent3);
                        return true;
                    case R.id.profile:
                        Intent intent4 = new Intent(DreamsActivity.this, ProfileActivity.class);
                        intent4.putExtra("dreamsDone", dreamsDone.size());
                        startActivity(intent4);
                        return true;
                }
                return true;
            }
        });
        if (savedInstanceState != null){
            for (String key : savedInstanceState.keySet()) {
                String dream = savedInstanceState.getString(key);
                dreamList.add(dream);
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            for (String key : extras.keySet()) {
                String dream = extras.getString(key);
                dreamList.add(dream);
            }
        }
        // Get a handle to the RecyclerView.
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new ListAdapter(this, dreamList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addDream(View view) {
        Intent intent = new Intent(DreamsActivity.this, CategoryActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        for (String i : dreamList) {
            outState.putString(i, i);
        }
        super.onSaveInstanceState(outState);
    }

    public void check(View view) {
        dreamsDone.add(1);
    }
}