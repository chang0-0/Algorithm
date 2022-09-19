import java.util.*;
import java.io.*;

public class Main_1263_사람_네트워크2 {
    static int N, result;
    static int[] dist;
    static List<List<Node>> nodeList;
    static int[][] arr;

    static class Node implements Comparable<Node> {
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return dist - o.dist;
        }
    } // End of Node class

    // 각 노드별 모든 노드가 해당 노드로 오는데 드는 최소 비용 계산하기.
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1263.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            init();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) {
                        nodeList.get(i).add(new Node(j, 1));
                    }
                }
            }


            for (int i = 1; i <= N; i++) {
                dijkstra(i);
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void dijkstra(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, N + 100);

        dist[start] = 0;
        que.offer(new Node(start, 0));

        while (!que.isEmpty()) {
            Node node = que.poll();
            int startNodeNum = node.num;

            if (isVisited[startNodeNum]) continue;
            isVisited[startNodeNum] = true;

            for (Node nodeNum : nodeList.get(startNodeNum)) {
                if (!isVisited[nodeNum.num] && dist[nodeNum.num] > (dist[startNodeNum] + nodeNum.dist)) {
                    dist[nodeNum.num] = nodeNum.dist + dist[startNodeNum];
                    que.offer(new Node(nodeNum.num, dist[nodeNum.num]));
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        }

        result = Math.min(result, sum);
    } // End of dijkstra

    private static void init() {
        result = Integer.MAX_VALUE;
        nodeList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            nodeList.add(new ArrayList<>());
        }

        arr = new int[N + 1][N + 1];
        dist = new int[N + 1];
    } // End of init
} // End of Main class