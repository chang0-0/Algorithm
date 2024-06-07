package BOJ_3018;

import java.io.*;
import java.util.*;

public class BOJ_3018 {

    // https://www.acmicpc.net/problem/3018
    // input
    private static BufferedReader br;

    // variables
    private static int N, E;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_3018\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        int totalSongCount = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int memberCount = Integer.parseInt(st.nextToken());
            int[] member = new int[memberCount];

            for (int j = 0; j < memberCount; j++) {
                member[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(member);
            if (member[0] == 1) {
                totalSongCount++;

                for (int num : member) {
                    Set<Integer> list = map.get(num);
                    list.add(totalSongCount);
                    map.put(num, list);
                }
            } else {
                // 선영이가 오지 않았을 때, 서로 아는노래 공유
                Set<Integer> nowSongs = new HashSet<>();
                for (int num : member) {
                    Set<Integer> list = map.get(num);
                    nowSongs.addAll(list);
                }

                for (int num : member) {
                    Set<Integer> list = map.get(num);
                    list.addAll(nowSongs);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (map.get(i).size() == totalSongCount) {
                sb.append(i).append('\n');
            }
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
    } // End of input()
} // End of Main class
