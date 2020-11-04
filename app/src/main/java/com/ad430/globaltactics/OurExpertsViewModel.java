package com.ad430.globaltactics;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class OurExpertsViewModel extends ViewModel {
    private final String TAG = OurExpertsViewModel.class.getSimpleName();
    private OurExpertsModel ourExpertsModel;

    public OurExpertsViewModel() {
        ourExpertsModel = new OurExpertsModel();
    }

    public void getExperts(Consumer<ArrayList<Expert>> responseCallback) {
        ourExpertsModel.getExperts(
                (QuerySnapshot querySnapshot) -> {
                    if (querySnapshot != null) {
                        ArrayList<Expert> experts = new ArrayList<>();

                        for (DocumentSnapshot expertSnapshot : querySnapshot.getDocuments()) {
                            Expert expert = expertSnapshot.toObject(Expert.class);
                            assert expert != null;
                            experts.add(expert);
                        }

                        responseCallback.accept(experts);
                    }
                },
                (databaseError -> Log.e(TAG, "Error reading experts: " + databaseError))
        );
    }

    public void clear() {
        ourExpertsModel.clear();
    }
}
