import java.util.*;
import java.util.stream.IntStream;

import static java.lang.Math.incrementExact;
import static java.lang.Math.max;

class TwoSum {
    /**
     * 1) Given an array of integers nums and an integer target, return indices
     * of the two numbers such that they add up to target. You may assume that each
     * input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        if ((nums.length <= 10000) && (nums.length >= 2) && (target <= 1000000000) && (target >= -1000000000)) {
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] <= 1000000000) && (nums[i] >= -1000000000)) {
                    map.put(nums[i], i);
                } else break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t) && map.get(t) != i) {
                res[0] = i;
                res[1] = map.get(t);
                break;
            }
        }
        return res;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class AddTwoNumbers {
    /**
     * 2) You are given two non-empty linked lists representing two non-negative integers.
     * The digits are stored in reverse order, and each of their nodes contains a single digit.
     * Add the two numbers and return the sum as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}


class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 3) Given a string s, find the length of the
     * longest substring without repeating characters.
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        TreeSet<Character> set = new TreeSet<Character>();
        int result = 1;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                result = max(result, set.size());
            } else {
                while (j < i) {
                    if (s.charAt(j) == c) {
                        j++;
                        break;
                    }
                    set.remove(s.charAt(j));
                    j++;
                }
            }
        }
        return result;
    }
}

class MedianOfTwoSortedArrays {
    /**
     * 4) Given two sorted arrays nums1 and nums2 of size m and n respectively,
     * return the median of the two sorted arrays.
     * The overall run time complexity should be O(log (m+n)).
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        Arrays.sort(arr);
        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2.0;
        } else {
            return arr[arr.length / 2];
        }
    }
}

class LongestPalindromicSubstring {
    /**
     * 5) Given a string s, return the longest palindromic substring in s.
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static int checkPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        int len1 = 0, len2 = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            len1 = checkPalindrome(s, i, i);
            len2 = checkPalindrome(s, i, i + 1);
            len = max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }
}

class ZigzagConversion {
    /**
     * 6) The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * (you may want to display this pattern in a fixed font for better legibility)
     * <p>
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * <p>
     * Write the code that will take a string and make this conversion given a number of rows:
     * <p>
     * string convert(string s, int numRows);
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int curRow = 0;
        boolean grid = false;
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) grid = !grid;
            curRow += grid ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : list) res.append(row);
        return res.toString();
    }
}

class ReverseInteger {
    /**
     * 7) Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit
     * integer range [-231, 231 - 1], then return 0.
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     * <p>
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int xx = 0;
        int x1 = x;
        int count1 = 0;
        int count2 = 0;
        int res = x;
        while (x1 != 0) {
            x1 = x1 / 10;
            count1 += 1;
        }
        while (x != 0) {
            count2 += 1;
            xx += x % 10 * Math.pow(10, count1) / Math.pow(10, count2);
            x = x / 10;
        }
        if ((xx >= Math.pow(2, 31) - 1) || (xx <= -1 * Math.pow(2, 31))) return 0;
        else return xx;
    }
}

class StringToIntegerAtoi {
    /**
     * 8) Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
     * <p>
     * The algorithm for myAtoi(string s) is as follows:
     * <p>
     * Read in and ignore any leading whitespace.
     * Check if the next character (if not already at the end of the string) is '-' or '+'.
     * Read this character in if it is either. This determines if the final result is negative or positive respectively.
     * Assume the result is positive if neither is present. Read in next the characters until the next non-digit
     * character or the end of the input is reached. The rest of the string is ignored.
     * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
     * If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
     * If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that
     * it remains in the range. Specifically, integers less than -231 should be clamped to -231,
     * and integers greater than 231 - 1 should be clamped to 231 - 1. Return the integer as the final result.
     * Note:
     * <p>
     * Only the space character ' ' is considered a whitespace character.
     * Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
     * // * @param s
     *
     * @return
     */

    enum SIGN {
        POS, NEG, UNKNOWN
    }


