import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    }
}
