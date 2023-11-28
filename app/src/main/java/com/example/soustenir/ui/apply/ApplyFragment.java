package com.example.soustenir.ui.apply;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.soustenir.R;
import com.example.soustenir.databinding.FragmentApplyBinding;

public class ApplyFragment extends Fragment {

    private FragmentApplyBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentApplyBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate the inputs if necessary
                if (isInputValid()) {
                    // Show the apply successful message
                    Toast.makeText(getContext(), "Apply successful", Toast.LENGTH_LONG).show();

                    // Here you would normally handle the actual submission, e.g., sending data to a server
                }
            }
        });

        return view;
    }

    private boolean isInputValid() {
        // Here you can add actual validation logic for your input fields
        return !binding.editTextCompanyName.getText().toString().trim().isEmpty() &&
                !binding.editTextCompanyAddress.getText().toString().trim().isEmpty();
    }


    public void onSubmitClicked(View view) {
        EditText editTextCompanyName = view.findViewById(R.id.editTextCompanyName);
        EditText editTextCompanyAddress = view.findViewById(R.id.editTextCompanyAddress);
        String companyName = editTextCompanyName.getText().toString();
        String companyAddress = editTextCompanyAddress.getText().toString();

        // Validate inputs
        if (companyName.isEmpty() || companyAddress.isEmpty()) {
            // Show error to user
            Toast.makeText(getContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Process the input data, such as sending to a server or saving in a database
        // ...
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}