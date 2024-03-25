package BOJ_4358;

import java.io.*;
import java.util.TreeMap;

public class BOJ_4358 {

    // https://www.acmicpc.net/problem/4358
    // input
    private static BufferedReader br;

    // variables

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_4358\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        TreeMap<String, Integer> map = new TreeMap<>();
        double sum = 0;
        String temp = "";

        while ((temp = br.readLine()) != null) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            sum++;
        }

        for (String key : map.keySet()) {
            int num = map.get(key);
            double v = (num / sum) * 100;

            String formatted = String.format("%.4f", v);
            sb.append(key).append(' ').append(formatted).append('\n');
        }


        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {

    } // End of input()
} // End of Main class
