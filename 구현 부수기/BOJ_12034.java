package BOJ_12034;

import java.io.*;
import java.util.*;

public class BOJ_12034 {

    // https://www.acmicpc.net/problem/12034
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static int[] arr = new int[202];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_12034\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(i).append(": ");
            input();

            bw.write(sb.toString());
            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        // 모든 물건의 정상가는 4의 배수
        List<Integer> list = new LinkedList<>();
        List<Integer> ansList = new ArrayList<>();

        for (int i = 0; i < N * 2; i++) {
            int num = arr[i];

            if (list.isEmpty()) {
                list.add(num);
            } else {
                int temp = (int) (num * 0.75);
                if (list.contains(temp)) {
                    ansList.add(temp);
                    list.remove((Integer) temp);
                } else {
                    list.add(num);
                }
            }
        }


        Collections.sort(ansList);
        for (int num : ansList) {
            sb.append(num).append(' ');
        }

        sb.append('\n');
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    } // End of input()
} // End of Main class
