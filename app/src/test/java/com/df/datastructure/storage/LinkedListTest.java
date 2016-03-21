package com.df.datastructure.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dongfang on 16/3/20.
 */
public class LinkedListTest {


    LinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new LinkedList();
        linkedList.add(10);

    }

    @Test
    public void testIsEmpty() throws Exception {
        Assert.assertTrue(!linkedList.isEmpty());
        linkedList.clear();
        Assert.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testSize() throws Exception {
        Assert.assertTrue(1 == linkedList.size());
        linkedList.add(11);
        Assert.assertTrue(2 == linkedList.size());
    }

    @Test
    public void testClear() throws Exception {
        testIsEmpty();
    }

    @Test
    public void testAddFirst() throws Exception {
        linkedList.addFirst(1);
        Assert.assertEquals(1, linkedList.getFirst());
    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testAdd1() throws Exception {
        linkedList.add(1, 11);
        Assert.assertEquals(11, linkedList.get(1));
    }

    @Test
    public void testAddAll() throws Exception {
        linkedList.addAll(new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        Assert.assertEquals(19, linkedList.get(9));
    }

    @Test
    public void testAddAll1() throws Exception {
        linkedList.addAll(new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        linkedList.addAll(3, new int[]{1, 2, 3, 4, 5, 6, 7});
        Assert.assertEquals(19, linkedList.get(16));


    }

    @Test
    public void testContains() throws Exception {
        linkedList.addAll(new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        Assert.assertTrue(linkedList.contains(19));
        linkedList.remove(9);
        Assert.assertTrue(!linkedList.contains(19));
    }

    @Test
    public void testGetFirst() throws Exception {
        linkedList.addFirst(1);
        Assert.assertEquals(1, linkedList.getFirst());
    }

    @Test
    public void testGetLast() throws Exception {
        linkedList.add(11);
        Assert.assertEquals(11, linkedList.getLast());
    }

    @Test
    public void testGet() throws Exception {
        testAdd1();
    }

    @Test
    public void testRemove() throws Exception {
        testContains();
    }

    @Test
    public void testSet() throws Exception {
        linkedList.addAll(new int[]{11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        linkedList.set(9, 99);
        Assert.assertTrue(99 == linkedList.get(9));
    }

    @Test
    public void testToArray() throws Exception {
        Assert.assertArrayEquals(new int[]{10}, linkedList.toArray());
    }
}
