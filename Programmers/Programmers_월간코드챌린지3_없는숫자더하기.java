import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_월간코드챌린지3_없는숫자더하기 {
    public int solution(int[] numbers) {
        int count = 0;
        Arrays.sort(numbers);
            
        ArrayList<Integer> value = new ArrayList<>();
        ArrayList<Integer> num = new ArrayList<>();
        for(int i=0; i<10; i++) {
            num.add(i);
        }

        for(int i=0; i<numbers.length; i++) {
            value.add(i);
        }

        int j = 0;
        while(!value.isEmpty()) {
            int i = value.remove(0); 

            if(!num.contains(i)) {
                count += j;
            }
            j++;
        }

        return count;
    }
    
    public static void main(String[] args) {
        Programmers_월간코드챌린지3_없는숫자더하기 s = new Programmers_월간코드챌린지3_없는숫자더하기();
        int[] n = {1,2,3,4,6,7,8,0};
        System.out.println(s.solution(n));

    }
}
