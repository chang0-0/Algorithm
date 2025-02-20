
import java.util.*;

class Solution {
    // https://school.programmers.co.kr/learn/courses/30/lessons/161989
    public int solution(int n, int m, int[] section) {
        int sectionIdx = 0;

        int count = 0;
        int len = 0;
        for(int i=1; i<=n; i++) {
            if(section[sectionIdx] == i) {
                if(len == 0) {
                    count++;
                    len = m;
                }
                sectionIdx++;
            }   

            if(sectionIdx == section.length) break;

            if(len > 0) {
                len--;
            }
        }

        return count;
    } // End of solution
} // End of Solution class