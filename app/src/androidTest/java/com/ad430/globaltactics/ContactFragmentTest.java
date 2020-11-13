package com.ad430.globaltactics;

import androidx.fragment.app.testing.FragmentScenario;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
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
    public void aboutUsFragmentsAllTextViews() {
        FragmentScenario<ContactFragment> fragmentScenario = FragmentScenario.launchInContainer(ContactFragment.class);

        onView(withId(R.id.first_name)).perform(typeText("test"));
        onView(withId(R.id.last_name)).perform(typeText("test last"));
        onView(withId(R.id.your_email)).perform(typeText("testing@gmail.com"));
        onView(withId(R.id.your_subject)).perform(typeText("test subject"));
        onView(withId(R.id.your_message)).perform(typeText("test message"));
        onView(withId(R.id.get_ip_btn)).perform(click());

        onView(withId(R.id.post_message)).check(matches(withText(R.string.contact_form_button)));
        //   onView(withId(R.id.tvBorderLine)).check(matches(isDisplayed()));

    }

}