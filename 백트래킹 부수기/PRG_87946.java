import java.util.*;

class Solution {
    // https://school.programmers.co.kr/learn/courses/30/lessons/87946

    public static int N, K, ans;
    public static int[] comb;
    public static boolean[] isVisited;
    public static int[][] arr;
    
    public int solution(int k, int[][] dungeons) {
        input(k, dungeons);
        DFS(0, 0);
        
        return ans;
    } // End of solution()
    
public void DFS(int depth, int idx) { // idx 매개변수 추가
    if(depth == N) {
        System.out.println(Arrays.toString(comb));
        int count = 0;
        int temp = K;
        for(int i : comb) {
            if(temp >= arr[i][0]) {
                temp -= arr[i][1];
                count++;
            } else {
                break;
            }
        }
        
        ans = Math.max(ans, count);
        return;
    }
    
    for(int i = idx; i < N; i++) { // i를 idx부터 시작
        if(isVisited[i]) continue;
        isVisited[i] = true;
        comb[depth] = i;
        DFS(depth + 1, 0); // 다음 탐색을 위해 idx 매개변수 업데이트
        isVisited[i] = false;
    }
} // End of DFS()
    
    public void input(int k, int[][] dungeons) {
        arr = dungeons;
        N = arr.length;
        ans = 0;
        K = k;
        comb = new int[N];
        isVisited = new boolean[N];
    } // End of input()
} // End of Solution class