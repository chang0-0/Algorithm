import java.util.ArrayList;

public class Programmers_claw_machine_game {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> basket = new ArrayList<Integer>();

        for(int i=0; i<moves.length; i++) {
             int move = moves[i] - 1;

            int j = 0;
            // board의 열을 검사해서 0일경우 계속 반복해서
            // 0이 아닌 값을 찾음
            while(board[j][move] == 0) { 
                // 만약 board열 전체를 다 돌았는데 모두 0일경우 그대로 반복문을 중단함
                if(j >= board.length - 1) {
                    break;
                }
                else {
                    j++;
                }
            }

            //열의 마지막 값이 0일 경우 그냥 넘어감
            if(board[j][move] == 0) {
                continue;
            }
            else {
                // 뽑기에서 숫자가 빠져나간 자리는 다시 0으로 채워줌
                int temp = board[j][move];
                board[j][move] = 0;
                basket.add(temp);
            }
            
            // 바구니의 사이즈가 2이상일 경우 검사함
            if(basket.size() >= 2) {
                //바구니의 2번째부터 검사를 시작함
                for(int k=1; k<basket.size(); k++) {
                    // basket을 가장 앞부터 반복해서 검사한다.
                    // 만약 k번째에 있는 값과 k-1번째의 값이 똑같으면 remove를 실행한다.
                    if(basket.get(k) == basket.get(k - 1)) {
                        basket.remove(k);
                        basket.remove(k - 1);

                        // answer을 증가시킨후 계속 진행
                        answer += 2;
                        continue;
                    }
                }
            }
        }
        return answer;
    }
   
    public static void main(String[] args) {
        Programmers_claw_machine_game p = new Programmers_claw_machine_game();
        int b[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int m[] = {1,5,3,5,1,2,1,4};

        System.out.println(p.solution(b, m));
    }
}
