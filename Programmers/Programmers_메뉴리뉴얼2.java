import java.util.*;

public class Programmers_메뉴리뉴얼2 {
    List<String> answerList = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    private void combination (String order, String others, int count) {
        // 탈출 조건
        if(count == 0) {
            map.put(order, map.getOrDefault(order, 0) + 1);
            return;
        }

        // 수행 동작 -> 0부터 length까지 조합
        for(int i=0; i<others.length(); i++) {
            combination(order + others.charAt(i), others.substring(i+1), count - 1);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        // 1. 각 order 정렬
        for(int i=0; i<orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        // 2. 각 order를 기준으로 courseLength만큼의 조합 만들기
        for(int courseLength : course) {
            for(String order : orders) {
                // combination -> 재귀함수 생성
                // 문자열로 만들 수 있는 조합을 계산하는 함수
                combination("", order, courseLength);
            }

            // 3. 가장 많은 조합을 answer에 저장한다.
            if(!map.isEmpty()) {
                System.out.println("map.values() : " + map.values());
                List<Integer> countList = new ArrayList<>(map.values());
                int max = Collections.max(countList);

                if(max > 1) {
                    for(String key : map.keySet()) {
                        if(map.get(key) == max) {
                            answerList.add(key);
                        }
                    }
                }

                map.clear();
            }
        }

        // List를 정렬 후 Array로 변환
        Collections.sort(answerList);
        String answer[] = new String[answerList.size()];
        
        
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        Programmers_메뉴리뉴얼2 s = new Programmers_메뉴리뉴얼2();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

        System.out.println(Arrays.toString(s.solution(orders, course)));
    }
}
