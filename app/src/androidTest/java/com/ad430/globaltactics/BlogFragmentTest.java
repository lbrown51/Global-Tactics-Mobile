package com.ad430.globaltactics;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.intent.Intents;

import org.junit.After;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

public class BlogFragmentTest {
    public static RecyclerViewMatcherTestUtils withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcherTestUtils(recyclerViewId);
    }

    @Test
    public void hasRecyclerView() throws InterruptedException {
        FragmentScenario<BlogFragment> fragmentScenario = FragmentScenario.launchInContainer(
                BlogFragment.class,
                new Bundle(),
                R.style.AppTheme,
                null
        );

        Thread.sleep(1000);

        onView(withId(R.id.blogs_list)).check(matches(isDisplayed()));
    }

    @Test
    public void onBlogPostClick() throws InterruptedException {
        FragmentScenario<BlogFragment> fragmentScenario = FragmentScenario.launchInContainer(
                BlogFragment.class,
                new Bundle(),
                R.style.AppTheme,
                null
        );

        Thread.sleep(1000);

        Intents.init();
        onView(withRecyclerView(R.id.blogs_list).atPosition(0)).perform(click());
        Intents.intended(allOf(hasAction(Intent.ACTION_VIEW)));
        Intents.release();
    }

    @Test
    public void onBlogPostLabelSelection() throws InterruptedException {
        FragmentScenario<BlogFragment> fragmentScenario = FragmentScenario.launchInContainer(
                BlogFragment.class,
                new Bundle(),
                R.style.AppTheme,
                null
        );

        Thread.sleep(1000);

        onView(withId(R.id.blog_post_label_dropdown)).perform(click());
        Thread.sleep(1000);

        onView(withText("Africa"))
                .inRoot(isPlatformPopup())
                .perform(click());
    }
}