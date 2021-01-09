package com.axel_stein.deque;

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    boolean isEmpty();
    boolean isNotEmpty();
    int size();
}
