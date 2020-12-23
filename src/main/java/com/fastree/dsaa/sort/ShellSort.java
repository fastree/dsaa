package com.fastree.dsaa.sort;

import java.time.Instant;
import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] array = SortUtils.generateArray(100000, 10000000);
//        System.out.println("排序前的数组");
//        System.out.println(Arrays.toString(array));

        Instant start = Instant.now();
        shellSort2(array);
        Instant end = Instant.now();

        long consumingStat = SortUtils.timeConsumingStat(start, end);
        System.out.println("耗时：" + consumingStat + "毫秒");

//        System.out.println("排序后的数组");
//        System.out.println(Arrays.toString(array));
    }

    /**
     * 交换法实现shell排序
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        int temp = 0;
        int count = 0;

        // 循环除2确定交换的步长
        for (int step = array.length / 2; step > 0; step /= 2) {
            // 根据步长遍历数组
            for (int i = step; i < array.length; i++) {
                // 根据步长循环分组
                for (int j = i - step; j >= 0; j -= step) {
                    // 循环与前一个步长值比较
                    if (array[j] > array[j + step]) {
                        temp = array[j];
                        array[j] = array[j + step];
                        array[j + step] = temp;
                    }
                }
            }
//            System.out.println("第" + (++count) + "趟排序后的数组");
//            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * 移位法实现shell排序
     *
     * @param array
     */
    public static void shellSort2(int[] array) {
        // 循环除2确定交换的步长
        for (int step = array.length / 2; step > 0; step /= 2) {
            // 根据步长遍历数组
            for (int i = step; i < array.length; i++) {
                // 保存当前正在遍历的索引
                int insertIndex = i;
                // 保存当前正在遍历的值
                int insertVal = array[insertIndex];

                // 判断前一个步长的值与当前值
                if (array[insertIndex - step] > array[insertIndex]) {
                    // 步长相同的组内遍历
                    while ((insertIndex - step) >= 0 && array[insertIndex - step] > insertVal) {
                        // 前一个步长值向后移动
                        array[insertIndex] = array[insertIndex - step];
                        // 根据步长值指针向前移动
                        insertIndex -= step;
                    }
                    // 将当前正在遍历的值插入指定位置
                    array[insertIndex] = insertVal;
                }
            }
//            System.out.println("步长为" + step + "排序后的数组");
//            System.out.println(Arrays.toString(array));
        }
    }
}
