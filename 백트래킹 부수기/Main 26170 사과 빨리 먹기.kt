import java.util.*
import java.io.*

/*
5*5 크기의 보드가 주어진다. 상 하 좌 우 한가지 방향으로 한 칸 이동할 수 있다.

보드의 정보가 1은 사과, 0은 빈칸, -1은 장애물
장애물이 있는 칸은 지낙갈 수 없다. 학생이 해당 칸을 떠나는 즉시 장애물이 있는 칸으로 변경된다.

학생이 현재 위치에서 사과 3개를 먹기 위한 최소 이동 횟수를 출력하자.

학생이 현재 위치에서 사과 3개를 먹기 위한 최소이동 횟수를 출력하라.
사과 3개를 먹을 수 없는 경우 -1을 출력한다.

 */

private const val N = 5
private val dirX = arrayOf(-1, 1, 0, 0)
private val dirY = arrayOf(0, 0, -1, 1)
private val isVisited = Array(N) { Array(N) { false } }
private val board = Array(N) { Array(N) { 0 } }
private var result = Integer.MAX_VALUE

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\백트래킹 부수기\\res\\26170.txt"
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

    if (result == Integer.MAX_VALUE) {
        println(-1)
    } else {
        println(result)
    }

} // End of main

private fun DFS(x: Int, y: Int, appleCount: Int, moveCount: Int) {
    if (appleCount == 3) {
        result = Math.min(result, moveCount)
        return
    }

    for (i in 0 until 4) {
        val nowX = dirX[i] + x
        val nowY = dirY[i] + y

        if (!rangeCheck(nowX, nowY) || isVisited[nowX][nowY] || board[nowX][nowY] == -1) continue

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