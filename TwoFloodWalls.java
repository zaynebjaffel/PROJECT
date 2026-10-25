/**
 * 1B Two Floodwalls
 *
 * Input:  walls[i] = height of the wall at position i (n >= 2, heights >= 0)
 * Output: the largest min(walls[i], walls[j]) * (j - i) over all i < j
 *
 * Keep the class name, method names and parameter types exactly as they are;
 * the test runner looks them up by name. You may add helper methods.
 */
public class TwoFloodWalls {

    /** Brute force solution. Time: O(n^2)  Space: O(1) */
    public static int maxWater(int[] walls) {
        int max = 0;
        for (int i = 0; i < walls.length; i++) {
            for (int j = i + 1; j < walls.length; j++) {
                int height = Math.min(walls[i], walls[j]);
                int width = j - i;
                int area = height * width;
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }
    /** Optimized solution. Time: O(n)    Space: O(1) */
    public static int optimized(int[] walls) {
        int left = 0;
        int right = walls.length - 1;

        int max = 0;
        while (left < right) {
            int height = Math.min(walls[left], walls[right]);
            int width = right - left;
            int area = height * width;
            if (area > max) {
                max = area;
            }
            if (walls[left] < walls[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] walls = {2, 7, 3, 1, 6, 4, 2, 5};
        System.out.println("Brute force: " + maxWater(walls));
        System.out.println("Optimized: " + optimized(walls));
    }


}
