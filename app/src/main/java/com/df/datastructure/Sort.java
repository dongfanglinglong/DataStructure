package com.df.datastructure;

import android.support.annotation.NonNull;
import android.support.annotation.Size;


/**
 * 排序是程序开发中一种非常常见的操作，对一组任意的数据元素（或记录）经过排序操作后，就可以把他们变成一组按关键字排序的有序队列。<br/>
 * 对一个排序算法来说，一般从下面3个方面来衡量算法的优劣：
 * <pre>
 * 1.时间复杂度：它主要是分析关键字的比较次数和记录的移动次数。
 * 2.空间复杂度：分析排序算法中需要多少辅助内存。
 * 3.稳定性：若两个记录A和B的关键字值相等，但是排序后A,B的先后次序保持不变，则称这种排序算法是稳定的；反之，就是不稳定的。
 * </pre>
 * 就现有的排序算法来看，排序大致可分为内部排序和外部排序。<br/>
 * 如果整个排序过程不需要借助外部存储器（如磁盘等），所有排序操作都是在内存中完成，这种排序就被称为内部排序。<br/>
 * 如果参与排序的数据元素非常多，数据量非常大，计算无法把整个排序过程放在内存中完成，必须借助于外部存储器（如磁盘），这种排序就被称为外部排序。<br/>
 * 外部排序最常用算噶是多路归并排序，即将原文件分解称多个能够一次性装入内存的部分，分别把每一部分调入内存完成排序，接下来再对多个有序的子文件进行归并排序。
 * <br/><br/>
 * 就常用的内部排序算法来说，可以分为以下几类：
 * <pre>
 * 选择排序（直接选择排序，堆排序）
 * 交换排序（冒泡排序，快速排序）
 * 插入排序（直接插入排序，折半插入排序，Shell排序）
 * 归并排序
 * 桶式排序
 * 基数排序
 * </pre>
 * <pre>
 * 排 序 法  平均时间           最好时间       最坏时间      额外空间            稳定     备注
 * 冒泡排序  平均O(n^2)         最好O(n)      最坏O(n^2)   辅助空间O(1)         稳定     n较小时好（简单）
 * 选择排序  平均O(n^2)         最好O(n^2)    最坏O(n^2)   辅助空间O(1)         稳定     n较小时好（简单）
 * 插入排序  平均O(n^2)         最好O(n)      最坏O(n^2)   辅助空间O(1)         稳定     基本有序时好（简答）
 * 希尔排序  平均O(nlgn)~O(n^2) 最好O(n^1.3)  最坏O(n^2)   辅助空间O(1)         不稳     n较小时好（简单）
 * 归并排序  平均O(nlgn)        最好O(nlgn)   最坏O(nlgn)  辅助空间O(n)         稳定     n较大时好（较复杂）
 * 快速排序  平均O(nlgn)        最好O(nlgn)   最坏O(n^2)   辅助空间O(lgn)~O(n)  不稳定   n较大时好,基本有序反而不好（较复杂）
 * 堆 排 序  平均O(nlgn)        最好O(nlgn)   最坏O(nlgn)  辅助空间O(1)         不稳定   n较大时好（较复杂）
 * </pre>
 * <p>
 * Created by dongfang on 2016/3/10.
 */
public class Sort {
    // 排序法		平均时间				最好时间		最坏时间		额外空间				稳定度	备注
    // 冒泡排序		平均O(n^2)			最好O(n)		最坏O(n^2)	辅助空间O(1)			稳定		n较小时好（简单）
    // 简单选择排序	平均O(n^2)			最好O(n^2)	最坏O(n^2)	辅助空间O(1)			稳定		n较小时好（简单）
    // 直接插入排序	平均O(n^2)			最好O(n)		最坏O(n^2)	辅助空间O(1)			稳定		基本有序时好（简答）
    // 希尔排序		平均O(nlgn)~O(n^2)	最好O(n^1.3)	最坏O(n^2)	辅助空间O(1)			不稳定	n较小时好（简单）
    // 归并排序		平均O(nlgn)			最好O(nlgn)	最坏O(nlgn)	辅助空间O(n)			稳定		n较大时好（较复杂）
    // 快速排序		平均O(nlgn)			最好O(nlgn)	最坏O(n^2)	辅助空间O(lgn)~O(n)	不稳定	n较大时好,基本有序反而不好（较复杂）
    // 堆排序		平均O(nlgn)			最好O(nlgn)	最坏O(nlgn)	辅助空间O(1)			不稳定	n较大时好（较复杂）


