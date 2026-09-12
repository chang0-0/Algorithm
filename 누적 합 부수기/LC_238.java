import java.util.*;
import java.io.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        
        // 32비트 정수.
        int[] left = new int[N + 1];
        left[0] = 1;
        for(int i=1; i<=N; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        // suffix 오른쪽 누적 곱
        int[] right = new int[N + 1];
        right[N] = 1;
        for(int i=N-1; i>=0; i--) {
            right[i] = nums[i] * right[i + 1];
        }

        // ans[i] = left[i] * right[i + 1];
        // left는 크기가 N + 1 이므로, 같은 nums의 index기준, left의 index는 해당 nums[i]의 값을 포함하지 않은 누적곱임
        // right는 크기가 N + 1, 오른쪽에서 곱해지므로, 당연하게도 i + 1까지의 값은 오른쪽 부터 i가 포함되지 않은 오른쪽 누적곱임.

        int[] ans = new int[N];
        for(int i=0; i<N; i++) {
            ans[i] = left[i] * right[i + 1];
        }
        
        return ans;
    } // End of main()
} // End of Main class