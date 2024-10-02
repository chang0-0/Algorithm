package BOJ_29723;

import java.io.*;
import java.util.*;

public class BOJ_29723 {

    // https://www.acmicpc.net/problem/29723
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K;
    private static TreeMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_29723\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int max = 0;
        int min = 0;
        for (int i = 0; i < K; i++) {
            String temp = br.readLine();
            max += map.get(temp);
            min += map.get(temp);
            map.remove(temp);
            M--;
        }

        if (M >= 1) {
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
            entryList.sort(Map.Entry.comparingByValue());
            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : entryList) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            int temp = M;
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                if (temp == 0) break;
                min += entry.getValue();
                temp--;
            }

            entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
            sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : entryList) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            temp = M;
            for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
                if (temp == 0) break;
                max += entry.getValue();
                temp--;
            }
        }

        sb.append(min).append(' ').append(max);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String sub = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.put(sub, score);
        }
    } // End of input()
} // End of Main class
