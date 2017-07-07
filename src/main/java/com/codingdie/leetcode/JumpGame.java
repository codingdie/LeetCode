package com.codingdie.leetcode;

/**
 * Created by xupen on 2017/7/7.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int k=i;
                while (k+1<nums.length&&nums[++k]==0){
                }
                boolean chFlag=false;
                for(int j=i-1;j>=0;j--){
                    if(j+nums[j]>=k){
                        chFlag=true;
                    }
                }
                if(chFlag==false){
                    return  false;
                }
                i=k;
            }
        }
        return  true;
    }




    public static void main(String[] args) {
        System.out.println(        new JumpGame().canJump(new int[]{3,2,1,0,4}));
    }
}
