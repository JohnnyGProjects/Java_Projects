package com.course.contents.coursecontents.ds.queue;


import com.course.contents.coursecontents.ds.utils.QueueNode;

public class PriorityQueue<T extends Comparable<T>> {
    private QueueNode<T> head;
    private QueueNode<T> tail;
    private int size;

    public PriorityQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void enqueue(T data) {
        QueueNode<T> newNode = new QueueNode<>(data);

        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            QueueNode<T> temp = this.head;
            QueueNode<T> prev = null;

            while (temp != null && temp.data.compareTo(newNode.data) < 0) {
                prev = temp;
                temp = temp.next;
            }

            if (prev == null) {
                newNode.next = this.head;
                this.head = newNode;
            } else if (temp == null) {
                this.tail.next = newNode;
                this.tail = newNode;
            } else {
                prev.next = newNode;
                newNode.next = temp;
            }
        }

        this.size++;
    }

    public T dequeue() {
        if (this.head == null) {
            return null;
        }

        T data = this.head.data;
        this.head = this.head.next;
        this.size--;

        return data;
    }

    public T peek() {
        if (this.head == null) {
            return null;
        }

        return this.head.data;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        QueueNode<T> temp = this.head;

        while (temp != null) {
            System.out.print(temp.data + "\n");
            temp = temp.next;
        }

        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        QueueNode<T> temp = this.head;

        while (temp != null) {
            sb.append(temp.data).append("\n");
            temp = temp.next;
        }

        return sb.toString();
    }
}
