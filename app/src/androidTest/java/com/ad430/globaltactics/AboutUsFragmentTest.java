package com.ad430.globaltactics;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
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
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertNotNull;


public class AboutUsFragmentTest {

    @Rule
    public ActivityTestRule<TestActivity> mActivityTestRule = new ActivityTestRule<>(TestActivity.class);

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<>(MainActivity.class);

    private TestActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void aboutUsFragmentsAllTextViews() {
        ConstraintLayout mRelativeLayout = mActivity.findViewById(R.id.testContainer);

        assertNotNull(mRelativeLayout);

        AboutUsFragment mFragment = new AboutUsFragment();

        mActivity.getSupportFragmentManager().beginTransaction().add(mRelativeLayout.getId(), mFragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();

        View view = mFragment.getView().findViewById(R.id.aboutUsFragment);

        assertNotNull(view);

        onView(withId(R.id.tvAboutUs)).check(matches(withText(R.string.about_us)));
        onView(withId(R.id.tvParagraphOne)).check(matches(withText(R.string.paragraph_one)));
        onView(withId(R.id.tvParagraphTwo)).check(matches(withText(R.string.paragraph_two)));
        onView(withId(R.id.tvParagraphThree)).check(matches(withText(R.string.paragraph_three)));
        onView(withId(R.id.tvParagraphFour)).check(matches(withText(R.string.paragraph_four)));
        onView(withId(R.id.tvBorderLine)).check(matches(isDisplayed()));
        onView(withId(R.id.ivLinkedin)).check(matches(isDisplayed()));
        onView(withId(R.id.ivFacebook)).check(matches(isDisplayed()));
        onView(withId(R.id.ivTwitter)).check(matches(isDisplayed()));
    }

    @Test
    public void clickOnLinkedinIcon() {
        RelativeLayout mRelativeLayout = mActivity.findViewById(R.id.testContainer);

        AboutUsFragment mFragment = new AboutUsFragment();

        mActivity.getSupportFragmentManager().beginTransaction().add(mRelativeLayout.getId(), mFragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();

        View view = mFragment.getView().findViewById(R.id.aboutUsFragment);

        onView(withId(R.id.ivLinkedin)).perform(scrollTo(), click());

        intended(allOf(hasAction(Intent.ACTION_VIEW), hasData(allOf(hasHost("www.linkedin.com")))));
    }

    @Test
    public void clickOnFacebookIcon() {
        RelativeLayout mRelativeLayout = mActivity.findViewById(R.id.testContainer);

        AboutUsFragment mFragment = new AboutUsFragment();

        mActivity.getSupportFragmentManager().beginTransaction().add(mRelativeLayout.getId(), mFragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();

        View view = mFragment.getView().findViewById(R.id.aboutUsFragment);

        onView(withId(R.id.ivLinkedin)).perform(scrollTo(), click());

        intended(allOf(hasAction(Intent.ACTION_VIEW)));
    }

    @Test
    public void clickOnTwitterIcon() {
        RelativeLayout mRelativeLayout = mActivity.findViewById(R.id.testContainer);

        AboutUsFragment mFragment = new AboutUsFragment();

        mActivity.getSupportFragmentManager().beginTransaction().add(mRelativeLayout.getId(), mFragment).commitAllowingStateLoss();

        getInstrumentation().waitForIdleSync();

        View view = mFragment.getView().findViewById(R.id.aboutUsFragment);

        onView(withId(R.id.ivLinkedin)).perform(scrollTo(), click());

        intended(allOf(hasAction(Intent.ACTION_VIEW)));
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }
}