package com.example.soustenir.ui.apply;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.soustenir.databinding.FragmentApplyBinding;

public class ApplyFragment extends Fragment {

    private FragmentApplyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ApplyViewModel applyViewModel =
                new ViewModelProvider(this).get(ApplyViewModel.class);

        binding = FragmentApplyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textApply;
        applyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}