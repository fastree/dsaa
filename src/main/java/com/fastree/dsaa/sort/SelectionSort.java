package com.fastree.dsaa.sort;

import java.time.Instant;
import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = SortUtils.generateArray(100000, 10000000);
//        System.out.println("排序前的数组");
//        System.out.println(Arrays.toString(array));

        Instant start = Instant.now();
        selectionSort(array);
        Instant end = Instant.now();

        long consumingStat = SortUtils.timeConsumingStat(start, end);
        System.out.println("耗时：" + consumingStat + "毫秒");

//        System.out.println("排序后的数组");
//        System.out.println(Arrays.toString(array));

    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            int minVal = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (minVal > array[j]) {
                    minVal = array[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = minVal;
            }

//            System.out.println("第" + (i + 1) + "趟排序后的数组");
//            System.out.println(Arrays.toString(array));
        }
    }
}
