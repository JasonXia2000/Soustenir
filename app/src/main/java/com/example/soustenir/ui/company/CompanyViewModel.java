package com.example.soustenir.ui.company;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CompanyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CompanyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Clothing Companies go here");
    }

    public LiveData<String> getText() {
        return mText;
    }
}