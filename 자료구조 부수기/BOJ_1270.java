package BOJ_1270;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1270 {

    // https://www.acmicpc.net/problem/1270
    // input
    private static BufferedReader br;

    // variables
    private static final String SYJKGW = "SYJKGW";

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1270\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());

            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < count; j++) {
                String num = st.nextToken();
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            String key = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
            if (map.get(key) > (count / 2)) {
                sb.append(key);
            } else {
                sb.append(SYJKGW);
            }
            sb.append('\n');
        }

        return sb.toString();
    } // End of solve()
} // End of Main class
