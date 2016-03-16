package com.df.datastructure;

import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(8 >> 1));
        System.out.println(Integer.toBinaryString(8 >>> 1));

        System.out.println(Integer.toBinaryString(-8));
        System.out.println(Integer.toBinaryString(-8 >> 1));
        System.out.println(Integer.toBinaryString(-8 >>> 10));
    }
}