package com.dehengxu.anunittestdemo;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by nicholasxu on 16/3/1.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class LogicTests {
    @Test
    public void CheckContent() {
        String html = "Hello";
        Assert.assertEquals("html should be 'Hello'", html, "Hello");
    }

    private String mToBeChecked;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void initCheckedString() {
        mToBeChecked = "Hello World!";
    }

    @Test
    public void ChangeTextViewContent() {
        onView(withId(R.id.textView_hello)).check(ViewAssertions.matches(withText(mToBeChecked)));
    }
}
