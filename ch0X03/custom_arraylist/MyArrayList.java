package custom_arraylist;

/**
 * ArrayList 커스텀 하기
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 2.
 */
public class MyArrayList<E> implements MyList<E>{

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    public int capacity() {
        return elementData.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyArrayList{ ");
        sb.append("size=").append(size);
        sb.append(", capacity=").append(elementData.length);
        sb.append(", elements=[");

        for (int i = 0; i < elementData.length; i++) {
            if (i < size) sb.append(elementData[i]);
            else sb.append("_");

            if (i < elementData.length - 1) sb.append(", ");
        }

        sb.append("] }");
        return sb.toString();
    }

    /**
     * 내부 배열의 용량(capacity)이
     * 최소 요구 용량(minCapacity)을 만족하는지 확인한다.
     *
     * - 현재 배열 길이(elementData.length)가
     *   minCapacity보다 작다면, 더 큰 배열로 확장해야 한다.
     * - 확장이 필요 없는 경우에는 아무 작업도 하지 않는다.
     *
     * 이 메서드는 "확장이 필요한지 판단"만 담당하고,
     * 실제 확장 로직은 grow()에 위임한다.
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > elementData.length) {
            grow(minCapacity);
        }
    }

    /**
     * 내부 배열의 크기를 증가시킨다.
     *
     * 1. 기존 배열 용량(oldCapacity)을 기준으로
     *    새 배열 용량(newCapacity)을 계산한다.
     *    - 기본 전략: 기존 용량의 1.5배
     *      (oldCapacity + oldCapacity / 2)
     *
     * 2. 계산된 newCapacity가
     *    실제로 필요한 최소 용량(minCapacity)보다 작으면,
     *    newCapacity를 minCapacity로 보정한다.
     *
     * 3. 새로운 배열을 생성하고,
     *    기존 배열의 요소들을 모두 복사한 뒤
     *    내부 배열 참조(elementData)를 교체한다.
     *
     * 이 방식 덕분에 add()는 대부분 O(1)처럼 동작하고,
     * 가끔 발생하는 배열 복사 비용은 amortized O(1)로 흡수된다.
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }

        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elementData, 0, newArray, 0, size);
        elementData = newArray;
    }
}
