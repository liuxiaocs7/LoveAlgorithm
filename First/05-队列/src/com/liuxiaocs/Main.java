package com.liuxiaocs;

public class Main {
    public static void main(String[] args) {
        test1();

        test2();
    }

    /**
     * 测试队列
     */
    private static void test1() {
        Queue<Integer> queue = new Queue<>();
        queue.enQueue(11);
        queue.enQueue(22);
        queue.enQueue(33);
        queue.enQueue(44);

        while(!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }
    }

    private static void test2() {
        Deque<Integer> queue = new Deque<>();
        queue.enQueueFront(11);
        queue.enQueueFront(22);
        queue.enQueueRear(33);
        queue.enQueueRear(44);

        while(!queue.isEmpty()) {
            // System.out.println(queue.deQueueFront());
            System.out.println(queue.deQueueRear());
        }
    }
}
