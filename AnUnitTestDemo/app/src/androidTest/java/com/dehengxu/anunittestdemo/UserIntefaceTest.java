package com.dehengxu.anunittestdemo;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by nicholasxu on 16/3/1.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class UserIntefaceTest {

    private String mToBeChecked;

    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    @Before
    public void initCheckedString() {
        mToBeChecked = "Hello World!";
    }

    @Test
    public void changeTextViewContent() {
        onView(withId(R.id.textView_hello)).check(ViewAssertions.matches(withText("Hello World!")));
    }

    @Test
    public void checkLoginToChangeUserName() {
        //点击button之后设置 editText_name 的值,然后检测内容
        onView(withId(R.id.button_login)).perform(ViewActions.click());
        onView(withId(R.id.editText_name)).check(ViewAssertions.matches(withText("Hello, Button!")));
    }
}
