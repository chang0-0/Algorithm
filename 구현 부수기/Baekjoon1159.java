import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon1159 {
    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        String player[] = new String[num];
    
        for(int i=0; i<num; i++) {
            player[i] = br.readLine();
        }

        //sort로 앞글자 같아지면서 정렬됨.
        Arrays.sort(player);

        for(int i=0; i<player.length; i++) {
            String name = player[i];
            char first_name = name.charAt(0);     

            if(i == 0) {
                map.put(first_name, map.getOrDefault(first_name ,1) + 1);
            }
            // 첫번재의 경우 무조건 map에 집어 넣고
            // 두번재의 경우 부터는 집어 넣기전에 key의 값이 있는지 없는지 검사하면서
            // key와 겹치는 값이 있으면 value의 count만 증가시킴
            else {
                map.put(first_name, map.getOrDefault(first_name ,1) + 1);
            }
        }

        // EntrySet 사용 경우
        Iterator<Map.Entry<Character, Integer>> iter = map.entrySet().iterator();
        char answer[] = new char[map.size()];

        //iterator.hasNext()는 다음 값이 있는지 없는지 확인하는 메소드
        
        int i=0; 
        while(iter.hasNext()) {
            Map.Entry<Character, Integer> entry = iter.next();
            
            if(entry.getValue() >= 5) {
                answer[i] = entry.getKey();
                System.out.print(answer[i]);
            }
            
            i++; 
        }
        int count = 0;
        for(int j=0; j<answer.length; j++) {

            if(answer[j] == 0) {
                count ++;
            }

            if(count == answer.length) {
                System.out.print("PREDAJA");
            }
            
        }
 
    }
}
