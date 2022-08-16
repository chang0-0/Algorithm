import java.util.*;
import java.io.*;

public class Main_1267_작업순서$인접리스트$ {
    static StringBuilder sb;
    static List<List<Integer>> nodeList;
    static boolean visit[];
    static int V, E;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1267.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder resultSb = new StringBuilder();

        String str = "";
        int T = 1;
        while ((str = br.readLine()) != null) {
            sb = new StringBuilder();
            sb.append('#').append(T).append(' ');

            StringTokenizer st = new StringTokenizer(str);
            V = Integer.parseInt(st.nextToken()); // 정점의 수
            E = Integer.parseInt(st.nextToken()); // 간선의 수

            nodeList = new ArrayList<>();
            visit = new boolean[V + 1];
            for (int i = 0; i <= V; i++) {
                nodeList.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            while (E-- > 0) {
                int startNode = Integer.parseInt(st.nextToken());
                int endNode = Integer.parseInt(st.nextToken());
                nodeList.get(endNode).add(startNode);
            }

            for(int i=1; i<=V; i++) {
                if(!visit[i]) {
                    DFS(i);
                }
            }

            resultSb.append(sb.toString()).append('\n');
            T++;
        }

        bw.write(resultSb.toString());
        bw.close();
    } // End of main

    private static void DFS(int startNode) {
        // 본인 노드의 선행 노드가 먼저 방문되었는지 확인하는 과정
        for(int num : nodeList.get(startNode)) {
            // 갈 수 잇는 노드를 하나씩 꺼내보고, 방문하지 않은 노드가 있을 경우 먼저 실행하기 위해서 DFS(num)으로 실행
            if(!visit[num]) {
                DFS(num);
            }
        }

        visit[startNode] = true;
        sb.append(startNode).append(' ');
    } // End of DFS
} // End of Main class