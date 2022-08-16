import java.util.*;
import java.io.*;

public class Main_1039_교환 {
    static String N;
    static int M;
    static int K;
    static int numN;
    static List<Change> memo = new ArrayList<>();

    static class Change {
        String num;
        int depth;

        Change(String num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    } // End of Change class

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1039.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        M = N.length();
        K = Integer.parseInt(st.nextToken());
        numN = Integer.parseInt(N);

        if(M == 1 || (M == 2 && N.charAt(1) == '0')) {
            System.out.print(-1);
            return;
        }

        System.out.println(BFS());
    } // End of main

    private static int BFS() {
        boolean visit[][] = new boolean[K + 1][1000001];
        Queue<Change> que = new LinkedList<>();
        que.offer(new Change(N, 0));
        visit[0][Integer.parseInt(N)] = true;

        int result = -1;
        while (!que.isEmpty()) {
            Change change = que.poll();

            if (change.depth == K) {
                result = Math.max(result, Integer.parseInt(change.num));
                continue;
            }

            for (int i = 0; i < M-1; i++) {
                for (int j = i + 1; j < M; j++) {

                    int newNum = swap(change.num, i, j);

                    if(newNum != -1 && !visit[change.depth + 1][newNum]) {
                        que.offer(new Change(Integer.toString(newNum), change.depth + 1));
                        visit[change.depth + 1][newNum] = true;
                    }
                }
            }
        }

        return result;
    } // End of DFS

    private static int swap(String numStr, int i, int j) {
        char chArr[] = String.valueOf(numStr).toCharArray();

        if(i == 0 && chArr[j] == '0') {
            // 교환되려고 하는 첫 번째 자리가 0이 될 경우, 교환할 필요가 없어짐.
            // 즉, i가 0인데 인덱스 0자리에 '0'이 올 경우는 고려하지 않음
            return -1;
        }

        char temp = chArr[i];
        chArr[i] = chArr[j];
        chArr[j] = temp;
        return Integer.parseInt(String.valueOf(chArr));
    } // End of swap
} // End of Main class