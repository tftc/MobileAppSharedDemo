package com.dehengxu.anunittestdemo;

import android.app.Activity;

import org.junit.Test;

import java.util.regex.Matcher;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class
        ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void TestContent() {
        String s = "KK";
        assertEquals("s content should be equals 'KK'", s, "KK");
    }
}