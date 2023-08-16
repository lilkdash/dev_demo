package com.kzheng.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/15 13:56
 */
public class AddFourNumbers {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n= nums.length;
        List<List<Integer>> outList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j=i+1;
            int sum=nums[i];
            List<Integer> list=new ArrayList<>();
            while(j<i+4 && i+4<n){
                sum+=nums[j]+nums[j+1]+nums[j+2];
                if(sum==target){
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[j+1]);
                    list.add(nums[j+2]);
                    outList.add(list);
                }
                j++;
            }

        }
        return null;
    }
    public static void main(String[] args) {
        AddTwoNumbers.ListNode listNode1 = new AddTwoNumbers.ListNode(2);
        AddTwoNumbers.ListNode listNode2 = new AddTwoNumbers.ListNode(4);
        AddTwoNumbers.ListNode listNode3 = new AddTwoNumbers.ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;

        AddTwoNumbers.ListNode listNode4 = new AddTwoNumbers.ListNode(5);
        AddTwoNumbers.ListNode listNode5 = new AddTwoNumbers.ListNode(6);
        AddTwoNumbers.ListNode listNode6 = new AddTwoNumbers.ListNode(4);
        listNode4.next=listNode5;
        listNode5.next=listNode6;

        AddTwoNumbers.ListNode newListNode= AddTwoNumbers.Solution.addTwoNumbers(listNode1,listNode4);
        while(newListNode!=null){
            System.out.print(newListNode.val);
            newListNode=newListNode.next;
        }



    }
}
