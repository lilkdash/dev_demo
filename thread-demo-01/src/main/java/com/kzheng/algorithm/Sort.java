package com.kzheng.algorithm;

import java.util.Arrays;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/8 13:33
 */
public class Sort {
    /**
     * 冒泡排序：
     * 步骤1.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 步骤2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 步骤3.针对所有的元素重复以上的步骤，除了最后一个；
     * @param arr
     */
    public static int[] bubbleSort(int[] arr){
        int count=0;
        for (int i = 0; i < arr.length; i++) {//步骤3
            for (int j = 0; j <arr.length-1-i ; j++) {//步骤2,arr.length-1-i 轮训i次后，倒数i个数字都是排好顺序的，无需处理
                    if(arr[j]>arr[j+1]){
                        swap(arr,j,j+1);//步骤1
                        count++;
                    }
            }
        }
        System.out.println("冒泡排序-总排序次数："+count);
        return arr;
    }
    public static int[]  bubbleSort2(int[] arr){
        int count=0;
        for(int i = 0;i < arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                int v = arr[i];
                if(v > arr[j]){
                    arr[i] = arr[j];
                    arr[j] = v;
                    count++;
                }
            }
        }
        System.out.println("冒泡排序-总排序次数："+count);
        return arr;
    }
    /**
     * 选择排序：
     * 最稳定的排序算法之一，因为无论什么数据进去都是O(n2)
     * 步骤1：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
     * 步骤2：再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
     */
    public static int[] selectionSort(int[] arr){
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            int minIndex=i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex=j;
                }
            }
            swap(arr,i,minIndex);
            count++;
        }
        System.out.println("选择排序-总排序次数："+count);
        return arr;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[j];
        arr[j]=arr[i];
        arr[i]=temp;
    }
    /**
     * 插入排序：
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     */
    public static int[] insertionSort(int[] arr){
        int count=0;
        for (int i = 1; i <arr.length ; i++) {
            int currentIndex=i;
            int current=arr[i];
            while(currentIndex>0){
                if(arr[currentIndex]<arr[currentIndex-1]){
                    swap(arr,currentIndex,currentIndex-1);
                    count++;
                }else break;
                currentIndex--;
            }
            arr[currentIndex]=current;
        }
        System.out.println("插入排序-总排序次数："+count);
        return arr;
    }
    /*
    *快速排序：
    1.选定一个基准值pivot（通常指定为数组第一个值），比基准值大的放在右侧，比基准值小的放在左侧
    2.指定左右两个指针分别为left，right ；left < right
    3.指定函数退出条件，即left > right
    4.先从右向左遍历，即右指针向左移动——right–操作，发现比pivot小的值暂停移动
    5.再从左向右遍历，即左指针向右移动——left++操作，发现比pivot大的值暂停移动
    6.交换左右指针发现的两个值的位置
    7.当两指针相遇，即left == right，当前值与pivot交换位置
     */
    public static void quicklySort(int[] arr,int left,int right){
        if(arr.length==0)return;
        // 方法退出条件,指针相遇或错过
        if(left>right)return;
        // 1. 指定基准值和左右指针记录位置
        int pivot=arr[left];
        int l=left;
        int r=right;
        // 2. 遍历条件，左右指针位置
        while(l<r){
            // 2.1 右侧遍历
            while(l<r && arr[r]>=pivot){
                r--;
            }
            // 2.2 左侧遍历
            while(l<r && arr[l]<=pivot){
                l++;
            }
            // 2.3 l指针还在r指针左侧，尚未相遇
            if(l<r){
                swap(arr,l,r);
            }
        }
        // 3. 当左右指针相遇，交换基准值位置
        arr[left]=arr[l];
        arr[l]=pivot;
        // 4. 根据条件左侧递归遍历
        if(left<l){
            quicklySort(arr,left,l-1);
        }
        // 5. 根据条件右侧递归遍历
        if(r<right){
            quicklySort(arr,r+1,right);
        }
    }
    public static void fastSort(int[] arr,int left,int right){
        if(arr.length==0)return;
        if(left>right)return;
        int l=left,r=right;
        int pivot=arr[left];
        while(l<r){
            if(l<r && arr[r]>=pivot){
                r--;
            }
            if(l<r && arr[l]<=pivot){
                l++;
            }
            if(l<r){
                swap(arr,l,r);
            }
        }
        arr[left]=arr[l];
        arr[l]=pivot;
        if(left<l){
            fastSort(arr,left,l-1);
        }
        if(r<right){
            fastSort(arr,r+1,right);
        }
    }
    public static void main(String[] args) {
        //1.冒泡排序
       /* int[] arr1={6,2,22,45,1,6,8,200,56,111};
        System.out.println(Arrays.toString(bubbleSort(arr1)));
        //2.选择排序
        int[] arr2={6,2,22,45,1,6,8,200,56,111};
        System.out.println(Arrays.toString(selectionSort(arr2)));
        //3.插入排序
        int[] arr3={6,2,22,45,1,6,8,200,56,111};
        System.out.println(Arrays.toString(insertionSort(arr3)));
        //5.快速排序
        int[] arr4={6,2,22,45,1,6,8,200,56,111};
        quicklySort(arr4,0,arr4.length-1);
        System.out.println("快速排序：");
        System.out.println(Arrays.toString(arr4));
        int[] arr5={6,2,22,45,1,6,8,200,56,111};
        fastSort(arr5,0,arr5.length-1);
        System.out.println(Arrays.toString(arr5));*/
        new Thread(()->{
            System.out.println(123);
            System.out.println(Thread.currentThread());
        },"B").start();

    }

}
