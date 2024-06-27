import java.util.*;

class Solution {
    public int maxSubArray(int[] nums) {
        // 누적합, 투 포인터

        int n = nums.length;
        int result = nums[0];
        int prev = nums[0];

        for(int i=1; i<n; i++) {
            int sum = prev + nums[i];

            // 합을 구했는데, nums[i] 값 보다 크면 누적 합 진행
            if(sum > nums[i]) {
                prev = sum;
            } else {
                // 합을 구했는데 nums[i]보다 작다면 굳이 연속합을 할 필요가 없다.
                // 처음부터 다시 시작
                prev = nums[i];
            }

            result = Math.max(result, prev);
        }

        return result;
    } // End of maxSubArray()
} // End of Solution class