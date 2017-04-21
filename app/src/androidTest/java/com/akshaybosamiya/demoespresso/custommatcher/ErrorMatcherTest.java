package com.akshaybosamiya.demoespresso.custommatcher;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.akshaybosamiya.demoespresso.MainActivity;
import com.akshaybosamiya.demoespresso.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by akshaybosamiya on 21/4/17.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ErrorMatcherTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void error_isDisplayedInEditText() {
        String errorText = "Type Here!";
        //Click button
        onView(withId(R.id.changeTextBt)).perform(click());
        //Check error in editText
        onView(withId(R.id.editTextUserInput)).check(matches(ErrorMatcher.withError(errorText)));
    }

}
