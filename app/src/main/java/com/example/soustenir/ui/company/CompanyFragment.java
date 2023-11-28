package com.example.soustenir.ui.company;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.soustenir.databinding.FragmentCompanyBinding;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompanyFragment extends Fragment {

    private FragmentCompanyBinding binding;
    private CompanyAdapter companyAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CompanyViewModel companyViewModel =
                new ViewModelProvider(this).get(CompanyViewModel.class);

        binding = FragmentCompanyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        setupRecyclerView();

        // Observe the LiveData in the ViewModel
        companyViewModel.getCompaniesLiveData().observe(getViewLifecycleOwner(), companies -> {
            // Update the adapter's dataset
            companyAdapter.setCompanies(companies);
            // notifyDataSetChanged is called inside setCompanies in the adapter
        });

        return root;
    }

    private void setupRecyclerView() {
        RecyclerView companyView = binding.companyView;
        companyView.setLayoutManager(new LinearLayoutManager(getContext()));
        companyAdapter = new CompanyAdapter(); // Initialize with empty list or remove the argument
        companyView.setAdapter(companyAdapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}