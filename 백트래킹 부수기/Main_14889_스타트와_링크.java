import java.util.*;
import java.io.*;

public class Main_14889_스타트와_링크 {
    static int N;
    static int[][] arr;
    static boolean[] isVisited;
    static int result = 200;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/14889.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); // 자신과 같은 값은 항상 0
            }
        }

        // for(int[] num : arr) System.out.println(Arrays.toString(num));

        DFS(0);
        System.out.println(result);
    } // End of main

    private static void DFS(int depth) {
        if (depth == N / 2) {
            result = Math.min(result, diff());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            DFS(depth + 1);
            isVisited[i] = false;
        }

    } // End of DFS

    private static int diff() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isVisited[i] && isVisited[j]) {
                    teamStart += arr[i][j] += arr[j][i];
                } else if (!isVisited[i] && !isVisited[j]) {
                    teamLink += arr[i][j] += arr[j][i];
                }
            }
        }

        return Math.abs(teamStart - teamLink);
    } // End of diff
} // End of Main class