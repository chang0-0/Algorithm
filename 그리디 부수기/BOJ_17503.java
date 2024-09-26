package BOJ_17503;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17503 {

    // https://www.acmicpc.net/problem/17503
    // input
    private static BufferedReader br;

    // variables
    private static int N, M, K;
    private static PriorityQueue<Beer> pque;

    private static class Beer implements Comparable<Beer> {
        int prefer;
        int abv;

        private Beer(int prefer, int abv) {
            this.prefer = prefer;
            this.abv = abv;
        }

        @Override
        public int compareTo(Beer o) {
            // 도수는 낮고 선호도는 높고
            if (abv == o.abv) {
                return o.prefer - prefer;
            }

            return abv - o.abv;
        }
    } // End of Beer class

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_17503\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input();

        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() {
        StringBuilder sb = new StringBuilder();

        /*
            하루에 맥주 1병만 받을 수 있고 N일 동안 맥주 N병을 마시려고 한다.
            M을 채우면서 N개의 맥주를 모두 마실 수 있는 간 레벨의 최솟값을 출력하라
         */

        int preferSum = 0; // 선호도 합
        PriorityQueue<Integer> temp = new PriorityQueue<>();

        // 선호도 값
        int max = 1;

        while (!pque.isEmpty()) {
            Beer cur = pque.poll();

            preferSum += cur.prefer;
            temp.offer(cur.prefer);
            max = Math.max(max, cur.abv);

            //
            if (temp.size() == N) {
                // 선호도가 가장 낮은 맥주를 버린다.

                if (preferSum < M) {
                    preferSum -= temp.poll();
                } else {
                    break;
                }
            }
        }

        if (preferSum < M) {
            sb.append(-1);
        } else {
            sb.append(max);
        }

        return sb.toString();
    } // End of solve()

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pque = new PriorityQueue<>();
        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            pque.offer(new Beer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
    } // End of input()
} // End of Main class
