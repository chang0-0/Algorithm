package BOJ_16938;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_16938 {

    // https://www.acmicpc.net/problem/16938
    // input
    private static BufferedReader br;

    // variables
    private static int N, L, R, X, ans;
    private static int[] arr;
    static LinkedList<Integer> list;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_16938\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        DFS(0, 0, 0);

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void DFS(int depth, int count, int idx) {
        if (depth >= 2) {

            int sum = 0;
            for (int num : list) {
                sum += num;
                if (sum > R) {
                    return;
                }
            }

            LinkedList<Integer> temp = new LinkedList<>(list);
            Collections.sort(temp);
            if (sum >= L && (temp.get(temp.size() - 1) - temp.get(0)) >= X) {
                ans++;
            }

            if (depth == N) {
                return;
            }
        }

        for (int i = idx; i < N; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;

            list.offerFirst(arr[i]);
            DFS(depth + 1, count + 1, i);
            list.pollFirst();
            isVisited[i] = false;
        }

    } // End of DFS()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ans = 0;
        arr = new int[N];
        isVisited = new boolean[N];
        list = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    } // End of input()
} // End of Main class
