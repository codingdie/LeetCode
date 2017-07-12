package com.codingdie.leetcode.easy;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * Created by xupeng on 2017/7/12.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                boolean flag=false;
                for(int j=i+1;j<nums.length;j++){
                   if(nums[j]!=0){
                       int tmp=nums[j];
                       nums[j]=0;
                       nums[i]=tmp;
                       flag=true;
                       i=j-1;
                       break;
                   }
                }
                if(flag==false)return;
            }
        }
    }
}
