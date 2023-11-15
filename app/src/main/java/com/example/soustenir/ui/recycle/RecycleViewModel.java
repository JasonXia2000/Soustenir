package com.example.soustenir.ui.recycle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecycleViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecycleViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Recycle Map goes here");
    }

    public LiveData<String> getText() {
        return mText;
    }
}