package com.axel_stein.queue;

/**
 * Queue interface
 * @author Axel Stein
 */
public interface Queue<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    boolean isNotEmpty();
    public int size();
}
