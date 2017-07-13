package com.codingdie.leetcode.easy;

import com.codingdie.leetcode.TestUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xupen on 2017/7/13.
 */
public class FindAllNumbersDisappearedInAnArray {

    //三种思路
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int swap=nums[i];
            int pos=i;
            while (swap!=pos+1){
                if(nums[swap-1]==swap)break;;
                int tmp=nums[swap-1];
                nums[swap-1]=swap;
                nums[pos]=tmp;
                swap=tmp;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}
