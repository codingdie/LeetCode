package com.codingdie.leetcode;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by xupen on 2017/7/6.
 */
public class WordSearch {
    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{"aa".toCharArray()}, "aaa"));

    }

    public boolean exist(char[][] board, String word) {

        char[] wordch = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == wordch[0]) {
                    board[i][j]='\0';
                    if (existRe(board, i, j, wordch, 1)) {
                        return true;
                    }else{
                        board[i][j]=wordch[0];

                    }
                }
            }
        }
        return false;
    }

    public boolean existRe(char[][] board, int i, int j, char[] ch, int index) {
        if (index == ch.length) {
            return true;
        }
        char c = ch[index];
        if (i + 1 < board.length && board[i + 1][j] == c) {
            board[i + 1][j]='\0';
            if(existRe(board, i+1, j, ch, index+1)){
                return true;
            }
            board[i + 1][j]=c;
        }
        if (i - 1 >= 0 && board[i - 1][j] == c) {
            board[i - 1][j]='0';

            if(existRe(board, i-1, j, ch, index+1)){
                return true;
            }
            board[i - 1][j]=c;

        }
        if (j - 1 >=0 && board[i][j - 1] == c ) {
            board[i ][j- 1]='0';

            if(existRe(board, i, j-1, ch, index+1)){
                return true;
            }
            board[i ][j- 1]=c;


        }
        if (j + 1 < board[i].length && board[i][j + 1] == c ) {
            board[i ][j+ 1]='0';
            if(existRe(board, i, j+1, ch, index+1)){
                return true;
            }
            board[i ][j+ 1]=c;

        }
        return false;

    }
}
