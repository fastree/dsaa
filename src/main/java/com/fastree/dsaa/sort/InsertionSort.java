package com.fastree.dsaa.sort;

import java.time.Instant;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = SortUtils.generateArray(100000, 10000000);
//        System.out.println("排序前的数组");
//        System.out.println(Arrays.toString(array));

        Instant start = Instant.now();
        insertionSort(array);
        Instant end = Instant.now();

        long consumingStat = SortUtils.timeConsumingStat(start, end);
        System.out.println("耗时：" + consumingStat + "毫秒");

//        System.out.println("排序后的数组");
//        System.out.println(Arrays.toString(array));
    }


    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            // 默认从第2个元素开始找位置
            int insertVal = array[i];
            // 默认插入位置为上一个位置
            int insertIndex = i - 1;

            // 当插入位置不越界且待插入值为逆序时
            while (insertIndex >= 0 && array[insertIndex] > insertVal) {
                // 当前遍历的索引位置的值后移
                array[insertIndex + 1] = array[insertIndex];
                // 索引继续向前移动直到为-1
                insertIndex--;
            }
            // 已经找到待插入的位置为(insertIndex + 1)
            array[insertIndex + 1] = insertVal;

//            System.out.println("第" + i + "趟排序后的数组");
//            System.out.println(Arrays.toString(array));
        }

    }
}
