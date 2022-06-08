import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Baekjoon2438 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./TestCase.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++) {
            String str = br.readLine();
            System.out.println(str);
            System.out.println(str.split("").length);
        }
    
    }
}
