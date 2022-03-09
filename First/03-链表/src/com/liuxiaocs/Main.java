package com.liuxiaocs;

public class Main {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    /**
     * 测试单链表
     */
    private static void test1() {
        List<Integer> list = new LinkedList<>();
        // list.remove(0);
        list.add(20);
        list.add(0, 10);
        list.add(30);
        list.add(list.size(), 40);
        list.remove(1);
        System.out.println(list);
    }

    /**
     * 测试带头节点单链表
     */
    private static void test2() {
        List<Integer> list = new LinkedListWithDummy<>();
        list.add(20);
        list.add(0, 10);
        list.add(30);
        list.add(list.size(), 40);
        list.remove(1);
        System.out.println(list);
    }

    /**
     * 测试动态数组缩容
     */
    private static void test3() {
        List<Integer> list = new ArrayListReduce<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        for (int i = 0; i < 50; i++) {
            list.remove(0);
        }

        System.out.println(list);
    }
}
