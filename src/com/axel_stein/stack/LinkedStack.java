package com.axel_stein.stack;

import java.util.Iterator;

/**
 * Linked-list implementation of Stack
 * A stack with N items uses ~40N bytes
 * Every operation takes constant time in the worst case
 * Uses extra space to deal with the links
 * @author Axel Stein
 */
public class LinkedStack<T> implements Stack<T>, Iterable<T> {
    private Node first;
    private int size;

    @Override
    public void push(T t) {
        Node node = new Node(t);
        node.next = first;
        first = node;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new IllegalStateException("Can't pop empty stack");
        T data = first.data;
        first = first.next;
        size--;
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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return isNotEmpty();
            }

            @Override
            public T next() {
                return pop();
            }
        };
    }

    private class Node {
        private final T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }
}
