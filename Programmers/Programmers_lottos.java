import java.util.Arrays;

public class Programmers_lottos {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // count는 맞는 개수
        
        // 순서가 상관없기 때문에 정렬을 함
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        //count는 로또에서 지워지지 않은 무조건 맞는 수
        int count = 0;

        //로또에서 지워져서 보이지 않는 수
        int zero = 0;

        for(int i=0; i<6; i++) {

            for(int j=0; j<6; j++) {
                if(lottos[i] == win_nums[j]) {
                    count++;
                }
    
            }

            if(lottos[i] == 0) {
                zero++;
            }
        }


        // zero + count일때는 최고 등수
        switch(zero + count) {
            case 6:
                answer[0] = 1;
                break;
            case 5:
                answer[0] = 2;
                break;    
            case 4:
                answer[0] = 3;
                break;       
            case 3:
                answer[0] = 4;
                break; 
            case 2:
                answer[0] = 5;
                break; 
            case 1:
                answer[0] = 6;
                break;       
            default:
                answer[0] = 6;
                break;
        }

        // count기준일때는 최저 등수
        switch(count) {
            case 6:
                answer[1] = 1;
                break;
            case 5:
                answer[1] = 2;
                break;    
            case 4:
                answer[1] = 3;
                break;       
            case 3:
                answer[1] = 4;
                break; 
            case 2:
                answer[1] = 5;
                break; 
            case 1:
                answer[1] = 6;
                break;       
            default:
                answer[1] = 6;
                break;
        }


        return answer;
    }

    public static void main(String[] args) {

        Programmers_lottos lotto = new Programmers_lottos();
        int lt[] = {45, 4, 35, 20, 3, 9};
        int wn[] = {20, 9, 3, 45, 4, 35};

        System.out.println(Arrays.toString(lotto.solution(lt, wn)));
    }
}
