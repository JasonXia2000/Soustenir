package com.example.soustenir.ui.partners;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.soustenir.R;
import com.example.soustenir.databinding.FragmentPartnersBinding;

public class PartnersFragment extends Fragment {

    private FragmentPartnersBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPartnersBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        // Assuming you have these TextViews in your fragment_partners.xml
        binding.textPartnerName.setText(R.string.partner_name);
        binding.textPartnerDescription.setText(R.string.partner_description);

        // If there's an ImageView for the partner's image
        // You'd set the image resource like this:
        binding.imagePartner.setImageResource(R.drawable.rectangle_1);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}