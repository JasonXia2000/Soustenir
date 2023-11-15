package com.example.soustenir.ui.partners;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PartnersViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public PartnersViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Gallery of partners and their descriptions here");
    }

    public LiveData<String> getText() {
        return mText;
    }
}