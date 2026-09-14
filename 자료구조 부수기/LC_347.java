import java.util.*;
import java.io.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int N = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> bucket = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            bucket.add(new ArrayList<>());
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue();
            bucket.get(cnt).add(num);
        }

        System.out.println(bucket);
        int[] ans = new int[k];
        int idx = 0;

        for(int cnt = N; cnt >= 1; cnt--) {
            if(bucket.get(cnt).isEmpty()) continue;

            for(int num : bucket.get(cnt)) {
                ans[idx++] = num;

                if(idx == k) return ans;
            }
        }

        return ans;
    } // End of main()
} // End of Main class