
class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var N = board.size
        var M = board[0].size
        
        var len = skill.size
        
        // 누적 합
        val prefixSum = Array(N + 1) { IntArray(M + 1)}
        for(i in 0 until len) {
            val temp = skill[i]
            
            val type1 = temp[0]
            val x1 = temp[1]
            val y1 = temp[2]
            val x2 = temp[3]
            val y2 = temp[4]
            var deg = temp[5]
            
            if(type1 == 1) {
                deg *= -1
            }
            
            // 누적합 표시
            prefixSum[x1][y1] += deg
            prefixSum[x1][y2 + 1] -= deg
            prefixSum[x2 + 1][y1] -= deg
            prefixSum[x2 + 1][y2 + 1] += deg
        }
        

        
        // 누적합 계산하기
        // 상하
        for(i in 0..M) {
            for(j in 0 until N) {
                prefixSum[j + 1][i] += prefixSum[j][i]
            }
        }

        
        // 좌우        
        for(i in 0..N) {
            for(j in 0 until M) {
              prefixSum[i][j + 1] += prefixSum[i][j]  
            }
        }
    
        
        var ans = 0
        // 원래 보드랑 합치기
        for(i in 0 until N) {
            for(j in 0 until M) {
                board[i][j] += prefixSum[i][j]
                
                if(board[i][j] >= 1) ans++
            }
        }
        
        return ans
    } // End of solution()
} // End of Solution class