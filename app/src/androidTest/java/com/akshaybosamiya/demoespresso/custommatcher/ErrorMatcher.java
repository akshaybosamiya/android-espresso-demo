package com.akshaybosamiya.demoespresso.custommatcher;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static org.hamcrest.Matchers.is;

/**
 * Created by akshaybosamiya on 21/4/17.
 */


//Require to make custom matcher for checking properties
//This is for checks the error property of an editText
public class ErrorMatcher {
    static Matcher<View> withError(final String substring) {
      return withError(is(substring));
    }

    static Matcher<View> withError(final Matcher<String> stringMatcher) {
        checkNotNull(stringMatcher);
        return new BoundedMatcher<View, EditText>(EditText.class) {

            @Override
            public boolean matchesSafely(EditText view) {
                final CharSequence error = view.getError();
                return error != null && stringMatcher.matches(error.toString());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with error: ");
                stringMatcher.describeTo(description);
            }
        };
    }
}
