package BOJ_16460;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_16460 {

    // https://www.acmicpc.net/problem/16460
    // input
    private static BufferedReader br;

    // variables
    private static int N, dist;
    private static String sex;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_16460\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<String> nameList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            StringTokenizer st = new StringTokenizer(temp);
            String name = st.nextToken();
            String s = st.nextToken();
            int d = Integer.parseInt(st.nextToken());

            if ((s.contains(sex) || sex.contains(s)) && dist >= d) {
                nameList.add(name);
            }
        }

        if (nameList.isEmpty()) {
            sb.append("No one yet");
        } else {
            int size = nameList.size();
            Collections.sort(nameList);

            for (int i = 0; i < size; i++) {
                sb.append(nameList.get(i)).append('\n');
            }
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        sex = st.nextToken();
        dist = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
