package sort.bubble;

/**
 * 버블 정렬을 구현합니다.
 *
 * @author junnukim1007gmail.com
 * @date 26. 1. 22.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[5000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        long start = System.nanoTime();
        old_bubble_sort(arr);
        long end = System.nanoTime();

        System.out.println("정렬 시간(ns): " + (end - start) + "");

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void old_bubble_sort(int[] arr) {
        int size = arr.length;
        int count = 0;

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
                count++;
                System.out.println("비교 횟수: " + count);
            }
        }
    }

    public static void new_bubble_sort(int[] arr) {
        int size = arr.length;
        int count = 0;

        for (int i = 1; i < size; i++) {
            boolean isSwapped = false;
            for (int j = 0; j < size - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
                count++;
                System.out.println("비교 횟수: " + count);
            }

            if (!isSwapped) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}