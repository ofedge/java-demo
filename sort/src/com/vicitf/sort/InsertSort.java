package com.vicitf.sort;

import com.vicitf.util.ArrayUtil;

/**
 * <h3>插入排序</h3>
 * 
 * 将每一个待排序的元素都插入到序列中合适的位置, 直到插入完成
 *
 */
public class InsertSort {
    
    public static void insertSort(int[] arr) {
        // i 为每次判断的数字, 第1个肯定是有序的, 所以从第二位开始
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i]; // 保存当前判断的数字
            int j;
            for (j = i - 1; j >= 0 && tmp < arr[j]; j--) {
                // 如果这个数比当前数字大, 则应该向后移动
                arr[j + 1] = arr[j];
            }
            // 如果没有被移动过的元素, arr[j+1]还是arr[i], 如果有发生过移动, 则arr[j+1]就是移动完成后arr[i](即tmp)应该所处的位置
            arr[j + 1] = tmp;
        }
    }
    
    public static void main(String[] args) {
        int[] data = ArrayUtil.UNORDER_ARRAY;
        System.out.println("排序前: ");
        ArrayUtil.printArray(data);
        insertSort(data);
        System.out.println("排序后: ");
        ArrayUtil.printArray(data);
    }
}
