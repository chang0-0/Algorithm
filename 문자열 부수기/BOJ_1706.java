package BOJ_1706;

import java.io.*;
import java.util.*;

public class BOJ_1706 {

    // https://www.acmicpc.net/problem/1706
    // input
    private static BufferedReader br;

    // variables
    private static int N, M;
    private static char[][] arr;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_1706\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();


        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringBuilder makeWord = new StringBuilder();
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != '#') {
                    makeWord.append(arr[i][j]);
                } else {
                    if (makeWord.length() >= 2) {
                        list.add(makeWord.toString());
                    }
                    makeWord = new StringBuilder();
                }
            }

            if (makeWord.length() >= 2) {
                list.add(makeWord.toString());
            }
        }

        for (int i = 0; i < M; i++) {
            StringBuilder makeWord = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if (arr[j][i] != '#') {
                    makeWord.append(arr[j][i]);
                } else {
                    if (makeWord.length() >= 2) {
                        list.add(makeWord.toString());
                    }
                    makeWord = new StringBuilder();
                }
            }

            if (makeWord.length() >= 2) {
                list.add(makeWord.toString());
            }
        }

        Collections.sort(list);

        sb.append(list.get(0));
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }
    } // End of input()
} // End of Main class
