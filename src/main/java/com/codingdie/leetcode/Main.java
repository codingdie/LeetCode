package com.codingdie.leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xupeng on 17-8-25.
 */
public class Main {
    static class Model {
        public long price;
        public long length;
        public long width;
        public long height;

    }

    private static long boxMinNum;
    private static Model[] items;
    private static Model boxTemplate = new Model();


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        boxTemplate.price = 2000;

        while (scanner.hasNext()) {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            boxMinNum = Integer.MAX_VALUE;
//            System.out.println (process());

        }
    }


}
