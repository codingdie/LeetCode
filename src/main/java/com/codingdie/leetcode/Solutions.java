package com.codingdie.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by xupeng on 2017/6/30.
 */
public class Solutions {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur1 = l1, cur2 = l2, curnew = null, newlist = null;
        int carray = 0;
        while (cur1 != null || cur2 != null) {
            int val1 = cur1 == null ? 0 : cur1.val;
            int val2 = cur2 == null ? 0 : cur2.val;

            int sum = val1 + val2 + carray;
            ListNode tmp = new ListNode(sum % 10);
            carray = sum / 10;
            if (newlist == null) {
                newlist = tmp;
                curnew = newlist;
            } else {
                curnew.next = tmp;
                curnew = curnew.next;
            }
            if (cur1 != null) {
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                cur2 = cur2.next;
            }
        }
        if (curnew != null && carray != 0) {
            curnew.next = new ListNode(carray);
        }
        return newlist;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int j = 0, i = 0, k = 0;
        int total = nums1.length + nums2.length;
        boolean flag = (total & 1) == 0;
        int sum = 0;
        int mid = total / 2;

        int t = 0;
        while (i < nums1.length || j < nums2.length) {
            k++;
            if (i >= nums1.length) {
                j++;
                t = 1;
            } else if (j >= nums2.length) {
                i++;
                t = 0;
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                    t = 0;
                } else {
                    j++;
                    t = 1;
                }
            }

