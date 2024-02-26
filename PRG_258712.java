import java.util.*;

class Solution {    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        int n = friends.length;
        int[][] giftArr = new int[n][n];
        
        HashMap<String, Integer> friendsMap = new HashMap<>(); // friends들의 인덱스 저장
        HashMap<String, Integer> giftMap = new HashMap<>(); // friends들의 받아야하는 선물수를 저장
        HashMap<String, Integer> ratioMap = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            friendsMap.put(friends[i], i);
        }
 
        
        int m = gifts.length;
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            
            String givePerson = st.nextToken();
            String receivePerson = st.nextToken();
            
            int g = friendsMap.get(givePerson);
            int r = friendsMap.get(receivePerson);
            giftArr[g][r]++;
            
            // 선물지수 계산
            ratioMap.put( givePerson, ratioMap.getOrDefault(givePerson, 0) + 1 );
            ratioMap.put( receivePerson, ratioMap.getOrDefault(receivePerson, 0) - 1 );
            
        }

        // for(int[] t : giftArr) {
        //     System.out.println(Arrays.toString(t));
        // }
        
        //System.out.println( "friendsMap : " + friendsMap);
        //System.out.println("friends : " + Arrays.toString(friends));
        //System.out.println("ratioMap : " + ratioMap  );

        
        for(int i=0; i<n; i++) {
            for(int j=i + 1; j<n; j++) {
                if(i == j) continue;
                
                // System.out.println( friendsMap.get(friends[i])  );
                // System.out.println( friendsMap.get(friends[j] )  );
                
                if(giftArr[i][j] > giftArr[j][i]) {
                    giftMap.put( friends[i], giftMap.getOrDefault(friends[i], 0 ) + 1);
                } else if ( giftArr[i][j] < giftArr[j][i] ) {
                    giftMap.put( friends[j], giftMap.getOrDefault( friends[j] , 0 ) + 1);
                }
                
                // 선물을 주고 받지 않은 사람 중 선물지수가 누가 큰지 계산
                if( giftArr[i][j] == giftArr[j][i] &&  ratioMap.get(friends[i]) > ratioMap.get(friends[j]) ) {
                    giftMap.put( friends[i], giftMap.getOrDefault(friends[i], 0 ) + 1);
                } else if( giftArr[i][j] == giftArr[j][i] && ratioMap.get(friends[i]) < ratioMap.get(friends[j]) ) {
                    giftMap.put( friends[j], giftMap.getOrDefault( friends[j] , 0 ) + 1);
                }
            }
        }
        
        //System.out.println("giftMap : " + giftMap  );
        
        for(String k : giftMap.keySet()) {
            answer = Math.max(answer, giftMap.get(k));    
        }
         
        
        return answer;
    } // End of solution()
} // End of Solution class