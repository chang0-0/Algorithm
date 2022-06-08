import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Programmers_K번째수 {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<commands.length; i++) {
            int temp1 = commands[i][0];
            int temp2 = commands[i][1];
            int temp3 = commands[i][2];

            for(temp1 -= 1; temp1<temp2; temp1++) {
                list.add(array[temp1]);
            }
            
            Collections.sort(list);
            answer.add(list.get(temp3 - 1));
            list.clear();
        }
        
        int result[] = new int[answer.size()];
        for(int j=0; j<answer.size(); j++) {
            result[j] = answer.get(j);
        }

        return result;
    }
    public static void main(String[] args) {
        Programmers_K번째수 s = new Programmers_K번째수();
        int array[] = {1, 5, 2, 6, 3, 7, 4};
        int commands[][] = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(s.solution(array, commands)));
    }
}