            if (flag) {
                if ((i + j) == mid || (i + j) == mid + 1) {
                    sum += t == 1 ? nums2[j - 1] : nums1[i - 1];
                }

            } else {
                if ((i + j) == mid + 1) {
                    sum += t == 1 ? nums2[j - 1] : nums1[i - 1];
                }
            }
        }
        System.out.println("循环次数:" + k + "\t数组大小:" + total);
        return flag ? sum / 2.0 : sum;
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int j = 0, i = 0;
        int total = nums1.length + nums2.length;
        boolean flag = (total & 1) == 0;
        int sum = 0;
        int mid = total / 2;
        int t = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                j++;
                t = 1;
            } else if (j >= nums2.length) {
                i++;
                t = 0;
            } else {
                if (nums1[i] < nums2[j]) {
                    i++;
                    t = 0;
                } else {
                    j++;
                    t = 1;
                }
            }

            if (flag) {
                if ((i + j) == mid || (i + j) == mid + 1) {
                    sum += t == 1 ? nums2[j - 1] : nums1[i - 1];
                }

            } else {
                if ((i + j) == mid + 1) {
                    sum += t == 1 ? nums2[j - 1] : nums1[i - 1];
                }
            }
        }
        return flag ? sum / 2.0 : sum;
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < numRows; i++) {
            int j = i;
            while (j < length) {
                stringBuffer.append(s.charAt(j));
                if (i != 0 && i != numRows - 1) {
                    int k = 2 * numRows - 2 - 2 * i + j;
                    if (k < length) {
                        stringBuffer.append(s.charAt(k));
                    }
                }
                j += 2 * numRows - 2;
            }
        }
        return stringBuffer.toString();
    }

    public static int reverse(int x) {
        int result = 0;


        while (((x >> 31 == 0 ? x : (~x + 1))) > 0) {

            int newresult = result * 10 + x % 10;
            if (newresult / 10 != result) {
                return 0;
            }
            result = newresult;
            x = x / 10;
        }

        return result;
    }

    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        int begin = 0;
        int result = 0;
        int f = 1;
        char c = str.charAt(0);
        if (c == '+') {
            begin = 1;
        }
        if (c == '-') {
            begin = 1;
            f = -1;
        }
        for (int i = begin; i < str.length(); i++) {
            int charint = str.charAt(i) - 48;
            if (charint < 0 || charint > 9) {
                break;
            }
            int newresult = result * 10 + charint * f;
            if (newresult / 10 != result) {
                return f == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = newresult;
        }
        return result;
    }

    public static boolean isPalindrome(int x) {

        int result = 0, tmp = x;
        while (tmp > 0) {
            result = result * 10 + tmp % 10;
            tmp /= 10;
        }
        return x == result;
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        int i1 = height[i];
        int j1 = height[j];
        while (i != j) {
            boolean b = i1 < j1;
            int tmp = (b ? i1 : j1) * (j - i);
            if (tmp > max) {
                max = tmp;
            }
            if (b) {
                i++;
            } else {
                j--;
            }
            i1 = height[i];
            j1 = height[j];
        }
        return max;
    }

    public static int get(char i) {
        switch (i) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 100;
            default:
                return 0;
        }
    }

    public static int romanToInt(String s) {
        int result = 0;

        int i = s.length() - 1;
        while (i >= 0) {
            char no = s.charAt(i);
            result += get(no);
            if (i - 1 >= 0) {
                int i1 = get(no) / get(s.charAt(i - 1));
                if (i1 == 10 || i1 == 5) {
                    result -= get(s.charAt(i - 1));
                    i--;
                }
            }
            i--;
        }
        return result;

    }

    public static String intToRoman(int num) {
        char[][] arr = {
                {'I', 'V'},
                {'X', 'L'},
                {'C', 'D'},
                {'M'}
        };
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        int k = 0;
        while (num > 0) {
            buffer.setLength(0);
            int i = num % 10;
            num /= 10;
            if (i == 0) {
                k++;
                continue;
            }
            if (i >= 1 && i <= 3) {
                for (int j = 0; j < i; j++) {
                    buffer.append(arr[k][0]);
                }
            } else if (i == 4) {
                buffer.append(arr[k][1]);
                buffer.append(arr[k][0]);
            } else if (i < 9) {
                for (int j = 0; j < i - 5; j++) {
                    buffer.append(arr[k][0]);
                }
                buffer.append(arr[k][1]);

            } else if (i == 9) {

                buffer.append(arr[k + 1][0]);
                buffer.append(arr[k][0]);

            }
            stringBuffer.append(buffer.toString());
            k++;

        }
        return stringBuffer.reverse().toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        boolean flag = true;
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (flag) {
            if (i >= strs[0].length()) {
                break;
            }
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    flag = false;
                    break;
                }
            }
            i++;
            if (flag) {
                stringBuffer.append(ch);
            }
        }
        return stringBuffer.toString();
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] < 0 || nums[0] > 0) {
            return lists;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int total = nums[j] + nums[k] + nums[i];
                int numk = nums[k];
                int numj = nums[j];
                if (total == 0) {
                    lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (--k > j && nums[k] == numk) {
                    }
                    while (++j < k && nums[j] == numj) {
                    }
                }
                if (total > 0) {
                    while (--k > j && nums[k] == numk) {

                    }

                }
                if (total < 0) {
                    while (++j < k && nums[j] == numj) {

                    }
                }
            }

        }
        return lists;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        char[][] chars = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'},
        };

        for (int j = 0; j < digits.length(); j++) {
            List<String> stringList1 = new ArrayList<>();
            char[] chars1 = chars[digits.charAt(j) - 50];
            for (char ch : chars1) {
                if (result.size() > 0) {
                    for (int i = 0; i < result.size(); i++) {
                        stringList1.add(result.get(i) + ch);
                    }
                } else {
                    stringList1.add(String.valueOf(ch));
                }

            }
            result = stringList1;
        }

        return result;

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return lists;
        }
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 3; i++) {

            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int numi = nums[i];
            if (numi > target && numi >= 0) {
                break;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                int m = j + 1;
                int n = nums.length - 1;
                int numj = nums[j];

                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if (nums[i] + nums[j] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue;
                while (m < n) {
                    int numk = nums[n];
                    int numm = nums[m];

                    int total = nums[m] + nums[n] + nums[i] + nums[j];

                    if (total == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[m], nums[n]));
                        while (--n > m && nums[n] == numk) {
                        }
                        while (++m < n && nums[m] == numm) {
                        }
                    }
                    if (total > target) {
                        while (--n > m && nums[n] == numk) {

                        }
                    }
                    if (total < target) {
                        while (++m < n && nums[m] == numm) {

                        }
                    }
                }

                int k = j;
                while (++k < nums.length && nums[k] == numj) {
                    j++;
                }
            }
        }
        return lists;
    }

    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int index = -1;
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack[++index] = ch;
            }

            if (ch == ')') {
                if (index == -1) {
                    return false;
                }
                if (stack[index--] != '(') {
                    return false;
                }
                ;
            }
            if (ch == ']') {
                if (index == -1) {
                    return false;
                }
                if (stack[index--] != '[') {
                    return false;
                }
                ;
            }
            if (ch == '}') {
                if (index == -1) {
                    return false;
                }
                if (stack[index--] != '{') {
                    return false;
                }
                ;
            }
        }
        return index == -1;
    }


    public static List<String> generateParenthesis(int n) {

        List<String> stringList = new ArrayList<>();
        char[] str = new char[n * 2];
        generateParenthesis(n, n, n, str, 0, stringList);
        return stringList;

    }

    public static void generateParenthesis(int i, int j, int n, char[] str, int index, List<String> result) {
        if (i > j) {
            return;
        }
        if (index == 2 * n) {
            result.add(String.valueOf(str));
            return;
        }

        if (i > 0) {
            str[index] = '(';
            generateParenthesis(i - 1, j, n, str, index + 1, result);

        }
        if (j > 0 && index > 0) {
            str[index] = ')';
            generateParenthesis(i, j - 1, n, str, index + 1, result);
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.length, (o1, o2) -> {
            return o1.val - o2.val;
        });

        for (ListNode listNode : lists) {
            if (listNode != null) {
                priorityQueue.add(listNode);
            }

        }
        ListNode head = null, headptr = null;
        while (priorityQueue.size() > 0) {
            ListNode peek = priorityQueue.peek();
            if (head == null) {
                head = peek;
                headptr = head;
            } else {
                headptr.next = peek;
                headptr = headptr.next;
            }
            priorityQueue.remove();
            if (peek.next != null) {
                priorityQueue.add(peek.next);
            }
        }
        return head;
    }

