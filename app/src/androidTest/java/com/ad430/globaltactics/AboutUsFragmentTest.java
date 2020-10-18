package com.ad430.globaltactics;

import android.content.Intent;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.intent.matcher.UriMatchers.hasHost;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


public class AboutUsFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class){
        @Override
        protected Intent getActivityIntent() {
            Intent intent = new Intent(ApplicationProvider.getApplicationContext(),MainActivity.class);

            return intent;
        }
    };

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    MainActivity mainActivity;
    AboutUsFragment aboutUsFragment;

    @Before
    public void init(){
        activityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
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
        onView(withId(R.id.ivLinkedin)).perform(scrollTo(), click());

        intended(allOf(hasAction(Intent.ACTION_VIEW), hasData(allOf(hasHost("www.linkedin.com")))));
    }

    @Test
    public void clickOnFacebookIcon() {
        onView(withId(R.id.ivFacebook)).perform(scrollTo(), click());

        intended(allOf(hasAction(Intent.ACTION_VIEW), hasData(allOf(hasHost("www.facebook.com")))));
    }

    @Test
    public void clickOnTwitterIcon() {
        onView(withId(R.id.ivTwitter)).perform(scrollTo(), click());

        intended(allOf(hasAction(Intent.ACTION_VIEW), hasData(allOf(hasHost("twitter.com")))));
    }
}