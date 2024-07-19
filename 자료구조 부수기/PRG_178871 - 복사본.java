import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {        
        int len = callings.length;
        int pLen = players.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int j = 0; j < pLen; j++) {
            map.put(players[j], j);
        }

        for(int i = 0; i < len; i++) {
            String calledName = callings[i];

            int playerIndex = map.get(calledName);
            String temp = players[playerIndex - 1];
            players[playerIndex - 1] = players[playerIndex];
            players[playerIndex] = temp;

            map.put(calledName, playerIndex - 1);
            map.put(temp, playerIndex);
        }
        
        return players;
    } // End of solution()
} // End of Solution class