    public static int myAtoi(String str) {

        String digits = "0123456789";

        int result = 0;

        str = str.trim();

        if (str.equals("") || str.equals("+") | str.equals("-"))
            return 0;

        SIGN sign = SIGN.POS;

        if ((str.charAt(0) == '-') || (str.charAt(0) == '+')) {

            if (str.charAt(0) == '-')
                sign = SIGN.NEG;

            str = str.substring(1);

            if (str.equals(""))
                return 0;
        }

        String[] words = str.split(" ");

        str = words[0];

        if (str.equals(""))
            return 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (digits.indexOf(ch, 0) == -1) {

                str = str.substring(0, i);

                if (str.equals(""))
                    return 0;

                break;
            }
        }

        try {
            result = Integer.parseInt(str);
        } catch (Exception e) {
            if (sign == SIGN.POS)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }

        return sign == SIGN.POS ? result : -result;
    }
}

class PalindromeNumber {
    /**
     * 9) Given an integer x, return true if x is palindrome integer.
     * An integer is a palindrome when it reads the same backward as forward.
     * For example, 121 is a palindrome while 123 is not.
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        int xx = 0;
        int i = 0;
        int res = x;

        if (x < 0) return false;

        while (x != 0) {
            xx = x % 10;
            i = i * 10 + xx;
            x = x / 10;
        }
        if (res == i) return true;
        else return false;
    }
}

class RegularExpressionMatching {
    /**
     * 10) Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
     * <p>
     * '.' Matches any single character.​​​​
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean flag = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (flag && isMatch(s.substring(1), p)));
        } else {
            return flag && isMatch(s.substring(1), p.substring(1));
        }
    }
}

class ContainerWithMostWater {
    /**
     * 11) You are given an integer array height of length n. n
     * There are vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
     * Find two lines that together with the x-axis form a container, such that the container contains the most water.
     * Return the maximum amount of water a container can store.
     * Notice that you may not slant the container.
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int a = 0;
        int n = height.length;
        int b = n - 1;
        int S = 0;
        while (a != b) {
            if (height[a] > height[b]) {
                S = Math.max(S, (b - a) * height[b]);
                b = b - 1;
            } else {
                S = Math.max(S, (b - a) * height[a]);
                a = a + 1;
            }
        }
        return S;
    }
}

class IntegerToRoman {
    /**
     * 12) Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * <p>
     * Symbol
     * I 1
     * V 5
     * X 10
     * L 50
     * C 100
     * D 500
     * M 1000
     * For example, 2 is written as II in Roman numeral, just two one's added together.
     * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     * <p>
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII. Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four. The same principle applies
     * to the number nine, which is written as IX. There are six instances where subtraction is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given an integer, convert it to a roman numeral.
     *
     * @param num
     * @return
     */
    private static String[] ROMENUMBER = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private static int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROMENUMBER.length; i++) {
            while (num >= VALUES[i]) {
                sb.append(ROMENUMBER[i]);
                num -= VALUES[i];
            }
        }
        return sb.toString();
    }
}

class RomanToInteger {
    /**
     * 13)
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer num = null;
            if (i + 2 <= s.length() && map.containsKey(s.substring(i, i + 2))) {
                current += map.get(s.substring(i, i + 2));
                i++;
            } else if (map.containsKey(s.substring(i, i + 1))) {
                current += map.get(s.substring(i, i + 1));
            }
        }
        return current;
    }
}

class LongestCommonPrefix {
    /**
     * 14) Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string "".
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}

class ThirtySum {
    /**
     * 15) Given an integer array nums, return all the triplets
     * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int low = 0;
        int high = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            high = nums.length - 1;
            low = i + 1;
            while (low < high) {
                sum = nums[i] + nums[low] + nums[high];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);

                    set.add(list);
                    low++;
                } else if (sum < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}

class SumClosest {
    /**
     * 16) Given an integer array nums of length n and an integer target,
     * find three integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     */
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length == 0 || nums == null || nums.length < 3 || nums.length > 1000 ||
                target < -10000 || target > 10000) return 0;
        Arrays.sort(nums);
        int nearestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                nearestSum = (Math.abs(sum - target) < Math.abs(nearestSum - target)) ? sum : nearestSum;
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else return target;
            }
        }
        return nearestSum;
    }
}

