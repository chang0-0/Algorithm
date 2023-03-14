import java.util.*;
import java.io.*;

public class Main_1855_영준이의_진짜_BFS {
    private static final int INF = Integer.MAX_VALUE;
    static int N, result;
    static int[][] dist; // 각 노드별 노드 간의 거리를 모두 계산 // 다익스트라 사용
    static List<List<Integer>> nodeList;
    static Deque<Integer> deque;

    static class Node implements Comparable<Node> {
        int nodeNum;
        int dist;

        public Node(int nodeNum, int dist) {
            this.nodeNum = nodeNum;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
        }
    } // End of Node class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1855.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            N = Integer.parseInt(br.readLine());
            init();

            st = new StringTokenizer(br.readLine());
            for (int i = 2; i <= N; i++) {
                int num = Integer.parseInt(st.nextToken());

                // i는 노드 번호 // 들어오는 값은 부모 노드 번호
                nodeList.get(i).add(num);
                nodeList.get(num).add(i);
            }

            for (int i = 1; i <= N; i++) {
                dijkstra(i);
            }

            BFS(1);

            int num = deque.pollFirst();
            int sum = dist[1][num];
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int pre = deque.pollFirst();
                sum += dist[num][pre];
                num = pre;
            }

            sb.append(sum).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void dijkstra(int startNodeNum) {
        PriorityQueue<Integer> pque = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        Arrays.fill(dist[startNodeNum], INF);
        dist[startNodeNum][startNodeNum] = 0;
        pque.offer(startNodeNum);

        while (!pque.isEmpty()) {
            int startNum = pque.poll();

            if (isVisited[startNum]) continue;
            isVisited[startNum] = true;

            for (int nodeNum : nodeList.get(startNum)) {
                if (!isVisited[nodeNum] && dist[startNodeNum][nodeNum] > dist[startNodeNum][startNum] + 1) {
                    dist[startNodeNum][nodeNum] = dist[startNodeNum][startNum] + 1;
                    pque.offer(nodeNum);
                }
            }
        }

    } // End of dijkstra

    private static void BFS(int startNodeNum) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];
        que.offer(startNodeNum);
        // Deque<Integer> deque = new LinkedList<>();

        while (!que.isEmpty()) {
            int startNum = que.poll();

            if (isVisited[startNum]) continue;
            isVisited[startNum] = true;
            // deque.offer(startNum);

            for (int nodeNum : nodeList.get(startNum)) {
                if (!isVisited[nodeNum]) {
                    que.offer(nodeNum);
                    deque.offer(nodeNum);
                }
            }
        }


    } // End of BFS

    private static void init() {
        result = 0;
        nodeList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodeList.add(new ArrayList<>());
        }
        dist = new int[N + 1][N + 1];
        deque = new LinkedList<>();

    } // End of init
} // End of Main class