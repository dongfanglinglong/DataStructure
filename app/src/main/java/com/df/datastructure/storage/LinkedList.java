package com.df.datastructure.storage;

import java.util.*;

/**
 * A doubly-linked list.
 * <p>
 * Created by dongfang on 16/3/18.
 */
public class LinkedList {

    private static final class Link {
        int data;
        Link previous, next;

        public Link(int d, Link p, Link n) {
            this.data = d;
            previous = p;
            next = n;
        }
    }


    transient int size = 0;

    transient Link voidLink;


    public LinkedList() {
        voidLink = new Link(0, null, null);
        voidLink.previous = voidLink;
        voidLink.next = voidLink;
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
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Removes all elements from this {@code LinkedList}, leaving it empty.
     *
     * @see #isEmpty()
     * @see #size()
     */
    public void clear() {
        if (size > 0) {
            voidLink.previous = voidLink;
            voidLink.next = voidLink;
            size = 0;
        }
    }

    /**
     * Adds the specified data at the beginning of this {@code LinkedList}.
     *
     * @param data the data to add.
     */
    public void addFirst(int data) {
        addFirstImpl(data);
    }

    private boolean addFirstImpl(int data) {
        Link oldFirst = voidLink.next;
        Link newLink = new Link(data, voidLink, oldFirst);
        voidLink.next = newLink;
        oldFirst.previous = newLink;
        size++;
        return true;
    }

    /**
     * Adds the specified data at the end of this {@code LinkedList}.
     *
     * @param data the data to add.
     * @return always true
     */
    public boolean add(int data) {
        return addLastImpl(data);
    }

    private boolean addLastImpl(int data) {
        Link oldLast = voidLink.previous;
        Link newLink = new Link(data, oldLast, voidLink);
        voidLink.previous = newLink;
        oldLast.next = newLink;
        size++;
        return true;
    }

    /**
     * Inserts the specified data into this {@code LinkedList} at the
     * specified location. The data is inserted before any previous element at
     * the specified location. If the location is equal to the size of this
     * {@code LinkedList}, the data is added at the end.
     *
     * @param location the index( [0,{@link size]) ) at which to insert.
     * @param data     the object to add.
     * @throws IndexOutOfBoundsException if {@code location < 0 || location > size}
     */
    public void add(int location, int data) {
        if (location < 0 || location > size) {
            throw new IndexOutOfBoundsException();
        }

        Link link = voidLink;
        if (location > (size >> 1)) {
            //inverted order
            for (int i = size; i > location; i--) {
                link = link.previous;
            }
        } else {
            for (int i = 0; i <= location; i++) {
                link = link.next;
            }
        }
        Link previous = link.previous;
        Link newLink = new Link(data, previous, link);
        previous.next = newLink;
        link.previous = newLink;
        size++;
    }

    /**
     * Inserts the datas in the specified collection at the specified location
     * in this {@code LinkedList}.
     *
     * @param location the index( [0,{@link size]) ) at which to insert.
     * @param aData    the array of data
     * @return {@code true} if this {@code LinkedList} is modified,
     * {@code false} otherwise.
     * @throws IndexOutOfBoundsException if {@code location < 0 || location > size()}
     */
    public boolean addAll(int location, int[] aData) {
        if (location < 0 || location > size) {
            throw new IndexOutOfBoundsException();
        }
        int adding = aData.length;
        if (adding == 0) {
            return false;
        }

        Link link = voidLink;
        if (location > (size >> 1)) {
            //inverted order
            for (int i = size; i > location; i--) {
                link = link.previous;
            }
        } else {
            for (int i = 0; i <= location; i++) {
                link = link.next;
            }
        }

        Link next = link.next;
        for (int i = 0; i < adding; i++) {
            Link newLink = new Link(aData[i], link, null);
            link.next = newLink;
            link = newLink;
        }
        link.next = next;
        next.previous = link;
        size += adding;


        return true;
    }


    /**
     * Adds the data of array to this {@code LinkedList}.
     *
     * @param aData the array of data
     * @return {@code true} if this {@code LinkedList} is modified,
     * {@code false} otherwise.
     */
    public boolean addAll(int[] aData) {
        int adding = aData.length;
        if (adding == 0) {
            return false;
        }
        Link lastLink = voidLink.previous;

        for (int i = 0; i < adding; i++) {
            Link newLink = new Link(aData[i], lastLink, null);
            lastLink.next = newLink;
            lastLink = newLink;
        }
        lastLink.next = voidLink;
        voidLink.previous = lastLink;

        size += adding;
        return true;
    }


    /**
     * Searches this {@code LinkedList} for the specified data.
     *
     * @param data the data to search for.
     * @return {@code true} if {@code data} is an element of this
     * {@code LinkedList}, {@code false} otherwise
     */
    public boolean contains(int data) {
        if (voidLink.previous.equals(voidLink)) {
            return false;
        }
        Link link = voidLink.next;
        while (link != voidLink) {
            if (link.data == data) {
                return true;
            }
            link = link.next;
        }
        return false;
    }


    /**
     * Returns the first element in this {@code LinkedList}.
     *
     * @return the first element.
     * @throws NoSuchElementException if this {@code LinkedList} is empty.
     */
    public int getFirst() {
        Link link = voidLink.next;
        if (link != voidLink) {
            return link.data;
        }
        throw new NoSuchElementException();
    }


    /**
     * Returns the last element in this {@code LinkedList}.
     *
     * @return the last element
     * @throws NoSuchElementException if this {@code LinkedList} is empty
     */
    public int getLast() {
        Link last = voidLink.previous;
        if (last != voidLink) {
            return last.data;
        }
        throw new NoSuchElementException();
    }

    /**
     * Returns the element at the specified location in this list.
     *
     * @param location the index( [0,{@link size}) ) at which to insert.
     * @return the element at the specified index.
     * @throws IndexOutOfBoundsException if {@code location < 0 || location >= size()}
     */
    public int get(int location) {
        if (location < 0 || location >= size) {
            throw new IndexOutOfBoundsException();
        }

        Link link = voidLink;
        if (location > (size >> 1)) {
            for (int i = size; i > location; i--) {
                link = link.previous;
            }
        } else {
            for (int i = 0; i <= location; i++) {
                link = link.next;
            }
        }
        return link.data;
    }

    /**
     * Removes the data at the specified location from this {@code LinkedList}.
     *
     * @param location the index( [0,{@link size}) ) at which to insert.
     * @return the removed data
     * @throws IndexOutOfBoundsException if {@code location < 0 || location >= size()}
     */
    public int remove(int location) {
        if (location < 0 || location >= size) {
            throw new IndexOutOfBoundsException();
        }

        Link link = voidLink;
        if (location > (size >> 1)) {
            for (int i = size; i > location; i--) {
                link = link.previous;
            }
        } else {
            for (int i = 0; i <= location; i++) {
                link = link.next;
            }
        }

        link.previous.next = link.next;
        link.next.previous = link.previous;
        return link.data;
    }

    /**
     * Replaces the element at the specified location in this {@code LinkedList}
     * with the specified object.
     *
     * @param location the index( [0,{@link size}) ) at which to insert.
     * @return the previous element at the index.
     * @throws IndexOutOfBoundsException if {@code location < 0 || location >= size()}
     */
    public int set(int location, int data) {
        if (location >= 0 && location < size) {
            Link link = voidLink;
            if (location < (size >> 1)) {
                for (int i = 0; i <= location; i++) {
                    link = link.next;
                }
            } else {
                for (int i = size; i > location; i--) {
                    link = link.previous;
                }
            }
            int result = link.data;
            link.data = data;
            return result;
        }
        throw new IndexOutOfBoundsException();
    }

}
