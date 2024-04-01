package BOJ_9205;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_9205 {

    // https://www.acmicpc.net/problem/9205
    // input
    private static BufferedReader br;

    // variables
    private static int N;
    private static Coordinate[] conveniences;
    private static Coordinate start, dest;

    private static class Coordinate {
        int x;
        int y;
        int beer;

        private Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Coordinate(int x, int y, int beer) {
            this.x = x;
            this.y = y;
            this.beer = beer;
        }
    } // End of Coordinate

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_9205\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            input();

            bw.write(solve());
        }

        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        boolean ret = BFS();

        if (ret) {
            sb.append("happy");
        } else {
            sb.append("sad");
        }
        sb.append('\n');

        return sb.toString();
    } // End of solve()

    private static boolean BFS() {
        LinkedList<Coordinate> que = new LinkedList<>();
        boolean[] isVisited = new boolean[N];

        que.offer(new Coordinate(start.x, start.y, 20));


        while (!que.isEmpty()) {
            Coordinate current = que.poll();

            if (isAbleCheck(current.x, current.y, dest.x, dest.y, current.beer) >= 0) {
                return true;
            }


            for (int i = 0; i < N; i++) {
                if (isVisited[i]) continue;
                Coordinate next = conveniences[i];

                int ret = isAbleCheck(current.x, current.y, next.x, next.y, current.beer);

                if (ret >= 0) {
                    isVisited[i] = true;
                    que.offer(new Coordinate(next.x, next.y, 20));
                }
            }
        }

        return false;
    } // End of BFS()

    private static int isAbleCheck(int nextX, int nextY, int currentX, int currentY, int remainingBeers) {
        int dist = distCalc(nextX, currentX, nextY, currentY);
        // 해당 지점까지 맥주의 남은 맥주로 갈 수 있는지 계산하기
        int canDist = remainingBeers * 50;

        return canDist - dist;
    } // End of isAbleCheck()

    private static int distCalc(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    } // End of distCalc()

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        conveniences = new Coordinate[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            conveniences[i] = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        dest = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    } // End of input()
} // End of Main class
