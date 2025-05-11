import java.util.*

class Solution {
    private var N = 0
    private var M = 0
    private var K = 5
    private lateinit var comb : IntArray
    private lateinit var q : Array<IntArray>
    private lateinit var ans : IntArray
    private lateinit var isVisited : BooleanArray
    private var answer = 0
    
    fun solution(n: Int, a1 : Array<IntArray>, a2 : IntArray): Int {        
        N = n 
        q = a1
        ans = a2
        M = ans.size
        K = 5
        comb = IntArray(K)
        isVisited = BooleanArray(N + 1)
        
        DFS(0, 1)
        
        return answer
    } // End of solution()
    
    private fun DFS(depth : Int, idx : Int) {
        if(depth == K) {
            if(check()) answer++
            return
        }
        
        for(i in idx..N) {
            if(isVisited[i]) continue
            
            isVisited[i] = true
            comb[depth] = i
            DFS(depth + 1, i + 1)
            isVisited[i] = false
        }
        
    } // End of DFS()
    
    private fun check() : Boolean {
        
        for(i in 0 until M) {
            var sum = 0
            
            for(j in 0 until K) {
                if(comb.contains(q[i][j])) {
                    sum++
                }
                
                if(ans[i] < sum) return false
            }
            
            if(ans[i] != sum) return false
        }
        
        return true
    } // End of check()
} // End of Solution class

