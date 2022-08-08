import java.util.Scanner;

public class test{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt(); // 할머니가 넘어온 날
        int K = sc.nextInt(); // 호랑이에게 준 떡의 개수

        int [] ddeok = new int [D]; // 넘어논 날 만큼 배열 생성
        ddeok[D-1] = K; // 배열 떡의 마지막 부분은 마지막 날 호랑이에게 준 떡의 개수
        int A = 1;

        while(true){
            ddeok[0] = A; // 1부터 시작
            for(int i=A; i<K; i++){ // ddeok[1] 번의 범위 A보다 크고 K보다 작음
                ddeok[1] = i;
                for(int j=2; j<D-1; j++){ // 배열 채우기 D-2번 까지
                    ddeok[j] = ddeok[j-1] + ddeok[j-2]; // 오늘의 떡의 개수는 전날과 전전날에 준 떡의 개수의 합
                }
                // 배열 완성 후 떡의 마지막 인덱스 (K개) 가 뒤에서 첫번째, 두번째 배열의 합과 같으면
                if(ddeok[D-1] == ddeok[D-2]+ddeok[D-3]){
                    System.out.println(ddeok[0]);
                    System.out.println(ddeok[1]); // 첫날과 두번째날에 준 개수 출력 후 종료
                    return;
                }
            }
            A++; // 만약 같지않다면 A + 1 한 후 다시 배열 채우고 비교하기기
       }

    }
}