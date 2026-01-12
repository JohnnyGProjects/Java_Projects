package com.course.contents.coursecontents.ds.dictionary;


import com.course.contents.coursecontents.ds.utils.Node;
import com.course.contents.coursecontents.ds.utils.Pair;

import java.util.Iterator;

/**
 *
 * @param <Key>
 * @param <Value>
 */
public class Dictionary<Key, Value> {
    private Node<Pair<Key, Value>> head;

    public Dictionary() {
        this.head = null;
    }

    public void add(Key key, Value value) {
        if (this.head == null) {
            this.head = new Node<>(new Pair<>(key, value));
        } else {
            Node<Pair<Key, Value>> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(new Pair<>(key, value));
        }
    }

    public Value get(Key key) {
        Node<Pair<Key, Value>> current = this.head;
        while (current != null) {
            if (current.data.key.equals(key)) {
                return current.data.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(Key key) {
        if (this.head == null) {
            return;
        }
        if (this.head.data.key.equals(key)) {
            this.head = this.head.next;
            return;
        }
        Node<Pair<Key, Value>> current = this.head;
        while (current.next != null) {
            if (current.next.data.key.equals(key)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean contains(Key key) {
        Node<Pair<Key, Value>> current = this.head;
        while (current != null) {
            if (current.data.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        Node<Pair<Key, Value>> current = this.head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public void clear() {
        this.head = null;
    }

    public void print() {
        Node<Pair<Key, Value>> current = this.head;
        while (current != null) {
            System.out.println(current.data.key + " -> " + current.data.value);
            current = current.next;
        }
    }

    public Iterator<Key> keys() {
        return new Iterator<Key>() {
            private Node<Pair<Key, Value>> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Key next() {
                Key key = current.data.key;
                current = current.next;
                return key;
            }
        };
    }
}
