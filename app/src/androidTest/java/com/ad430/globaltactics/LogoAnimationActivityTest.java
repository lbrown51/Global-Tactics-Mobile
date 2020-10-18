package com.ad430.globaltactics;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class LogoAnimationActivityTest {
    @Rule
    public ActivityTestRule<LogoAnimationActivity> activityTestRule =
            new ActivityTestRule<>(LogoAnimationActivity.class);

    private LogoAnimationActivity lAActivity = null;

    @Before
    public void setUp() throws Exception {
        lAActivity = activityTestRule.getActivity();
    }

    @Test
    public void hasLogoLetters() {
        View view = lAActivity.findViewById(R.id.lALogo);

        assertNotNull(view);
    }

    @After
    public void tearDown() throws Exception {
        lAActivity = null;
    }
}