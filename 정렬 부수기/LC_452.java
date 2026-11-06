import java.util.*;
import java.io.*;

// 모든 풍선을 터트리기 위한 최소 화살 개수

class Solution {
    public int findMinArrowShots(int[][] points) {

        int N = points.length;

        // 정렬 겹치는 풍선 찾기.
        Arrays.sort(points, (a1, a2) -> {
            return Integer.compare(a1[0], a2[0]);
        });

        int preStartX = points[0][0];
        int preEndX = points[0][1];
        int count = 1;

        for(int i=1; i<N; i++) {
            int nextStartX = points[i][0];
            int nextEndX = points[i][1];
            
            // 화살 가능 범위를 계산하기.
            if(preEndX >= nextStartX) {    
                // 화살을 쏠 수 있는 범위 조정하기
                if(preStartX < nextStartX) {
                    preStartX = nextStartX;
                }

                if(nextEndX < preEndX) {
                    preEndX = nextEndX;
                }
            } else {
                preStartX = nextStartX;
                preEndX = nextEndX;
                count++;
            }
        }

        
        return count;
    } // End of main()
} // End of Main class