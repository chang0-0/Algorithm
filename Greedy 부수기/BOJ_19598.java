package BOJ_19598;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_19598 {

    // https://www.acmicpc.net/problem/19598
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static Room[] rooms;

    private static class Room implements Comparable<Room> {
        int start;
        int end;

        private Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            // 제일 빨리 끝나는 시간 기준
            return end - o.end;
        }
    } // End of Room class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_19598\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        Arrays.sort(rooms, (o1, o2) -> Integer.compare(o1.start, o2.start));
        PriorityQueue<Room> pque = new PriorityQueue<>();
        int max = 0;

        for (int i = 0; i < N; i++) {
            Room cur = rooms[i];

            while (!pque.isEmpty()) {
                Room peek = pque.peek();

                if (cur.start >= peek.end) {
                    pque.poll();
                } else {
                    break;
                }
            }

            pque.offer(cur);
            max = Math.max(max, pque.size());
        }


        sb.append(max);
        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        rooms = new Room[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rooms[i] = new Room(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
    } // End of input()
} // End of Main class
