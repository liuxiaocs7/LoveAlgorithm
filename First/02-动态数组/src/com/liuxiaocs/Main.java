package com.liuxiaocs;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{11, 22, 33};

        ArrayList list = new ArrayList();
        list.add(99);
        list.add(88);
        list.add(77);
        list.add(66);
        list.add(55);

        list.remove(0);
        list.remove(list.size() - 1);
        list.remove(2);

        list.add(0, 100);
        list.add(1, 200);

        list.add(list.size(), 100);

        list.set(3, 80);
        // if(list.get(3) != 80) {
        //     throw new IllegalArgumentException("测试不通过");
        // }
        Asserts.test(list.get(3) == 80);
        Asserts.test(list.get(0) == 88);
        Asserts.test(list.size() == 4);
        System.out.println(list);

    }
}
