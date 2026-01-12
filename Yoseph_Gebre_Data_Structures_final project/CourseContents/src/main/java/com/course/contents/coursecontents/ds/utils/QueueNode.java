package com.course.contents.coursecontents.ds.utils;

public class QueueNode<T extends Comparable<T>> {
    public T data;
    public QueueNode<T> next;

    public QueueNode(T data) {
        this.data = data;
        this.next = null;
    }
}
