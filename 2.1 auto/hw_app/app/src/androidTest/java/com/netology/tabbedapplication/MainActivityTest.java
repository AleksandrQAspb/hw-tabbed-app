package com.netology.tabbedapplication;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        checkPageText("Page: 1");
        clickTab("Tab 2");
        checkPageText("Page: 2");
        clickTab("Tab 1");
        checkPageText("Page: 1");
    }

    private void clickTab(String contentDescription) {
        onView(withContentDescription(contentDescription))
                .perform(click());
    }

    private void checkPageText(String text) {
        onView(allOf(withId(R.id.section_label), withText(text), isDisplayed()))
                .check(matches(withText(text)));
    }

}
