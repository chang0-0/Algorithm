import java.util.*;
import java.io.*;

public class Main_7465_창용_마을_무리의_개수 {
    static int N, M, result;
    static boolean[] isVisited;
    static List<List<Integer>> list;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/7465.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            init();


            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list.get(from).add(to);
                list.get(to).add(from);
            }

            for (int i = 1; i <= N; i++) {
                if (!isVisited[i]) {
                    BFS(i);
                    result++;
                }
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void BFS(int num) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(num);

        while (!que.isEmpty()) {
            int nodeNum = que.poll();

            if (isVisited[nodeNum]) continue;

            isVisited[nodeNum] = true;
            for (int node : list.get(nodeNum)) {
                que.offer(node);
            }
        }
    } // End of BFS

    private static void init() {
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        isVisited = new boolean[N + 1];
        result = 0;
    } // End of init
} // End of Main class