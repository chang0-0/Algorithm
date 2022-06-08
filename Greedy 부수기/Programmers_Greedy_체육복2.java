import java.util.HashSet;

public class Programmers_Greedy_체육복2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> loSet = new HashSet<>();

        for(int i: reserve) {
            resSet.add(i);
        }

        for(int i: lost) {
            if(resSet.contains(i)) {
                resSet.remove(i);
            }
            else {
                loSet.add(i);
            }
        }

        for(int i: resSet) {
            if(loSet.contains(i-1)) {
                loSet.remove(i - 1);
            }
            else if(loSet.contains(i+1)) {
                loSet.remove(i + 1);
            }
        }   

        answer = n - loSet.size();

        return answer;
    }

    public static void main(String[] args) {
        Programmers_Greedy_체육복2 s = new Programmers_Greedy_체육복2();
        int n = 3;
        int lost[] = {1, 2};
        int reserve[] = {2, 3};

        System.out.println(s.solution(n, lost, reserve));
    }
}
