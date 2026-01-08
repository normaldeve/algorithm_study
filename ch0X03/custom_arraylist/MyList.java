package custom_arraylist;

/**
 * List 커스텀
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 2.
 */
public interface MyList<E> {
    void add(E e);

    void add(int index, E element);

    void addFirst(E element);

    void addLast(E element);

    int size();
}
