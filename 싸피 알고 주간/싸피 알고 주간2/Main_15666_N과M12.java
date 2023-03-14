import java.util.*;
import java.io.*;

// 중복 없는 순열
public class Main_15666_N과M12 {
    static int N, M;
    static int[] arr;
    static int[] perm;
    static boolean[] isVisited;
    static Set<String> set;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/15666.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        DFS(0, 0);
        System.out.print(sb);
    } // End of main

    private static void DFS(int depth, int index) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(perm[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int pre = -1;
        for (int i = index; i < arr.length; i++) {
            int now = arr[i];
            if (pre != now) {
                pre = now;
                perm[depth] = arr[i];
                DFS(depth + 1, i);
            }
        }
    } // End of DFS

    private static void init() {
        arr = new int[N];
        perm = new int[M];
        isVisited = new boolean[N];
        set = new TreeSet<>();
        sb = new StringBuilder();
    } // End of init
} // End of Main class