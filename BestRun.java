/**
 * 3B Food Truck's Best Run
 *
 * Input:  daily net profit, may be negative (n >= 1)
 * Output: the largest total of a non-empty run of consecutive days
 *
 * Keep the class name, method names and parameter types exactly as they are;
 * the test runner looks them up by name. You may add helper methods.
 */
public class BestRun {

    /** Brute force solution. Time: O(n^2)  Space: O(1) */
     public static int brute(int[] profit) {
        int n = profit.length;
        int maxSum = profit[0];
        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += profit[j];

                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
    /** Optimized solution. Time: O(n)  Space: O(1) */
    public static int optimized(int[] profit) {
        int maxSum = profit[0];
        int currentSum = profit[0];
        for (int i = 1; i < profit.length; i++) {
            currentSum = Math.max(profit[i], currentSum + profit[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        int[] profit = {3, -5, 4, -1, 2, 6, -9, 5};

        System.out.println("Brute force: " + brute(profit));
        System.out.println("Optimized: " + optimized(profit));
    }

}