//    public static ListNode mergeKLists1(ListNode[] lists) {
//        if (lists.length == 0) {
//            return null;
//        }
//        return mergeKListsStep1(lists, 0, lists.length - 1);
//    }

//    public static ListNode mergeKListsStep1(ListNode[] lists, int i, int j) {
//        if (i < j) {
//            if (j - i == 0) {
//                return mergeTwoLists(lists[i], lists[j]);
//            }
//            int k = (i + j) / 2;
//
//            return mergeTwoLists(mergeKListsStep1(lists, i, k), mergeKListsStep1(lists, k + 1, j));
//        } else {
//            return lists[i];
//        }
//
//    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = nums[0];
        int l = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != i) {
                l++;
                i = nums[j];
                nums[l] = i;
            }
        }
        return l;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ptr = head;
        ListNode ptrPre = null;
        while (ptr != null) {
            if (ptr.next != null) {
                ListNode after = ptr.next.next;
                if (ptrPre != null) {
                    ptrPre.next = ptr.next;
                }
                ptrPre = ptr;
                ptr.next.next = ptr;
                ptr.next = after;
                ptr = after;

            } else {
                break;
            }
        }
        return head.next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode ptr = head;
        ListNode ptrPre = null;
        ListNode result = head;
        ListNode[] nodes = new ListNode[k];
        while (ptr != null) {
            int n = 0;
            while (n < k) {
                nodes[n] = ptr;
                if (nodes[n] == null) {
                    break;
                }
                ptr = ptr.next;
                n++;
            }
            if (n != k) {
                break;
            } else {
                ListNode afterNode = nodes[k - 1].next;
                for (int i = 0; i < k / 2; i++) {
                    ListNode tmp = nodes[i];
                    nodes[i] = nodes[k - i - 1];
                    nodes[k - i - 1] = tmp;
                }
                if (ptrPre != null) {
                    ptrPre.next = nodes[0];
                } else {
                    result = nodes[0];
                }
                ptrPre = nodes[k - 1];
                nodes[k - 1].next = afterNode;
                for (int i = 0; i < k - 1; i++) {
                    nodes[i].next = nodes[i + 1];
                }
            }

        }
        return result;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) {
            return head;
        }
        int i = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            i++;
        }
        if (n > i) {
            return head;
        }

        ListNode pre = null;
        ptr = head;
        int k = 0;
        while (k < i - n) {
            pre = ptr;
            ptr = ptr.next;
            k++;
        }
        if (pre == null) {
            return head.next;
        } else {
            pre.next = ptr.next;
            return head;
        }

    }

    public static void henei(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("Move " + n + " from " + A + "  to " + C);
        } else {
            henei(n - 1, A, C, B);
            System.out.println("Move " + n + " from " + A + " to " + C);
            henei(n - 1, B, A, C);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int l = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[l++] = nums[i];
            }
        }

        return l;
    }

    public static int[] next(char[] str) {

        int[] next = new int[str.length];
        next[0] = 0;
        for (int i = 1; i < str.length; i++) {
            int k = next[i - 1];
            if (str[i] == str[k]) {
                next[i] = next[i - 1] + 1;
            } else {
                while (k > 0) {
                    k = next[k];
                    if (str[i] == str[k]) {
                        next[i] = next[k] + 1;
                    }
                }
            }
        }
        return next;
    }

    public static int indexOf(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        char[] str1 = haystack.toCharArray();
        char[] str2 = needle.toCharArray();
        int[] next = new int[str2.length];
        next[0] = 0;
        for (int i = 1; i < str2.length; i++) {
            int k = next[i - 1];
            if (str2[i] == str2[k]) {
                next[i] = next[i - 1] + 1;
            } else {
                int r = i - 1;
                while (k < r) {
                    if (str2[i] == str2[k]) {
                        next[i] = next[k] + 1;
                        break;
                    }
                    r = k;
                    if (k == 0) break;
                    k = next[k - 1];
                }
            }
        }
        for (int i = 0; i <= str1.length - str2.length; ) {
            boolean flag = true;
            for (int j = 0; j < str2.length; j++) {
                if (str1[i + j] != str2[j]) {
                    flag = false;
                    int move = j - next[(j - 1) > 0 ? (j - 1) : 0];
                    i += move > 0 ? move : 1;
                    break;
                }
            }
            if (flag) return i;

        }
        return -1;
    }

    public static int longestValidParentheses(String s) {
        char[] str = s.toCharArray();
        char[] stack = new char[s.length() / 2];
        int index = -1;
        int start = 0;
        int max = 0;
        for (int j = 0; j < str.length; ) {
            index = -1;
            int l = 0;
            int maxl = 0;
            for (int i = j; i < str.length; i++) {
                char ch = str[i];
                if (ch == '(') {
                    if (index + 1 >= stack.length) {
                        break;
                    }
                    stack[++index] = ch;
                }
                if (ch == ')') {
                    if (index == -1) {
                        break;
                    }
                    if (stack[index] != '(') {
                        break;
                    }
                    index--;
                    l++;
                    if (l > maxl & index == -1) {
                        maxl = l;
                    }
                }
            }
            if (maxl > max) {
                max = maxl;
            }
            if (maxl != 0) {
                j = j + maxl * 2;
            } else {
                j++;
            }

        }
        return max * 2;
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        if (a < b) {
            return 0;
        }
        int k = 0;
        long res = 1;
        while (true) {
            if ((b << (k + 1)) > a) {
                break;
            }
            res = res << 1;


            k++;
        }
        long l = a - (b << k);
        if (l >= b) {
            res += divide((int) l, (int) b);
        }

        if ((dividend ^ divisor) >> 31 == 0) {
            return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
        } else {
            return (int) (-res);
        }

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        combinationSumR(candidates, target, 0, integers, lists);

        return lists;
    }

    public static void combinationSumR(int[] candidates, int target, int i, List<Integer> cur, List<List<Integer>> lists) {

        if (target == 0) {
            List<Integer> integers = new ArrayList<>();
            integers.addAll(cur);
            lists.add(integers);
            return;
        }

        for (; i < candidates.length && candidates[i] <= target; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i]) continue;
            cur.add(candidates[i]);
            combinationSumR(candidates, target - candidates[i], i + 1, cur, lists);
            cur.remove(cur.size() - 1);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return lists;
        permute(nums, 0, lists);
        return lists;
    }

    public static void permute(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length - 1) {
            List list = new ArrayList();
            for (int n : nums) {
                list.add(n);
            }
            res.add(list);
            return;
        }
        int j = i;
        for (; i < nums.length; i++) {
            int tmp = nums[i];
            if (i > j) {
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            permute(nums, j + 1, res);
            if (i > j) {
                nums[j] = nums[i];

                nums[i] = tmp;
            }
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return lists;
        permuteUnique(nums, used, integers, lists);
        return lists;
    }

    public static void permuteUnique(int[] nums, boolean[] used, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            List list = new ArrayList(cur);

            res.add(list);
            return;
        }
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == false) {
                if (last != -1 && nums[last] == nums[i]) continue;
                cur.add(nums[i]);
                used[i] = true;
                permuteUnique(nums, used, cur, res);
                used[i] = false;
                cur.remove(cur.size() - 1);
                last = i;
            }

        }
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = 1;
        for (long i = 0; i < Math.abs((long) n); i++) {
            double tmp = v * x;
            if (tmp > Double.MAX_VALUE) {
                if (n > 0) {
                    return Double.MAX_VALUE;
                } else {
                    return 0;
                }
            }
            if (Math.abs(v) == Math.abs(tmp)) {
                return v;
            }
            v = tmp;
            if (v == 0) {
                return 0;
            }
        }
        return (n > 0 ? v : 1 / v);
    }

    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int z1 = 0, z2 = 0;
        StringBuffer zero = new StringBuffer();
        for (int i = length1 - 1; i >= 0; i--) {
            if (num1.charAt(i) == '0') {
                z1++;
                zero.append('0');
            } else {
                break;
            }
        }
        for (int i = length2 - 1; i >= 0; i--) {
            if (num2.charAt(i) == '0') {
                zero.append('0');
                z2++;
            } else {
                break;
            }
        }
        List<String> integers = new ArrayList<String>();
        int jl = length2 - z2;
        int il = length1 - z1;
        for (int j = jl - 1; j >= 0; j--) {
            char chj = num2.charAt(j);
            int jn = (chj - 48);

            char[] chars = new char[length1 - z1 + 1];
            StringBuffer stringBuffer = new StringBuffer();
            int res = 0;
            for (int i = il - 1; i >= 0; i--) {
                char chi = num1.charAt(i);
                int in = (chi - 48);

                int result = in * jn + res;

                stringBuffer.append(result % 10);
                res = result / 10;
            }

            if (res != 0) {
                stringBuffer.append(res);
            }
            integers.add(stringBuffer.toString());

        }
        int k = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int res = 0;

        int size = integers.size();
        int minSize = size - 1 + integers.get(size - 1).length();

        for (int m = 0; m < minSize; m++) {
            int total = 0;

            for (int i = 0; i < integers.size(); i++) {
                String str = integers.get(i);
                int j = m - i;
                if (j >= 0 && j < str.length()) {
                    int i1 = str.charAt(j) - 48;
                    total += i1;
                }
            }

            System.out.println(total);
            total += res;
            stringBuffer.append(total % 10);

            res = total / 10;
        }
        if (res > 0) {
            stringBuffer.append(res);
        }
        return stringBuffer.reverse().append(zero).toString();
    }

    public static int trap(int[] height) {
        return 0;
    }

    public static void main(String args[]) {

        System.out.println(multiply("6", "501"));
    }

    public static ListNode buildList(int[] arry) {
        ListNode listNode = null, tmp = null;
        for (int value : arry) {
            if (listNode == null) {
                listNode = new ListNode(value);
                tmp = listNode;
            } else {
                tmp.next = new ListNode(value);
                tmp = tmp.next;
            }
        }
        return listNode;
    }

    public int threeSumClosest(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int total = nums[j] + nums[k] + nums[i];
                int numk = nums[k];
                int numj = nums[j];
                int cur = total - target;

                if (cur == 0) {
                    return target;
                } else {
                    int curAbs = Math.abs(cur);
                    int resultAbs = Math.abs(result);
                    if (curAbs < resultAbs) {
                        result = cur;
                    }

                    if (cur < 0) {
                        while (++j < k && nums[j] == numj) {

                        }
                    } else {
                        while (--k > j && nums[k] == numk) {

                        }
                    }
                }

            }

        }
        return result + target;
    }

    //    public void nextPermutation(int[] nums) {
