import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_Stack_Queue1 {

    public int[] solution(int [] progresses, int[] speeds) {
        int count = 0;
        Queue<Integer> progresses_que = new LinkedList<Integer>();
        Queue<Integer> speed_que = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        //que에 넣는 작업
        for(int i=0; i<progresses.length; i++){
            progresses_que.offer(progresses[i]);
            speed_que.offer(speeds[i]);
        }

        //que의 size가 0일때까지 계속해서 반복
        while(progresses_que.isEmpty() == false) {
            for(int j=0; j<progresses_que.size(); j++) {
                int num = progresses_que.peek(); 
                System.out.println("첫번째 반복 검사" + progresses_que); 

                // 90에서 계속 0을 더하는 문제 발생.
                if(num >= 100) {
                    progresses_que.poll();
                    speed_que.poll();
                    speed_que.offer(0);
                    progresses_que.offer(num);
                }
                else {
                    int speed_value = speed_que.poll();
                    progresses_que.poll();
                    progresses_que.offer(speed_value + num);
                    speed_que.offer(speed_value);
                }
            }

            // 큐에서 첫번째 100이 탄생하면 그때부터 문제가 생김.
            System.out.println("돌고난 progresses_que" + progresses_que);
            System.out.println("스피드 큐 : " + speed_que);

            // 무조건 3바퀴를 다 돌고 나왔을때 검사를 해야됨
            // 그다음 count를 증가시켜서 
            // 앞에서부터 100인지 아닌지 검사를 함           
            
            while(progresses_que.peek() >= 100) {
                progresses_que.poll();
                speed_que.poll();
                count ++;    

                if(progresses_que.isEmpty() == true) {
                    break;
                }
            }

            if(count != 0) {
                result.offer(count);
            }

            count = 0;
        }   
        
            System.out.println(result);
            int answer[] = new int [result.size()];
            int size = result.size();
            for(int i=0; i<size; i++) {
                int a = result.poll();
                answer[i] = a;
            }

            return answer;
        }

    public static void main(String[] args) {
        Programmers_Stack_Queue1 psq = new Programmers_Stack_Queue1();
        int[] progresses = {93,30,55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(psq.solution(progresses, speeds)));
    }
}
