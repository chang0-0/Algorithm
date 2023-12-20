package BOJ_30959;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_30959_앙상블할래 {

    // https://www.acmicpc.net/problem/30959
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static int[] corrects;
    private static boolean[] isVisited;
    private static int[][] studentAns;
    private static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_30959\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 1. 학생들이 만든 모델의 가장 높은 정확도를 우선 찾는다.
        double maxStudentScore = 0.0;
        for (int i = 0; i < N; i++) {
            int corCount = 0;
            for (int j = 0; j < M; j++) {
                if (corrects[j] == studentAns[i][j]) {
                    corCount++;
                }
            }

            double temp = (double) corCount / M;
            maxStudentScore = Math.max(maxStudentScore, temp);
        }

        sb.append(DFS(maxStudentScore, 0, 0));
        return sb.toString();
    } // End of solve()

    private static int DFS(double maxStudentScore, int idx, int depth) {
        if (depth >= 3 && depth % 2 == 1) {

            double predict = 0.0;
            for (int i = 0; i < M; i++) {
                int zeroCount = 0;
                int oneCount = 0;
                int ret = 0;
                for (int j = 0; j < N; j++) {
                    if (!deque.contains(j)) continue;

                    if (studentAns[j][i] == 1) {
                        oneCount++;
                    } else {
                        zeroCount++;
                    }
                }

                if (oneCount > zeroCount) {
                    ret = 1;
                }

                if (corrects[i] == ret) {
                    predict++;

                    if (predict / M > maxStudentScore) {
                        return 1;
                    }
                }
            }
        }

        if (depth == N) {
            return 0;
        }

        for (int i = idx; i < N; i++) {
            if (isVisited[i]) continue;
            deque.offerFirst(i);
            isVisited[i] = true;
            if (DFS(maxStudentScore, i, depth + 1) == 1) return 1;
            isVisited[i] = false;
            deque.pollFirst();
        }

        return 0;
    } // End of DFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        corrects = new int[M];
        studentAns = new int[N][M];
        deque = new LinkedList<>();
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            corrects[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                studentAns[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    } // End of input()
} // End of Main class
