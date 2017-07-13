package com.codingdie.leetcode;

import javax.xml.transform.Source;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xupen on 2017/7/13.
 */
public class TestUtil {
    public  static  char[][] getCharArray(String[] strings){
        char[][] result=new char[strings.length][strings[0].length()];
        List<char[]> chars=Arrays.stream(strings).map(s -> {
            return s.toCharArray();
        }).collect(Collectors.toList());
        for(int i=0;i<chars.size();i++){
            result[i]=chars.get(i);
        }
        return result;
    }
    public  static  void printArray(char[][] chars){
        for(int i=0;i<chars.length;i++){
            for(int j=0;j<chars[i].length;j++){
                System.out.print(chars[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public  static  void printArray(int[][] chars){
        for(int i=0;i<chars.length;i++){
            for(int j=0;j<chars[i].length;j++){
                System.out.print(chars[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println();

    }
    public  static  void printArray(int[] chars){
        for(int i=0;i<chars.length;i++){
            System.out.print(chars[i]+"  ");
        }
        System.out.println();

    }
}
