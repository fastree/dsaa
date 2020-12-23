package com.fastree.dsaa.sort;

import java.time.Instant;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = SortUtils.generateArray(100000, 10000000);
//        System.out.println("排序前的数组");
//        System.out.println(Arrays.toString(array));

        Instant start = Instant.now();
        bubbleSort(array);
        Instant end = Instant.now();

        long consumingStat = SortUtils.timeConsumingStat(start, end);
        System.out.println("耗时：" + consumingStat + "毫秒");

//        System.out.println("排序后的数组");
//        System.out.println(Arrays.toString(array));

    }


    public static void bubbleSort(int[] array) {
        boolean flag = false;
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
//            System.out.println("第"+(i + 1)+"趟排序后的数组");
//            System.out.println(Arrays.toString(array));
        }
    }

}
