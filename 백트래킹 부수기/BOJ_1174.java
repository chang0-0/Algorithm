package BOJ_1174;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_1174 {

    // https://www.acmicpc.net/problem/1174
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static List<Long> list;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1174\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            DFS(i, 1);
        }

        Collections.sort(list);

        if (N <= list.size()) {
            sb.append(list.get(N - 1));
        } else {
            sb.append(-1);
        }

        return sb.toString();
    } // End of solve()

    private static void DFS(long num, int depth) {
        if (depth > 10) {
            return;
        }

        list.add(num);
        for (int i = 0; i < 10; i++) {
            if (num % 10 > i) {
                DFS(num * 10 + i, depth + 1);
            }
        }
    } // End of DFS()

//    private static void DFS(int posMax, int posIdx, int idx, int pre, int count) {
//        if (flag) return;
//        //System.out.println(idx + ", " + depth + ", " + pre);
//        if (idx == 10) {
//            comb = new int[8];
//            DFS(posMax + 1, 0, 0, 0, count);
//        }
//
//        if (count == N) {
//            System.out.println(Arrays.toString(comb));
//            flag = true;
//            return;
//        }
//
//        for (int i = posIdx; i < posMax; i++) {
//            for (int j = idx; j <= 9; j++) {
//                if (pre < j) {
//                    comb[i] = j;
//                    DFS(posMax, posIdx, idx + 1, j, count + 1);
//                    //comb[i] = -1;
//                }
//            }
//        }
//
//    } // End of DFS()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
    } // End of input()
} // End of Main class
