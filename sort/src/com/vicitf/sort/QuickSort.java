package com.vicitf.sort;

import com.vicitf.util.ArrayUtil;

/**
 * <h3>快速排序算法</h3>
 * 
 * <ul>
 * <li>首先选取第一个数作为基数, 然后依次从左边右边遍历, 大于基数的数放在右边, 小于基数的数放在左边, 基数放置于中间</li>
 * <li>之后以基数为界, 把左边和右边分别作为一个整体, 重复第一个步骤</li>
 * <li>最后重复之前的动作, 直到排序完成</li>
 * </ul>
 */
public class QuickSort {

    /**
     * 对给定的列表排序, 并返回排序后的基数索引
     * 
     * @param list
     *            排序列表
     * @param low
     *            列表首位索引
     * @param high
     *            列表高位索引
     * @return 该列表的中位数
     */
    public static int getMiddle(int[] list, int low, int high) {
        int tmp = list[low]; // 拿左边第一位做基数
        while (low < high) {
            while (low < high && list[high] >= tmp) {
                high--;
            }
            list[low] = list[high]; // 找到右边比基数小的, 交换到左边
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low]; // 找到左边比基数大的, 交换到右边
        }
        list[low] = tmp; // 最后把中间的一位替换为基数
        return low;
    }

    public static void quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high);
            quickSort(list, low, middle - 1);
            quickSort(list, middle + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] data = ArrayUtil.UNORDER_ARRAY;
        System.out.println("排序前: ");
        ArrayUtil.printArray(data);
        quickSort(data, 0, data.length - 1);
        System.out.println("排序后: ");
        ArrayUtil.printArray(data);
    }
}
