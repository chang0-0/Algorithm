package BOJ_3022;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BOJ_3022 {

    // https://www.acmicpc.net/problem/3022
    // input
    private static BufferedReader br;

    // variables
    private static int N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_3022\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int ans = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();

            if (map.putIfAbsent(name, 1) != null) {
                // map에 name이 없으면 null을 뱉고 put을 진행, 있으면 if안으로 동작
                if (i - map.get(name) < map.get(name)) ans++; // 현재껄 포함하지 않고, 전체보다 많이 가지고 있으면 경고
                map.put(name, map.getOrDefault(name, 0) + 1);
            }
        }

        sb.append(ans);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
