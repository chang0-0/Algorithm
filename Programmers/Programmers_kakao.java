public class Programmers_kakao {
    public int solution(String[][] schedule) {
        
        // 1. 번쨰 과목
        String sub1[] = new String[schedule.length];

        for(int i=0; i<sub1.length; i++) {
            sub1[i] = schedule[i][0];
            System.out.println(sub1[i]);
        }

    
        
        int answer = -1;

        return answer;
    }
    
    public static void main(String[] args) {
        Programmers_kakao s = new Programmers_kakao();

        String arr[][] = {{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"}, 
        {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"},
         {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"},
          {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"}, 
          {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}};

        System.out.println(s.solution(arr));
    }
}
