package com.liuxiaocs.circle;


/**
 * 循环队列
 *
 * @param <E>
 */
public class CircleQueue<E> {
    /**
     * 队头元素下标
     */
    private int front;

    /**
     * 队列元素数量
     */
    private int size;

    /**
     * 队列元素
     */
    private E[] elements;

    public static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 循环入队
     *
     * @param element E 入队元素
     */
    public void enQueue(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    /**
     * 循环出队
     *
     * @return E[front]
     */
    public E deQueue() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * 获取队头元素
     *
     * @return E[front]
     */
    public E front() {
        return elements[front];
    }

    /**
     * 动态扩容
     *
     * @param capacity int 至少容量
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        // newCapacity = oldCapacity * 1.5 新容量为旧容量的1.5倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        // 重置front
        front = 0;

        System.out.println(oldCapacity + "扩容为: " + newCapacity);
    }

    /**
     * 通过循环队列上的逻辑索引获取真实的下标索引
     *
     * @param index 循环队列上的逻辑索引(0~size-1)
     * @return int 循环队列上的真实索引(+front)
     */
    private int index(int index) {
        return (index + front) % elements.length;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("capacity=").append(elements.length)
                .append(", size=").append(size)
                .append(", front=").append(front)
                .append(", [");

        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
