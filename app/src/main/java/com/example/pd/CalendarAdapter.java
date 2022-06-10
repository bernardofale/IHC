package com.example.pd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarViewHolder>
{
    public CalendarAdapter(ArrayList<String> daysOfMonth, OnItemListener onItemListener, Bundle extras) {
        this.daysOfMonth = daysOfMonth;
        this.onItemListener = onItemListener;
        this.activities = extras;
    }

    private final ArrayList<String> daysOfMonth;
    private final OnItemListener onItemListener;
    private final Bundle activities;

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.calendar_cell, parent, false);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = (int) (parent.getHeight() * 0.166666666);
        return new CalendarViewHolder(view, onItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position)
    {
        if (activities != null) {
            if (daysOfMonth.get(position).equals(Integer.toString(activities.getInt("day")))) {
                holder.dayOfMonth.setText(daysOfMonth.get(position) + "\n" + this.activities.get("name"));
            } else {
                holder.dayOfMonth.setText(daysOfMonth.get(position));
            }
        } else {
        holder.dayOfMonth.setText(daysOfMonth.get(position));
        }
    }

    @Override
    public int getItemCount()
    {
        return daysOfMonth.size();
    }

    public interface OnItemListener
    {
        void onItemClick(int position, String dayText);
    }


}
