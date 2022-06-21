import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1145 {
    public static void main(String[] args) throws IOException {
        // 띄어쓰기 정수 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int value[] = new int[5];

        for(int i=0; i<value.length; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(value);
        int min = value[0];
        int count = 0;


        while(true) {
            for(int i=0; i<5; i++) {
               if(min % value[i] == 0) {
                    count++;    
               } 
            }

            if(count >= 3) {
                System.out.println(min);
                return;
            }
            count = 0;
            min++;
        }
    }          
}