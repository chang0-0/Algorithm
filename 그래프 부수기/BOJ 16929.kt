package BOJ_16929

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/16929
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private lateinit var arr: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>

private val dirX = intArrayOf(-1, 0, 1, 0)
private val dirY = intArrayOf(0, 1, 0, -1)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_16929\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (isVisited[i][j]) continue

            if (DFS(i, j, i, j, arr[i][j])) {
                sb.append("Yes")
                return sb.toString()
            }
        }
    }

    sb.append("No")
    return sb.toString()
} // End of solve()

private fun DFS(x: Int, y: Int, preX: Int, preY: Int, color: Char): Boolean {
    if (isVisited[x][y]) return true
    isVisited[x][y] = true

    for (i in 0 until 4) {
        val nX = x + dirX[i]
        val nY = y + dirY[i]

        if (!isAbleCheck(nX, nY, color)) continue
        if (nX == preX && nY == preY) continue

        if (DFS(nX, nY, x, y, color)) {
            return true
        }
    }

    return false
} // End of DFS()

private fun isAbleCheck(x: Int, y: Int, color: Char): Boolean {
    return x in 0 until N && y in 0 until M && arr[x][y] == color
} // End of isAbleCheck()

private fun input() {
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    arr = Array(N) {
        br.readLine().toCharArray()
    }
    isVisited = Array(N) { BooleanArray(M) }
} // End of input()
