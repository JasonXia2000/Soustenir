package com.example.soustenir.ui.company;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soustenir.R;
import com.google.firebase.firestore.core.*;

import java.util.ArrayList;
import java.util.List;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {
    private List<Company> companies;

    // Provide a reference to the views for each data item
    public static class CompanyViewHolder extends RecyclerView.ViewHolder {
        public TextView companyNameTextView;
        public TextView companyDescriptionTextView;
        public TextView companyScoreTextView;

        public CompanyViewHolder(View itemView) {
            super(itemView);
            companyNameTextView = itemView.findViewById(R.id.companyNameTextView);
            companyDescriptionTextView = itemView.findViewById(R.id.companyDescriptionTextView);
            companyScoreTextView = itemView.findViewById(R.id.companyScoreTextView);
        }
    }

    // Constructor
    public CompanyAdapter() {
        companies = new ArrayList<>();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CompanyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.company_item_layout, parent, false);
        return new CompanyViewHolder(v);
    }

    public void setCompanies(List<Company> newCompanies) {
        companies.clear();
        companies.addAll(newCompanies);
        notifyDataSetChanged(); // To notify the adapter of the new data
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        Company company = companies.get(position);
        holder.companyNameTextView.setText(company.getName());
        holder.companyDescriptionTextView.setText(company.getDescription());
        holder.companyScoreTextView.setText(String.valueOf(company.getScore()));

        holder.itemView.setOnClickListener(v -> {
            // Set a breakpoint here to see if this is triggered
            String url = company.getUrl();
            if (url != null && !url.isEmpty() && (url.startsWith("http://") || url.startsWith("https://"))) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                v.getContext().startActivity(intent);
            } else {
                // Log an error or show a toast
                Log.e("CompanyAdapter", "Invalid URL: " + url);
                Toast.makeText(v.getContext(), "Invalid URL", Toast.LENGTH_SHORT).show();
            }
        });
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return companies.size();
    }
}