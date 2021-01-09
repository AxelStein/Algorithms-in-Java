package com.axel_stein.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<T> implements Deque<T>, Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    @Override
    public void addFirst(T item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldFirst = first;
        Node node = new Node(item);
        node.next = oldFirst;
        first = node;
        if (isEmpty()) last = first;
        else oldFirst.prev = first;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (item == null) throw new IllegalArgumentException();
        Node oldLast = last;
        last = new Node(item);
        last.prev = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();
        Node oldFirst = first;
        T data = oldFirst.data;
        first = oldFirst.next;
        oldFirst.clearLinks();
        size--;
        if (isEmpty()) last = null;
        else first.prev = null;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException();
        Node oldLast = last;
        T data = oldLast.data;
        last = oldLast.prev;
        oldLast.clearLinks();
        size--;
        if (isEmpty()) first = null;
        else last.next = null;
        return data;
    }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public boolean isNotEmpty() { return size > 0; }

    @Override
    public int size() { return size; }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) throw new NoSuchElementException();
                T data = current.data;
                current = current.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private class Node {
        T data;
        Node prev;
        Node next;

        Node(T data) {
            this.data = data;
        }

        void clearLinks() {
            prev = null;
            next = null;
        }
    }
}
