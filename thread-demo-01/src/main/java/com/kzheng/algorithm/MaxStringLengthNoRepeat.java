package com.kzheng.algorithm;

import java.util.HashMap;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/13 15:42
 */
public class MaxStringLengthNoRepeat {

    public static int lengthOfLongestSubstring(String s) {
        int m = s.length();
        if(m==0) {
            return 0;
        }
        int num =1;  //初始值表示以s的第一个字符为结束的不重复的最长子串
        int max =1;

        for(int i=1;i<m;i++){
            System.out.print("i="+i+",");
            int index = s.indexOf(s.charAt(i),i-num);
            System.out.print("index="+index+",");
            if(index<i) {  //num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                num = i-index;
            } else {
                num = num+1;
            }
            System.out.print("num="+num+",");
            max = Math.max(max,num);
            System.out.print("max="+max);
            System.out.println("");
        }
        return max;
    }
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        System.out.println("abcabcbb".indexOf("b",4));
    }
}
