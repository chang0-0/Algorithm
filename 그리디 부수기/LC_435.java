import java.util.*;
import java.io.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> {
            return Integer.compare(a1[1], a2[1]);
        });


        int N = intervals.length;
        int M = 2;

        int preStart = Integer.MIN_VALUE;
        int preEnd = Integer.MIN_VALUE;
        int ans = 0;

        for(int i=0; i<N; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1]; 

            if(start >= preEnd) {
                preStart = start;
                preEnd = end;
            } else {
                ans++;
            }
        }


        return ans;
    } // End of eraseOverlapIntervals()
} // End of Solution class

