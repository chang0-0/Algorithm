package TEST;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private static int maxSum = 0;

    public static void main(String[] args) {
        int[][] garden = {
                {2, 1, 3, 3},
                {5, 1, 2, 1},
                {2, 1, 2, 3},
                {5, 1, 1, 1}
        };

        findMaxSumPairs(garden, new boolean[4][4], 0, 0);
        System.out.println("Max Sum: " + maxSum);
    }

    private static void findMaxSumPairs(int[][] garden, boolean[][] visited, int pairsCount, int currentSum) {
        if (pairsCount == 4) {
            maxSum = Math.max(maxSum, currentSum);
            return;
        }

        for (int i = 0; i < garden.length; i++) {
            for (int j = 0; j < garden[i].length; j++) {
                if (!visited[i][j]) {
                    int[][] directions = {{0, 1}, {1, 0}};
                    for (int[] dir : directions) {
                        int newI = i + dir[0];
                        int newJ = j + dir[1];
                        if (newI < garden.length && newJ < garden[i].length && !visited[newI][newJ]) {
                            visited[i][j] = true;
                            visited[newI][newJ] = true;

                            findMaxSumPairs(garden, visited, pairsCount + 1, currentSum + garden[i][j] + garden[newI][newJ]);

                            visited[newI][newJ] = false;
                            visited[i][j] = false;
                        }
                    }
                }
            }
        }

        // 모든 쌍을 고르지 않아도 될 경우 최대값 갱신
        if (pairsCount > 0) {
            maxSum = Math.max(maxSum, currentSum);
        }
    }
}
