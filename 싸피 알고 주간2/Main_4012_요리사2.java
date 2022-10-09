import java.util.*;
import java.io.*;


// 두 음식간의 맛차이가 최소가 되도록 A음식과 B음식을 만들었을 때 그 차이 값
public class Main_4012_요리사2 {
    static int N, result;
    static int[][] arr;
    static int[] comb;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/4012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');
            N = Integer.parseInt(br.readLine());
            init();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            DFS(0, 0);
            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // 순서가 영향을 미치고 중복을 허용하지 않는 조합. (순열)
    private static void DFS(int depth, int index) {

        if (depth == N / 2) {
            boolean[] isVisited = new boolean[N];
            int aSum = 0;
            for (int i = 0; i < N / 2; i++) {
                for (int j = 0; j < N / 2; j++) {
                    if (i == j) continue;
                    aSum += arr[comb[i]][comb[j]];
                    isVisited[comb[i]] = true;
                }
            }

            int bSum = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) continue;
                    else if (isVisited[i] || isVisited[j]) continue;

                    bSum += arr[i][j];
                }
            }

            result = Math.min(result, Math.abs(aSum - bSum));
            return;
        }

        for (int i = index; i < N; i++) {
            comb[depth] = i;
            DFS(depth + 1, i + 1);
        }
    } // End of DFS

    private static void init() {
        arr = new int[N][N];
        result = Integer.MAX_VALUE;
        comb = new int[N / 2];
    } // End of init
} // End of Main class