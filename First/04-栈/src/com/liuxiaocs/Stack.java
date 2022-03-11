package com.liuxiaocs;

import com.liuxiaocs.list.ArrayList;
import com.liuxiaocs.list.List;

public class Stack<E> {

    private List<E> list = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        // 往最后添加
        list.add(element);
    }

    public E pop() {
        // 移除最后的元素
        return list.remove(list.size() - 1);
    }

    public E top() {
        return list.get(list.size() - 1);
    }
}
