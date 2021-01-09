package com.axel_stein.queue;

/**
 * Array implementation of queue
 * Every operation takes amortized time
 * @author Axel Stein
 */
public class ArrayQueue<T> implements Queue<T> {
    public T[] arr = (T[]) new Object[1];
    private int head;
    private int tail;
    private int size;

    @Override
    public void enqueue(T item) {
        if (tail >= arr.length) resize(2 * arr.length);
        arr[tail++] = item;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T data = arr[head++];
        arr[head-1] = null;
        size--;
        if (head == tail) { head = 0; tail = 0; }
        if (size > 0 && size == arr.length / 4) resize(arr.length / 2);
        return data;
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

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = head, j = 0; i < tail; i++, j++) {
            copy[j] = arr[i];
        }
        head = 0;
        tail = size;
        arr = copy;
    }
}
