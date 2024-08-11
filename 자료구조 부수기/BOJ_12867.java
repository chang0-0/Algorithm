package BOJ_12867;

import java.io.*;
import java.util.*;

public class BOJ_12867 {

    // https://www.acmicpc.net/problem/12867
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_12867\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        String temp = br.readLine();

        Map<Integer, Integer> coord = new HashMap<>();
        Set<Map<Integer, Integer>> set = new HashSet<>();
        coord.put(0, 0);
        set.add(coord);

        for (int i = 0; i < M; i++) {
            int idx = arr[i];
            char ch = temp.charAt(i);

            Map<Integer, Integer> map = new HashMap<>(coord);
            int value = map.getOrDefault(idx, 0) + ch;
            if (value == 0) {
                map.remove(idx);
            } else {
                map.put(idx, value);
            }

            boolean isExist = set.add(map);
            if (!isExist) {
                sb.append(0);
                return sb.toString();
            }

            coord = map;
        }

        sb.append(1);
        return sb.toString();
    } // End of solve()

    private static Map<Integer, Integer> deepCopy(Map<Integer, Integer> origin) {
        return new HashMap<>(origin);
    } // End of deepCopy()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
