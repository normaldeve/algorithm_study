package custom_linkedlist.test;

import custom_linkedlist.MyLinkedList;

import java.util.List;

/**
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 8.
 */
public class MyLinkedListTest {
    public static void main(String[] args) {

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        System.out.println("=== add(E) 테스트 ===");
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList); // [1, 2, 3]

        System.out.println("\n=== add(index, E) 테스트 ===");
        linkedList.add(0, 100);   // 맨 앞
        System.out.println(linkedList); // [100, 1, 2, 3]

        linkedList.add(2, 200);   // 중간
        System.out.println(linkedList); // [100, 1, 200, 2, 3]

        linkedList.add(linkedList.size(), 300); // 맨 뒤
        System.out.println(linkedList); // [100, 1, 200, 2, 3, 300]

        System.out.println("\n=== 연속 삽입 테스트 ===");
        for (int i = 0; i < 5; i++) {
            linkedList.add(i * 10);
        }
        System.out.println(linkedList);

        System.out.println("\n=== 예외 테스트 ===");
        try {
            linkedList.add(-1, 999);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("예외 발생 OK: " + e.getMessage());
        }
    }
}
