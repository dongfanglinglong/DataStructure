package com.df.datastructure.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dongfang on 2016/3/17.
 */
public class ArrayListTest {

    ArrayList arrayList;

    @Before
    public void setUp() throws Exception {
        arrayList = null;
        arrayList = new ArrayList();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
    }

    @Test
    public void testAdd() throws Exception {
        Assert.assertTrue(1 == arrayList.get(0));
        Assert.assertTrue(2 == arrayList.get(1));
        Assert.assertTrue(3 == arrayList.get(2));
        Assert.assertTrue(4 == arrayList.get(3));
        arrayList.clear();
        for (int i = 0; i < 1024; i++) {
            arrayList.add(i);
            switch (i + 1) {
            case 10:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 11:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 16:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 23:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 34:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 50:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 74:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 110:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 163:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 164:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 245:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 367:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 550:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 823:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            case 824:
                System.out.println("i[" + (i + 1) + "]:capacity length = " + arrayList.getCapacityLength());
                break;
            }
        }
    }

    @Test
    public void testAdd1() throws Exception {
        arrayList.add(0, 11);
        arrayList.add(0, 12);
        arrayList.add(0, 13);
        arrayList.add(0, 14);

        Assert.assertTrue(11 == arrayList.get(3));
        Assert.assertTrue(12 == arrayList.get(2));
        Assert.assertTrue(13 == arrayList.get(1));
        Assert.assertTrue(14 == arrayList.get(0));
    }

    @Test
    public void testAddAll() throws Exception {
        arrayList.addAll(new int[]{1, 2, 3});
        Assert.assertTrue(1 == arrayList.get(0));
        Assert.assertTrue(2 == arrayList.get(1));
        Assert.assertTrue(3 == arrayList.get(2));
    }

    @Test
    public void testAddAll1() throws Exception {
        arrayList.addAll(1, new int[]{1, 2, 3});
        Assert.assertTrue(1 == arrayList.get(1));
        Assert.assertTrue(2 == arrayList.get(2));
        Assert.assertTrue(3 == arrayList.get(3));
    }

    @Test
    public void testClear() throws Exception {
        arrayList.addAll(1, new int[]{1, 2, 3});
        arrayList.clear();
        Assert.assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertTrue(arrayList.contains(3));
    }

    @Test
    public void testGet() throws Exception {
        Assert.assertTrue(4 == arrayList.get(3));
    }

    @Test
    public void testIndexOf() throws Exception {
        arrayList.add(411);
        arrayList.add(411);
        arrayList.add(411);
        arrayList.add(411);
        Assert.assertTrue(4 == arrayList.indexOf(411));
    }

    @Test
    public void testLastIndexOf() throws Exception {
        arrayList.add(411);
        arrayList.add(411);
        arrayList.add(411);
        arrayList.add(411);
        Assert.assertTrue(arrayList.size() - 1 == arrayList.lastIndexOf(411));
    }

    @Test
    public void testRemove() throws Exception {
        arrayList.remove(2);
        Assert.assertArrayEquals(new int[]{1, 2, 4}, arrayList.toArray());
    }

    @Test
    public void testRemoveAll() throws Exception {
        arrayList.removeAll(new int[]{1, 4});

        Assert.assertArrayEquals(new int[]{2, 3}, arrayList.toArray());
    }

    @Test
    public void testRetainAll() throws Exception {
        arrayList.retainAll(new int[]{1, 4});
        Assert.assertArrayEquals(new int[]{1, 4}, arrayList.toArray());
    }

    @Test
    public void testSet() throws Exception {
        arrayList.set(1, 10);
        Assert.assertTrue(10 == arrayList.get(1));
    }

    @Test
    public void testSize() throws Exception {
        Assert.assertTrue(4 == arrayList.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        arrayList.add(111);
        arrayList.clear();
        Assert.assertTrue(arrayList.isEmpty());

    }

    @Test
    public void testToArray() throws Exception {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, arrayList.toArray());
    }
}