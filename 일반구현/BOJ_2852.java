package BOJ_2852;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2852 {

    // https://www.acmicpc.net/problem/2852
    // input
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\bigyo\\Desktop\\알고리즘\\JavaAlgorithm\\src\\BOJ_2852\\res.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        bw.write(solve());
        bw.close();
    } // End of main()

    private static String solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        // 총 48분간 진행된다.

        int N = Integer.parseInt(br.readLine());
        int team1Score = 0;
        int team2Score = 0;
        int team1Time = 0;
        int team2Time = 0;
        int winTeam = 0;

        // 가장 처음 이기게 된 시간.
        int lastWinGoalTime = 0;

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            if (team == 1) {
                team1Score++;
            } else {
                team2Score++;
            }

            int time = changeTime(st.nextToken());
            if (team1Score > team2Score) {
                if (winTeam == 2) {
                    team2Time += time - lastWinGoalTime;
                    lastWinGoalTime = time;
                } else if (winTeam == 0) {
                    lastWinGoalTime = time;
                }
                winTeam = 1;
            } else if (team1Score < team2Score) {
                if (winTeam == 1) {
                    team1Time += time - lastWinGoalTime;
                    lastWinGoalTime = time;
                } else if (winTeam == 0) {
                    lastWinGoalTime = time;
                }
                winTeam = 2;
            } else {
                if (winTeam == 1) {
                    team1Time += time - lastWinGoalTime;
                } else if (winTeam == 2) {
                    team2Time += time - lastWinGoalTime;
                }
                winTeam = 0;
                lastWinGoalTime = time;
            }
        }

        int endTime = 48 * 60;
        if (winTeam == 1) {
            team1Time += endTime - lastWinGoalTime;
        } else if (winTeam == 2) {
            team2Time += endTime - lastWinGoalTime;
        }

        String team1Result = formatTime(team1Time);
        String team2Result = formatTime(team2Time);
        sb.append(team1Result).append('\n').append(team2Result);
        return sb.toString();
    } // End of solve()

    private static String formatTime(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%02d:%02d", minutes, seconds);
    } // End of formatTime()

    private static int changeTime(String str) {
        int time = 0;

        StringTokenizer st = new StringTokenizer(str, ":");
        time += Integer.parseInt(st.nextToken()) * 60;
        time += Integer.parseInt(st.nextToken());
        return time;
    } // End of changeTime
} // End of Main class
