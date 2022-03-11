package com.liuxiaocs;

import com.liuxiaocs.list.DoubleLinkedList;
import com.liuxiaocs.list.List;

public class Queue<E> {

    private List<E> list = new DoubleLinkedList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}
