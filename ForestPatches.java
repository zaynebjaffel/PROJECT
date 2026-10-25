/**
 * 2B Forest Patches
 *
 * Input:  grid of 0s and 1s (1 = trees), at least 1x1
 * Output: the number of separate forest patches
 *
 * Keep the class name, method names and parameter types exactly as they are;
 * the test runner looks them up by name. You may add helper methods.
 */
public class ForestPatches {
    /** Brute force solution. Time: O(n)  Space: O(n) */
    public static int brute(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        int patches = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 1) {
                    patches++;
                    removeTrees(map, i, j);
                }
            }
        }
        return patches;
    }
    private static void removeTrees(int[][] map, int row, int col) {
        int rows = map.length;
        int cols = map[0].length;
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            map[row][col] == 0) {
            return;
        }
        map[row][col] = 0;
        removeTrees(map, row - 1, col);
        removeTrees(map, row + 1, col);
        removeTrees(map, row, col - 1);
        removeTrees(map, row, col + 1);
    }
    /** Optimized solution. Time: O(n)  Space: O(n) */
public static int optimized(int[][] map) {
        int rows = map.length;
        int cols = map[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int patches = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    patches++;
                    explore(map, visited, i, j);
                }
            }
        }
        return patches;
    }
    private static void explore(
            int[][] map, boolean[][] visited, int row, int col) {
        int rows = map.length;
        int cols = map[0].length;
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols ||
            map[row][col] == 0 ||
            visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        explore(map, visited, row - 1, col);
        explore(map, visited, row + 1, col);
        explore(map, visited, row, col - 1);
        explore(map, visited, row, col + 1);
    }
    public static void main(String[] args) {
    int[][] map = {
        {1, 1, 0, 0},
        {0, 1, 0, 1},
        {0, 0, 0, 1},
        {1, 0, 0, 0}
    };
    System.out.println("Forest patches: " + optimized(map));
}
}
