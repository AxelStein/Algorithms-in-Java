package com.axel_stein.stack;

/**
 * Stack interface
 * @author Axel Stein
 */
public interface Stack<T> {
    void push(T item);
    T pop();
    boolean isEmpty();
    boolean isNotEmpty();
    int size();
}
