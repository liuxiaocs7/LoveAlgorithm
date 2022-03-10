package com.liuxiaocs;

public class Main {
    public static void main(String[] args) {
        // test1();
        // test2();
        // test3();

        test4(new ArrayList<>());
        test4(new LinkedList<>());
        test4(new LinkedListWithDummy<>());
        test4(new DoubleLinkedList<>());
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

    /**
     * 测试双向链表
     */
    private static void test4(List<Integer> list) {
        // List<Integer> list = new DoubleLinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }
}
