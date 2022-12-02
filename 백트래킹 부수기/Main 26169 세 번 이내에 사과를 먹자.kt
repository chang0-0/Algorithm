import java.util.*
import java.io.*
import kotlin.system.exitProcess

/*
학생이 현재 위치에서 3번 이하의 이동으로 사과를 2개 이상 먹을 수 있으면 1을 출력하고, 그렇지 않으면 0을 출력
 */

private const val N = 5
private val dirX = arrayOf(-1, 1, 0, 0)
private val dirY = arrayOf(0, 0, -1, 1)
private val isVisited = Array(N) { Array(N) { false } }
private val board = Array(N) { Array(N) { 0 } }
private var result = 0

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\26169.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st: StringTokenizer

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until N) {
            board[i][j] = st.nextToken().toInt()
        }
    }

    st = StringTokenizer(br.readLine())
    val startX = st.nextToken().toInt()
    val startY = st.nextToken().toInt()

    isVisited[startX][startY] = true
    DFS(startX, startY, 0, 0)
    println(0)
} // End of main

private fun DFS(x: Int, y: Int, appleCount: Int, moveCount: Int) {
    if (moveCount <= 3) {
        if (appleCount >= 2) {
            println(1)
            exitProcess(0)
        }
        return
    }

    for (i in 0 until 4) {
        val nowX = dirX[i] + x
        val nowY = dirY[i] + y

        if (rangeCheck(nowX, nowY) || isVisited[nowX][nowY] || board[nowX][nowY] == -1) continue

        if (board[nowX][nowY] == 1) {
            isVisited[nowX][nowY] = true
            board[nowX][nowY] = -1
            DFS(nowX, nowY, appleCount + 1, moveCount + 1)
            board[nowX][nowY] = 1
            isVisited[nowX][nowY] = false
        } else if (board[nowX][nowY] == 0) {
            isVisited[nowX][nowY] = true
            board[nowX][nowY] = -1
            DFS(nowX, nowY, appleCount, moveCount + 1)
            board[nowX][nowY] = 0
            isVisited[nowX][nowY] = false
        }
    }

} // End of DFS

private fun rangeCheck(nowX: Int, nowY: Int): Boolean {
    return nowX >= 0 && nowX < N && nowY >= 0 && nowY < N
} // End of rangeCheck