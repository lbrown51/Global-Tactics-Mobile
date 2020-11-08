package com.ad430.globaltactics;

import android.util.Log;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class OurSuccessesViewModel {
    private final String TAG = OurSuccessesViewModel.class.getSimpleName();
    private OurSuccessesModel ourSuccessesModel;

    public OurSuccessesViewModel() {
        ourSuccessesModel = new OurSuccessesModel();
    }

    public void getOurSuccesses(Consumer<ArrayList<OurSuccess>> responseCallback) {
        ourSuccessesModel.getOurSuccesses(
                (QuerySnapshot querySnapshot) -> {
                    if (querySnapshot != null) {
                        ArrayList<OurSuccess> ourSuccesses = new ArrayList<>();

                        for (DocumentSnapshot ourSuccessSnapshot : querySnapshot.getDocuments()) {
                            OurSuccess ourSuccess = ourSuccessSnapshot.toObject(OurSuccess.class);
                            assert ourSuccess != null;
                            ourSuccesses.add(ourSuccess);
                        }

                        responseCallback.accept(ourSuccesses);
                    }
                },
                (databaseError -> Log.e(TAG, "Error reading successes: " + databaseError))
        );
    }

    public void clear() {
        ourSuccessesModel.clear();
    }
}
