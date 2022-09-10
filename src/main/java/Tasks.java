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
            len2 = checkPalindrome(s, i, i+1);
            len = max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) /2;
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
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     *
     * Write the code that will take a string and make this conversion given a number of rows:
     *
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
            curRow += grid ? 1 : -1 ;
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
     *
     // * @param x
     * @return
     */
   /* public int reverse(int x) {

    }*/
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
            helper(heights, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++) {
            helper(heights, pacific, Integer.MIN_VALUE, i, 0);
            helper(heights, atlantic, Integer.MIN_VALUE, i, m-1);
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
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || heights[x][y] < value) return;
        visited[x][y] = true;
        for (int[] d : dir) {
            helper(heights, visited, heights[x][y], x+d[0], y+d[1]);
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

        //call on root first
        averageOfLevel(Collections.singletonList(root));
        return result;
    }

    void averageOfLevel(List<TreeNode> nodes) {
        double sum = 0d;
        //store all children of current node(s) in list
        List<TreeNode> childs = new ArrayList<>();
        for (TreeNode n : nodes) {
            //sum all node(s) vals
            sum += n.val;
            if (n.left != null)
                childs.add(n.left);
            if (n.right != null)
                childs.add(n.right);
        }

        //add average to shared results
        result.add(sum / nodes.size());

        //if we had noticed any child from current node(s), recursively call the func again
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
    }
}
