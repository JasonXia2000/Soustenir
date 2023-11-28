package com.example.soustenir.ui.company;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.soustenir.R;

public class CompanyViewHolder extends RecyclerView.ViewHolder {
    public TextView companyNameTextView;
    public TextView companyDescriptionTextView;
    public TextView companyScoreTextView;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        companyNameTextView = itemView.findViewById(R.id.companyNameTextView);
        companyDescriptionTextView = itemView.findViewById(R.id.companyDescriptionTextView);
        companyScoreTextView = itemView.findViewById(R.id.companyScoreTextView);

        // Make the entire ViewHolder clickable
        itemView.setClickable(true);
        itemView.setFocusable(true);
    }
}
