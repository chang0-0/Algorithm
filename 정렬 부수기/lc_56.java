import java.util.*;
import java.io.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        // 배열의 앞 기준으로 정렬 후 뒤 기준으로 정렬
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        List<int[]> list = new ArrayList<>();

        int N = intervals.length;
        int i = 0;
        int j = i + 1;

        while(i < N) {
            int first = intervals[i][0];
            int last = intervals[i][1];

            while(j < N) {
                int b1 = intervals[j][0];
                int b2 = intervals[j][1];
                if(last >= b1) {
                    last = Math.max(last, b2);
                } else {
                    break;
                }
                j++;
            }

            int[] temp = {first, last};
            list.add(temp);
            i = j;
            j = i + 1;
        }

        int size = list.size();
        int[][] ans = new int[size][2];

        i = 0;
        for(i = 0; i<size; i++) {
            int[] t = list.get(i);

            ans[i] = t;
        }

        return ans;
    } // End of merge()
} // End of Solution class