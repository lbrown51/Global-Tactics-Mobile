package com.ad430.globaltactics.models;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class OurSuccessesModel {
    private final String TAG = OurSuccessesModel.class.getSimpleName();
    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public OurSuccessesModel() {
        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

    public void getOurSuccesses(Consumer<QuerySnapshot> dataChangedCallback,
                          Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration listener = db.collection("successes2")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    if (e != null) {
                        dataErrorCallback.accept(e);
                    }

                    dataChangedCallback.accept(queryDocumentSnapshots);
                });
        listeners.add(listener);
    }

    public void clear() {
        listeners.forEach(ListenerRegistration::remove);
    }
}
