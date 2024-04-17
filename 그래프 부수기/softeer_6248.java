import java.io.*;
import java.util.*;

public class Main {
    // https://softeer.ai/practice/6248
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, S, T;
    private static List<List<Integer>> adjList;
    private static List<List<Integer>> reverseAdjList;
        
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        // 단방향 그래프
        // 모두 포함될 수 있는 정점의 개수 파악

        boolean[] isVisited = new boolean[N + 1];
        isVisited[T] = true; // 도착지를 1로 표시
        boolean[] toStart = BFS(adjList, S, T, isVisited);

        isVisited = new boolean[N + 1];
        isVisited[S] = true;
        boolean[] toDest = BFS(adjList, T, S, isVisited);


        isVisited = new boolean[N + 1];
        boolean[] fromStart = BFS(reverseAdjList, S, T, isVisited);

        isVisited = new boolean[N + 1];
        boolean[] fromDest = BFS(reverseAdjList, T, S, isVisited);
        
        // S와 T를 제외하고 개수
        int ans = 0;
        for(int i=1; i<=N; i++) {
            if(i == S || i == T) continue;

            if(toStart[i] && toDest[i] && fromStart[i] && fromDest[i]) ans++;
        }
    

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static boolean[] BFS(List<List<Integer>> adjList, int start, int dest, boolean[] isVisited) {
        ArrayDeque<Integer> que = new ArrayDeque<>();

        isVisited[start] = true;
        que.offer(start);

        while(!que.isEmpty()) {
            int cur = que.poll();

            for(int next : adjList.get(cur)) {
                if(isVisited[next]) continue;
                isVisited[next] = true;
                que.offer(next);
            }
        }

        return isVisited;
    } // End of BFS()
    
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        reverseAdjList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
            reverseAdjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            reverseAdjList.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
    } // End of input()
} // End of Main class
