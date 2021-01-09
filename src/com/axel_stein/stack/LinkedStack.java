package com.axel_stein.stack;

/**
 * Linked-list implementation of Stack
 * A stack with N items uses ~40N bytes
 * Every operation takes constant time in the worst case
 * @author Axel Stein
 */
public class LinkedStack<T> {
    private Node<T> first;
    private int size;

    public void push(T t) {
        Node<T> node = new Node<>(t);
        node.next = first;
        first = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Can't pop empty stack");
        T data = first.data;
        first = first.next;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isNotEmpty() {
        return size > 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
