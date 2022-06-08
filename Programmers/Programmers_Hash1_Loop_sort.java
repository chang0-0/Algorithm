import java.util.Arrays;

public class Programmers_Hash1_Loop_sort {

    public String solution(String[] participant, String[] completion) {
        //1. 배열을 정렬(sort) 한다.
        Arrays.sort(participant);
        Arrays.sort(completion);

        //2. 두 배열이 다를 때 까지 찾는다.
    
        //⭐⭐완주하지 못한선수가 마지막일 경우의 예외처리를 해줘야 함
        // for(int i=0; i<completion.length; i++) {
        //     if(!participant[i].equals(completion[i])) {
        //         return participant[i];
        //     }
        // }

        int i = 0;
        for(;i<completion.length; i++) {
            // participant의 i번째와 completion의 i번째의 값이 같지 않다면 그 값이 완주하지 못한사람이 된다.
            if(!participant[i].equals(completion[i])) {
                break;
            }
        }

        //3. 전체를 모두 반복했는데도 찾지 못했다면, 마지막 주자가 완주하지 못한 선수다
        return participant[i];
    }

    public static void main(String[] args) {
        Programmers_Hash1_Loop_sort p = new Programmers_Hash1_Loop_sort();

        String[] part = {"A", "B", "C"};
        String[] comp = {"A",  "B"};

        System.out.println(p.solution(part, comp));
    }
}
