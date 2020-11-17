package com.ad430.globaltactics.viewmodels;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.ad430.globaltactics.objects.Event;
import com.ad430.globaltactics.models.EventsModel;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class EventViewModel extends ViewModel {
    private final String TAG = EventViewModel.class.getSimpleName();
    private EventsModel eventsModel;

    public EventViewModel() {
        eventsModel = new EventsModel();
    }

    public void getEvents(Consumer<ArrayList<Event>> responseCallback) {
        eventsModel.getEvents(
            (QuerySnapshot querySnapshot) -> {
                if (querySnapshot != null) {
                    ArrayList<Event> events = new ArrayList<>();

                    for (DocumentSnapshot eventSnapshot : querySnapshot.getDocuments()) {
                        Event event = eventSnapshot.toObject(Event.class);
                        assert event != null;
                        events.add(event);
                    }

                    responseCallback.accept(events);
                }
            },
            (databaseError -> Log.e(TAG, "Error reading events: " + databaseError))
        );
    }

    public void clear() {
        eventsModel.clear();
    }
}
