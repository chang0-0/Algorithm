import java.util.*

class Solution {
    private val N = 24
    private data class Server(val endTime : Int ) : Comparable<Server> {
        override fun compareTo(o : Server) : Int {
            return endTime - o.endTime
        }
    } // End of Server class
    
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var ans = 0
        
        val que = PriorityQueue<Server>()
        val startNum = players[0]
        val div = (startNum / m)
        var needServerCount = div
        
        for(i in 0 until N) {
            val nowPlayerCount = players[i]
            
            while(que.isNotEmpty() && que.peek().endTime <= i) {
                que.poll()
            }
            
            needServerCount = nowPlayerCount / m
            val nowServerCount = que.size
            val diff = needServerCount - nowServerCount
                        
            if(diff >= 1) {
                ans += diff
                for(j in 0 until diff) {
                    que.offer(Server(i + k))
                }
            }
        }
        
        
        return ans
    } // End of solution()
} // End of Solution class