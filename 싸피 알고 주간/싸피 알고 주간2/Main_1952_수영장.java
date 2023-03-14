import java.util.*;
import java.io.*;

// 출력해야 할 정답은 이용 계획대로 수영장을 이용하는 경우 중 가장 적게 지출하는 비용이다
public class Main_1952_수영장 {
    static int ticket1, ticket2, ticket3, ticket4;
    static int arr[];
    static int result;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/1952.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            ticket1 = Integer.parseInt(st.nextToken()); // 1일 이용권
            ticket2 = Integer.parseInt(st.nextToken()); // 1달 이용권
            ticket3 = Integer.parseInt(st.nextToken()); // 3달 이용권
            ticket4 = Integer.parseInt(st.nextToken()); // 1년 이용권
            init();

            result = ticket4; // 우선 1년권을 가장 작은 값으로 설정해 놓는다.
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            DFS(0, 0);
            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    // 어떤 티켓을 어떤 방식으로 구입하는게 가장 적은 비용을 만들 수 있는지 알 수 없으므로 모든 조합을 만들어서 가장 적게 만들어진 가격을 선택하는 것.
    private static void DFS(int month, int totalPrice) {
        if (month >= 12) {

            // 12달까지 조합이 완성되면, 가장 낮은 비용으로 갱신한다.
            result = Math.min(result, totalPrice);
            return;
        }

        // 해당 달이 가는 날이 있으면 메소드 실행
        if (arr[month] > 0) {
            // 1일권
            DFS(month + 1, totalPrice + (ticket1 * arr[month]));
            DFS(month + 1, totalPrice + ticket2);
            DFS(month + 3, totalPrice + ticket3);
        } else if (arr[month] == 0) {
            // 해당 달에 가는 날이 없는 경우, 다음달로 지나감
            DFS(month + 1, totalPrice);
        }
    } // End of DFS

    private static void init() {
        arr = new int[12];
    } // End of init
} // End of Main class