class LetterCombinationsOfAPhoneNumber {
    /**
     * 17) Given a string containing digits from 2-9 inclusive,
     * return all possible letter combinations that the number could represent.
     * Return the answer in any order.
     * A mapping of digits to letters (just like on the telephone buttons)
     * is given below. Note that 1 does not map to any letters.
     *
     * @param digits
     * @return
     */
    List<String> list = new ArrayList<>();
    Map<String, String> map = new HashMap<>(){{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9","wxyz");
    }};

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) return new ArrayList<>();
        else {backtrack("", digits);}
        return list;
    }
    public void backtrack(String combination, String nextDigits){
        if(nextDigits.length() == 0){
            list.add(combination);
        }else{
            String digit = nextDigits.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }
}

class FourSum {
    /**
     * 18) Given an array numsn of integers, return an array
     * of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
     *
     * 0 <= a, b, c, d < n
     * a, b, c, and d are distinct.
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * You may return the answer in any order.
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return sum(nums, target, 0, 4);
    }
    private List<List<Integer>> sum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length) return res;
        int average_value = target / k;
        if (nums[start] > average_value || average_value > nums[nums.length - 1]) return res;
        if (k == 2) return evenSum(nums, target, start);
        for (int i = 0; i < nums.length; i++) {
            if (i == start || nums[i - 1] !=nums[i]) {
                for (List<Integer> list : sum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(list);
                }
            }
        }
        return res;
    }
    private List<List<Integer>> evenSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int index1 = start, index2 = nums.length - 1;
        while (index1 != nums.length-1) {
            int currSum = nums[index1] + nums[index2];
            if (currSum < target || (index1 > start && nums[index1] == nums[index1-1])) index1++;
            else if (currSum > target || (index2 < nums.length -1 && nums[index2] == nums[index2 + 1])) index2--;
            else res.add(Arrays.asList(nums[index1++], nums[index2--]));
        }
        return res;
    }
}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {
    }

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }
}


class RemoveNthNodeFromEndOfList {
    /**
     * 19) Given the head of a linked list, remove the nth node from the end of the list and return its head.
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode1 removeNthFromEnd(ListNode1 head, int n) {
        if (head == null || n == 0 || (head.next == null && n == 1)) return null;
        int k = 0;
        ListNode1 temp = head;
        while (temp != null) {
            k++;
            temp = temp.next;
        }
        if (k == n) {
            return head.next;
        }
        temp = head;
        for (int i = 1; i < k - n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;

        return head;
    }
}

class WildcardMatching {
    /**
     * 44) Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
     * <p>
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     *
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int ind = -1;
        int match = 0;
        while (i < s.length()) {
            if (i < s.length() && j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                ind = j;
                match = i;
                j++;
            } else if (ind != -1) {
                i = ++match;
                j = ind + 1;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}

class ThreeHundredAndTwentySix {
    /**
     * 326) Given an integer n, return true if it is a power of three. Otherwise, return false.
     * An integer n is a power of three, if there exists an integer x such that n == 3x.
     */
    public static boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n % 3 == 0) {
            n = n / 3;
        }
        if (n == 1) return true;
        else return false;
    }
}

