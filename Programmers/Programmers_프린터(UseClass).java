import java.util.ArrayList;
import java.util.List;

class Programmers_프린터 {
    // Class 사용
    public int solution(int[] priorities, int location) {
        // 1. Queue를 만든다
        List<PrintJob> printer = new ArrayList<PrintJob>();
        for(int i=0; i<priorities.length; i++) {
            printer.add(new PrintJob(i, priorities[i]));
        }

        int turn = 0;
        while(!printer.isEmpty()) {
            // 2. 0번을 꺼내서 max priority가 아니면 다시 끝에 넣는다.
            PrintJob job = printer.remove(0);
            if(printer.stream().anyMatch(otherJob -> job.priority < otherJob.priority)) {
                printer.add(job);
            }
            else {
                // 3. max priority이면 내가 찾는 job이 맞는지 확인한다.
                turn ++;
                if(location == job.location) {
                    break;
                }
            }
        }
        return turn;
    }
    
    class PrintJob {
        int priority;
        int location;

        public PrintJob(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Programmers_프린터 s = new Programmers_프린터();
        int p[] = {2, 1, 3, 2};
        int lo = 2;
        
        System.out.println(s.solution(p, lo));
    }
}