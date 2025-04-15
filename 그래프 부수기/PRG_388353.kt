import java.util.*

class Solution {    
    private var N = 0
    private var M = 0
    private lateinit var board : Array<CharArray>
    private val dirX = intArrayOf(-1, 0, 1, 0)
    private val dirY = intArrayOf(0, 1, 0, -1)
    private data class Coordinate(val x : Int, val y : Int) 
    
    fun solution(storage: Array<String>, requests: Array<String>): Int {
        var answer: Int = 0
        
        N = storage.size + 2
        M = storage[0].length + 2
        val isVisited = Array(N) { BooleanArray(M) }
        board = Array(N) { i->
                
            CharArray(M) { j ->
                if(i in 1 until N - 1 && j in 1 until M - 1) {
                    storage[i - 1][j - 1]
                } else {
                    ' '
                }
            }
        }

        for(i in 0 until N) {
            for(j in 0 until M) {
                if(i == 0 || i == N - 1) {
                    isVisited[i][j] = true
                } else if(j == 0 || j == M - 1) {
                    isVisited[i][j] = true
                }
            }
        }
        
        val size = requests.size
        for(i in 0 until size) {
            val temp = requests[i]
            
            if(temp.length == 1) {
                BFS(temp[0], isVisited)            
            } else {
                val target = requests[i][0]
                
                for(j in 1..N - 1) {
                    for(k in 1..M - 1) {
                        if(!isVisited[j][k] && board[j][k] == target) {
                            isVisited[j][k] = true
                        }
                    }
                }
            }
        }
        
        var ans = 0
        for(i in 1 until N-1) {
            for(j in 1 until M-1) {
                if(!isVisited[i][j]) ans++
            }
        }
        
        
        
        return ans
    } // End of solution()
    
    private fun BFS(target : Char, isVisited : Array<BooleanArray>) {
        val que = ArrayDeque<Coordinate>()
        val memo = Array(N) { BooleanArray(M)}
        que.addLast(Coordinate(0, 0))
        memo[0][0] = true
        
        while(que.isNotEmpty()) {
            val cur = que.poll()
            
            for(i in 0 until 4) {
                val nX = dirX[i] + cur.x
                val nY = dirY[i] + cur.y
                
                if(!check(nX, nY, memo)) continue

                if(isVisited[nX][nY]) {
                    que.addLast(Coordinate(nX, nY))
                    memo[nX][nY] = true
                } else if(!isVisited[nX][nY] && board[nX][nY] == target) {
                    isVisited[nX][nY] = true
                    // que.addLast(Coordinate(nX, nY))
                    memo[nX][nY] = true
                }
            }
        }
    } // End of BFS()
    
    private fun check(x : Int, y : Int, memo : Array<BooleanArray>) : Boolean {
        return x in 0 until N && y in 0 until M && !memo[x][y]
    } // End of check()
    
} // End of Solution class