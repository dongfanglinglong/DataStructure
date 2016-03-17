package com.df.datastructure.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dongfang on 2016/3/15.
 */
public class StackTest {

    Stack stack;

    @Before
    public void setUp() throws Exception {
        stack = null;
        stack = new Stack();
    }

    @Test
    public void testEmpty() throws Exception {
        Assert.assertTrue(stack.isEmpty());
        stack.push(10);
        Assert.assertFalse(stack.isEmpty());
    }

    @Test
    public void testPeek() throws Exception {
        stack.push(11);
        Assert.assertEquals(11, stack.peek());
    }

    @Test
    public void testPop() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);

        Assert.assertEquals(12, stack.pop());
        Assert.assertEquals(11, stack.pop());

    }

    @Test
    public void testPush() throws Exception {
        for (int i = 0; i < 1024; i++) {
            stack.push(i);
            switch (i + 1) {
            case 10:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 11:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 16:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 23:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 34:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 50:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 74:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 110:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 163:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 164:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 245:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 367:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 550:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 823:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            case 1000:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + stack.getCapacityLength());
                break;
            }
        }
    }

    @Test
    public void testSearch() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);

        Assert.assertEquals(1, stack.search(12));
        Assert.assertEquals(2, stack.search(11));
        Assert.assertEquals(12, stack.search(1));
    }
}