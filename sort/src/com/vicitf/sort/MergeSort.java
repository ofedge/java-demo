package com.vicitf.sort;

import com.vicitf.util.ArrayUtil;

/**
 * <h3>归并排序</h3>
 * 
 * 将待排序的序列看作是n个长度为1的有序序列, 之后将相邻的两个归并, 得到共n/2个长度为2的有序序列, 
 * 再次将这些有序序列相邻的归并, 得到n/4个长度为4的有序序列, 如此反复, 直到得到一个长度为n的有序序列
 */
public class MergeSort {
    
    /**
     * 合并数组arr从low到mid和mid+1到high的两段
     * 
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low; // 第一段数组下标
        int j = mid + 1; // 第二段数组下标
        int k = 0; // 临时数组下标
        int[] tmp = new int[high - low + 1]; // 临时数组
        // 扫描两个数组, 进行归并
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        // 若第一个数组还没扫描完, 全部复制到temp[]
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        // 若第二个数组还没扫描完, 全部复制到temp[]
        while (j <= high) {
            tmp[k++] = arr[j++];
        }
        for (k = 0, i = low; i <= high; i++, k++) {
            arr[i] = tmp[k];
        }
    }
    
    /**
     * 根据间隔gap, 归并数组arr
     * 
     * @param arr
     * @param gap
     * @param length
     */
    public static void mergePass(int[] arr, int gap, int length) {
        int i = 0;
        // 归并相邻两个子表
        for (i = 0; i + 2 * gap - 1 < length; i = i + 2 * gap) {
            merge(arr, i, i + gap - 1, i + 2 * gap - 1);
        }
        if (i + gap - 1 < length) {
            merge(arr, i, i + gap - 1, length - 1);
        }
    }
    
    public static void mergeSort(int[] arr) {
        for (int gap = 1; gap < arr.length; gap = 2 * gap) {
            mergePass(arr, gap, arr.length);
        }
    }
    
    public static void main(String[] args) {
        int[] data = ArrayUtil.UNORDER_ARRAY;
        System.out.println("排序前: ");
        ArrayUtil.printArray(data);
        mergeSort(data);
        System.out.println("排序后: ");
        ArrayUtil.printArray(data);
    }
}
