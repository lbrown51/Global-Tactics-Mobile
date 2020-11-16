package com.ad430.globaltactics.models;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventsModel {
    private final String TAG = EventsModel.class.getSimpleName();
    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public EventsModel() {
        db = FirebaseFirestore.getInstance();
        new SignInHelper();
        listeners = new ArrayList<>();
    }

    public void getEvents(Consumer<QuerySnapshot> dataChangedCallback,
                           Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration listener = db.collection("events")
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
