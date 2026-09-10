import java.util.*;
import java.io.*;

class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;

        for(int i=0; i<=amount; i++) {
            for(int coin : coins) {
                long next = (long) i + coin;

                if(next <= amount) {
                    memo[(int) next] = Math.min(memo[(int) next], memo[i] + 1);
                }
            }
        }

        if(memo[amount] == amount + 1) {
            return -1;
        }
        return memo[amount];
    } // End of main()
} // End of Main class