package com.ad430.globaltactics;

import android.view.Gravity;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.contrib.DrawerMatchers.isOpen;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    public static RecyclerViewMatcherTestUtils withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcherTestUtils(recyclerViewId);
    }

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
                .check(matches(hasDescendant(withText(R.string.our_experts_fragment_title))));
        onView(withId(R.id.navigation_view))
                .check(matches(hasDescendant(withText(R.string.blog_fragment_title))));
        onView(withId(R.id.navigation_view))
                .check(matches(hasDescendant(withText(R.string.events_fragment_title))));
        onView(withId(R.id.navigation_view))
                .check(matches(hasDescendant(withText(R.string.privacy_policy_fragment_title))));
        onView(withId(R.id.navigation_view))
                .check(matches(hasDescendant(withText(R.string.contact_fragment_title))));
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

        Thread.sleep(1000);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.ourExpertsFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.our_experts_fragment_title))));

        Thread.sleep(1000);
        onView(withRecyclerView(R.id.our_experts_list).atPosition(0)).perform(click());
        onView(withId(R.id.expertDetailsFragment))
                .check(matches(isDisplayed()));

        pressBack();

        Thread.sleep(1000);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.blogFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.blog_fragment_title))));

        Thread.sleep(1000);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.eventsFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.events_fragment_title))));

        Thread.sleep(1000);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.privacyPolicyFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.privacy_policy_fragment_title))));

        Thread.sleep(1000);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.contactFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.contact_fragment_title))));

        Thread.sleep(1000);
        onView(withId(R.id.drawer_layout))
                .perform(DrawerActions.open())
                .check(matches(isOpen()));
        onView(withId(R.id.navigation_view))
                .perform(NavigationViewActions.navigateTo(R.id.homeScreenFragment));
        onView(withId(R.id.topAppBar))
                .check(matches(hasDescendant(withText(R.string.home_fragment_title))));
    }
}