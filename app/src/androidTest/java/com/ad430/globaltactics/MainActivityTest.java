package com.ad430.globaltactics;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.net.Uri;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.intent.matcher.UriMatchers.hasHost;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.allOf;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void hasHelloWorld() {
        onView(withId(R.id.hello_world_text))
                .check(matches(withText("Hello World!")));
    }
  
    @Test
    public void allFragmentsDisplayed() {
        onView(withId(R.id.tvAboutUs))
                .check(matches(withText(R.string.about_us)));
        onView(withId(R.id.blog_placeholder_text))
                .check(matches(withText(R.string.blog_placeholder)));
        onView(withId(R.id.events_placeholder_text))
                .check(matches(withText(R.string.events_placeholder)));
        onView(withId(R.id.privacy_placeholder_text))
                .check(matches(withText(R.string.privacy_placeholder)));

    }

    @Test
    public void aboutUsFragmentsAllTextViews() {
        onView(withId(R.id.tvAboutUs)).check(matches(withText(R.string.about_us)));
        onView(withId(R.id.tvParagraphOne)).check(matches(withText(R.string.paragraph_one)));
        onView(withId(R.id.tvParagraphTwo)).check(matches(withText(R.string.paragraph_two)));
        onView(withId(R.id.tvParagraphThree)).check(matches(withText(R.string.paragraph_three)));
        onView(withId(R.id.tvParagraphFour)).check(matches(withText(R.string.paragraph_four)));
        onView(withId(R.id.tvBorderLine)).check(matches(isDisplayed()));
    }

    @Test
    public void homeScreenFragmentHasSocialLinks() {
        onView(withId(R.id.ivLinkedin)).check(matches(isDisplayed()));
        onView(withId(R.id.ivFacebook)).check(matches(isDisplayed()));
        onView(withId(R.id.ivTwitter)).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnLinkedinIcon() {
        onView(withId(R.id.ivLinkedin)).perform(click());

        intended(allOf(hasAction(Intent.ACTION_VIEW), hasData(allOf(hasHost("www.linkedin.com")))));
    }

    @Test
    public void clickOnFacebookIcon() {
        onView(withId(R.id.ivFacebook)).perform(click());

        intended(allOf(hasAction(Intent.ACTION_VIEW), hasData(allOf(hasHost("www.facebook.com")))));
    }

    @Test
    public void clickOnTwitterIcon() {
        onView(withId(R.id.ivTwitter)).perform(click());

        intended(allOf(hasAction(Intent.ACTION_VIEW), hasData(allOf(hasHost("twitter.com")))));
    }
}