//       int i=0;
//
//    }
//    public static String countAndSay(int n) {
//        if (n == 1) {
//            return "1";
//        }
//        String s = countAndSay(n - 1);
//        int k = 0;
//        StringBuffer stringBuffer = new StringBuffer();
//        for (int i = 0; i < s.length(); i++) {
//            k++;
//            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
//                continue;
//            } else {
//                stringBuffer.append(k).append(s.charAt(i));
//                k = 0;
//            }
//        }
//        return stringBuffer.toString();
//    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (target < nums[0]) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    return i;
                }
                if (target > nums[i]) {
                    return -1;
                }
                if (i - 1 >= 0) {
                    if (nums[i - 1] > nums[i]) {
                        return -1;
                    }
                }
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
                if (i + 1 < nums.length) {
                    if (nums[i + 1] < nums[i]) {
                        return -1;
                    }
                }
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int[] result = new int[]{-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                return result;
            }
            if (nums[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                }
                result[1] = i;
            }

        }
        return result;
    }

    public int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int i = 0, j = nums.length - 1;
        while (j - 1 > i) {
            int k = (j + i) / 2;
            if (nums[k] == target) {
                return k;
            } else if (nums[k] < target) {
                i = k;

            } else {

                j = k;

            }
        }
        if (nums[i] == target) {
            return i;
        } else {
            return i + 1;
        }

    }

    public boolean isValidSudoku(char[][] board) {
        int[] hash = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < hash.length; k++) {
                hash[k] = 0;
            }
            for (int j = 0; j < 9; i++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                if (hash[ch - 49] == 1) {
                    return false;
                } else {
                    hash[ch - 49] = 1;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < hash.length; k++) {
                hash[k] = 0;
            }
            for (int j = 0; j < 9; i++) {
                char ch = board[j][i];
                if (ch == '.') {
                    continue;
                }
                if (hash[ch - 49] == 1) {
                    return false;
                } else {
                    hash[ch - 49] = 1;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; i++) {
                for (int k = 0; k < hash.length; k++) {
                    hash[k] = 0;
                }
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        char ch = board[i * 3 + m][j * 3 + n];
                        if (ch == '.') {
                            continue;
                        }
                        if (hash[ch - 49] == 1) {
                            return false;
                        } else {
                            hash[ch - 49] = 1;
                        }
                    }
                }
            }
        }


        return true;
    }

    public String longestPalindrome(String s) {
        if (s.isEmpty()) return "";
        if (s.length() == 1) return s;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#");
        for (char ch : s.toCharArray()) {
            stringBuffer.append(ch).append("#");
        }
        s = stringBuffer.toString();
        int length = s.length();
        int[] table = new int[length];
        int maxRight = 0, pos = 0, max = 1, maxpos = 0;
        char maxCh = '#';
        for (int i = 0; i < length && maxRight < length - 1; i++) {
            int j = 2 * pos - i;
            if (i < maxRight) {
                if (table[j] < maxRight - i) {
                    table[i] = table[j];
                } else {
                    int k = maxRight - i;
                    int m = i - (k), n = i + (k);
                    while (--m >= 0 && ++n < length && s.charAt(m) == s.charAt(n)) {
                        k++;
                    }
                    table[i] = k;
                    maxRight = i + k - 1;
                    pos = i;
                    if (k > max || (k == max && s.charAt(i) != '#' && maxCh == '#')) {
                        max = k;
                        maxpos = i;
                        maxCh = s.charAt(i);
                    }
                }
            } else {
                int m = i, n = i;
                int k = 1;
                while (--m >= 0 && ++n < length && s.charAt(m) == s.charAt(n)) {
                    k++;
                }
                table[i] = k;
                maxRight = i + k - 1;
                pos = i;
                if (k > max || (k == max && s.charAt(i) != '#' && maxCh == '#')) {
                    max = k;
                    maxpos = i;
                    maxCh = s.charAt(i);
                }
            }

        }
        StringBuffer resultBuffer = new StringBuffer();
        for (int i = maxpos - max + 1; i < maxpos + max; i++) {
            char charAt = stringBuffer.charAt(i);
            if (charAt != '#') {
                resultBuffer.append(charAt);
            }
        }
        return resultBuffer.toString();
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];

        int lastSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum;
            if (lastSum > 0) {
                sum = lastSum + nums[i];
            } else {
                sum = nums[i];
            }
            if (sum > max) {
                max = sum;
            }
            lastSum = sum;
        }
        return max;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        void print() {
            ListNode t = this;
            StringBuffer stringBuffer = new StringBuffer();
            while (t != null) {
                stringBuffer.append(t.val + ",");
                t = t.next;
            }
            System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));
        }
    }
}