class ThreeHundredAndFortyTwo {
    /**
     * 342) Given an integer n, return true if it is a power of four. Otherwise, return false .
     * An integer n is a power of four, if there exists an integer x such that n == 4x. Could you solve it without loops/recursion?
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n) {
        if (n == 0) return false;

        while (n % 4 == 0) n /= 4;

        if (n == 1) return true;
        else return false;
    }
}

class UTFValidation {
    /**
     * 393 Given an integer array data representing the data, return whether it is a valid UTF-8 encoding
     * (i.e. it translates to a sequence of valid UTF-8 encoded characters).
     * <p>
     * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
     * <p>
     * For a 1-byte character, the first bit is a 0, followed by its Unicode code.
     * For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0,
     * followed by n - 1 bytes with the most significant 2 bits being 10.
     * This is how the UTF-8 encoding would work:
     * <p>
     * Number of Bytes   |        UTF-8 Octet Sequence
     * |              (binary)
     * --------------------+-----------------------------------------
     * 1          |   0xxxxxxx
     * 2          |   110xxxxx 10xxxxxx
     * 3          |   1110xxxx 10xxxxxx 10xxxxxx
     * 4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
     * x denotes a bit in the binary form of a byte that may be either 0 or 1.
     * <p>
     * Note: The input is an array of integers. Only the least significant 8 bits of each integer
     * is used to store the data. This means each integer represents only 1 byte of data.
     *
     * @param data
     * @return
     */
    public static boolean validUtf8(int[] data) {
        int number = 0;
        for (int i = 0; i < data.length; i++) {

            String bin = Integer.toBinaryString(data[i]);
            bin = bin.length() >= 8 ? bin.substring(bin.length() - 8) : "00000000".substring(bin.length() % 8) + bin;

            if (number == 0) {
                for (int j = 0; j < bin.length(); j++) {
                    if (bin.charAt(j) == '0') {
                        break;
                    }
                    number += 1;
                }
                if (number == 0) {
                    continue;
                }
                if (number > 4 || number == 1) {
                    return false;
                }
            } else {
                if (!(bin.charAt(0) == '1' && bin.charAt(1) == '0')) {
                    return false;
                }
            }
            number -= 1;
        }
        return number == 0;
    }
}

class PacificAtlanticWaterFlow {
    /**
     * 417) There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
     * The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches
     * the island's right and bottom edges. The island is partitioned into a grid of square cells.
     * You are given an m x n integer matrix heights where heights[r][c] represents the height above
     * sea level of the cell at coordinate (r, c). The island receives a lot of rain, and
     * the rain water can flow to neighboring cells directly north, south, east, and west if
     * the neighboring cell's height is less than or equal to the current cell's height.
     * Water can flow from any cell adjacent to an ocean into the ocean. Return a 2D list of grid
     * coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci)
     * to both the Pacific and Atlantic oceans.
     */

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        if (heights == null && heights.length == 0) return new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < m; i++) {
            helper(heights, pacific, Integer.MIN_VALUE, 0, i);
            helper(heights, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            helper(heights, pacific, Integer.MIN_VALUE, i, 0);
            helper(heights, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    list.add(new ArrayList<Integer>());
                    list.get(list.size() - 1).add(i);
                    list.get(list.size() - 1).add(j);
                }
            }
        }
        return list;
    }

    private static void helper(int[][] heights, boolean[][] visited, int value, int x, int y) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || heights[x][y] < value) return;
        visited[x][y] = true;
        for (int[] d : dir) {
            helper(heights, visited, heights[x][y], x + d[0], y + d[1]);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class AverageOfLevelsInBinaryTree {
    /**
     * 637) Given the root of a binary tree, return the average value of the nodes on each level
     * in the form of an array. Answers within 10-5 of the actual answer will be accepted.
     */
    List<Double> result = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {

        if (root == null)
            return result;

        averageOfLevel(Collections.singletonList(root));
        return result;
    }

    void averageOfLevel(List<TreeNode> nodes) {
        double sum = 0d;
        List<TreeNode> childs = new ArrayList<>();
        for (TreeNode n : nodes) {
            sum += n.val;
            if (n.left != null)
                childs.add(n.left);
            if (n.right != null)
                childs.add(n.right);
        }

        result.add(sum / nodes.size());

        if (childs.size() > 0)
            averageOfLevel(childs);
    }
}

class ReorderedPowerOfTwo {
    /**
     * 869) You are given an integer n. We reorder the digits in any order
     * (including the original order) such that the leading digit is not zero.
     * Return true if and only if we can do this so that the resulting
     * number is a power of two.
     */
    public static boolean reorderedPowerOf2(int n) {
        String num = String.valueOf(n);
        String[] split = num.split("");
        Arrays.sort(split);
        int power = 1;
        for (int i = 0; i < 31; i++) {
            String str = String.valueOf(power);
            if (str.length() == num.length()) {
                String[] pow = str.split("");
                Arrays.sort(pow);
                if (Arrays.equals(pow, split)) {
                    return true;
                }
            }
            if (str.length() > num.length()) {
                break;
            }
            power *= 2;
        }
        return false;
    }
}

class FindOriginalArrayFromDoubledArray {
    /**
     * 2007) An integer array original is transformed into a doubled array changed by appending
     * twice the value of every element in original, and then randomly shuffling the resulting array.
     * Given an array changed, return original if changed is a doubled array.
     * If changed is not a doubled array, return an empty array.
     * The elements in original may be returned in any order.
     *
     * @param changed
     * @return
     */
    public static int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[0];
        int[] res = new int[changed.length / 2];
        int j = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int x : changed) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (int x : map.keySet()) {
            if (map.getOrDefault(2 * x, 0) < map.get(x)) return new int[0];
            for (int i = 0; i < map.get(x); i++) {
                res[j++] = x;
                map.put(2 * x, map.get(2 * x) - 1);
            }
        }
        return res;
    }
}

