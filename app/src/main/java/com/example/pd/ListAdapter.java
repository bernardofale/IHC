package com.example.pd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ListAdapter extends
            RecyclerView.Adapter<ListAdapter.WordViewHolder>  {
        class WordViewHolder extends RecyclerView.ViewHolder {
            public final TextView wordItemView;
            final ListAdapter mAdapter;

            public WordViewHolder(View itemView, ListAdapter adapter) {
                super(itemView);
                wordItemView = itemView.findViewById(R.id.exp);
                this.mAdapter = adapter;
            }
        }
        private final LinkedList<String> mWordList;
        private LayoutInflater mInflater;
        public ListAdapter(Context context,
                               LinkedList<String> wordList) {
            mInflater = LayoutInflater.from(context);
            this.mWordList = wordList;
    }
        @NonNull
        @Override
        public ListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View mItemView = mInflater.inflate(R.layout.list_item,
                    parent, false);
            return new WordViewHolder(mItemView, this);
        }

        @Override
        public void onBindViewHolder(@NonNull ListAdapter.WordViewHolder holder, int position) {
            String mCurrent = mWordList.get(position);
            holder.wordItemView.setText(mCurrent);
        }

        @Override
        public int getItemCount() {
            return mWordList.size();
        }
    }

