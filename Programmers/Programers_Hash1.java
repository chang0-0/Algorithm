import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Programers_Hash1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 1. HahsMap을 생성한다. (participant 기준)
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String player : participant) {
            // map에 player를 key로 추가한다.
            // 동명이인이 있을 수 있기때문에 같은 key가 있을 경우에는 value에 1을 더하도록 한다.
            // 위의 경우를 해결하기 위해 getOrDefault를 사용한다. 
            // 이전에 없었으면 0으로 만들어줌 그런데 뒤에서 + 1을 붙여서 value를 1로 만들어줌
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        // 2. HashMap을 뺀다 (completion 기준)
        for(String player : completion) {
            map.put(player, map.get(player) - 1);
        }
        
        // 3. value가 0이 아닌 값이 마지막 주자가 되기때문에 그 값을 찾는다
        for(String key: map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }

        // EntrySet 사용 경우
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        //iterator.hasNext()는 다음 값이 있는지 없는지 확인하는 메소드
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = iter.next();
            
            if(entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] part = {"leo", "kiki","leo", "eden"};
        String[] comp = {"kiki", "leo",  "leo"};
        Programers_Hash1 sol = new Programers_Hash1();

        System.out.println(sol.solution(part,comp));
    }

}