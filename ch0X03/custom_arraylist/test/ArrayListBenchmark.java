package custom_arraylist.test;

import custom_arraylist.MyArrayList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 2.
 */
public class ArrayListBenchmark {

    private static final int COUNT = 5_000_000;

    public static void main(String[] args) {
        // JIT 워밍업
        warmUp();

        // JDK ArrayList
        long jdkTime = testJdkArrayList();

        // MyArrayList
        long myTime = testMyArrayList();

        System.out.println("=================================");
        System.out.printf("JDK ArrayList   : %d ms%n", jdkTime);
        System.out.printf("MyArrayList     : %d ms%n", myTime);
        System.out.printf("Ratio (My/JDK)  : %.2f%n",
                (double) myTime / jdkTime);
    }

    private static void warmUp() {
        for (int i = 0; i < 3; i++) {
            testJdkArrayList();
            testMyArrayList();
        }
    }

    private static long testJdkArrayList() {
        List<Integer> list = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            list.add(i);
        }
        long end = System.nanoTime();

        return (end - start) / 1_000_000;
    }

    private static long testMyArrayList() {
        MyArrayList<Integer> list = new MyArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < COUNT; i++) {
            list.add(i);
        }
        long end = System.nanoTime();

        return (end - start) / 1_000_000;
    }
}
