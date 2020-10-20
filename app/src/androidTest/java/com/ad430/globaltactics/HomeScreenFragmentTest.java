package com.ad430.globaltactics;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class HomeScreenFragmentTest {
    @Test
    public void homeScreenFragmentHasCorrectContent() {
        FragmentScenario<HomeScreenFragment> fragmentScenario = FragmentScenario.launchInContainer(HomeScreenFragment.class);
        onView(withId(R.id.motto_placeholder)).check(matches(withText(R.string.motto_text)));
    }
}