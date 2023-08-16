package com.kzheng.other;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author kaizheng
 * @Description TODO
 * @Date 2023/7/10 14:36
 */
public class OtherTest {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>(nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
    @Test
    public  void test(){
        int[] nums={2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums,17)));
        int[] nums2=new int[] {1,1,1,1};
        System.out.println(threeSumClosest(nums2,13));
    }
    public  int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int length=nums.length;
        int best=Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int b=i+1;
            int c=length-1;
            while(b<c){
                int sum=nums[i]+nums[b]+nums[c];
                if(sum==target)return sum;
                /*if(Math.abs(sum-target)==Math.abs(best-target)){//1+2+3<7<1+2+5 这种情况如果取和为最小值时取前者
                    return sum;
                }*/
                if(Math.abs(sum-target)<Math.abs(best-target)){
                    best=sum;
                }
                if(sum<target){
                    int b0=b+1;
                    while(b0<c && nums[b]==nums[b0]){
                        b0++;
                    }
                    b=b0;
                }else{
                    int c0=c-1;
                    while(b<c0 && nums[c]==nums[c0]){
                        c0--;
                    }
                    c=c0;
                }

            }
        }
        return best;
    }
}
