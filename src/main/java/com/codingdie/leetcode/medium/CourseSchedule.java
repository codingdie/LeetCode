package com.codingdie.leetcode.medium;

import com.codingdie.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.Inflater;

/**
 * Created by xupen on 2017/7/11.
 */
public class CourseSchedule {
    //拓扑排序
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return true;
        int[] dus=new int[numCourses];
        ArrayList<Integer>[] lines=new ArrayList[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            dus[prerequisites[i][0]]++;
            if(lines[prerequisites[i][1]]==null){
                lines[prerequisites[i][1]]=new ArrayList<Integer>();
            }
            lines[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        boolean[] used = new boolean[numCourses];
        return canFinishRe(lines,used,dus,numCourses);

    }

    public boolean canFinishRe(List<Integer>[] lines,boolean[] used,int[] dus,int rest) {
        if(rest==0) return true;
        int zero=-1;
        for(int i=0;i<dus.length;i++){
            if(dus[i]==0&&used[i]==false){
                zero=i;
                used[i]=true;
                break;
            }
        }
        if(zero==-1)return false;
        if(lines[zero]!=null){
            lines[zero].iterator().forEachRemaining(integer -> {
                dus[integer]--;
            });
        }
        return canFinishRe(lines,used,dus,rest-1);
    }
    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(2,new int[][]{}));   ;
    }
}
