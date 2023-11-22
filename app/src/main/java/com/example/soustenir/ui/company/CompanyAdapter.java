package com.example.soustenir.ui.company;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.soustenir.R;
import com.google.firebase.firestore.core.*;

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
    public CompanyAdapter(List<Company> myDataset) {
        companies = myDataset;
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

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CompanyViewHolder holder, int position) {
        Company company = companies.get(position);
        holder.companyNameTextView.setText(company.getName());
        holder.companyDescriptionTextView.setText(company.getDescription());
        holder.companyScoreTextView.setText(String.valueOf(company.getScore()));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return companies.size();
    }
}