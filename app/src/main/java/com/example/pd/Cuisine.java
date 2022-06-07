package com.example.pd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Set;

public class Cuisine extends AppCompatActivity {
    HashMap<String,String> extra = new HashMap<String, String>();
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine);
    }

    public void add(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.brunchBox:
                if (checked) {
                    TextView tv = (TextView) findViewById(R.id.brunch);
                    Log.d(TAG, tv.getText().toString());
                    extra.put("EXTRA_EXPERIENCE_BRUNCH", tv.getText().toString());
                }
                break;
            case R.id.chineseBox:
                if (checked) {
                    TextView tv = (TextView) findViewById(R.id.chinese);
                    Log.d(TAG, tv.getText().toString());
                    extra.put("EXTRA_EXPERIENCE_CHINESE", tv.getText().toString());
                }
                break;
        }
    }

    public void done(View view) {
        Toast.makeText(this, "You've added experiences to your list!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DreamsActivity.class);
        Bundle extras = new Bundle();
        for(String i: extra.keySet()){
            Log.d(TAG, i);
            extras.putString(i, extra.get(i));
        }
        intent.putExtras(extras);
        startActivity(intent);
    }
}