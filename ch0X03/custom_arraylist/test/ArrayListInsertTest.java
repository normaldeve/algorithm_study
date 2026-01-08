package custom_arraylist.test;

import custom_arraylist.MyArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 데이터를 앞에서 넣을때 뒤에서 넣을 때와 성능 차이
 * @author junnukim1007gmail.com
 * @date 26. 1. 3.
 */
public class ArrayListInsertTest {

    private static final int COUNT = 100000;

    public static void main(String[] args) {

        System.out.println("========== JDK ArrayList ==========");
        testJdkAddFirst();
        testJdkAddLast();

        System.out.println("\n========== MyArrayList ==========");
        testMyAddFirst();
        testMyAddLast();
    }

    // ---------------- JDK ----------------
    private static void testJdkAddFirst() {
        List<Integer> list = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            list.add(0, i);
        }
        long end = System.nanoTime();

        printResult("JDK addFirst(e)", start, end);
    }

    private static void testJdkAddLast() {
        List<Integer> list = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            list.add(i);
        }
        long end = System.nanoTime();

        printResult("JDK addLast(e)", start, end);
    }

    // ---------------- MyArrayList ----------------
    private static void testMyAddFirst() {
        MyArrayList<Integer> list = new MyArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            list.addFirst(i);
        }
        long end = System.nanoTime();

        printResult("My addFirst(e)", start, end);
    }

    private static void testMyAddLast() {
        MyArrayList<Integer> list = new MyArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            list.addLast(i);
        }
        long end = System.nanoTime();

        printResult("My addLast(e)", start, end);
    }

    // ---------------- util ----------------
    private static void printResult(String label, long start, long end) {
        long ms = (end - start) / 1_000_000;
        System.out.printf("%-18s : %6d ms%n", label, ms);
    }
}