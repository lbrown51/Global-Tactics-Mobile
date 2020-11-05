package com.ad430.globaltactics;

import android.content.Intent;

import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.intent.Intents;

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

public class PrivacyPolicyFragmentTest {

    @Test
    public void privacyPolicyFragmentTextViews() {
        FragmentScenario<PrivacyPolicyFragment> fragmentScenario = FragmentScenario.launchInContainer(PrivacyPolicyFragment.class);

        onView(withId(R.id.tvPrivacyPolicy)).check(matches(withText(R.string.privacy_policy)));
        onView(withId(R.id.tvPrivacyUpdated)).check(matches(withText(R.string.privacy_updated)));
        onView(withId(R.id.tvPrivacyHeaderOne)).check(matches(withText(R.string.privacy_header_one)));
        onView(withId(R.id.tvPrivacyParagraphOne)).check(matches(withText(R.string.privacy_paragraph_one)));
        onView(withId(R.id.tvPrivacyParagraphTwo)).check(matches(withText(R.string.privacy_paragraph_two)));
        onView(withId(R.id.tvPrivacyParagraphThree)).check(matches(withText(R.string.privacy_paragraph_three)));
        onView(withId(R.id.tvPrivacyParagraphFour)).check(matches(withText(R.string.privacy_paragraph_four)));
        onView(withId(R.id.tvPrivacyHeaderTwo)).check(matches(withText(R.string.privacy_header_two)));
        onView(withId(R.id.tvPrivacyParagraphFive)).check(matches(withText(R.string.privacy_paragraph_five)));
        onView(withId(R.id.tvPrivacyParagraphSix)).check(matches(withText(R.string.privacy_paragraph_six)));
        onView(withId(R.id.tvPrivacyBulletOne)).check(matches(withText(R.string.privacy_bullet_one)));
        onView(withId(R.id.tvPrivacyBulletTwo)).check(matches(withText(R.string.privacy_bullet_two)));
        onView(withId(R.id.tvPrivacyBulletThree)).check(matches(withText(R.string.privacy_bullet_three)));
        onView(withId(R.id.tvPrivacyBulletFour)).check(matches(withText(R.string.privacy_bullet_four)));
        onView(withId(R.id.tvPrivacyParagraphSeven)).check(matches(withText(R.string.privacy_paragraph_seven)));
        onView(withId(R.id.tvPrivacyBulletFive)).check(matches(withText(R.string.privacy_bullet_five)));
        onView(withId(R.id.tvPrivacyBulletSix)).check(matches(withText(R.string.privacy_bullet_six)));
        onView(withId(R.id.tvPrivacyBulletSeven)).check(matches(withText(R.string.privacy_bullet_seven)));
        onView(withId(R.id.tvPrivacyBulletEight)).check(matches(withText(R.string.privacy_bullet_eight)));
        onView(withId(R.id.tvPrivacyBulletNine)).check(matches(withText(R.string.privacy_bullet_nine)));
        onView(withId(R.id.tvPrivacyBulletTen)).check(matches(withText(R.string.privacy_bullet_ten)));
        onView(withId(R.id.tvPrivacyBulletEleven)).check(matches(withText(R.string.privacy_bullet_eleven)));
        onView(withId(R.id.tvPrivacyParagraphEight)).check(matches(withText(R.string.privacy_paragraph_eight)));
        onView(withId(R.id.tvPrivacyParagraphNine)).check(matches(withText(R.string.privacy_paragraph_nine)));
        onView(withId(R.id.tvPrivacyHeaderThree)).check(matches(withText(R.string.privacy_header_three)));
        onView(withId(R.id.tvPrivacyParagraphTen)).check(matches(withText(R.string.privacy_paragraph_ten)));
        onView(withId(R.id.tvPrivacyBulletTwelve)).check(matches(withText(R.string.privacy_bullet_twelve)));
        onView(withId(R.id.tvPrivacyBulletThirteen)).check(matches(withText(R.string.privacy_bullet_thirteen)));
        onView(withId(R.id.tvPrivacyBulletFourteen)).check(matches(withText(R.string.privacy_bullet_fourteen)));
        onView(withId(R.id.tvPrivacyBulletFifteen)).check(matches(withText(R.string.privacy_bullet_fifteen)));
        onView(withId(R.id.tvPrivacyBulletSixteen)).check(matches(withText(R.string.privacy_bullet_sixteen)));
        onView(withId(R.id.tvPrivacyBulletSeventeen)).check(matches(withText(R.string.privacy_bullet_seventeen)));
        onView(withId(R.id.tvPrivacyParagraphEleven)).check(matches(withText(R.string.privacy_paragraph_eleven)));
        onView(withId(R.id.tvPrivacyHeaderFour)).check(matches(withText(R.string.privacy_header_four)));
        onView(withId(R.id.tvPrivacyParagraphTwelve)).check(matches(withText(R.string.privacy_paragraph_twelve)));
        onView(withId(R.id.tvPrivacyBulletEighteen)).check(matches(withText(R.string.privacy_bullet_eighteen)));
        onView(withId(R.id.tvPrivacyBulletNineteen)).check(matches(withText(R.string.privacy_bullet_nineteen)));
        onView(withId(R.id.tvPrivacyBulletTwenty)).check(matches(withText(R.string.privacy_bullet_twenty)));
        onView(withId(R.id.tvPrivacyBulletTwentyOne)).check(matches(withText(R.string.privacy_bullet_twentyone)));
        onView(withId(R.id.tvPrivacyBulletTwentyTwo)).check(matches(withText(R.string.privacy_bullet_twentytwo)));
        onView(withId(R.id.tvPrivacyHeaderFive)).check(matches(withText(R.string.privacy_header_five)));
        onView(withId(R.id.tvPrivacyParagraphThirteen)).check(matches(withText(R.string.privacy_paragraph_thirteen)));
        onView(withId(R.id.tvPrivacyParagraphFourteen)).check(matches(withText(R.string.privacy_paragraph_fourteen)));
        onView(withId(R.id.tvPrivacyParagraphFifteen)).check(matches(withText(R.string.privacy_paragraph_fifteen)));
        onView(withId(R.id.tvPrivacyHeaderSix)).check(matches(withText(R.string.privacy_header_six)));
        onView(withId(R.id.tvPrivacyParagraphSixteen)).check(matches(withText(R.string.privacy_paragraph_sixteen)));
        onView(withId(R.id.tvPrivacyParagraphSeventeen)).check(matches(withText(R.string.privacy_paragraph_seventeen)));
        onView(withId(R.id.tvPrivacyParagraphEighteen)).check(matches(withText(R.string.privacy_paragraph_eighteen)));
        onView(withId(R.id.tvPrivacyParagraphNineteen)).check(matches(withText(R.string.privacy_paragraph_nineteen)));
        onView(withId(R.id.tvPrivacyParagraphTwenty)).check(matches(withText(R.string.privacy_paragraph_twenty)));
        onView(withId(R.id.tvPrivacyParagraphTwentyOne)).check(matches(withText(R.string.privacy_paragraph_twentyone)));
        onView(withId(R.id.tvPrivacyParagraphTwentyTwo)).check(matches(withText(R.string.privacy_paragraph_twentytwo)));
        onView(withId(R.id.tvPrivacyParagraphTwentyThree)).check(matches(withText(R.string.privacy_paragraph_twentythree)));
        onView(withId(R.id.tvPrivacyParagraphTwentyFour)).check(matches(withText(R.string.privacy_paragraph_twentyfour)));
        onView(withId(R.id.tvPrivacyHeaderSeven)).check(matches(withText(R.string.privacy_header_seven)));
        onView(withId(R.id.tvPrivacyParagraphTwentyFive)).check(matches(withText(R.string.privacy_paragraph_twentyfive)));
        onView(withId(R.id.tvPrivacyHeaderEight)).check(matches(withText(R.string.privacy_header_eight)));
        onView(withId(R.id.tvPrivacyParagraphTwentySix)).check(matches(withText(R.string.privacy_paragraph_twentysix)));
        onView(withId(R.id.tvPrivacyHeaderNine)).check(matches(withText(R.string.privacy_header_nine)));
        onView(withId(R.id.tvPrivacyParagraphTwentySeven)).check(matches(withText(R.string.privacy_paragraph_twentyseven)));
        onView(withId(R.id.tvPrivacyHeaderTen)).check(matches(withText(R.string.privacy_header_ten)));
        onView(withId(R.id.tvPrivacyParagraphTwentyEight)).check(matches(withText(R.string.privacy_paragraph_twentyeight)));
        onView(withId(R.id.tvPrivacyParagraphTwentyNine)).check(matches(withText(R.string.privacy_paragraph_twentynine)));
        onView(withId(R.id.tvPrivacyParagraphThirty)).check(matches(withText(R.string.privacy_paragraph_thirty)));
        onView(withId(R.id.tvPrivacyHeaderEleven)).check(matches(withText(R.string.privacy_header_eleven)));
        onView(withId(R.id.tvPrivacyParagraphThirtyOne)).check(matches(withText(R.string.privacy_paragraph_thirtyone)));
        onView(withId(R.id.tvPrivacyParagraphThirtyTwo)).check(matches(withText(R.string.privacy_paragraph_thirtytwo)));
        onView(withId(R.id.tvPrivacyBulletTwentyThree)).check(matches(withText(R.string.privacy_bullet_twentythree)));
        onView(withId(R.id.tvPrivacyBulletTwentyFour)).check(matches(withText(R.string.privacy_bullet_twentyfour)));
        onView(withId(R.id.tvPrivacyBulletTwentyFive)).check(matches(withText(R.string.privacy_bullet_twentyfive)));
        onView(withId(R.id.tvPrivacyBulletTwentySix)).check(matches(withText(R.string.privacy_bullet_twentysix)));
        onView(withId(R.id.tvPrivacyParagraphThirtyThree)).check(matches(withText(R.string.privacy_paragraph_thirtythree)));
        onView(withId(R.id.tvPrivacyParagraphThirtyFour)).check(matches(withText(R.string.privacy_paragraph_thirtyfour)));
        onView(withId(R.id.tvPrivacyParagraphThirtyFive)).check(matches(withText(R.string.privacy_paragraph_thirtyfive)));
        onView(withId(R.id.tvPrivacyParagraphThirtySix)).check(matches(withText(R.string.privacy_paragraph_thirtysix)));
        onView(withId(R.id.tvPrivacyParagraphThirtySeven)).check(matches(withText(R.string.privacy_paragraph_thirtyseven)));
        onView(withId(R.id.tvPrivacyParagraphThirtyEight)).check(matches(withText(R.string.privacy_paragraph_thirtyeight)));
        onView(withId(R.id.tvPrivacyParagraphThirtyNine)).check(matches(withText(R.string.privacy_paragraph_thirtynine)));
        onView(withId(R.id.tvPrivacyParagraphForty)).check(matches(withText(R.string.privacy_paragraph_forty)));
        onView(withId(R.id.tvPrivacyParagraphFortyOne)).check(matches(withText(R.string.privacy_paragraph_fortyone)));
        onView(withId(R.id.tvPrivacyParagraphFortyTwo)).check(matches(withText(R.string.privacy_paragraph_fortytwo)));
        onView(withId(R.id.tvPrivacyParagraphFortyThree)).check(matches(withText(R.string.privacy_paragraph_fortythree)));
        onView(withId(R.id.tvPrivacyBulletTwentySeven)).check(matches(withText(R.string.privacy_bullet_twentyseven)));
        onView(withId(R.id.tvPrivacyBulletTwentyEight)).check(matches(withText(R.string.privacy_bullet_twentyeight)));
        onView(withId(R.id.tvPrivacyBulletTwentyNine)).check(matches(withText(R.string.privacy_bullet_twentynine)));
        onView(withId(R.id.tvPrivacyBulletThirty)).check(matches(withText(R.string.privacy_bullet_thirty)));
        onView(withId(R.id.tvPrivacyParagraphFortyFour)).check(matches(withText(R.string.privacy_paragraph_fortyfour)));
        onView(withId(R.id.tvPrivacyBulletThirtyOne)).check(matches(withText(R.string.privacy_bullet_thirtyone)));
        onView(withId(R.id.tvPrivacyBulletThirtyTwo)).check(matches(withText(R.string.privacy_bullet_thirtytwo)));
        onView(withId(R.id.tvPrivacyBulletThirtyThree)).check(matches(withText(R.string.privacy_bullet_thirtythree)));
        onView(withId(R.id.tvPrivacyBulletThirtyFour)).check(matches(withText(R.string.privacy_bullet_thirtyfour)));
        onView(withId(R.id.tvPrivacyParagraphFortyFive)).check(matches(withText(R.string.privacy_paragraph_fortyfive)));
        onView(withId(R.id.tvPrivacyBulletThirtyFive)).check(matches(withText(R.string.privacy_bullet_thirtyfive)));
        onView(withId(R.id.tvPrivacyBulletThirtySix)).check(matches(withText(R.string.privacy_bullet_thirtysix)));
        onView(withId(R.id.tvPrivacyBulletThirtySeven)).check(matches(withText(R.string.privacy_bullet_thirtyseven)));
        onView(withId(R.id.tvPrivacyBulletThirtyEight)).check(matches(withText(R.string.privacy_bullet_thirtyeight)));
        onView(withId(R.id.tvPrivacyBulletThirtyNine)).check(matches(withText(R.string.privacy_bullet_thirtynine)));
        onView(withId(R.id.tvPrivacyParagraphFortySix)).check(matches(withText(R.string.privacy_paragraph_fortysix)));
        onView(withId(R.id.tvPrivacyBulletForty)).check(matches(withText(R.string.privacy_bullet_forty)));
        onView(withId(R.id.tvPrivacyBulletFortyOne)).check(matches(withText(R.string.privacy_bullet_fortyone)));
        onView(withId(R.id.tvPrivacyBulletFortyTwo)).check(matches(withText(R.string.privacy_bullet_fortytwo)));
        onView(withId(R.id.tvPrivacyBulletFortyThree)).check(matches(withText(R.string.privacy_bullet_fortythree)));
        onView(withId(R.id.tvPrivacyBulletFortyFour)).check(matches(withText(R.string.privacy_bullet_fortyfour)));
        onView(withId(R.id.tvPrivacyBulletFortyFive)).check(matches(withText(R.string.privacy_bullet_fortyfive)));
        onView(withId(R.id.tvPrivacyBulletFortySix)).check(matches(withText(R.string.privacy_bullet_fortysix)));
        onView(withId(R.id.tvPrivacyBulletFortySeven)).check(matches(withText(R.string.privacy_bullet_fortyseven)));
        onView(withId(R.id.tvPrivacyParagraphFortySeven)).check(matches(withText(R.string.privacy_paragraph_fortyseven)));
        onView(withId(R.id.tvPrivacyParagraphFortyEight)).check(matches(withText(R.string.privacy_paragraph_fortyeight)));
        onView(withId(R.id.tvPrivacyParagraphFortyNine)).check(matches(withText(R.string.privacy_paragraph_fortynine)));
        onView(withId(R.id.tvPrivacyHeaderTwelve)).check(matches(withText(R.string.privacy_header_twelve)));
        onView(withId(R.id.tvPrivacyParagraphFifty)).check(matches(withText(R.string.privacy_paragraph_fifty)));
        onView(withId(R.id.tvPrivacyHeaderThirteen)).check(matches(withText(R.string.privacy_header_thirteen)));
        onView(withId(R.id.tvPrivacyParagraphFiftyOne)).check(matches(withText(R.string.privacy_paragraph_fiftyone)));
        onView(withId(R.id.tvPrivacyHeaderFourteen)).check(matches(withText(R.string.privacy_header_fourteen)));
        onView(withId(R.id.tvPrivacyParagraphFiftyTwo)).check(matches(withText(R.string.privacy_paragraph_fiftytwo)));
        onView(withId(R.id.tvPrivacyParagraphFiftyThree)).check(matches(withText(R.string.privacy_paragraph_fiftythree)));
        onView(withId(R.id.tvPrivacyParagraphFiftyFour)).check(matches(withText(R.string.privacy_paragraph_fiftyfour)));

        //   onView(withId(R.id.tvBorderLine)).check(matches(isDisplayed()));
    }
    @Test
    public void clickOnLinkedinIcon() throws InterruptedException {
        FragmentScenario<AboutUsFragment> fragmentScenario = FragmentScenario.launchInContainer(AboutUsFragment.class);

        Thread.sleep(5000);

        Intents.init();
        onView(withId(R.id.ivLinkedin)).perform(scrollTo()).perform(click());
        Intents.intended(allOf(hasAction(Intent.ACTION_VIEW)));
        Intents.release();
    }

    @Test
    public void clickOnFacebookIcon() throws InterruptedException {
        FragmentScenario<AboutUsFragment> fragmentScenario = FragmentScenario.launchInContainer(AboutUsFragment.class);

        Thread.sleep(5000);
        Intents.init();

        onView(withId(R.id.ivFacebook)).perform(scrollTo()).perform(click());
        Intents.intended(allOf(hasAction(Intent.ACTION_VIEW)));
        Intents.release();

    }

    @Test
    public void clickOnTwitterIcon() throws InterruptedException {
        FragmentScenario<AboutUsFragment> fragmentScenario = FragmentScenario.launchInContainer(AboutUsFragment.class);

        Thread.sleep(5000);
        Intents.init();

        onView(withId(R.id.ivTwitter)).perform(scrollTo()).perform(click());
        Intents.intended(allOf(hasAction(Intent.ACTION_VIEW)));
        Intents.release();

    }

}