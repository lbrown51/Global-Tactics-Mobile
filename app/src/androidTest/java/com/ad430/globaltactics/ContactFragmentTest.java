package com.ad430.globaltactics;

import androidx.fragment.app.testing.FragmentScenario;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
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

        onView(withId(R.id.post_message)).check(matches(withText(R.string.contact_form_button)));
        //   onView(withId(R.id.tvBorderLine)).check(matches(isDisplayed()));

    }

}