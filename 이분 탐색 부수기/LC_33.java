import java.util.*;
import java.io.*;

class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;
        int left = 0;
        int right = N - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    // target이 left 보다는 크고, mid보다는 작을 때,
                    right = mid - 1;
                } else {
                    left = mid + 1; 
                }
            } else {
                // 왼쪽이 정렬되어 있지 않은 경우.
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    } // End of main()
} // End of Main class