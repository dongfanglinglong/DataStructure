package com.df.datastructure;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;


/**
 * Created by chenfu on 2016/3/11.
 */

public class SortTest {
    private int[] array = null;
    private static final int[] arraySorted = {2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50, 51};


    @Before
    public void initArray() {
        array = new int[]{
                3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
//                ,3, 44, 38, 5, 47, 15, 51, 36, 26, 27, 2, 46, 4, 19, 50, 48
        };
    }

    @Test
    public void testDubble() throws Exception {
        //System.out.println(Arrays.toString(array));
        Sort.dubble(array);
        //System.out.println(Arrays.toString(array));
        //org.junit.Assert.assertArrayEquals(arraySorted, array);

    }

    @Test
    public void testDubbleAlpha() throws Exception {
        //System.out.println(Arrays.toString(array));
        Sort.dubbleAlpha(array);
        //System.out.println(Arrays.toString(array));
        //org.junit.Assert.assertArrayEquals(arraySorted, array);

    }


    @Test
    public void testSelect() throws Exception {
        //System.out.println(Arrays.toString(array));
        Sort.select(array);
        //System.out.println(Arrays.toString(array));
        //org.junit.Assert.assertArrayEquals(arraySorted, array);
    }

    @Test
    public void testInsertion() throws Exception {
        //System.out.println(Arrays.toString(array));
        Sort.insertion(array);
        //System.out.println(Arrays.toString(array));
        //org.junit.Assert.assertArrayEquals(arraySorted, array);
    }


    @Test
    public void testShell() throws Exception {
        //System.out.println(Arrays.toString(array));
        Sort.shell(array);
        //System.out.println(Arrays.toString(array));
    }
}