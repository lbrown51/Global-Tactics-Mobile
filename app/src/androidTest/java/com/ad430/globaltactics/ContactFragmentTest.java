package com.ad430.globaltactics;

import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;

import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
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

    @Test
    public void contactFragmentCanSendRequests() throws InterruptedException {
        FragmentScenario<ContactFragment> fragmentScenario = FragmentScenario.launchInContainer(
                ContactFragment.class,
                new Bundle(),
                R.style.AppTheme,
                null
        );

        Thread.sleep(2000);

        onView(withId(R.id.post_message)).perform(click());
        onView(withId(R.id.first_name)).perform(typeText("test"));
        closeSoftKeyboard();

        onView(withId(R.id.last_name)).perform(typeText("test last"));
        closeSoftKeyboard();
        onView(withId(R.id.post_message)).perform(click());

        onView(withId(R.id.your_email)).perform(typeText("testing@gmail.com"));
        closeSoftKeyboard();
        onView(withId(R.id.post_message)).perform(click());

        onView(withId(R.id.your_subject)).perform(typeText("test subject"));
        closeSoftKeyboard();
        onView(withId(R.id.post_message)).perform(click());

        onView(withId(R.id.your_message)).perform(typeText("test message"));
        closeSoftKeyboard();

        onView(withId(R.id.post_message)).perform(click());

        Thread.sleep(2000);

        onView(withId(R.id.post_message)).check(matches(withText(R.string.contact_form_button)));
        //   onView(withId(R.id.tvBorderLine)).check(matches(isDisplayed()));

    }

}