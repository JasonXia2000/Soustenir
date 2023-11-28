package com.example.soustenir.ui.review;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.soustenir.databinding.FragmentReviewBinding;

public class ReviewFragment extends Fragment {
    private FragmentReviewBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentReviewBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.buttonSubmit.setOnClickListener(v -> submitReview());

        return root;
    }

    private void submitReview() {
        String companyName = binding.editTextCompanyName.getText().toString().trim();
        String rating = binding.editTextRating.getText().toString().trim();
        String description = binding.editTextDescription.getText().toString().trim();

        if (companyName.isEmpty() || rating.isEmpty() || description.isEmpty()) {
            Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_LONG).show();
        } else {
            // Here you might want to save the review or send it to a server
            // ...

            Toast.makeText(getContext(), "Review successful", Toast.LENGTH_LONG).show();
        }
    }
}