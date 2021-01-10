package com.axel_stein.array;

/**
 * Implementation of Durstenfeld shuffle algorithm
 * @author Axel Stein
 */
public class DurstenfeldShuffle {

    public static void shuffle(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int j = (int) Math.floor(Math.random() * (i + 1));
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }
}
