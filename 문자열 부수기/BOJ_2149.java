package BOJ_2149;

import java.io.*;
import java.util.Arrays;

public class BOJ_2149 {

    // https://www.acmicpc.net/problem/2149
    // input
    private static BufferedReader br;

    // variables
    private static String key, password;
    private static int keyLen, passwordLen, N;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2149\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        int[] arr = find();
        char[][] chArr = new char[N][keyLen];
        for (int i = 0; i < keyLen; i++) {
            for (int j = 0; j < N; j++) {
                chArr[j][arr[i]] = password.charAt((i * N) + j);
            }
        }

        for (char[] t : chArr) {
            for (int j = 0; j < keyLen; j++) {
                sb.append(t[j]);
            }
        }

        return sb.toString();
    } // End of solve()

    private static int[] find() {
        char[] chArr = key.toCharArray();
        char[] sortingChArr = key.toCharArray();
        Arrays.sort(sortingChArr);
        boolean[] isVisited = new boolean[keyLen];
        int[] indicies = new int[keyLen];


        for (int i = 0; i < keyLen; i++) {
            char cur = sortingChArr[i];

            for (int j = 0; j < keyLen; j++) {
                if (cur == chArr[j] && !isVisited[j]) {
                    isVisited[j] = true;
                    indicies[i] = j;
                    break;
                }
            }
        }

        return indicies;
    } // End of find()

    private static void input() throws IOException {
        key = br.readLine();
        password = br.readLine();
        keyLen = key.length();
        passwordLen = password.length();
        N = passwordLen / keyLen;
    } // End of input()
} // End of Main class
