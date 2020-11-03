package com.ad430.globaltactics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;


public class EventsFragmentTest {
    public static RecyclerViewMatcherTestUtils withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcherTestUtils(recyclerViewId);
    }

    @Test
    public void hasRecyclerView() throws InterruptedException{
        FragmentScenario<EventsFragment> fragmentScenario = FragmentScenario.launchInContainer(
                EventsFragment.class,
                new Bundle(),
                R.style.AppTheme,
                null
        );

        Thread.sleep(5000);

        onView(withId(R.id.eventList)).check(matches(isDisplayed()));
    }

    @Test
    public void onEventsClick() throws InterruptedException{
        FragmentScenario<EventsFragment> fragmentScenario = FragmentScenario.launchInContainer(EventsFragment.class);

        Thread.sleep(5000);

        Intents.init();
        onView(withRecyclerView(R.id.eventList).atPosition(0)).perform(click());
        Intents.intended(allOf(hasAction(Intent.ACTION_VIEW)));
        Intents.release();
    }
}