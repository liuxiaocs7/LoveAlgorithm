package com.liuxiaocs;

import com.liuxiaocs.circle.CircleDeque;
import com.liuxiaocs.circle.CircleQueue;

public class Main {
    public static void main(String[] args) {
        test1();

        test2();

        System.out.println("\n==================");
        test3();

        System.out.println("\n==================");
        test4();
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

        while (!queue.isEmpty()) {
            System.out.print(queue.deQueue() + " ");
        }
    }

    /**
     * 测试双端队列
     */
    private static void test2() {
        Deque<Integer> queue = new Deque<>();
        queue.enQueueFront(11);
        queue.enQueueFront(22);
        queue.enQueueRear(33);
        queue.enQueueRear(44);

        while (!queue.isEmpty()) {
            // System.out.println(queue.deQueueFront());
            System.out.println(queue.deQueueRear() + " ");
        }
    }

    /**
     * 测试循环队列
     */
    private static void test3() {
        CircleQueue<Integer> queue = new CircleQueue<Integer>();
        // 0 1 2 3 4 5 6 7 8 9
        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }
        // null null null null null 5 6 7 8 9
        for (int i = 0; i < 5; i++) {
            queue.deQueue();
        }
        // 15 16 17 18 19 5 6 7 8 9
        for (int i = 15; i < 23; i++) {
            queue.enQueue(i);
        }
        System.out.println(queue);

        // 注意此时队头在5的位置上
        while (!queue.isEmpty()) {
            System.out.print(queue.deQueue() + " ");
        }
    }

    /**
     * 测试双向循环队列
     */
    private static void test4() {
        CircleDeque<Integer> queue = new CircleDeque<>();
        // 头5 4 3 2 1 100 101 102 103 104 105 106 8 7 6 尾

        // 头 8 7 6 5 4 3 2 1 100 101 102 103 104 105 106 | 107 108 109 null null 10 9 尾
        for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }

        System.out.println("添加完元素：");
        System.out.println(queue);
        System.out.println();

        // 头 null 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null null 尾
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }

        System.out.println("出队之后：");
        System.out.println(queue);
        System.out.println();

        // 头 11 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null 12 尾
        queue.enQueueFront(11);
        queue.enQueueFront(12);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.print(queue.deQueueFront() + " ");
        }
    }
}
