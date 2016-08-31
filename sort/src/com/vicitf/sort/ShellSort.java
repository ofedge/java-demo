package com.vicitf.sort;

import com.vicitf.util.ArrayUtil;

/**
 * <h3>希尔排序</h3>
 * 
 * 先把数组按找一个步长分组, 对每组采用插入排序进行排序, 之后减小步长, 再进行排序, 当步长减小为1时, 排序完成
 *
 */
public class ShellSort {
    
    public static void shellSort(int[] arr) {
        int gap = arr.length >> 1;
        while (1 <= gap) {
            // 把距离为gap的元素编为一个组, 扫描所有组
            for (int i = gap; i < arr.length; i++) {
                int j = 0;
                int temp = arr[i];
                // 对距离为gap的元素进行插入排序
                for (j = i - gap; j >= 0 && temp < arr[j]; j = j - gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
            // 缩小步长
            gap = gap >> 1;
            ArrayUtil.printArray(arr);
        }
    }
    
    public static void main(String[] args) {
        int[] data = ArrayUtil.UNORDER_ARRAY;
        System.out.println("排序前: ");
        ArrayUtil.printArray(data);
        shellSort(data);
        System.out.println("排序后: ");
        ArrayUtil.printArray(data);
    }
}
