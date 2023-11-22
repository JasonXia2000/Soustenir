package com.example.soustenir.ui.company;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soustenir.ui.company.Company;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class CompanyViewModel extends ViewModel {

    private MutableLiveData<List<Company>> companiesLiveData;

    public CompanyViewModel() {
        companiesLiveData = new MutableLiveData<>();
        loadCompanies();
    }

    private void loadCompanies() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("companies")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        List<Company> companyList = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Company company = document.toObject(Company.class);
                            companyList.add(company);
                        }
                        companiesLiveData.setValue(companyList);
                    } else {
                        Log.w(TAG, "Error getting documents.", task.getException());
                    }
                });
    }

    public LiveData<List<Company>> getCompaniesLiveData() {
        return companiesLiveData;
    }
}