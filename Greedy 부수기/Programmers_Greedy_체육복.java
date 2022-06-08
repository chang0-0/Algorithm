import java.util.ArrayList;
import java.util.Collections;

public class Programmers_Greedy_체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        // 빌려줄수 있는 학생의 번호
        ArrayList<Integer> reservelist = new ArrayList<>();
        ArrayList<Integer> lostlist = new ArrayList<>();

        int i = 0;
        while(reserve.length > i) {
            reservelist.add(reserve[i]);
            i++;
        }

        i = 0;
        while(lost.length > i) {
            lostlist.add(lost[i]);
            i++;
        }
        
         Collections.sort(lostlist);
         Collections.sort(reservelist);
        
                // 테스트 케이스 5, 12번 해결은 체육복 여분이 있는 학생이 도난을 당한 경우 미리 해결
         for(i = 0; i<reservelist.size(); i++) {
            loop: for(int j=0; j<lostlist.size(); j++) {
                if(reservelist.get(i) == lostlist.get(j)) {
                    lostlist.remove(j);
                    reservelist.remove(i);
                    i = -1;
                    answer ++;
                    break loop;
                }
            }
        }
        
        for(i=0; i<lostlist.size(); i++) {

            loop: for(int j=0; j<reservelist.size(); j++) {

                int k = -1;
                while(k<=1) {
                    if(lostlist.get(i) == reservelist.get(j) + k) {
                        reservelist.remove(j);
                        lostlist.remove(i);
                        i = -1;
                        answer ++;

                        if(reservelist.size() == 0 || lostlist.size() == 0) {
                            return answer;
                        }
                        break loop;
                    }

                    k++;
                }
            }
        }

        // 전체 학생수 n - 체육복을 빌리지 못한 학생수
        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int lost[] = {1, 2};
        int reserve[] = {2, 3};

        Programmers_Greedy_체육복 s = new Programmers_Greedy_체육복();

        System.out.println(s.solution(n, lost, reserve));

    }
}
