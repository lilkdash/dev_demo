package com.kzheng.algorithm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author kaizheng
 * @Description leetcode->2. 两数相加
 * @Date 2023/7/13 14:38
 */
public class AddTwoNumbers {
    static public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null,cur = null;
            int carry=0;
            while(l1!=null || l2!=null){
                int num1= l1==null?0:l1.val;
                int num2= l2==null?0:l2.val;
                int sum= num1+num2+carry;
                carry = sum>9?1:0;
                sum = sum%10;
                if(head==null){
                    head=cur=new ListNode(sum);
                }else{
                    cur.next=new ListNode(sum);
                    cur=cur.next;
                }
                if(l1!=null){
                    l1=l1.next;
                }
                if(l2!=null){
                    l2=l2.next;
                }
            }
            if(carry==1){
                cur.next= new ListNode(carry);
            }
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode1.next=listNode2;
        listNode2.next=listNode3;

        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(4);
        listNode4.next=listNode5;
        listNode5.next=listNode6;

        ListNode newListNode=Solution.addTwoNumbers(listNode1,listNode4);
        while(newListNode!=null){
            System.out.print(newListNode.val);
            newListNode=newListNode.next;
        }



    }
}
