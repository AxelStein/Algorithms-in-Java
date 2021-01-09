package com.axel_stein.stack;

public interface Stack<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
    boolean isNotEmpty();
    int size();
}
