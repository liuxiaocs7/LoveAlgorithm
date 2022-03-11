package com.liuxiaocs.circle;

/**
 * 循环双端队列
 *
 * @param <E>
 */
public class CircleDeque<E> {
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

    public CircleDeque() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 从尾部入队
     *
     * @param element
     */
    public void enQueueRear(E element) {
        ensureCapacity(size + 1);
        elements[index(size)] = element;
        size++;
    }

    /**
     * 从头部出队
     *
     * @return
     */
    public E deQueueFront() {
        E frontElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return frontElement;
    }

    /**
     * 头部入队
     *
     * @param element
     */
    public void enQueueFront(E element) {
        ensureCapacity(size + 1);
        // 更新头节点下标
        front = index(-1);
        // 往队列-1位置添加新元素
        elements[front] = element;
        size++;
    }

    /**
     * 尾部出队
     *
     * @return
     */
    public E deQueueRear() {
        int rearIndex = index(size - 1);
        E rear = elements[rearIndex];
        elements[rearIndex] = null;
        size--;
        return rear;
    }

    public E front() {
        return elements[front];
    }

    public E rear() {
        return elements[index(size - 1)];
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
        return (index + front + elements.length) % elements.length;
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
