package BOJ_1339;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_1339 {

    // https://www.acmicpc.net/problem/1339
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static HashMap<Character, Integer> map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1339\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        int sum = 0;
        int digit = 9;
        for (Map.Entry<Character, Integer> entry : entryList) {
            sum += entry.getValue() * digit;
            digit--;
        }

        sb.append(sum);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            int len = temp.length();

            for (int j = 0; j < len; j++) {
                char ch = temp.charAt(j);

                int placeValue = (int) Math.pow(10, len - j - 1);
                map.put(ch, map.getOrDefault(ch, 0) + placeValue);
            }
        }
    } // End of input()
} // End of Main class