class DeleteTheMiddleNodeOfALinkedList {
    /**
     * 2095) You are given the head of a linked list. Delete the middle node,
     * and return the head of the modified linked list.
     * The middle node of a linked list of size n is the ⌊n / 2⌋th node
     * from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.
     * For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        int count = 0;
        ListNode list1 = head, list2 = head;

        while (list1 != null) {
            count += 1;
            list1 = list1.next;
        }

        for (int i = 0; i < count / 2 - 1; i++) {
            list2 = list2.next;
        }
        list2.next = list2.next.next;
        return head;
    }
}

public class Tasks {
    static TreeNode root;

    static {
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
    }

    public static void main(String[] args) {
        ThreeHundredAndFortyTwo.isPowerOfFour(17);

        ThreeHundredAndTwentySix.isPowerOfThree(9);

        int[] xu = {2, 6, 8, 7, 5};
        TwoSum.twoSum(xu, 10);

        System.out.println(ReorderedPowerOfTwo.reorderedPowerOf2(1));
        System.out.println(ReorderedPowerOfTwo.reorderedPowerOf2(10));
        System.out.println(ReorderedPowerOfTwo.reorderedPowerOf2(16));
        System.out.println(ReorderedPowerOfTwo.reorderedPowerOf2(24));
        System.out.println(ReorderedPowerOfTwo.reorderedPowerOf2(46));
        System.out.println(ReorderedPowerOfTwo.reorderedPowerOf2(368407186));
        System.out.println(ReorderedPowerOfTwo.reorderedPowerOf2(679213508));
        System.out.println(ReorderedPowerOfTwo.reorderedPowerOf2(850239671));

        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("anjanjll"));

        System.out.println(new AverageOfLevelsInBinaryTree().averageOfLevels(root));

        System.out.println(LongestPalindromicSubstring.longestPalindrome("babad"));

        int[][] grid = new int[][]{{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(PacificAtlanticWaterFlow.pacificAtlantic(grid));

        System.out.println(ZigzagConversion.convert("PAYPALISHIRING", 4));

        System.out.println(ReverseInteger.reverse(321));

        System.out.println(StringToIntegerAtoi.myAtoi("+6574245"));

        System.out.println(PalindromeNumber.isPalindrome(363));

        int[] changed = {1, 3, 4, 2, 6, 8};
        System.out.print(new FindOriginalArrayFromDoubledArray().findOriginalArray(changed));

        System.out.println(RegularExpressionMatching.isMatch("aa", "a*"));

        System.out.println(WildcardMatching.isMatch("aaaa", "***a") + " T");

        System.out.println(IntegerToRoman.intToRoman(6));

        System.out.println(RomanToInteger.romanToInt("VII"));
    }
}
