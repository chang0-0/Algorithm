import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_Stack_Queue2 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max = priorities[0];
        int max_index = 0;
        Queue<Integer> que = new LinkedList<>();
        // priorities는 우선순위
        // location은 내가 원하는 값

        // 처음 max 값 찾기
        for(int i=0; i<priorities.length; i++) {
            if(max < priorities[i]) {
                max = priorities[i];
                max_index = i;
            }
        }
        
        for(int i=max_index; i<priorities.length; i++) {
            que.add(priorities[i]);
        }

        for(int i=0; i<max_index; i++) {
            que.add(priorities[i]);
        }

        System.out.println(que);


        return answer;
    }

    public static void main(String[] args) {
        Programmers_Stack_Queue2 s = new Programmers_Stack_Queue2();
        int[] p = {2, 1, 3, 1, 1, 2, 2, 1, 1};
        int l = 0;

        System.out.println(s.solution(p, l));
    }
}
