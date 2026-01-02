package custom_arraylist.test;

import custom_arraylist.MyArrayList;

/**
 * MyArrayList 기능 테스트 해보기
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 2.
 */
public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> myList = new MyArrayList<>();

        for (int i = 1; i <= 15; i++) {
            myList.add(i);
            System.out.printf(
                    "add(%d) -> size=%d, capacity=%d data=%s%n,",
                    i,
                    myList.size(),
                    myList.capacity(),
                    myList
            );
        }
    }
}
