import java.util.*

class Solution {
    private var N = 0
    private var M = 0
    private val dirX = intArrayOf(-1, 0, 1, 0)
    private val dirY = intArrayOf(0, 1, 0, -1)
    private lateinit var board : Array<CharArray>
    private data class Coordinate(val x : Int, val y : Int, val dir : Int, val count : Int) : Comparable<Coordinate> {  
        override fun compareTo(o : Coordinate) : Int {
            return count - o.count
        }
    } // End of Coordinate class
    private lateinit var start : Coordinate
    private lateinit var target : Coordinate
    
    fun solution(board2: Array<String>): Int {
        N = board2.size
        M = board2[0].length
        
        board = Array(N) { CharArray(M) }
        board2.forEachIndexed { i, it ->
            it.forEachIndexed { j, it ->
                
                if(it == 'R') {
                    start = Coordinate(i, j, 0, 0)
                } else if(it == 'G') {
                    target = Coordinate(i, j, 0, 0)
                }
                board[i][j] = it
            }
        }

        
        
        return BFS()
    } // End of solution()
    
    private fun BFS() : Int {
        val que = PriorityQueue<Coordinate>()
        val memo = Array(N) { Array(M) { IntArray(4) { Int.MAX_VALUE } }}
        var ret = Int.MAX_VALUE
        
        for(i in 0 until 4) {
            que.offer(Coordinate(start.x, start.y, i, 0))
            memo[start.x][start.y][i] = 0
        }
        
        while(que.isNotEmpty()) {
            val cur = que.poll()
            //println("cur : $cur")
            
            var nX = cur.x + dirX[cur.dir]
            var nY = cur.y + dirY[cur.dir]
            
            if(!check(nX, nY)) {
                // 범위를 벗어나거나, 다음이 장애물인 경우
                if(cur.x == target.x && cur.y == target.y) {
                    ret = Math.min(ret, cur.count)
                    return ret + 1
                }
                
                
                for(i in 0 until 4) {
                    if(cur.dir == i) continue
                    nX = cur.x + dirX[i]
                    nY = cur.y + dirY[i]
                    
                    if(!check(nX, nY)) continue
                    if(memo[nX][nY][i] > memo[cur.x][cur.y][cur.dir] + 1) {
                        memo[nX][nY][i] = memo[cur.x][cur.y][cur.dir] + 1
                        que.offer(Coordinate(nX, nY, i, memo[nX][nY][i]))
                    }
                }
            } else {
                
                if(memo[nX][nY][cur.dir] > memo[cur.x][cur.y][cur.dir]) {
                    memo[nX][nY][cur.dir] = memo[cur.x][cur.y][cur.dir]
                    que.offer(Coordinate(nX, nY, cur.dir, memo[nX][nY][cur.dir]))
                }
            }
        }
        
        if(ret == Int.MAX_VALUE) ret = -1
        
        return ret
    } // End of BFS()
    
    private fun check(x : Int, y : Int) : Boolean {
        return x in 0 until N && y in 0 until M && board[x][y] != 'D'
    } // End of check()
} // End of Solution class