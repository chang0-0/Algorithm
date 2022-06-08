import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Programmers_위장 {
    public int solution(String[][] clothes) {
        // 옷을 종류별로 구분한다.
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(Arrays.deepToString(clothes));

        // 2차원 배열을 행단위로 끊어서 하나씩 반복함.
        // 행단위의 1번째 열은 type이 됨.
        for(String [] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        System.out.println(map);

        // 2. 입지 않는 경우(none)를 추가해서 모든 경우의 수를 구한다.
        Iterator<Integer> it = map.values().iterator();
        int answer = 1;

        while(it.hasNext()) {
            // intValue -> Integer형을 int형으로 변환해줌
            // Itertor는 객체형만 저장이 되기때문에 형변환을 해줘야됨
            // 입지 않았을 경우를 추가하기 위해 + 1 을 해준다.
            answer *= it.next().intValue() + 1; 
        }

        // 마지막으로 아무것도 입지 않았을 경우 모두 none일 경우를 제거해야 하기 때문에
        // answer에 - 1을 해준다.
        return answer - 1;
    }
    public static void main(String[] args) {
        Programmers_위장 p = new Programmers_위장();
        String value[][] = {{"yellowhat", "headgear"}, 
                    {"bluesunglasses", "eyewear"},
                        {"green_turban", "headgear"}};
        
        System.out.println(p.solution(value));
    
    }
}
