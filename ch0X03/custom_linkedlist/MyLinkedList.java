package custom_linkedlist;

import custom_arraylist.MyList;

import java.util.LinkedList;

/**
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 8.
 */
public class MyLinkedList<E> implements MyList<E> {

    private MyNode<E> first;
    private MyNode<E> last;
    private int size;

    private static class MyNode<E> {
    E item;
    MyNode<E> next;
    MyNode<E> prev;

    MyNode(MyNode<E> prev, E element, MyNode<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
        }
    }

    @Override
    public void add(E e) {
        linkLast(e);
    }

    @Override
    public void add(int index, E element) {
        checkPositionIndex(index);

        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    @Override
    public void addFirst(E element) {

    }

    @Override
    public void addLast(E element) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isContains(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    private void linkLast(E e) {
        final MyNode<E> l = last;
        final MyNode<E> newNode = new MyNode<>(l, e, null);
        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    private void linkBefore(E e, MyNode<E> succ) {
        final MyNode<E> pred = succ.prev;
        final MyNode<E> newNode = new MyNode<>(pred, e, succ);
        succ.prev = newNode;

        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

    private MyNode<E> node(int index) {
        if (index < (size >> 1)) {
            MyNode<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            MyNode<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        MyNode<E> current = first;
        while (current != null) {
            sb.append(current.item);
            current = current.next;
            if (current != null) sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }
}
