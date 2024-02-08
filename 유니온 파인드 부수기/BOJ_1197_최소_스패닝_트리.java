package BOJ_1197;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소_스패닝_트리 {
    // 최소신장트리 -> 유니온 파인드 + 크루스칼

    // https://www.acmicpc.net/problem/1197
    // input
    private static BufferedReader br;

    // variables
    private static int V, E;
    private static int[] parents, ranks;
    private static PriorityQueue<Node> adjList;

    private static class Node implements Comparable<Node> {
        int start;
        int end;
        int weight;

        private Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "start=" + start +
                    ", end=" + end +
                    ", weight=" + weight +
                    '}';
        }
    } // End of Node class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1197\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        sb.append(kruskal());
        return sb.toString();
    } // End of solve()

    private static int kruskal() {
        int weight = 0;

        while (!adjList.isEmpty()) {
            Node next = adjList.poll();
            // 가중치가 낮은 간선을 우선 적으로 꺼내며,
            // 두 노드의 부모가 같지 않아 사이클이 아니라는것이 판명이 나면 합친다.

            if (find(next.start) != find(next.end)) {
                weight += next.weight;
                union(next.start, next.end);
            }
        }

        return weight;
    } // End of kruskal

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot) return; // 이미 같은 집합에 속해 있음

        // 랭크가 낮은 트리를 랭크가 높은 트리 아래에 붙임
        if (ranks[aRoot] < ranks[bRoot]) {
            parents[aRoot] = bRoot;
        } else if (ranks[aRoot] > ranks[bRoot]) {
            parents[bRoot] = aRoot;
        } else {
            parents[bRoot] = aRoot;
            // 랭크가 같을 경우 한 쪽의 랭크를 증가.
            ranks[aRoot]++;
        }
    } // End of union()

    private static int find(int node) {
        if (node == parents[node]) return node;

        return parents[node] = find(parents[node]);
    } // End of find()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V + 1];
        ranks = new int[V + 1];
        adjList = new PriorityQueue<>();

        for (int i = 0; i <= V; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList.offer(new Node(a, b, c));
        }

    } // End of input()
} // End of Main class
