package BOJ_9466;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9446 {

    // https://www.acmicpc.net/problem/9466
    // input
    private static BufferedReader br;

    // variables
    private static final int MAX = 100_001;
    private static int N, ret;
    private static boolean[] isVisited, finished;
    private static int[] arr = new int[MAX];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_9466\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        isVisited = new boolean[N + 1];
        finished = new boolean[N + 1];
        ret = 0;

        // 팀에 속하지 못한 학생의 수를 출력하기
        for (int i = 1; i <= N; i++) {
            if (isVisited[i]) continue;
            DFS(i);
        }

        sb.append(N - ret).append('\n');
        return sb.toString();
    } // End of solve()

    private static void DFS(int node) {
        System.out.println("node : " + node);
        isVisited[node] = true;
        int next = arr[node];

        if (!isVisited[next]) {
            DFS(next);
        } else if (!finished[next]) {
            // 방문은 했는데, 팀이 정해지지 않은 경우
            int count = 1;
            System.out.println("finished Inner node : " + node);
            for (int i = next; i != node; i = arr[i]) {
                System.out.println("i : " + i);
                count++;
            }
            ret += count;
        }

        finished[node] = true;
    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i + 1] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
