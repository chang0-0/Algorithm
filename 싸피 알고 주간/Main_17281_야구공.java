import java.util.*;
import java.io.*;

public class Main_17281_야구공 {
    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int[] lineUp;
    static int ans;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/17281.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][10];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[10];
        lineUp = new int[10];

        visit[4] = true;
        lineUp[4] = 1;

        ans = 0;
        DFS(2);

        System.out.println(ans);
    } // End of main

    private static void DFS(int depth) {
        if (depth == 10) {
            playMatch();
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (visit[i]) continue;

            visit[i] = true;
            lineUp[i] = depth;
            DFS(depth + 1);
            visit[i] = false;
        }
    } // End of DFS

    private static void playMatch() {
        int score = 0;
        int startPlayer = 1;
        boolean[] base;

        for (int i = 1; i <= N; i++) {
            int outCount = 0;
            base = new boolean[4];

            outer:
            for (; ; ) {

                for (int j = startPlayer; j <= 9; j++) {
                    int hitter = arr[i][lineUp[j]];

                    if (hitter == 0) {
                        outCount++;
                        break;
                    } else if (hitter == 1) {
                        for (int k = 3; k >= 1; k--) {
                            if (base[k]) {
                                if (k == 3) {
                                    score++;
                                    base[k] = false;
                                    continue;
                                }

                                base[k] = false;
                                base[k + 1] = true;
                            }
                        }
                        base[1] = true;
                        break;
                    } else if (hitter == 2) {
                        for (int k = 3; k >= 1; k--) {
                            if (base[k]) {
                                if (k == 3 || k == 2) {
                                    score++;
                                    base[k] = false;
                                    continue;
                                }

                                base[k] = false;
                                base[k + 2] = true;
                            }
                        }
                        base[2] = true;
                        break;
                    } else if (hitter == 3) {

                        for (int k = 3; k >= 3; k--) {
                            if (base[k]) {
                                score++;
                                base[k] = false;
                            }
                        }
                        base[3] = true;
                        break;
                    } else if(hitter == 4){
                        for (int k = 1; k <= 3; k++) {
                            if (base[k]) {
                                score++;
                                base[k] = false;
                            }
                        }
                        score++;
                        break;
                    }

                    if(outCount == 3) {
                        startPlayer = j + 1;
                        if(startPlayer == 10) {
                            startPlayer = 1;
                        }
                        break outer;
                    }
                }

                startPlayer = 1;
            }
        }

        ans = Math.max(ans, score);
    } // End of playMatch
} // End of Main class