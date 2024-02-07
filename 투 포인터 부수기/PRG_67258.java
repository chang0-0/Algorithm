import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> gemSet = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> gemMap = new HashMap<>();
        int start = 0, end = 0, minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while (true) {
            if (gemMap.size() == gemSet.size()) { // 모든 종류의 보석을 포함하면
                gemMap.put(gems[start], gemMap.get(gems[start]) - 1);
                
                if (gemMap.get(gems[start]) == 0) {
                    gemMap.remove(gems[start]);
                }
                start++;
            } else if (end == gems.length) { // 더 이상 끝을 옮길 수 없으면 종료
                break;
            } else { // 모든 종류를 포함하지 않으면
                gemMap.put(gems[end], gemMap.getOrDefault(gems[end], 0) + 1);
                end++;
            }
            
            // 모든 종류의 보석을 포함하고, 현재 구간의 길이가 더 짧으면 결과 업데이트
            if (gemMap.size() == gemSet.size() && end - start < minLength) {
                minLength = end - start;
                answer[0] = start + 1;
                answer[1] = end;
            }
            
            System.out.println(gemMap);
                        System.out.println(start);
                        System.out.println(end);
        }
        
        return answer;
    } // End of solution() 
} // End of Solution class