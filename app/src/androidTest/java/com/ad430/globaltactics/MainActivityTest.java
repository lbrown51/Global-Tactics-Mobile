package com.ad430.globaltactics;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void hasHelloWorld() {
        onView(withId(R.id.hello_world_text))
                .check(matches(withText("Hello World!")));
    }
  
    @Test
    public void allFragmentsDisplayed() {
        onView(withId(R.id.about_placeholder_text))
                .check(matches(withText(R.string.about_us_placeholder)));
        onView(withId(R.id.blog_placeholder_text))
                .check(matches(withText(R.string.blog_placeholder)));
        onView(withId(R.id.events_placeholder_text))
                .check(matches(withText(R.string.events_placeholder)));
        onView(withId(R.id.privacy_placeholder_text))
                .check(matches(withText(R.string.privacy_placeholder)));

    }
}