package com.example.pd;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;
import java.util.HashMap;

public class ExperienceDetailsActivity extends AppCompatActivity {

    HashMap<String,String> extra = new HashMap<String, String>();
    private static final String TAG = "MyActivity";
    private static String activityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_details);
        this.activityName = ((TextView) findViewById(R.id.textView26)).getText().toString();
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            Bundle extras = new Bundle();
            extras.putInt("day",day);
            extras.putInt("month",month);
            extras.putInt("year",year);
            extras.putString("name", activityName);
            Intent intent = new Intent(getActivity(),CalendarActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        }

        private void sendMail(int day, int year, int month) {
            String mail = "mbfale@gmail.com";
            String message = "You've booked an experience with PipeDreamer for the date "+day+"/"+month+"/"+year+"!";
            String subject = "Booking";

            JavaMailAPI javaMailAPI = new JavaMailAPI(getActivity(), mail, message, subject);
            javaMailAPI.execute();


        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

}
