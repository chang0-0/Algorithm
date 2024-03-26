import java.io.*;
import java.util.*;

public class Main {
    // input
    private static BufferedReader br;

    // variables    
    private static int N, M, K;
    private static List<List<Node>> adjList;
    private static final int INF = Integer.MAX_VALUE;

    private static class Node {
        int node;
        int requiredTime;
        int term;

        private Node(int node, int requiredTime, int term) {
            this.node = node;
            this.requiredTime = requiredTime; // 소요 시간
            this.term = term;
        }
    } // End of Node class

    private static class Data implements Comparable<Data> {
        int node;
        int time;
        int skips;

        private Data(int node, int time, int skips) {
            this.node = node;
            this.time = time;
            this.skips = skips;
        }

        @Override
        public int compareTo(Data o) {
            return time - o.time;
        }
    } // End of Data class
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 1번에서 N번 까지 
        int ret = dijkstra();

        if(ret == INF) {
            sb.append(-1);
        } else {
            sb.append(ret);
        }

        return sb.toString();
    } // End of solve()

    private static int dijkstra() {
        PriorityQueue<Data> pque = new PriorityQueue<>();
        int[][] times = new int[N + 1][K + 1];
        for(int i=0; i<=N; i++) {
            for(int j=0; j<=K; j++) {
                times[i][j] = INF;
            }
        }

        // 빨리기다리기 사용회수
        // 현재까지 걸린 시간
        pque.offer(new Data(1, 0, 0));
        times[1][0] = 0;

        while(!pque.isEmpty()) {
            Data current = pque.poll();

            if(times[current.node][current.skips] < current.time) continue;
            
            for(Node next : adjList.get(current.node)) {
                if (current.skips < K) {
                    int skipCost = current.time + next.requiredTime; // 대기 시간 없이 바로 이동
                    if (times[next.node][current.skips + 1] > skipCost) {
                        times[next.node][current.skips + 1] = skipCost;
                        pque.add(new Data(next.node, skipCost, current.skips + 1));
                    }
                }

                // 대기 시간을 포함하여 이동하는 경우
                int waitTime = (next.term - current.time % next.term) % next.term;
                int waitCost = current.time + next.requiredTime + waitTime; // 대기 시간을 포함한 이동
                if (times[next.node][current.skips] > waitCost) {
                    times[next.node][current.skips] = waitCost;
                    pque.add(new Data(next.node, waitCost, current.skips));
                }
            }
        }

        int ans = INF;
        for(int i=0; i<=K; i++) {
            ans = Math.min(ans, times[N][i]);
        }

        return ans;
    } // End of dijkstra()
    
    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken()); // 소요시간
            int g = Integer.parseInt(st.nextToken()); // 매 g시간 뒤에 s번 정류장에서 버스가 운행을 시작한다 텀.

                        
            if (s == N || e == 1) continue; // skip invalid edges

            adjList.get(s).add(new Node(e, t, g));
        }
    } // End of input()
} // End of Main class
