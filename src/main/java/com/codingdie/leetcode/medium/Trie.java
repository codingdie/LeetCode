package com.codingdie.leetcode.medium;

/**
 * Created by xupen on 2017/7/13.
 */
public class Trie {

    private Node root;


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node('\0');
    }


    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        insertNode(root, word.toCharArray(),0);
    }

    public void insertNode(Node node, char[] word,int charIndex) {
        if (word.length == charIndex) {
            node.isWord=true;
            return;
        }
        int index = word[charIndex] - 'a';
        if (node.nodes[index] == null) {
            node.nodes[index] = new Node(word[charIndex]);
        }
        insertNode(node.nodes[index], word,charIndex+1);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return searchNode(root, word.toCharArray(),0);
    }

    public boolean searchNode(Node node, char[] word,int charIndex) {
        if (word.length == charIndex ) {
            if (node.isWord) return true;
            else return false;
        }
        if (node == null) return false;
        char ch = word[charIndex];
        int index = ch - 'a';

        if (node.nodes[index] != null && node.nodes[index].ch == ch) {
            return searchNode(node.nodes[index], word,charIndex+1);
        } else {
            return false;
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix.toCharArray(),0);
    }

    public boolean startsWith(Node node, char[] word,int charIndex) {
        if (word.length == charIndex) return true;
        if (node == null) return false;
        char ch = word[charIndex];
        int index = ch - 'a';
        if (node.nodes[index] != null && node.nodes[index].ch == ch) {
            return startsWith(node.nodes[index], word,charIndex+1);
        } else {
            return false;
        }
    }

    public class Node {
        char ch = '\0';
        boolean isWord = false;
        Node[] nodes = new Node[26];

        public Node(char ch) {
            this.ch = ch;
        }
    }
}
