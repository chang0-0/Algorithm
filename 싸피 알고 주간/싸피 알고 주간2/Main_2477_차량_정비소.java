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
            A = Integer.parseInt(st.nextToken()); // 지갑을 두고 간 고객이 이용한 A 창구 번호
            B = Integer.parseInt(st.nextToken()); // 지갑을 두고 간 고객이 이용한 B 창구 번호
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
                personList.add(new Person(i + 1, people[i], 0, 0, 0, 0)); // 인덱스를 번호로 하고, value를 시간으로 저장
            }

            int time = 0;
            List<Integer> AwaitingList = new LinkedList<>(); // 창구 A 대기열
            List<Integer> BwaitingList = new LinkedList<>(); // 창구 B 대기열
            List<Person> tempList = new LinkedList<>(); // A창구에서 나와서 B창구로 넘어갈 때 쓰일 임시 저장 list

            for (; ; ) {
                // 시간이 따라 도착하는 사람을 찾아서 있을 경우 OR 현재 대기중인 사람이 있을 경우, 시간에 따라 창구에 자리가 나는지 계속 확인해야됨.

                // 우선순위 첫번째, 먼저 시간에 따라 나갈 사람이 있는지를 확인.
                // A창구를 기준으로 나갈 사람이 있으면 내보낸다.
                System.out.println("============================= " + time + " =============================");


                for (int i = 0; i < N; i++) {
                    // 현재 빠져나갈 값들은 temp에 저장하고 null값 처리로 해서 자리가 비었다는 것을 표시해줌.
                    if (reception[i].person != null && reception[i].person.outTime == time) {
                        tempList.add(reception[i].person);
                        reception[i].person = null;
                    }
                }

                // B창구 쪽에서도 나갈 사람이 있는지 확인 B창구는 따로 tempList에 저장X
                for (int i = 0; i < M; i++) {
                    // 현재 빠져나갈 값들은 temp에 저장하고 null값 처리로 해서 자리가 비었다는 것을 표시해줌.
                    if (repair[i].person != null && repair[i].person.outTime == time) {
                        repair[i].person = null;
                        break;
                    }
                }


                // 탈출 조건
                // 모든 창구 모든 대기열이 비었으면 스탑\
//                if (personList.get(K - 1).outTime != 0 && personList.get(K - 1).outTime < time) {
//                    break;
//                }


                // 빠져 나갈 사람은 다 빠져나갔으니, A창구 먼저 진행
                // 1. 전체를 반복해서. 시간에 맞는 사람이 있을 경우(조건), 들어갈 수 있는지를 확인

                // A에 빈자리가 있는지를 먼저 확인.

                // 1. A에 빈자리가 있는데, 시간에 맞게 들어갈 사람이 있는 경우 
                // 1 - 1. 대기열이 있는 경우, 대기열 사람이 먼저 들어감
                // 1 - 1 - 1. 대기열이 모두 비었지만, 자리가 남은 경우, 이제 시간에 맞는 사람이 들어갈 수 있음
                // 1 - 1 - 2. 대기열이 모두 비었지만. 자리가 남지 않은 경우, 대기열로 모두 들어감

                // 2. A에 빈자리가 있는데, 시간에 맞게 들어갈 사람이 없는 경우
                // 2 - 1. 대기열에 사람이 있는지를 확인
                // 2 - 1 - 1. 대기열에 사람이 있을 경우 빈 자리 만큼 사람을 집어넣음
                // 2 - 1 - 2. 대기열에 사람이 없을 경우 그냥 통과

                // ====================================== A 창구 시작 ==========================================


                if (isEmptyADesk(time) > 0) {

                    // 현재 시간에 맞는 사람을 list로 추가. (인덱스를 담음)
                    // 없으면 nowTimeList의 size가 0이 됨
                    List<Integer> nowTimeList = new LinkedList<>();
                    for (int i = 0; i < K; i++) {
                        if (people[i] == time) { // 현재 시간에 맞게 들어갈 수 있는 사람
                            nowTimeList.add(i);
                        }
                    }


                    if (!nowTimeList.isEmpty()) {
                        // 시간에 맞게 들어갈 사람이 있지만. 대기열이 있는 경우

                        while (!AwaitingList.isEmpty()) {
                            int index = AwaitingList.remove(0);

                            for (int i = 0; i < N; i++) {
                                if (reception[i].person != null) continue;
                                personList.get(index).usedReceptionNum = i + 1;
                                personList.get(index).enterTime = time;
                                personList.get(index).outTime = reception[i].workTime + time;
                                reception[i].person = personList.get(index);
                                break;
                            }

                            if (isEmptyADesk(time) <= 0) break; // 빈자리 없으면 break;
                        }


                        // 대기열을 모두 소진하지 못한 경우
                        if (!AwaitingList.isEmpty()) {
                            // 남은 인원들을 대기열에 추가
                            while (!nowTimeList.isEmpty()) {
                                int index = nowTimeList.remove(0);
                                AwaitingList.add(index);
                            }
                        } else {
                            // 대기열을 모두 소진한 경우,
                            // 다시 현재 인원에서 들어갈 수 있는 사람이 있는지 파악.

                            if (isEmptyADesk(time) > 0) {
                                while (!nowTimeList.isEmpty()) {
                                    int index = nowTimeList.remove(0);

                                    for (int i = 0; i < N; i++) {
                                        if (reception[i].person != null) continue;
                                        personList.get(index).usedReceptionNum = i + 1;
                                        personList.get(index).enterTime = time;
                                        personList.get(index).outTime = reception[i].workTime + time;
                                        reception[i].person = personList.get(index);
                                        break;
                                    }

                                    if (isEmptyADesk(time) == 0) break; // 빈자리 없으면 break;
                                }

                                // 또 빈자리가 없는데 현재 인원이 남은 경우.
                                while (!nowTimeList.isEmpty()) {
                                    int index = nowTimeList.remove(0);
                                    AwaitingList.add(index);
                                }

                            } else {
                                while (!nowTimeList.isEmpty()) {
                                    int index = nowTimeList.remove(0);
                                    AwaitingList.add(index);
                                }
                            }
                        }

                    } else { // 자리는 있지만 현재 시간에 맞게 들어갈 사람이 없는 경우
                        // 대기열에 있는 사람을 최대한 집어 넣는다.
                        while (!AwaitingList.isEmpty()) {
                            int index = AwaitingList.remove(0);

                            for (int i = 0; i < N; i++) {
                                if (reception[i].person != null) continue;
                                personList.get(index).usedReceptionNum = i + 1;
                                personList.get(index).enterTime = time;
                                personList.get(index).outTime = reception[i].workTime + time;
                                reception[i].person = personList.get(index);
                                break;
                            }

                            if (isEmptyADesk(time) <= 0) break; // 빈자리 없으면 break;
                        }
                    }

                } else {
                    // else -> A에 빈자리가 없는데, 시간에 맞게 들어갈 사람이 있는 경우.
                    // System.out.println(Arrays.toString(people));

                    // people을 그냥 LinkedList로 해줘도 나쁘지 않을듯?
                    for (int i = 0; i < K; i++) {
                        if (people[i] == time) {
                            // System.out.println(people[i]);
                            AwaitingList.add(i); // 대기열에 index를 넣어줌.
                        }
                    }
                }


                // ====================== A창구 종료 ======================
                for (Person p : tempList) System.out.println("tempList num : " + p.num);
                System.out.println("BwaitingList : " + BwaitingList);

                // tempList에 있는 사람을 B창구로 넘겨옴.
                // 즉, A번 창구에서 끝난 사람이 바로 B창구로 넘어갈 수 있는지를 확인
                // B창구로 넘어갈 사람이 있는지 확인하기 위해서 tempList가 비었는지 확인.

                // 1. B창구가 비었는데 tempList가 있을 때, -> tempList가 있는데 대기열이 있을 때,
                // 1 - 1 tempList가 있는데 대기열은 없을 때
                // 3. B창구가 비었는데 tempList는 없는데, 대기열이 있을 때


                // B창구에 자리가 있고, 넣을 수 있는 값도 있을 경우, (대기열이 있거나, 현재 들어올 수 있는 값이 있는 경우)
                while (isEmptyBDesk(time) > 0 && (!tempList.isEmpty() || !BwaitingList.isEmpty())) {

                    // B창구에 자리도 있고, 대기열도 사람이 있으면 회전
                    while (isEmptyBDesk(time) > 0 && !BwaitingList.isEmpty()) {
                        int personNum = BwaitingList.remove(0);

                        for (int i = 0; i < M; i++) {
                            if (repair[i].person != null) continue;
                            personList.get(personNum).usedRepairNum = i + 1; // 들어간 B창구 번호
                            personList.get(personNum).enterTime = time; // B창구에 들어간 시간
                            personList.get(personNum).outTime = time + repair[i].workTime; // 나올 시간.
                            repair[i].person = personList.get(personNum); // B창구에 들어간 사람에 대한 정보.
                            break;
                        }
                    }

                    // 대기열은 모두 비워졌지만, 아직 들어올 사람이 남았고 자리도 남았을 때
                    while (isEmptyBDesk(time) > 0 && !tempList.isEmpty()) {
                        Person newPerson = tempList.remove(0);
                        int personNum = newPerson.num - 1;

                        for (int i = 0; i < M; i++) {
                            if (repair[i].person != null) continue;
                            personList.get(personNum).usedRepairNum = i + 1;
                            personList.get(personNum).enterTime = time;
                            personList.get(personNum).outTime = time + repair[i].workTime;
                            repair[i].person = personList.get(personNum);
                            break;
                        }
                    }

//                    // 자리가 없는데, tempList가 남았으면,
//                    while (isEmptyBDesk(time) <= 0 && !tempList.isEmpty()) {
//                        Person newPerson = tempList.remove(0);
//                        int personNum = newPerson.num - 1;
//                        BwaitingList.add(personNum);
//                    }

                    // 탈출 조건 : tempList도 비었고, 대기열도 없으면 종료 (자리는 남았지만 더이상 넣을 수 있는 값이 없을 경우)
                    if (isEmptyBDesk(time) <= 0 || tempList.isEmpty() && BwaitingList.isEmpty()) {
                        break;
                    }
                } // B창구에 자리가 있는 경우 End

                // 2. B창구에 자리가 없는 경우, tempList가 있을 때, 대기열로 저장
                while (isEmptyBDesk(time) <= 0 && !tempList.isEmpty()) {
                    Person newPerson = tempList.remove(0);
                    int personNum = newPerson.num - 1;
                    BwaitingList.add(personNum);
                }

                // 가장 마지막 번호 사람의 B번 창구가 결정되면, 중지
                boolean stopCheck = false;
                for (Person p : personList) {
                    if (p.usedRepairNum == 0) {
                        stopCheck = true;
                        break;
                    }
                }

                if(!stopCheck) break;

                time++; // 시간은 계속 증가
            } // End of for(;;)


            // 마지막 결과 출력
            // 전체 사람을 순회해서 A 창구를 이용한 번호와 B 창구를 이용한 번호를 확인
            for (Person p : personList) {
                System.out.println("num : " + p.num + ", usedReceptionNum : " + p.usedReceptionNum + ", usedRepairNum : " + p.usedRepairNum);

                if (A == p.usedReceptionNum && B == p.usedRepairNum) {
                    // 조건에 부합할 경우 결과에 번호를 합함.
                    // System.out.println("조건에 맞는 사람 : " + p.num);
                    result += p.num;
                }
            }

            if (result == 0) {
                result = -1;
            }


            sb.append(result).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    } // End of main

    private static int isEmptyADesk(int time) { // A창구가 비었는지 확인하는 메소드
        int count = 0;
        for (int i = 0; i < N; i++) {
            Person p = reception[i].person;

            if (p == null) {
                count++;
            }
        }

        return count;
    } // End of isEmptyADesk

    private static int isEmptyBDesk(int time) { //B창구가 비었는지 확인하는 메소드
        int count = 0;
        for (int i = 0; i < M; i++) {
            Person p = repair[i].person;

            if (p == null) {
                count++;
            }
        }

        return count;
    } // End of isEmptyBDesk

    private static void init() {
        reception = new Desk[N];
        repair = new Desk[M];
        people = new int[K];
        result = 0; // 결과 값이 없을 경우 -1을 출력하기 위해 -1로 초기화.
        personList = new LinkedList<>();
    } // End of init
} // End of Main class