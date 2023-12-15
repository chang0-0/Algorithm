package BOJ_4195;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_4195_친구_네트워크 {

    // https://www.acmicpc.net/problem/4195
    // input
    private static BufferedReader br;

    // variables
    private static int N, idx;
    private static int[] parents;
    private static int[] cost;
    private static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_4195\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());;

            String f1 = st.nextToken();
            String f2 = st.nextToken();
            System.out.println("f1 : " + f1 + ", f2 : " + f2);

            // 친구의 이름에 index를 부여해서 node 번호로 관리.
            // map에 존재하지 않으면 map에 추가
            if (!map.containsKey(f1)) {
                map.put(f1, idx++);
            }

            if (!map.containsKey(f2)) {
                map.put(f2, idx++);
            }

            System.out.println("map : " + map);

            // map에 이미 존재하는 이름이면, 이름을 key값으로 index를 찾는다.
            int ret = union(map.get(f1), map.get(f2));
            System.out.println(Arrays.toString(parents));
            System.out.println(Arrays.toString(cost));

            sb.append(ret).append('\n');
        }

        return sb.toString();
    } // End of solve()

    public static int union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        if(node1Parent == node2Parent) {
            return cost[node1Parent];
        }

        parents[node1Parent] = node2Parent;
        cost[node2Parent] += cost[node1Parent];
        cost[node1Parent] = 1;

        return cost[node2Parent];
    } // End of union()

    public static int find(int n) {
        if (parents[n] == n) {
            return n;
        }
        return parents[n] = find(parents[n]);
    } // End of find()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        idx = 0;

        map = new HashMap<>();

        parents = new int[N * 2];
        cost = new int[N * 2];
        for (int i = 0; i < N * 2; i++) {
            parents[i] = i;
            cost[i] = 1;
        }
    } // End of input()
} // End of Main class
