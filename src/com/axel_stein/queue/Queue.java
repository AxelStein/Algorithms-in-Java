package com.axel_stein.queue;

public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    boolean isNotEmpty();
    public int size();
}
