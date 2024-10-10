package BOJ_10546;

import java.io.*;
import java.util.HashMap;

public class BOJ_10546 {

    // https://www.acmicpc.net/problem/10546
    // input
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_10546\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (int i = 0; i < N - 1; i++) {
            String name = br.readLine();

            int value = map.get(name);
            if (value == 1) {
                map.remove(name);
            } else {
                map.put(name, value - 1);
            }
        }

        for (String name : map.keySet()) {
            sb.append(name);
        }

        return sb.toString();
    } // End of solve()
} // End of Main class
