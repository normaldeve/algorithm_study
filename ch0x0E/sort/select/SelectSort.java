package sort.select;

/**
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 22.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[5000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        long start = System.nanoTime();
        select_sort(arr);
        long end = System.nanoTime();

        System.out.println("정렬 시간(ns): " + (end - start) + "");

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void select_sort(int[] arr) {
        int size = arr.length;
        int count = 0;

        for (int i = 0; i < size - 1; i++) {
            int min_index = i;

            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
                count++;
                System.out.println("시행 횟수: " + count);
            }

            swap(arr, i, min_index);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
