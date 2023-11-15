package com.example.soustenir.ui.partners;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.soustenir.databinding.FragmentPartnersBinding;

public class PartnersFragment extends Fragment {

    private FragmentPartnersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PartnersViewModel partnersViewModel =
                new ViewModelProvider(this).get(PartnersViewModel.class);

        binding = FragmentPartnersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPartners;
        partnersViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}