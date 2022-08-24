class TwoSum {
    /** 1) Given an array of integers nums and an integer target, return indices
     * of the two numbers such that they add up to target. You may assume that each
     * input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     */
    public int[] twoSum(int[] nums, int target) {

    }
}

class ThreeHundredAndTwentySix {
    /** 326) Given an integer n, return true if it is a power of three. Otherwise, return false.
     * An integer n is a power of three, if there exists an integer x such that n == 3x.
     */
    public static boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        while (n % 3 == 0) {
            n=n / 3;
        }
        if (n == 1) return true;
        else return false;
    }
}

public class ThreeHundredAndFortyTwo {
    /**
     * 342) Given an integer n, return true if it is a power of four. Otherwise, return false .
     * An integer n is a power of four, if there exists an integer x such that n == 4x. Could you solve it without loops/recursion?
     * @param n
     * @return
     */
    public static boolean isPowerOfFour(int n) {
        if (n == 0) return false;

        while (n % 4 == 0) n /= 4;

        if(n==1) return true;
        else return false;
    }


    public static void main(String[] args) {
        isPowerOfFour(17);
        ThreeHundredAndTwentySix.isPowerOfThree(9);
    }
}
