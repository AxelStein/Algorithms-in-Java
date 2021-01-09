package com.axel_stein.queue;

/**
 * Linked-list implementation of queue
 * Every operation takes constant time in the worst case
 * Uses extra space to deal with the links
 * @author Axel Stein
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node(item);
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty");
        T data = first.data;
        first = first.next;
        size--;
        if (isEmpty()) last = null;
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

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }
}
