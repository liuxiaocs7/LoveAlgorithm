package com.liuxiaocs;

/**
 * 增强双向循环链表
 *
 * @param <E>
 */
public class DoubleCircleAdvancedLinkedList<E> extends AbstractList<E> {

    /**
     * 链表头节点
     */
    private Node<E> first;

    /**
     * 链表尾节点
     */
    private Node<E> last;

    /**
     * 用于指向某个节点
     */
    private Node<E> current;

    /**
     * 内部节点
     *
     * @param <E>
     */
    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (prev != null) {
                sb.append(prev.element).append("<--");
            } else {
                sb.append("null").append("<--");
            }
            sb.append(element);
            if (next != null) {
                sb.append("-->").append(next.element);
            } else {
                sb.append("-->").append("null");
            }
            return sb.toString();
        }
    }

    /**
     * current重新指向头节点
     */
    public void reset() {
        current = first;
    }

    public E next() {
        if(current == null) return null;
        current = current.next;
        return current.element;
    }

    public E remove() {
        if(current == null) return null;

        // 获取current节点下一个节点
        Node<E> next = current.next;
        // 移除current节点
        E element = remove(current);
        if(size == 0) {
            // 初始只有一个节点，删除之后为空
            current = null;
        } else {
            // current指向下一个位置
            current = next;
        }
        return element;
    }


    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        // size == 0
        // index == 0
        if (index == size) {  // 往最后面添加元素
            Node<E> oldLast = last;
            last = new Node<E>(oldLast, element, first);
            // 最开始的时候有可能为空
            if (oldLast == null) {  // 这是链条添加的第一个元素
                first = last;
                first.next = first;
                first.prev = first;
            } else {
                oldLast.next = last;
                first.prev = last;
            }

            // 另一种写法
            // last = new Node<E>(last, element, null);
            // last.prev.next = last;
        } else {
            // 知道当前这个index节点，也就是新添加节点的下一个
            Node<E> next = node(index);
            // 新添加节点的上一个
            Node<E> prev = next.prev;
            Node<E> node = new Node<E>(prev, element, next);
            next.prev = node;
            prev.next = node;

            if (next == first) {  // index == 0
                first = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);

        return remove(node(index));
    }

    private E remove(Node<E> node) {
        if(size == 1) {
            first = null;
            last = null;
        } else {
            Node<E> prev = node.prev;
            Node<E> next = node.next;

            prev.next = next;
            next.prev = prev;

            if (node == first) {  // index == 0
                first = next;
            }

            if (node == last) {  // index == size - 1
                last = prev;
            }
        }

        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取指定下标位置的节点
     *
     * @param index 指定下标
     * @return Node 对应节点
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node);
            node = node.next;
        }
        string.append("]");
        return string.toString();
    }
}