    /**
     * <EM>冒泡排序（Bubble Sort，台湾译为：泡沫排序或气泡排序）</EM>是一种简单的排序算法。<BR/>
     * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
     * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
     * 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     * <p>
     * 步骤：
     * <pre>
     * 1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 3.针对所有的元素重复以上的步骤，除了最后一个。
     * 4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * <pre/>
     *
     * @param array
     */
    public static void dubble(@NonNull @Size(min = 1) int[] array) {
        int num = 1;
        int length = array.length;
        int temp = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    num++;
                    // System.out.println("[" + num++ + "][" + i + "][" + j + "] : " + Arrays.toString(array));
                }
            }
        }

        System.out.println("dubble num [" + num + "]");
    }

    /**
     * 冒泡排序。
     * 若当前为第i次循环；
     * 则i与大于i的元素一次比较，使得i位置上变成最小元素；
     *
     * @param array
     */
    public static void dubbleAlpha(@NonNull @Size(min = 1) int[] array) {
        int num = 1;
        int length = array.length;
        int temp = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    num++;
                    // System.out.println("[" + num++ + "][" + i + "][" + j + "] : " + Arrays.toString(array));
                }
            }
        }
        System.out.println("dubbleAlpha num [" + num + "]");

    }

    /**
     * <EM>选择排序(Selection sort)</EM>是一种简单直观的排序算法。<BR/>
     * 它的工作原理如下。<BR/>
     * 首先在未排序序列中找到最小元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。以此类推，直到所有元素均排序完毕。
     * <BR/>
     * 选择排序无论初始状态如何,时间复杂度永远是O(n^2),但是移动的数据是最少的;<BR/>
     * 对于长度为N的数组，选择排序需要大约(N^2)/2次比较和N次交换
     *
     * @param array
     */
    public static void select(@NonNull @Size(min = 1) int[] array) {
        int num = 1;
        int length = array.length;

        int min = 0; // 最小数值下标值
        int temp = 0;

        for (int i = 0; i < length; i++) {
            min = i;
            for (int j = i + 1; j < length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                    num++;
                    // System.out.println("[" + num++ + "][" + i + "][" + j + "] : " + Arrays.toString(array));
                }
            }

            if (min > i) {
                temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }

        System.out.println("select num [" + num + "]");

    }

    /**
     * <EM>插入排序（Insertion Sort）</EM>的算法描述是一种简单直观的排序算法。<BR/>
     * 它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。<BR/>
     * 插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
     * <p>
     * 步骤：
     * <pre>
     * 1. 从第一个元素开始，该元素可以认为已经被排序
     * 2. 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 3. 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     * 5. 将新元素插入到该位置中
     * 6. 重复步骤2
     * <pre/>
     *
     * @param array
     */
    public static void insertion(@NonNull @Size(min = 1) int[] array) {
        int num = 1;
        int length = array.length;
        int temp = 0;

        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && (array[j - 1] > array[j]); j--) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                num++;
                // System.out.println("[" + num++ + "][" + i + "][" + j + "] : " + Arrays.toString(array));
            }
        }
        System.out.println("insertion num [" + num + "]");

    }

    /**
     * <EM>希尔排序</EM>，也称递减增量排序算法，是插入排序的一种高速而稳定的改进版本。
     * <pre>
     * 希尔排序是基于插入排序的以下两点性质而提出改进方法的：
     *      1、插入排序在对几乎已经排好序的数据操作时， 效率高， 即可以达到线性排序的效率
     *      2、但插入排序一般来说是低效的， 因为插入排序每次只能将数据移动一位
     * </pre>
     * 由于shell排序的时间复杂度和步长有关，目前还没法证明哪个步长效率最好，此处用Knuth提出的方法；<BR/>
     *
     * @param array
     */
    public static void shell(@NonNull @Size(min = 1) int[] array) {
        int num = 1;
        int length = array.length;
        int temp = 0;

        int h = 0;
        while (h <= length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            // System.out.println("h = " + h);
            for (int i = h; i < length; i += h) {
                for (int j = i - h; j > -1 && array[j] > array[j + h]; j--) {
                    temp = array[j + h];
                    array[j + h] = array[j];
                    array[j] = temp;
                    num++;
                    // System.out.println("[" + num++ + "][" + i + "][" + j + "] : " + Arrays.toString(array));
                }
            }
            h = (h - 1) / 3;
        }
        System.out.println("shell num [" + num + "]");

        // 当h == 1时, 就变成了直接插入排序了

        // while (1 > 0) {
        //     System.out.println("h = " + 1);
        //     for (int i = 1; i < length; i += 1) {
        //         for (int j = i - 1; j > -1 && array[j] > array[j + 1]; j--) {
        //             temp = array[j + 1];
        //             array[j + 1] = array[j];
        //             array[j] = temp;
        //             System.out.println("[" + num++ + "][" + temp + "][" + i + "][" + j + "] : " + Arrays.toString(array));
        //         }
        //     }
        //     h = (1 - 1) / 3;
        // }

    }

    /**
     * <EM>归并排序（Merge）</EM>是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
     * <p>
     * 归并排序是建立在归并操作上的一种有效的排序算法。<br/>
     * 该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。 <br/>
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。<br/>
     * <p>
     * -----
     * <pre>
     * 归并排序算法稳定，
     * 数组需要O(n)的额外空间，链表需要O(log(n))的额外空间，
     * 时间复杂度为O(nlog(n))，
     * 算法不是自适应的，不需要对数据的随机读取。
     * </pre>
     *
     * @param array
     */
    public static void merge(@NonNull @Size(min = 1) int[] array) {
        int length = array.length;
        int[] reg = new int[length];
        int num = mergePartition(array, reg, 0, length - 1);

        System.out.println("mergeAlpha num [" + num + "]");

    }

    public static void mergeAlpha(@NonNull @Size(min = 1) int[] array) {
        int num = 1;
        int length = array.length;
        int[] result = new int[length];

        for (int block = 1; block < length; block *= 2) {
            for (int i = 0; i < length; i += 2 * block) {
                int low = i;
                int mid = (i + block) < length ? (i + block) : length;
                int high = (i + 2 * block) < length ? (i + 2 * block) : length;

                //两个块的起始下标及结束下标
                int stratL = low;
                int startH = mid;
                //开始对两个block进行归并排序
                while (stratL < mid && startH < high) {
                    result[low++] = array[stratL] < array[startH] ? array[stratL++] : array[startH++];
                    num++;
                }
                while (stratL < mid) {
                    result[low++] = array[stratL++];
                    num++;
                }
                while (startH < high) {
                    result[low++] = array[startH++];
                    num++;
                }
            }
            int[] temp = array;
            array = result;
            result = temp;
        }
        System.out.println("mergeAlpha num [" + num + "]");

    }


    /**
     * <EM>归并排序（英语：Merge sort，或mergesort）</EM>，是创建在归并操作上的一种有效的排序算法，效率为O(nlogn)。
     * <Pre>
     * 原理如下（假设序列共有n个元素）：
     * 1.将序列每相邻两个数字进行归并操作，形成floor(n/2)个序列，排序后每个序列包含两个元素
     * 2.将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
     * 3.重复步骤2，直到所有元素排序完毕
     * </Pre>
     *
     * @param array
     * @param reg
     * @param start
     * @param end
     */
    private static int mergePartition(int[] array, int[] reg, int start, int end) {
        if (start >= end)
            return 0;

        int num = 0;
        int mid = ((end - start) >> 1) + start;

        int startL = start;
        int startH = mid + 1;
        mergePartition(array, reg, startL, mid);
        mergePartition(array, reg, startH, end);

        int i = start;
        while (startL <= mid && startH <= end) {
            reg[i++] = array[startL] < array[startH] ? array[startL++] : array[startH++];
            num++;
        }
        while (startL <= mid) {
            reg[i++] = array[startL++];
            num++;
        }
        while (startH <= end) {
            reg[i++] = array[startH++];
            num++;
        }
        for (i = start; i <= end; i++) {
            array[i] = reg[i];
            num++;
        }

        return num;
    }

    /**
     * 快速排序
     * <pre>
     * 将任务进行分割，然后各个击破
     * 在某种特定的情况下，是最快的算法
     * 基本原理：
     *      1.设定一个基准值（也就是轴）
     *      2.将比轴小的值，移到轴的左边，形成左子数列
     *      3.将比轴大的值，移到轴的右边，形成右子数列
     *      4.分别对左子数列和右子数列做上述三个步骤(递归)，直到左子数列或右子数列只剩一个值或没有数值
     * 快速排序的效率：选择的基准值越接近数列平均值越好
     * 基准值（轴）的选择方式：
     *      - 固定位置：第一位，或者最后一位
     *      - 随机选择一位
     *      - 随机取三个值，然后取中间值
     * 不稳定算法
     *
     * </pre>
     *
     * @param array
     */
    public static void quick(@NonNull @Size(min = 1) int[] array) {
        int num = quickPartition(array, 0, array.length - 1);
        System.out.println("quick num [" + num + "]");

    }

    /**
     * 快速排序分治方法
     * <pre>
     * 1.以array[l]为轴，作为基准值进行分治
     * 2.将比轴小的值，移到轴的左边，形成左子数列
     * 3.将比轴大的值，移到轴的右边，形成右子数列
     * 4.分别对左子数列和右子数列做上述三个步骤(递归)，直到左子数列或右子数列只剩一个值或没有数值
     * </pre>
     * 每次一次分治，都会把轴的值给排序好
     *
     * @param array
     * @param l     起始位置
     * @param r     结束位置
     */
    private static int quickPartition(int array[], int l, int r) {
        int num = 0;

        if (l < r) {
            int i = l, j = r, temp = array[l];
            while (i < j) {
                while (i < j && array[j] >= temp) // 从右向左找第一个小于x的数
                    j--;
                if (i < j) {
                    array[i] = array[j];
                    // System.out.println("[" + ++num + "][" + temp + "][" + i + "][" + j + "] : " + Arrays.toString(array));
                    num++;
                    i++;
                }
                while (i < j && array[i] < temp) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j) {
                    array[j] = array[i];
                    // System.out.println("[" + ++num + "][" + temp + "][" + i + "][" + j + "] : " + Arrays.toString(array));
                    num++;
                    j--;
                }
            }
            array[i] = temp;
            // System.out.println("[" + ++num + "][" + temp + "][" + i + "][0] : " + Arrays.toString(array));
            num++;
            num += quickPartition(array, l, i - 1); // 递归调用
            num += quickPartition(array, i + 1, r);
        }

        return num;
    }

    /**
     * <EM>堆排序（Heapsort）</EM>是指利用堆这种数据结构所设计的一种排序算法。<br/>
     * 堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：<I>即子结点的键值或索引总是小于（或者大于）它的父节点。<I/>
     * <pre>
     *  不稳定的排序方法
     *  辅助空间为O(1)， 最坏时间复杂度为O(nlog2n)
     *  堆排序的堆序的平均性能较接近于最坏性能。
     * </pre>
     *
     * @param array
     */
    public static void heap(@NonNull @Size(min = 1) int[] array) {
        int num = 0; // 数据交换次数

        int length = array.length;
        for (int i = (length - 1) >> 1; i > -1; i--) { // 从最后一个父节点开始建堆
            num += heapify(array, i, length);
        }

        int temp;
        for (int i = length - 1; i > 0; i--) {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            num++;
            // System.out.println("[" + num++ + "][" + i + "][0]\t: " + Arrays.toString(array));
            num += heapify(array, 0, i);
        }
        System.out.println("heap num [" + num + "]");
    }

    /**
     * 建堆--> 大堆
     * <pre>
     * 1. 若array[0，...，n-1]表示一颗完全二叉树的顺序存储模式，则双亲节点指针和孩子结点指针之间的内在关系如下：
     *   任意一节点指针 i：父节点：i==0 ? null : (i-1)/2
     *                   左孩子：2*i + 1
     *                   右孩子：2*i + 2
     * 2. 堆的定义：n个关键字序列array[0，...，n-1]，当且仅当满足下列要求：(0 <= i <= (n-1)/2)
     *            ① array[i] <= array[2*i + 1] 且 array[i] <= array[2*i + 2]； 称为小根堆；
     *            ② array[i] >= array[2*i + 1] 且 array[i] >= array[2*i + 2]； 称为大根堆；
     * </pre>
     *
     * @param array  待建堆数组
     * @param i      父节点下标
     * @param length 数组长度
     * @return num数据交换次数
     */
    private static int heapify(@NonNull @Size(min = 1) int[] array, int i, int length) {
        int temp = array[i];
        int num = 1;

        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {  //j为初始化为父节点的左孩子，沿节点较大的子节点向下调整
            if (j < (length - 1) && array[j] < array[j + 1]) {//取节点较大的子节点的下标
                ++j;//如果节点的右孩子>左孩子，则取右孩子节点的下标
            }

            if (temp > array[j]) {
                break;
            }

            //根节点 <左右子女中关键字较大者
            array[i] = array[j]; //将左右子结点中较小值array[j]调整到双亲节点上
            num++;

            //System.out.println("[" + num++ + "][" + i + "][" + j + "]\t: " + Arrays.toString(array));
            i = j;//【关键】修改i值，以便继续向下调整
            array[i] = temp;//被调整的结点的值放人最终位置
        }
        return num;
        // System.out.println("[" + num++ + "][" + i + "][-]\t: " + Arrays.toString(array));
    }


}