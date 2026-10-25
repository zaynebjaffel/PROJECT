/**
 * 1B Two Floodwalls
 *
 * Input:  walls[i] = height of the wall at position i (n >= 2, heights >= 0)
 * Output: the largest min(walls[i], walls[j]) * (j - i) over all i < j
 *
 * Keep the class name, method names and parameter types exactly as they are;
 * the test runner looks them up by name. You may add helper methods.
 */
public class TwoFloodwalls {

    /** Brute force solution. Time: O(?)  Space: O(?) */
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



    /** Optimized solution. Time: O(?)  Space: O(?) */
    public static int optimized(int[] walls) {
        // TODO
        return 0;
    }

}
