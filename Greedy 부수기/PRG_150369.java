package PRG_150369;

class Solution {
    // https://school.programmers.co.kr/learn/courses/30/lessons/150369

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int dPointer = n - 1;
        int pPointer = n - 1;

        while (dPointer >= 0 || pPointer >= 0) {

            while (dPointer >= 0 && deliveries[dPointer] == 0) dPointer--;
            while (pPointer >= 0 && pickups[pPointer] == 0) pPointer--;

            int sum = 0;

            answer += (Math.max(dPointer, pPointer) + 1) * 2;

            // dPointer 조정
            while (dPointer >= 0 && sum < cap) {
                sum += deliveries[dPointer];
                deliveries[dPointer--] = 0;
            }
            if (sum > cap) {
                deliveries[++dPointer] = sum - cap;
            }

            sum = 0;
            // pPointer 조정
            while (pPointer >= 0 && sum < cap) {
                sum += pickups[pPointer];
                pickups[pPointer--] = 0;
            }
            if (sum > cap) {
                pickups[++pPointer] = sum - cap;
            }
        }

        return answer;
    } // End of solution()
} // End of Solution class