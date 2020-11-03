package com.ad430.globaltactics;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class OurExpertsFragmentTest {
    public static RecyclerViewMatcherTestUtils withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcherTestUtils(recyclerViewId);
    }

    @Test
    public void hasRecyclerView() {
        FragmentScenario<OurExpertsFragment> fragmentScenario = FragmentScenario
                .launchInContainer(
                        OurExpertsFragment.class,
                        new Bundle(),
                        R.style.AppTheme,
                        null
                );

        onView(withId(R.id.our_experts_list)).check(matches(isDisplayed()));
    }

    @Test
    public void cardsHaveCorrectContent() {
        FragmentScenario<OurExpertsFragment> fragmentScenario = FragmentScenario
                .launchInContainer(
                        OurExpertsFragment.class,
                        new Bundle(),
                        R.style.AppTheme,
                        null
                );

        onView(
                withRecyclerView(R.id.our_experts_list)
                        .atPositionOnView(0, R.id.expert_name_tv)
        )
                .check(matches(isDisplayed()));

        onView(
                withRecyclerView(R.id.our_experts_list)
                        .atPositionOnView(0, R.id.expert_title_tv)
        )
                .check(matches(isDisplayed()));

        onView(
                withRecyclerView(R.id.our_experts_list)
                        .atPositionOnView(0, R.id.expert_location_tv)
        )
                .check(matches(isDisplayed()));

        onView(
                withRecyclerView(R.id.our_experts_list)
                        .atPositionOnView(0, R.id.expert_specialties_tv)
        )
                .check(matches(isDisplayed()));

    }

    @Test
    public void canGoToExpertDetails() throws InterruptedException {
        TestNavHostController navController = new TestNavHostController(
                ApplicationProvider.getApplicationContext()
        );
        navController.setGraph(R.navigation.navigation_graph);
        navController.setCurrentDestination(R.id.ourExpertsFragment);

        FragmentScenario<OurExpertsFragment> fragmentScenario = FragmentScenario
                .launchInContainer(
                        OurExpertsFragment.class,
                        new Bundle(),
                        R.style.AppTheme,
                        null
                );

        fragmentScenario.onFragment(fragment -> {
            Navigation.setViewNavController(fragment.requireView(), navController);
        });

        onView(withRecyclerView(R.id.our_experts_list).atPosition(0)).perform(click());
        assertEquals(navController.getCurrentDestination().getId(), R.id.expertDetailsFragment);
    }
}