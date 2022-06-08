import java.util.*;

public class Programmers_메뉴리뉴얼 {
    //https://programmers.co.kr/learn/courses/30/lessons/72411?language=java
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        // 1. orders 배열 전체 문자열 단위로 분리해서 오름차순 정렬.
        for(int i =0; i< orders.length; i++) {
            char array[] = orders[i].toCharArray();
            Arrays.sort(array);

            orders[i] = String.valueOf(array);
        }

        // 2. orders 배열을 반복하면서 course의 배열 값의 크기 만큼 쪼개서 해시맵에 저장
        for(int i=0; i< course.length; i++) {
            int course_size = course[i];

            for(int j=0; j<orders.length; j++) {
                char array[] = orders[j].toCharArray();

                for(int k=0; k<array.length-1; k++) {
                    char temp1 = array[k];
                    System.out.println("temp1 : " + temp1);

                    for(int l=k+1; l<array.length; l++) {
                        char temp2 = array[l];
                        System.out.println("temp2 : " + temp2);
                    } 
                }


            } 
            
        }




        return answer;
    }
    
    public static void main(String[] args) {
        Programmers_메뉴리뉴얼 s = new Programmers_메뉴리뉴얼();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};


        System.out.println(s.solution(orders, course));
    }
}
