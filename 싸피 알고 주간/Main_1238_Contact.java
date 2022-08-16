import java.io.*;
import java.util.*;

public class Main_1238_Contact {
    static int N;
    static List<List<Node>> nodeList;
    static int maxDepth;
    static int maxNode;

    static class Node {
        int num;
        int depth;

        Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    } // End of Node

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1238.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = "";
        int T = 1;
        while ((str = br.readLine()) != null) {
            sb.append('#').append(T).append(' ');
            StringTokenizer st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            nodeList = new ArrayList<>();
            for (int i = 0; i <= 100; i++) {
                nodeList.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                nodeList.get(from).add(new Node(to, 1));
            }

            maxNode = -1;
            maxDepth = -1;
            BFS(start);
            T++;
            sb.append(maxNode).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static void BFS(int start) {
        Queue<Node> que = new LinkedList<>();
        boolean visit[] = new boolean[101];
        que.offer(new Node(start, 1));

        while (!que.isEmpty()) {
            Node node = que.poll();

            for (Node n : nodeList.get(node.num)) {
                if (visit[n.num]) continue;

                visit[n.num] = true;
                int newDepth = n.depth + node.depth;
                que.offer(new Node(n.num, newDepth));

                if (maxDepth < newDepth) {
                    maxDepth = newDepth;
                    maxNode = -1;
                    maxNode = Math.max(maxNode, n.num);
                } else if (maxDepth == newDepth) {
                    maxNode = Math.max(maxNode, n.num);
                }
            }
        }
    } // End of BFS
} // End of Main class