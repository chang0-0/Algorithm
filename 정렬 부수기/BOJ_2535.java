package BOJ_2535;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2535 {

    // https://www.acmicpc.net/problem/2535
    // input
    private static BufferedReader br;

    // variables

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2535\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[2], o1[2]);
            }
        });
        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;
        for (int[] t : arr) {
            int c = t[0];
            int n = t[1];

            if (map.get(c) == null || map.get(c) < 2) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                count++;
                sb.append(c).append(' ').append(n).append('\n');
            } else {
                continue;
            }
            if (count == 3) break;
        }


        return sb.toString();
    } // End of solve()
} // End of Main class
