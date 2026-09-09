import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        int N = s.length();
        int left = 0;
        int max = 0;
        int[] count = new int[26];
        int ans = 0;

        for(int right = 0; right < N; right++) {
            count[s.charAt(right) - 'A']++;

            while(true) {
                for(int cnt : count) {
                    max = Math.max(max, cnt);
                }
                int length = right - left + 1; // 지금까지 슬라이딩 윈도우 범위 문자 길이
                int changeCount = length - max;

                if(changeCount <= k) {
                    // 아직 k개 까지 채워지지 않았기 때문에 right를 더 늘려도 된다.
                    break;
                }

                count[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    } // End of main()
} // End of Main class