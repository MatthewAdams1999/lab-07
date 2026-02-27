package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);
    private final String TEST_CITY = "Edmonton";


    @Test
    public void testActivitySwitch() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText(TEST_CITY));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText(TEST_CITY)).perform(click());
        onView(withId(R.id.text_city)).check(matches(withText(TEST_CITY)));
    }

    @Test
    public void testCityNameMatchesSelectedCity() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText(TEST_CITY));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText(TEST_CITY)).perform(click());
        onView(withId(R.id.text_city)).check(matches(withText(TEST_CITY)));
    }

    @Test
    public void testBackButtonOnShowActivity() {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText(TEST_CITY));
        onView(withId(R.id.button_confirm)).perform(click());

        onView(withText(TEST_CITY)).perform(click());

        onView(withId(R.id.button_back)).perform(click());

        onView(withId(R.id.button_add)).check(matches(isDisplayed()));
    }
}
