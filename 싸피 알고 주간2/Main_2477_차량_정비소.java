import java.util.*;
import java.io.*;

public class Main_2477_차량_정비소 {
    static int N, M, K, A, B, result;
    static int[] people;
    static Desk[] reception, repair;
    static List<Person> personList;

    static class Person {
        int num;
        int arrivalTime;
        int enterTime; // 들어온 시간
        int outTime; // 나갈 시간
        int usedReceptionNum;
        int usedRepairNum;

        public Person(int num, int arrivalTime, int enterTime, int outTime, int usedReceptionNum, int usedRepairNum) {
            this.num = num;
            this.arrivalTime = arrivalTime;
            this.enterTime = enterTime;
            this.outTime = outTime;
            this.usedReceptionNum = usedReceptionNum;
            this.usedRepairNum = usedRepairNum;
        }
    } // End of Person

    static class Desk {
        int workTime; // 업무 시간.
        Person person;

        public Desk(int workTime, Person person) {
            this.workTime = workTime;
            this.person = person;
        }
    } // End of Desk class


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/2477.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append('#').append(t).append(' ');

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken()); // 지갑을 두고 간 고객이 이용한 접수 창구 번호
            B = Integer.parseInt(st.nextToken()); // 지갑을 두고 간 고객이 이용한 정비 창구 번호
            init(); // 변수 초기화 메소드

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                reception[i] = new Desk(Integer.parseInt(st.nextToken()), null);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                repair[i] = new Desk(Integer.parseInt(st.nextToken()), null);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                people[i] = Integer.parseInt(st.nextToken()); // 시간 값 저장
                personList.add(new Person(i, people[i], 0, 0, 0, 0)); // 인덱스를 번호로 하고, value를 시간으로 저장
            }

            int time = 0;
            int peopleIndex = 0;
            List<Integer> AwaitingList = new LinkedList<>(); // 창구 A 대기열
            List<Integer> BwaitingList = new LinkedList<>(); // 창구 B 대기열
            List<Person> tempList = new LinkedList<>(); // A창구에서 나와서 B창구로 넘어갈 때 쓰일 임시 저장 list

            for (; ; ) {
                // 시간이 따라 도착하는 사람을 찾아서 있을 경우 OR 현재 대기중인 사람이 있을 경우, 시간에 따라 창구에 자리가 나는지 계속 확인해야됨.

                System.out.println("(시작) 현재시간 : " + time);

                // 우선순위 첫번째, 먼저 시간에 따라 나갈 사람이 있는지를 확인.
                // A창구를 기준으로 나갈 사람이 있으면 내보낸다.
                if (isEmptyADesk(time) > 0) {
                    for (int i = 0; i < N; i++) {
                        // 현재 빠져나갈 값들은 temp에 저장하고 null값 처리로 해서 자리가 비었다는 것을 표시해줌.
                        if (reception[i].person != null && reception[i].person.outTime == time) {
                            tempList.add(reception[i].person);
                            reception[i].person = null;
                        }
                    }
                }

                // B창구 쪽에서도 나갈 사람이 있는지 확인 B창구는 따로 tempList에 저장X
                if (isEmptyBDesk(time) > 0) {
                    for (int i = 0; i < M; i++) {
                        // 현재 빠져나갈 값들은 temp에 저장하고 null값 처리로 해서 자리가 비었다는 것을 표시해줌.
                        if (repair[i].person != null && repair[i].person.outTime == time) {
                            tempList.add(repair[i].person);
                            repair[i].person = null;
                        }
                    }
                }

                if (peopleIndex == people.length) break;
                System.out.println("peopleIndex : " + peopleIndex);

                // 빠져 나갈 사람은 다 빠져나갔으니, A창구 먼저 진행
                // 1. 먼저 시간에 맞는 사람이 있는지 확인하기. 시간대에 맞는 사람이 있을 경우 while문을 통해서 사람 찾기
                while (people[peopleIndex] == time) {
                    // 2. 빈 자리가 있는지 확인
                    int hole = isEmptyADesk(time);

                    if (hole > 0) { // 빈자리가 있을 때,
                        // 2-2 빈자리가 있으면 (true) 다시 AwaitingList가 비어있는지 확인
                        if (AwaitingList.isEmpty()) {
                            for (int i = 0; i < N; i++) {
                                if (reception[i].person != null) continue; // 자리가 비어있지 않은 곳은 그대로 통과.

                                personList.get(peopleIndex).usedReceptionNum = i + 1; // 사용한 A창구 번호 설정
                                personList.get(peopleIndex).enterTime = time; // A창구에 들어온 시간 설정
                                personList.get(peopleIndex).enterTime = time + reception[i].workTime; // A창구에서 나갈 시간 설정
                                reception[i].person = personList.get(peopleIndex);
                                peopleIndex++;
                            }
                        } else {
                            // 대기열에 사람이 있으면 대기열에 있는 사람이 우선순위로 들어감.
                            while (!AwaitingList.isEmpty()) {
                                int num = AwaitingList.remove(0);

                                for (int i = 0; i < N; i++) {
                                    if (reception[i].person != null) continue;

                                    personList.get(num).usedReceptionNum = i + 1; // 사용한 A창구 번호 설정
                                    personList.get(num).enterTime = time; // A창구에 들어온 시간 설정
                                    personList.get(num).enterTime = time + reception[i].workTime; // A창구에서 나갈 시간 설정
                                    reception[i].person = personList.get(num); // 사람 객체 자체를 넘겨줌.
                                }
                            }

                            // 대기열이 비었는데, 아직 창구에 자리가 남았을 경우, 시간에 맞는 사람이 들어갈 수 있기 때문에 자리가 있는지 확인
                            if (isEmptyADesk(time) != 0) {
                                for (int i = 0; i < N; i++) {
                                    if (reception[i].person != null) continue; // 자리가 비어있지 않은 곳은 그대로 통과.

                                    personList.get(peopleIndex).usedReceptionNum = i + 1; // 사용한 A창구 번호 설정
                                    personList.get(peopleIndex).enterTime = time; // A창구에 들어온 시간 설정
                                    personList.get(peopleIndex).enterTime = time + reception[i].workTime; // A창구에서 나갈 시간 설정
                                    reception[i].person = personList.get(peopleIndex);
                                    peopleIndex++;
                                }
                            }
                        }

                    } else if (hole == 0) { // 빈자리가 없을 경우, 그냥 대기열에 추가만 해줌
                        AwaitingList.add(people[peopleIndex]);
                        peopleIndex++;
                    }
                }

                // A창구 종료.


                System.out.println(tempList);


                System.out.println("코드 마지막 시간 : " + time);
                time++; // 시간은 계속 증가
                if (time == 30) break; // 테스트용 무한 반복 방지
            } // End of for(;;)


            // 마지막 결과 출력
            // 전체 사람을 순회해서 A 창구를 이용한 번호와 B 창구를 이용한 번호를 확인
            for (Person p : personList) {
                if (A == p.usedReceptionNum && B == p.usedReceptionNum) {
                    // 조건에 부합할 경우 결과에 번호를 합함.
                    result += p.num;
                }
            }

            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static int isEmptyADesk(int time) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            Person p = reception[i].person;

            if (p == null || p.outTime == time) {
                count++;
            }
        }

        return count;
    } // End of isEmptyADesk

    private static int isEmptyBDesk(int time) {
        int count = 0;
        for (int i = 0; i < M; i++) {
            Person p = repair[i].person;

            if (p == null || p.outTime == time) {
                count++;
            }
        }

        return count;
    } // End of isEmptyBDesk

    private static void init() {
        reception = new Desk[N];
        repair = new Desk[M];
        people = new int[K];
        result = -1; // 결과 값이 없을 경우 -1을 출력하기 위해 -1로 초기화.
        personList = new LinkedList<>();
    } // End of init
} // End of Main class