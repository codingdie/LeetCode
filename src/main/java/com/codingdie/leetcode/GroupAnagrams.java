package com.codingdie.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shixi_xupeng on 2017/7/4.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        HashMap<Integer,Integer> integer=new HashMap<>();
        List<List<String>> reList=new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] chas=strs[i].toCharArray();
            int key=1;
            for (char ch:chas){
                key*=prime[(ch-'a')];
            }
            List<String> res=null;
            if(integer.containsKey(key)){
                res=reList.get(integer.get(key));
            }else{
                res= new ArrayList<>();
                reList.add( res);
                integer.put(key,reList.size()-1);
            }
            res.add(strs[i]);
        }
        return  reList;
    }

    public static void main(String[] args) {
        new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(strings -> {
            strings.forEach(s -> {
                System.out.print(s+"\t");
            });
            System.out.println();

        });
    }
}
