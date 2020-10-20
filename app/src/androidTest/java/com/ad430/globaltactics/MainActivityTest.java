package com.ad430.globaltactics;

import android.view.Gravity;

import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.contrib.DrawerMatchers.isOpen;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void navigationDrawerHasCorrectItems() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(DrawerActions.open());

        onView(withId(R.id.navigation_view))
                .check(matches(hasDescendant(withText(R.string.home_fragment_title))));
        onView(withId(R.id.navigation_view))
                .check(matches(hasDescendant(withText(R.string.about_us_fragment_title))));
        onView(withId(R.id.navigation_view))
                .check(matches(hasDescendant(withText(R.string.blog_fragment_title))));
        onView(withId(R.id.navigation_view))
                .check(matches(hasDescendant(withText(R.string.events_fragment_title))));
        onView(withId(R.id.navigation_view))
                .check(matches(hasDescendant(withText(R.string.privacy_policy_fragment_title))));
    }

    @Test
    public void canNavigateToAllFragments() throws InterruptedException {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT)))
                .perform(DrawerActions.open());
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.aboutUsFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.about_us_fragment_title))));

        Thread.sleep(500);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.blogFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.blog_fragment_title))));

        Thread.sleep(500);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.eventsFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.events_fragment_title))));

        Thread.sleep(500);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.privacyPolicyFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.privacy_policy_fragment_title))));

        Thread.sleep(500);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.homeScreenFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.home_fragment_title))));
    }


}