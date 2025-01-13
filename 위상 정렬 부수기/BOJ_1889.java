package BOJ_1889;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1889 {

    // https://www.acmicpc.net/problem/1889
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] degrees;
    private static List<List<Integer>> adjList;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1889\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 위상 정렬, 방향 그래프에서 사이클 찾기
        // 순서 찾기,
        // 모든 학생들이 선물을 2개 받을 수 있도록, 이벤트에 참여할 학생들을 결정

        BFS();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (degrees[i] == 2) {
                list.add(i);
            }
        }

        if (list.isEmpty()) {
            sb.append(0);
        } else {
            sb.append(list.size()).append('\n');
            for (int num : list) sb.append(num).append(' ');
        }

        return sb.toString();
    } // End of solve()

    private static void BFS() {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        boolean[] isVisited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            if (degrees[i] < 2) {
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (isVisited[cur]) continue;
            isVisited[cur] = true;

            for (int next : adjList.get(cur)) {
                degrees[next]--;
                if (degrees[next] < 2) {
                    que.offer(next);
                }
            }
        }
    } // End of BFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        degrees = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                int temp = Integer.parseInt(st.nextToken());
                adjList.get(i).add(temp);
                degrees[temp]++;
            }
        }
    } // End of input()
} // End of Main class
