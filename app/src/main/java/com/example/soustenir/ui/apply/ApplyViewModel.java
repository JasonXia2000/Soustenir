package com.example.soustenir.ui.apply;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ApplyViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ApplyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Apply to be a company here");
    }

    public LiveData<String> getText() {
        return mText;
    }
}