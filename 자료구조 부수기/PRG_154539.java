import java.util.*;

class Solution {
    // https://school.programmers.co.kr/learn/courses/30/lessons/154539
    
    public int[] solution(int[] numbers) {
        int N = numbers.length;
        int[] answer = new int[N];
        Deque<Integer> list = new ArrayDeque<>();
        
        list.offerFirst(answer[0]);
        for(int i=1; i<N; i++) {
            
            while(!list.isEmpty() && numbers[list.peek()] < numbers[i]) {
                answer[list.pollFirst()] = numbers[i];
            }
            
            list.offerFirst(i);
        }
        
        while(!list.isEmpty()) {
            answer[list.pollFirst()] = -1;
        }
        
        
        return answer;
    } // End of solution()
} // End of Solution class