package com.ad430.globaltactics;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;
import java.util.function.Consumer;

public class OurExpertsModel {
    private final String TAG = OurExpertsModel.class.getSimpleName();
    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public OurExpertsModel() {
        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

    public void getExperts(Consumer<QuerySnapshot> dataChangedCallback,
                           Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration listener = db.collection("experts")
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
