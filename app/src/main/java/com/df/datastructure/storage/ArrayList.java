package com.df.datastructure.storage;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.VisibleForTesting;

import java.util.Arrays;

/**
 * Created by dongfang on 2016/3/16.
 */
public class ArrayList {
    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The elements of the Stack.
     */
    protected int[] elementData;
    /**
     * Shared empty array instance used for empty instances.
     */
    private static final int[] EMPTY_ELEMENTDATA = {};

    /**
     * The size of the ArrayList (the number of elements it contains).
     *
     * @serial
     */
    private int size;


    public ArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }


    /**
     * Increases the capacity of this <tt>ArrayList</tt> instance, if
     * necessary, to ensure that it can hold at least the number of elements
     * specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void ensureCapacity(int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }


    /**
     * Inserts the specified element at the specified position in this
     * list. Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param item  element to be inserted
     * @return <tt>true</tt>
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public boolean add(int index, int item) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = item;
        size++;
        return true;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param item element to be appended to this list
     * @return <tt>true</tt>
     */
    public boolean add(int item) {
        ensureCapacity(size + 1);
        elementData[size++] = item;
        return true;
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list.  The behavior of this operation is
     * undefined if the specified collection is modified while the operation
     * is in progress.  (This implies that the behavior of this call is
     * undefined if the specified collection is this list, and this
     * list is nonempty.)
     *
     * @param collection collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(@NonNull @Size(min = 1) int[] collection) {
        int len = collection.length;
        ensureCapacity(size + len);
        System.arraycopy(collection, 0, elementData, size, len);
        size += len;
        return true;
    }


    /**
     * Inserts all of the elements in the specified collection into this
     * list, starting at the specified position.  Shifts the element
     * currently at that position (if any) and any subsequent elements to
     * the right (increases their indices).  The new elements will appear
     * in the list in the order that they are returned by the
     * specified collection's iterator.
     *
     * @param index      index at which to insert the first element from the
     *                   specified collection
     * @param collection collection containing elements to be added to this list
     * @return <tt>true</tt> if this list changed as a result of the call
     * @throws IndexOutOfBoundsException {@inheritDoc}
     * @throws NullPointerException      if the specified collection is null
     */
    public boolean addAll(int index, @NonNull @Size(min = 1) int[] collection) {
        rangeCheckForAdd(index);
        int len = collection.length;
        ensureCapacity(size + len);
        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + len, numMoved);
        System.arraycopy(collection, 0, elementData, index, len);
        size += len;
        return true;
    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear() {
        // clear to let GC do its work
        elementData = null;
        elementData = EMPTY_ELEMENTDATA;
        size = 0;
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element.
     *
     * @param item element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    public boolean contains(int item) {
        return indexOf(item) > -1;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public int get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>item==get(i)</tt>, or -1 if there is no such index.
     *
     * @param item
     * @return -1 or i
     */
    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (item == elementData[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index <tt>i</tt> such that
     * <tt>item==get(i)</tt>, or -1 if there is no such index.
     *
     * @param item
     * @return -1 or i
     */
    public int lastIndexOf(int item) {
        for (int i = size - 1; i >= 0; i--) {
            if (item == elementData[i])
                return i;
        }
        return -1;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public int remove(@IntRange(from = 0, to = MAX_ARRAY_SIZE - 1) int index) {
        rangeCheck(index);

        int value = elementData[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);

        size--;
        return value;
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     *
     * @param collection collection containing elements to be removed from this list
     * @return {@code true} if this list changed as a result of the call
     */
    public boolean removeAll(@NonNull @Size(min = 1) int[] collection) {
        return batchRemove(collection, false);
    }

    /**
     * Retains only the elements in this list that are contained in the
     * specified collection.  In other words, removes from this list all
     * of its elements that are not contained in the specified collection.
     *
     * @param collection collection containing elements to be retained in this list
     * @return {@code true} if this list changed as a result of the call
     */
    public boolean retainAll(@NonNull @Size(min = 1) int[] collection) {
        return batchRemove(collection, true);
    }

    private boolean batchRemove(int[] c, boolean complement) {
        final int[] elementDataNew = this.elementData;
        int w = 0;
        for (int i = 0; i < size; i++) {
            if (contains(c, elementDataNew[i]) == complement) {
                elementDataNew[w++] = elementDataNew[i];
            }
        }
        size = w;
        return true;
    }

    /**
     * @param array
     * @param item
     * @return {@code true} if this {@code array} contains item.
     */
    private boolean contains(int[] array, int item) {
        for (int i = 0, l = array.length; i < l; i++) {
            if (item == array[i])
                return true;
        }
        return false;
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index index of the element to replace
     * @param item  element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public int set(int index, int item) {
        rangeCheck(index);
        elementData[index] = item;
        return item;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     * <p>
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     * <p>
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list in
     * proper sequence
     */
    @NonNull
    public int[] toArray() {
        return Arrays.copyOf(elementData, size);
    }


    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = 1024;

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
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
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

    /**
     * Constructs an IndexOutOfBoundsException detail message.
     * Of the many possible refactorings of the error handling code,
     * this "outlining" performs best with both server and client VMs.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * Checks if the given index is in range.  If not, throws an appropriate
     * runtime exception.  This method does *not* check if the index is
     * negative: It is always used immediately prior to an array access,
     * which throws an ArrayIndexOutOfBoundsException if index is negative.
     */
    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * A version of rangeCheck used by add and addAll.
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }


}
