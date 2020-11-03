package com.ad430.globaltactics;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class ExpertDetailsFragmentTest {
    @Test
    public void hasCorrectContent() {
        Bundle expertBundle = new Bundle();
        expertBundle.putString("name", getResourceString(R.string.expert_test_name));
        expertBundle.putString("title", getResourceString(R.string.expert_test_title));
        expertBundle.putString("location", getResourceString(R.string.expert_test_location));
        expertBundle.putString("specialties", getResourceString(R.string.expert_test_specialties));
        expertBundle.putString("description", getResourceString(R.string.expert_test_description));
        expertBundle.putString("linkedin", getResourceString(R.string.expert_test_linkedin));

        FragmentScenario<ExpertDetailsFragment> fragmentScenario = FragmentScenario
                .launchInContainer(
                        ExpertDetailsFragment.class,
                        expertBundle,
                        R.style.AppTheme,
                        null
                );

        onView(withId(R.id.expertDetailsFragment))
                .check(matches(isDisplayed()));

        onView(withId(R.id.expert_details_name_tv))
                .check(matches(withText(R.string.expert_test_name)));
        onView(withId(R.id.expert_details_title_tv))
                .check(matches(withText(R.string.expert_test_title)));
        onView(withId(R.id.expert_details_location_tv))
                .check(matches(withText(R.string.expert_test_location)));
//        onView(withId(R.id.expert_details_specialties_tv))
//                .check(matches(withText(R.string.expert_test_specialties)));
        onView(withId(R.id.expert_details_description_tv))
                .check(matches(withText(R.string.expert_test_description)));
//        onView(withId(R.id.expert_details_linkedin_tv))
//                .check(matches(withText(R.string.expert_test_linkedin)));

    }

    private String getResourceString(int id) {
        Context targetContext = ApplicationProvider.getApplicationContext();
        return targetContext.getResources().getString(id);
    }
}