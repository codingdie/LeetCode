package com.codingdie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by xupen on 2017/7/6.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,(o1, o2) -> {
            return o1.start-o2.start;
        });
        Interval tmp=null;
        List<Interval> result=new ArrayList<>();
        for(int i=0;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if(tmp==null){
                tmp= interval;
                result.add(tmp);
            }else{
                if(interval.start<=tmp.end){
                    if(interval.end>tmp.end){
                        tmp.end=interval.end;
                    }
                }else{
                    tmp=interval;
                    result.add(tmp);
                }
            }
        }
        return  intervals;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
