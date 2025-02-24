package BOJ_2194

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/2194
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private var A = 0
private var B = 0
private var K = 0

private lateinit var start: Coordinate
private lateinit var end: Coordinate
private lateinit var board: Array<IntArray>
private lateinit var count: Array<IntArray>
private val dirX = intArrayOf(-1, 0, 1, 0)
private val dirY = intArrayOf(0, 1, 0, -1)
private data class Coordinate(val x: Int, val y: Int, val count: Int)


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2194\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    BFS()

    if (count[end.x][end.y] == 0) {
        sb.append(-1)
    } else {
        sb.append(count[end.x][end.y])
    }
    return sb.toString()
} // End of solve()

private fun BFS() {
    val que = ArrayDeque<Coordinate>()
    val isVisited = Array(N + 1) { BooleanArray(M + 1) }

    isVisited[start.x][start.y] = true
    que.addLast(Coordinate(start.x, start.y, 0))

    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        for (i in 0 until 4) {
            val nX = dirX[i] + cur.x
            val nY = dirY[i] + cur.y

            if (!isAbleCheck(nX, nY, isVisited)) continue

            // 시계방향으로 회전
            if (!check(nX, nY)) continue

            que.addLast(Coordinate(nX, nY, cur.count + 1))
            count[nX][nY] = count[cur.x][cur.y] + 1
            isVisited[nX][nY] = true
        }
    }
} // End of BFS()

private fun isAbleCheck(x: Int, y: Int, isVisited: Array<BooleanArray>): Boolean {
    return x >= 1 && x + A <= N && y >= 1 && y + B <= M && !isVisited[x][y] && board[x][y] == 0
} // End of isAbleCheck()

private fun check(x: Int, y: Int): Boolean {
    for (i in x..x + A) {
        for (j in y..y + B) {
            if (board[i][j] == 1) return false
        }
    }

    return true
} // End of check()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    A = st.nextToken().toInt()
    B = st.nextToken().toInt()
    K = st.nextToken().toInt()

    board = Array(N + 1) { IntArray(M + 1) }
    count = Array(N + 1) { IntArray(M + 1) }
    repeat(K) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        board[a][b] = 1
    }

    st = StringTokenizer(br.readLine())
    start = Coordinate(st.nextToken().toInt(), st.nextToken().toInt(), 0)

    st = StringTokenizer(br.readLine())
    end = Coordinate(st.nextToken().toInt(), st.nextToken().toInt(), 0)
} // End of input()
