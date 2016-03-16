package com.df.datastructure.storage;

import android.support.annotation.VisibleForTesting;

import java.util.Arrays;
import java.util.EmptyStackException;


/**
 * The <code>Stack</code> class represents a last-in-first-out (LIFO) stack of objects.
 * The usual <tt>push</tt> and <tt>pop</tt> operations are provided, as well as a
 * method to <tt>peek</tt> at the top item on the stack, a method to test
 * for whether the stack is <tt>empty</tt>, and a method to <tt>search</tt>
 * the stack for an item and discover how far it is from the top.
 * When a stack is first created, it contains no items and the max length is 1024;.
 * <p/>
 * Created by dongfang on 2016/3/15.
 */
public class Stack {
    /**
     * The number of elements or the size of the Stack.
     */
    protected int elementCount = 0;


    /**
     * The elements of the Stack.
     */
    protected int[] elementData;


    private static final int DEFAULT_SIZE = 10;

    public Stack() {
        elementData = new int[DEFAULT_SIZE];
    }

    /**
     * Tests if this stack is empty.
     *
     * @return <code>true</code> if and only if this stack contains
     * no items; <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return 0 == elementCount;
    }

    /**
     * Looks at the object at the top of this stack without removing it
     * from the stack.
     *
     * @return the object at the top of this stack (the last item
     * of the <tt>Vector</tt> object).
     * @throws EmptyStackException if this stack is empty.
     */
    public synchronized int peek() {
        if (elementCount == 0)
            throw new EmptyStackException();

        if (elementCount >= elementData.length) {
            throw new ArrayIndexOutOfBoundsException(elementCount + " >= 1024");
        }
        return elementData[elementCount - 1];
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack.
     * @throws EmptyStackException if this stack is empty.
     */
    public synchronized int pop() {
        int item = peek();
        elementCount--;
        return item;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed onto this stack.
     * @return the <code>item</code> argument.
     * @see java.util.Vector#addElement
     */
    public Integer push(int item) {
        ensureCapacity(elementCount + 1);
        elementData[elementCount++] = item;
        return item;
    }

    /**
     * Returns the 1-based position where an object is on this stack.
     * If the object <tt>o</tt> occurs as an item in this stack, this
     * method returns the distance from the top of the stack of the
     * occurrence nearest the top of the stack; the topmost item on the
     * stack is considered to be at distance <tt>1</tt>. The <tt>equals</tt>
     * method is used to compare <tt>o</tt> to the
     * items in this stack.
     *
     * @param item the desired object.
     * @return the 1-based position from the top of the stack where
     * the object is located; the return value <code>-1</code>
     * indicates that the object is not on the stack.
     */
    public synchronized int search(int item) {
        int position = -1;

        for (int i = elementCount - 1; i > -1; i--) {
            if (elementData[i] == item) {
                position = i;
                break;
            }
        }
        position = position > -1 ? elementCount - position : position;
        return position;
    }


    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = 1024;
    /**
     * It will be add {@code CAPACITY_GROW_SPEED } times stack length elements to the stack when it is detected that
     * it needs to grow to accommodate extra entries.
     */
    private static final float CAPACITY_GROW_SPEED = 1.5f;

    /**
     * Increases the capacity of this stack, if necessary, to ensure
     * that it can hold at least the number of components specified by
     * the minimum capacity argument.
     * <p/>
     * <p>If the current capacity of this stack is less than {@code minCapacity}, then its capacity is increased by
     * replacing its internal data array, kept in the field {@code elementData}, with a larger one.  The size of the new
     * data array will be the old size multiply {@code CAPACITY_GROW_SPEED}; but if this new size is still smaller than
     * {@code minCapacity}, then the new capacity will be {@code minCapacity}.Similarly, if {@code minCapacity} is larger
     * then {@code MAX_ARRAY_SIZE},the new capacity will be {@code MAX_ARRAY_SIZE} and it will throw OutOfMemoryError;
     *
     * @param minCapacity the desired minimum capacity
     * @throws OutOfMemoryError
     */
    private void ensureCapacity(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);

        if (minCapacity > MAX_ARRAY_SIZE)
            throw new OutOfMemoryError();

    }

    /**
     * 空间增长情况
     * 10
     * 15
     * 22
     * 33
     * 49
     * 73
     * 109
     * 163
     * 244
     * 366
     * 549
     * 823
     * 1024(1234)
     *
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int newCapacity = (int) (elementData.length * CAPACITY_GROW_SPEED);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = MAX_ARRAY_SIZE;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }


    @VisibleForTesting
    public int getCapacityLength() {
        return elementData.length;
    }


}
