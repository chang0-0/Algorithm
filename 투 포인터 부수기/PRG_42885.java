import java.util.*;

class Solution {
    private static int N, limit, ans;
    private static int[] people;
    
    public int solution(int[] people, int limit) {
        
        Arrays.sort(people);
        this.people = people;
        N = people.length;
        this.limit = limit;
        ans = 0;
        twoPointer(0, N - 1);
        
        return ans;
    } // End of solution()
    
    public void twoPointer(int low, int high) {
        if(low > high) {
            return;
        }
        
        if(people[low] + people[high] <= limit) {
            twoPointer(low + 1, high - 1);
        } else {
            twoPointer(low, high  - 1);
        }
        
        ans++;
        return;
    } // End of twoPointer()
} // End of Solution class