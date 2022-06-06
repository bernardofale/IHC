package com.example.pd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
    }

    public void cuisine(View view) {
        Intent intent = new Intent(CategoryActivity.this, Cuisine.class);
        startActivity(intent);
    }

    public void sports(View view) {
        Intent intent = new Intent(CategoryActivity.this, Travel.class);
        startActivity(intent);
    }

    public void fashion(View view) {
        Intent intent = new Intent(CategoryActivity.this, Fashion.class);
        startActivity(intent);
    }

    public void travel(View view) {
        Intent intent = new Intent(CategoryActivity.this, Travel.class);
        startActivity(intent);
    }
}