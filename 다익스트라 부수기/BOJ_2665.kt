package BOJ_2665

import java.io.File
import java.util.PriorityQueue

// https://www.acmicpc.net/problem/2665
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private lateinit var board: Array<CharArray>
private val dirX = arrayOf(-1, 0, 1, 0)
private val dirY = arrayOf(0, 1, 0, -1)
private const val INF = Integer.MAX_VALUE

private data class Coordinate(var x: Int, var y: Int, var changeCount: Int) : Comparable<Coordinate> {
    override fun compareTo(o: Coordinate): Int {
        return changeCount - o.changeCount
    }
} // End of Coordinate class


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2665\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(BFS())
    return sb.toString()
} // End of solve()

private fun BFS(): Int {
    val que = PriorityQueue<Coordinate>()
    val memo = Array(N) { IntArray(N) { INF } }
    que.offer(Coordinate(0, 0, 0))
    memo[0][0] = 0

    while (que.isNotEmpty()) {
        val cur = que.poll()

        if (cur.x == N - 1 && cur.y == N - 1) {
            return cur.changeCount
        }

        for (i in 0 until 4) {
            val nX = cur.x + dirX[i]
            val nY = cur.y + dirY[i]

            if (!isAble(nX, nY)) continue
            if (board[nX][nY] == '0') {
                // 검은 방
                if (memo[nX][nY] > memo[cur.x][cur.y] + 1) {
                    memo[nX][nY] = memo[cur.x][cur.y] + 1
                    que.offer(Coordinate(nX, nY, memo[nX][nY]))
                }
            } else {
                if (memo[nX][nY] > memo[cur.x][cur.y]) {
                    memo[nX][nY] = memo[cur.x][cur.y]
                    que.offer(Coordinate(nX, nY, memo[nX][nY]))
                }
            }
        }
    }

    return 0
} // End of BFS()

private fun isAble(x: Int, y: Int): Boolean {
    return x in 0 until N && y in 0 until N
} // End of isAble()

private fun input() {
    N = br.readLine().toInt()

    board = Array(N) {
        br.readLine().toCharArray()
    }
} // End of input()
