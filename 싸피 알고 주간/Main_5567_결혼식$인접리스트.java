import java.util.*;
import java.io.*;

public class Main_5567_결혼식$인접리스트 {
    // 목표: 출발점에서 어디 까지 갈 수 있는지를 체크하고, 몇번의 과정을 통해서 도달하는지를 확인하기.
    private static final int MAX_RELATION = 501;
    static List<List<Relationship>> friendList = new ArrayList<>();
    static int dist[];
    static int N;

    static class Relationship implements Comparable<Relationship> {
        int num;
        int weight;

        Relationship(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Relationship o) {
            return this.weight - o.weight;
        }
    } // End of Relationship

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/5567.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            friendList.add(new ArrayList<>());
        }
        Arrays.fill(dist, MAX_RELATION);

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            friendList.get(first).add(new Relationship(second, 1));
            friendList.get(second).add(new Relationship(first, 1));
        }

        graphSearch(1);

        int count = 0;
        for(int num : dist) {
            if(num <= 3) {
                count++;
            }
        }

        System.out.println(count-1); // 자신은 제외하기 위해 -1
    } // End of main

    private static void graphSearch(int num) {
        Queue<Relationship> que = new LinkedList<>();
        boolean visit[] = new boolean[N + 1];
        dist[num] = 1;
        que.offer(new Relationship(num, 1));

        while (!que.isEmpty()) {
            Relationship relationship = que.poll();
            int friendNum = relationship.num;

            if (!visit[friendNum]) {
                visit[friendNum] = true;

                for (Relationship r : friendList.get(friendNum)) {
                    if (!visit[r.num] && dist[r.num] > (dist[friendNum] + r.weight)) {
                        dist[r.num] = dist[friendNum] + r.weight;
                        que.offer(new Relationship(r.num, dist[r.num]));
                    }
                }
            }
        }

    } // End of graphSearch

//    private static void graphSearch(int num) {
//        Queue<Relationship> que = new LinkedList<>();
//        boolean visit[] = new boolean[N + 1];
//        dist[num] = 1;
//        que.offer(new Relationship(num, 1));
//
//        while (!que.isEmpty()) {
//            Relationship relationship = que.poll();
//            int friendNum = relationship.num;
//
//            if (!visit[friendNum]) {
//                visit[friendNum] = true;
//
//                for (Relationship r : friendList.get(friendNum)) {
//                    if (!visit[r.num] && dist[r.num] > dist[friendNum] + r.weight) {
//                        dist[r.num] = dist[friendNum] + r.weight;
//                        que.offer(new Relationship(r.num, dist[r.num]));
//                    }
//                }
//            }
//        }
//
//    } // End of graphSearch


} // End of Main class