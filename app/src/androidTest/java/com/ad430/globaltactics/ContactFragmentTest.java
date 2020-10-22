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


public class ContactFragmentTest {

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

        View view = mFragment.getView().findViewById(R.id.contactFragment);

        onView(withId(R.id.your_email_top)).check(matches(withText(R.string.contact_form_email)));
        onView(withId(R.id.your_name_top)).check(matches(withText(R.string.contact_form_name)));
        onView(withId(R.id.your_email_top)).check(matches(withText(R.string.contact_form_button)));
        onView(withId(R.id.your_subject_top)).check(matches(withText(R.string.contact_form_subject)));
        onView(withId(R.id.post_message)).check(matches(withText(R.string.contact_form_button)));
     //   onView(withId(R.id.tvBorderLine)).check(matches(isDisplayed()));

    }

   @After
   public void tearDown() throws Exception {
       mActivity = null;
    }
}