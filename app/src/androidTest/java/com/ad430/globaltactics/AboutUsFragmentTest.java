package com.ad430.globaltactics;

import android.content.Intent;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


public class AboutUsFragmentTest {

    @Test
    public void aboutUsFragmentsHasCorrectContent() throws InterruptedException {
        FragmentScenario<AboutUsFragment> fragmentScenario = FragmentScenario.launchInContainer(AboutUsFragment.class);

        Thread.sleep(1000);

        onView(withId(R.id.tvParagraphOne)).check(matches(isDisplayed()));
        onView(withId(R.id.tvParagraphTwo)).check(matches(isDisplayed()));
        onView(withId(R.id.tvParagraphThree)).check(matches(isDisplayed()));
        onView(withId(R.id.tvParagraphFour)).check(matches(isDisplayed()));
        onView(withId(R.id.ivLinkedin)).perform(scrollTo());

        onView(withId(R.id.tvBorderLine)).check(matches(isDisplayed()));
        onView(withId(R.id.ivLinkedin)).check(matches(isDisplayed()));
        onView(withId(R.id.ivFacebook)).check(matches(isDisplayed()));
        onView(withId(R.id.ivTwitter)).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnLinkedinIcon() throws InterruptedException {
        FragmentScenario<AboutUsFragment> fragmentScenario = FragmentScenario.launchInContainer(AboutUsFragment.class);

        Thread.sleep(5000);

        Intents.init();
        onView(withId(R.id.ivLinkedin)).perform(scrollTo()).perform(click());
        Intents.intended(allOf(hasAction(Intent.ACTION_VIEW)));
        Intents.release();
    }

    @Test
    public void clickOnFacebookIcon() throws InterruptedException {
        FragmentScenario<AboutUsFragment> fragmentScenario = FragmentScenario.launchInContainer(AboutUsFragment.class);

        Thread.sleep(5000);
        Intents.init();

        onView(withId(R.id.ivFacebook)).perform(scrollTo()).perform(click());
        Intents.intended(allOf(hasAction(Intent.ACTION_VIEW)));
        Intents.release();

    }

    @Test
    public void clickOnTwitterIcon() throws InterruptedException {
        FragmentScenario<AboutUsFragment> fragmentScenario = FragmentScenario.launchInContainer(AboutUsFragment.class);

        Thread.sleep(5000);
        Intents.init();

        onView(withId(R.id.ivTwitter)).perform(scrollTo()).perform(click());
        Intents.intended(allOf(hasAction(Intent.ACTION_VIEW)));
        Intents.release();

    }
}