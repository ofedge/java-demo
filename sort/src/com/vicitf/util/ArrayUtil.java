package com.vicitf.util;

public class ArrayUtil {
    
    public static final int[] UNORDER_ARRAY = {4, 3, 6, 9, 7, 1, 2, 4};
    
    public static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[array.length - 1]).append("]");
        System.out.println(sb);
    }
}
