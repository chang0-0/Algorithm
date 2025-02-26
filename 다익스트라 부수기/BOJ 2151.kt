package BOJ_2151

import java.io.File

// https://www.acmicpc.net/problem/2151
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private lateinit var board: Array<CharArray>
private val dirX = intArrayOf(-1, 0, 1, 0)
private val dirY = intArrayOf(0, 1, 0, -1)
private val door = Array<Coordinate>(2) { Coordinate(0, 0, 0, 0) }
private const val INF = Int.MAX_VALUE

private data class Coordinate(val x: Int, val y: Int, val dir: Int, val count: Int) : Comparable<Coordinate> {
    override fun compareTo(o: Coordinate): Int {
        return count - o.count
    }
} // End of Coordinate class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2151\\res.txt"
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
    val que = ArrayDeque<Coordinate>()
    val dist = Array(N) { Array(N) { IntArray(4) { INF } } }
    var ret = INF

    for (i in 0 until 4) {
        que.addLast(Coordinate(door[0].x, door[0].y, i, 0))
        dist[door[0].x][door[0].y][i] = 0
    }

    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        if (cur.x == door[1].x && cur.y == door[1].y) {
            ret = Math.min(ret, cur.count)
        }

        val nX = cur.x + dirX[cur.dir]
        val nY = cur.y + dirY[cur.dir]

        if (!check(nX, nY)) continue

        if (board[nX][nY] == '!') {
            // 현재 방향의 좌 우로 이동
            // 거울 설치,
            var nDir = (cur.dir + 3) % 4
            if (dist[nX][nY][nDir] > dist[cur.x][cur.y][cur.dir] + 1) {
                dist[nX][nY][nDir] = dist[cur.x][cur.y][cur.dir] + 1
                que.addLast(Coordinate(nX, nY, nDir, dist[nX][nY][nDir]))
            }

            nDir = (cur.dir + 1) % 4
            if (dist[nX][nY][nDir] > dist[cur.x][cur.y][cur.dir] + 1) {
                dist[nX][nY][nDir] = dist[cur.x][cur.y][cur.dir] + 1
                que.addLast(Coordinate(nX, nY, nDir, dist[nX][nY][nDir]))
            }
        }

        // 거울이 있어도 설치하지 않고 이동가능
        if (dist[nX][nY][cur.dir] > cur.count) {
            que.addLast(Coordinate(nX, nY, cur.dir, cur.count))
            dist[nX][nY][cur.dir] = cur.count
        }
    }

    return ret
} // End of BFS()

private fun check(x: Int, y: Int): Boolean {
    return x in 0 until N && y in 0 until N && board[x][y] != '*'
} // End of check()

private fun input() {
    N = br.readLine().toInt()

    var idx = 0
    board = Array(N) { i ->
        val temp = br.readLine()
        CharArray(N) { j ->
            if (temp[j] == '#') {
                door[idx++] = Coordinate(i, j, 0, 0)
            }
            temp[j]
        }
    }
} // End of input()
