package com.example.soustenir.ui.recycle;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.soustenir.databinding.FragmentRecycleBinding;

public class RecycleFragment extends Fragment {

    private FragmentRecycleBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecycleViewModel galleryViewModel =
                new ViewModelProvider(this).get(RecycleViewModel.class);

        binding = FragmentRecycleBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}