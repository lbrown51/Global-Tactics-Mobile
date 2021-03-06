package com.ad430.globaltactics;

import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withParentIndex;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)

public class OurSuccessesFragmentTest {
    public static RecyclerViewMatcherTestUtils withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcherTestUtils(recyclerViewId);
    }

    @Test
    public void hasRecyclerView() throws InterruptedException {
        FragmentScenario<OurSuccessesFragment> fragmentScenario = FragmentScenario
                .launchInContainer(
                        OurSuccessesFragment.class,
                        new Bundle(),
                        R.style.AppTheme,
                        null
                );

        Thread.sleep(5000);

        onView(withId(R.id.ourSuccessesTabs)).check(matches(isDisplayed()));
        onView(withId(R.id.ourSuccessesCorporateList)).check(matches(isDisplayed()));
    }

    @Test
    public void cardsHaveCorrectContent() throws InterruptedException {
        FragmentScenario<OurSuccessesFragment> fragmentScenario = FragmentScenario
            .launchInContainer(
                OurSuccessesFragment.class,
                new Bundle(),
                R.style.AppTheme,
                null
            );

        Thread.sleep(5000);

        onView(
            withRecyclerView(R.id.ourSuccessesCorporateList)
                .atPositionOnView(0, R.id.llOurSuccess)
        )
            .check(matches(isDisplayed()));

        onView(
            withRecyclerView(R.id.ourSuccessesCorporateList)
                .atPositionOnView(0, R.id.ivOurSuccessFlag)
        )
            .check(matches(isDisplayed()));

        onView(
            withRecyclerView(R.id.ourSuccessesCorporateList)
                .atPositionOnView(0, R.id.tvOurSuccessTitle)
        )
            .check(matches(isDisplayed()));

        onView(
            withRecyclerView(R.id.ourSuccessesCorporateList)
                .atPositionOnView(0, R.id.tvOurSuccessDescription)
        )
            .check(matches(isDisplayed()));
    }

    @Test
    public void canNavigateToAllTabs() {
        FragmentScenario<OurSuccessesFragment> fragmentScenario = FragmentScenario
                .launchInContainer(
                        OurSuccessesFragment.class,
                        new Bundle(),
                        R.style.AppTheme,
                        null
                );

        onView(withText("GOVERNMENT")).perform(click());
        onView(withText("NON-PROFIT")).perform(click());
        onView(withText("CORPORATE")).perform(click());
    }

}