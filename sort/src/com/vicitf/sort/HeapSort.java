package com.vicitf.sort;

import com.vicitf.util.ArrayUtil;

/**
 * <h3>堆排序算法</h3>
 * 
 * <ul>
 * <li>首先把数组变成一个堆, 之后从最后一个非叶子节点开始, 依次调整每个二叉树中节点位置, 使堆变成大顶堆(或者小顶堆), 此时堆顶元素最大(或最小)</li>
 * <li>将堆顶元素与最后一项交换, 剩余的元素重新组成无序堆, 再次排序成为大顶堆(或小顶堆)</li>
 * <li>重复上一步, 直到排序完成</li>
 * </ul>
 */
public class HeapSort {
    
    /**
     * 交换数组中两个元素的位置
     * 
     * @param data
     * @param i
     * @param j
     */
    public static void swap(int[] data, int i, int j) {
        if (i ==  j || i > (data.length - 1) || j > (data.length - 1))
            return;
        data[i] = data[i] + data[j];
        data[j] = data[i] - data[j];
        data[i] = data[i] - data[j];
    }
    
    /**
     * 创建最大堆
     * 
     * @param data
     * @param lastIndex
     */
    public static void createMaxHeap(int[] data, int lastIndex) {
        for (int i = (lastIndex - 1) >> 1; i >= 0; i--) {  // 从最后一个有叶子的节点开始
            // 使用k复制正在判断的节点索引i, 防止i在判断过程中被变化
            int k = i;
            while ((k << 1) + 1 <= lastIndex) {
                // 使用biggerIndex记录较大的节点索引
                int biggerIndex = (k << 1) + 1; // 假设左子节点是较大的, 把左子节点索引赋值给biggerIndex
                if (biggerIndex < lastIndex) {
                    // 如果右子节点的值比左子节点的值大, 则biggerIndex等于右子节点的索引
                    if (data[biggerIndex] < data[biggerIndex + 1]) {
                        biggerIndex++;
                    }
                }
                // 循环完成后biggerIndex为两个子节点中值较大的节点的索引, 此时如果当前节点k的值小于biggerIndex节点值, 交换两者位置
                if (data[k] < data[biggerIndex]) {
                    swap(data, k, biggerIndex);
                }
                break;
            }
        }
    }
    
    /**
     * 堆排序
     */
    public static void heapSort(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            createMaxHeap(data, data.length - 1 - i);
            swap(data, 0, data.length - 1 - i);
        }
    }
    
    public static void main(String[] args) {
        int[] data = ArrayUtil.UNORDER_ARRAY;
        System.out.println("排序前: ");
        ArrayUtil.printArray(data);
        heapSort(data);
        System.out.println("排序后: ");
        ArrayUtil.printArray(data);
    }
}
