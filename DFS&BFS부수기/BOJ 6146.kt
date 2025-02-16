package BOJ_6146

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/6146
// input
private var br = System.`in`.bufferedReader()

// variables
private var X = 0
private var Y = 0
private var N = 0

private data class Coordinate(val x: Int, val y: Int, val dist: Int = 0)

private val dirX = intArrayOf(-1, 0, 1, 0)
private val dirY = intArrayOf(0, 1, 0, -1)
private lateinit var isVisited: Array<BooleanArray>
private const val MAX = 1001


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_6146\\res.txt"
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

    que.addLast(Coordinate(500, 500, 0))
    isVisited[500][500] = true

    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        if (cur.x == X && cur.y == Y) return cur.dist

        for (i in 0 until 4) {
            val nX = dirX[i] + cur.x
            val nY = dirY[i] + cur.y

            if (isVisited[nX][nY]) continue
            if (!isAbleCheck(nX, nY)) continue

            que.addLast(Coordinate(nX, nY, cur.dist + 1))
            isVisited[nX][nY] = true
        }
    }

    return 0
} // End of BFS()

private fun isAbleCheck(x: Int, y: Int): Boolean {
    return x in 0 until MAX && y in 0 until MAX
} // End of isAbleCheck()

private fun input() {
    var st = StringTokenizer(br.readLine())
    X = st.nextToken().toInt() + 500
    Y = st.nextToken().toInt() + 500
    N = st.nextToken().toInt()
    isVisited = Array(MAX) { BooleanArray(MAX) }

    repeat(N) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt() + 500
        val b = st.nextToken().toInt() + 500

        isVisited[a][b] = true
    }
} // End of input()
