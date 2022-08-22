import java.util.*;
import java.io.*;

public class Algo1_구미_6반_최창영 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/solution1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append('#').append(t).append(' ');

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int maxLen = 0;
			// 높은 수 낮은 수 들 높은 수
			for (int i = 0; i < N - 1; i++) {
				List<Integer> list = new ArrayList<>();
				int startHeight = arr[i];

				// 처음값과 다음값이 같으면 진행할 필요가 없음
				if (arr[i] == arr[i + 1]) {
					continue;
				}

				list.add(startHeight);
				int preHeight = -1;
				int middleHeight = -1;

				// 같은 값은 지나쳐야됨
				
				// 중간높이와 이전의 값을 비교하면서 지나감
				for (int j = i + 1; j < N; j++) {
					middleHeight = arr[j];

					if (list.size() > 1 && preHeight < middleHeight) {
						list.add(middleHeight);
						break;
					}

					if (preHeight == -1 && middleHeight < startHeight) {
						list.add(middleHeight);
						preHeight = middleHeight;
						continue;
					}

					if (preHeight < middleHeight) {
						list.add(middleHeight);
						break;
					}

					if (preHeight >= middleHeight) {
						list.add(middleHeight);
					}

					preHeight = middleHeight;
				}
				
				// list 사이즈가 3이하면 골짜기가 안되기 때문애 0이 되어야 함
				if (list.size() < 3) {
					maxLen = Math.max(maxLen, 0);
				} else {
					maxLen = Math.max(maxLen, list.size());
				}

			}

			sb.append(maxLen).append('\n');
		}

	bw.write(sb.toString());bw.close();
} // End of main
} // End of Algo1_구미_6반_최창영 class