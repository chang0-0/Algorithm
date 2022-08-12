import java.util.*;
import java.io.*;

public class Main_1267_작업순서_$DFS_인접행렬$ {
    static StringBuilder sb;
    static int arr[][];
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
            arr = new int[V + 1][V + 1];
            visit = new boolean[V + 1];

            st = new StringTokenizer(br.readLine());
            while (E-- > 0) {
                int startNode = Integer.parseInt(st.nextToken());
                int endNode = Integer.parseInt(st.nextToken());
                arr[startNode][endNode] = 1;
            }

            for (int i = 1; i <= V; i++) {
                if (!visit[i]) {
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
        // 본인 노드의 선행 노드가 방문이 되었는지 안되었는지를 보는 과정
        for (int i = 1; i <= V; i++) {
            if (!visit[i] && arr[i][startNode] == 1)
                return;
        }
        // 내가 가진 부모가 없거나, 방문을 한 부모일 경우, 진행을 할 수 있음 열 방향 체크

        visit[startNode] = true;
        sb.append(startNode).append(' ');
        for (int i = 1; i <= V; i++) {
            // 자신이 갈 수 있는 노드 번호를 찾음. 행 방향
            if (!visit[i] && arr[startNode][i] == 1) {
                DFS(i);
            }
        }
    } // End of DFS
} // End of Main class