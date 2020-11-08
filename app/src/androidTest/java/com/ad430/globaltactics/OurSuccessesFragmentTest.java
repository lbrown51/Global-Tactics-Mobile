package com.ad430.globaltactics;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;

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
                    .atPositionOnView(0, R.id.ivOurSuccessBackground)
        )
            .check(matches(isDisplayed()));

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

//    @Test
//    public void onTabClick() throws InterruptedException {
//        FragmentScenario<OurSuccessesFragment> fragmentScenario = FragmentScenario
//            .launchInContainer(
//                OurSuccessesFragment.class,
//                new Bundle(),
//                R.style.AppTheme,
//                null
//            );
//
//        Thread.sleep(5000);
//
//        onView(withId(R.id.ivLinkedin)).perform(scrollTo()).perform(click());
//        Intents.intended(allOf(hasAction(Intent.ACTION_VIEW)));
//        Intents.release();
//    }
}