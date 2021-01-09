package com.axel_stein.stack;

/**
 * Array implementation of Stack
 * Every operation takes amortized time
 * Uses less wasted space than LinkedStack
 * @author Axel Stein
 */
public class ArrayStack<T> implements Stack<T> {
    public T[] arr;
    private int pointer;
    private int size;

    public ArrayStack() {
        arr = (T[]) new Object[1];
    }

    /**
     * Worst case O(N)
     * Best case O(1)
     * Amortized O(1)
     */
    @Override
    public void push(T item) {
        if (pointer >= arr.length) resize(2 * arr.length);
        arr[pointer++] = item;
        size++;
    }

    /**
     * Worst case O(N)
     * Best case O(1)
     * Amortized O(1)
     */
    @Override
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Can't pop empty stack");
        T item = arr[--pointer];
        arr[pointer] = null;
        size--;
        if (pointer > 0 && pointer == arr.length / 4) resize(arr.length / 2);
        return item;
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        int length = arr.length;
        if (capacity < arr.length) {
            length = capacity;
        }
        System.arraycopy(arr, 0, copy, 0, length);
        arr = copy;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isNotEmpty() {
        return size > 0;
    }

    @Override
    public int size() {
        return size;
    }
}
