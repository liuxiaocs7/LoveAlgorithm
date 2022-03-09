package com.liuxiaocs;

/**
 * 抽象线性表
 */
public abstract class AbstractList<E> implements List<E> {

    /**
     * 元素数量
     */
    protected int size;

    /**
     * 元素的数量
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element 查询元素
     * @return boolean
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     */
    public void add(E element) {
        add(size, element);
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }
}
