package com.fastree.dsaa.sort;

import java.time.Duration;
import java.time.Instant;

public class SortUtils {
    public static int[] generateArray(int len, int max) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static long timeConsumingStat(Instant start, Instant end) {
        Duration duration = Duration.between(start, end);
        return duration.toMillis();
    }

}
