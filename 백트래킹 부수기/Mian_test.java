

import java.util.*;
import java.io.*;

public class Mian_test {
    static int N;
    static int[] arr;
    static int[] comb;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        comb = new int[3];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0);

    } // End of main

    // index자리에 i를 넣으면 중복을 허용하지 않는 순열이 완성됨
    // [1, 1, 1, 3] 은 딱 한번만 나오게 된다.


    // index자리에 0을 넣으면 중복을 허용하는 조합이 완성됨
    // [3, 1, 1, 1]
    // [1, 3, 1, 1]
    // [1, 1, 3, 1]
    // [1, 1, 1, 3]


    // index 자리에 i + 1을 넣을 경우
    // [1, 2, 3, 4]


    // index를 사용하지 않고 for문 i에 0을 넣었을 때,  isVisited를 사용
    // 중복을 허용하지 않는 조합이 완성된다.

    // index 없이 isVisited만 사용하면 중복을 허용하지 않는 순열 4P3
//        [1, 2, 3]
//        [1, 2, 4]
//        [1, 3, 2]
//        [1, 3, 4]
//        [1, 4, 2]
//        [1, 4, 3]
//        [2, 1, 3]
//        [2, 1, 4]
//        [2, 3, 1]
//        [2, 3, 4]
//        [2, 4, 1]
//        [2, 4, 3]
//        [3, 1, 2]
//        [3, 1, 4]
//        [3, 2, 1]
//        [3, 2, 4]
//        [3, 4, 1]
//        [3, 4, 2]
//        [4, 1, 2]
//        [4, 1, 3]
//        [4, 2, 1]
//        [4, 2, 3]
//        [4, 3, 1]
//        [4, 3, 2]


    // isVisited + index -> index를 i + 1로 (4C3)
    // 중복을 허용하지 않는 조합.
//            [1, 2, 3]
//            [1, 2, 4]
//            [1, 3, 4]
//            [2, 3, 4]

    // isVisited + index, index를 0으로 (중복을 허용하지 않는 순열) 4P3
//            [1, 2, 3]
//            [1, 2, 4]
//            [1, 3, 2]
//            [1, 3, 4]
//            [1, 4, 2]
//            [1, 4, 3]
//            [2, 1, 3]
//            [2, 1, 4]
//            [2, 3, 1]
//            [2, 3, 4]
//            [2, 4, 1]
//            [2, 4, 3]
//            [3, 1, 2]
//            [3, 1, 4]
//            [3, 2, 1]
//            [3, 2, 4]
//            [3, 4, 1]
//            [3, 4, 2]
//            [4, 1, 2]
//            [4, 1, 3]
//            [4, 2, 1]
//            [4, 2, 3]
//            [4, 3, 1]
//            [4, 3, 2]


    private static void comb(int depth, int index) {
        if (depth == 3) {
            System.out.println(Arrays.toString(comb));
            return;
        }

        for (int i = index; i < N; i++) {
            // if (isVisited[i]) continue;

            isVisited[i] = true;
            comb[depth] = arr[i];
            comb(depth + 1, i);
            isVisited[i] = false;
        }
    } // End of comb

} // End of Main class
