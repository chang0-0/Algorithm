package `DFS&BFS 부수기`

/*
    내가 생각하기엔 백트래킹 문제이지 않을까 하는 생각이 듬
    K개 이하의 구역을 보정해서 두 구역의 선명도의 가장 큰 차이의 최솟값을 출력하라

    어떤 구역의 선명도를 바꿨을 때,
    가장 큰 차이의 최솟값.

    차이가 나는 값들을 테스트해야됨 일단

    ⭐ 플러드 필 문제라고 함

 */

import java.util.*
import java.io.*

private var N = 0 // 세로의 칸 수
private var M = 0 // 가로의 칸 수
private var K = 0 // 보정할 수 있는 구역의 개수
private var X: Long = 0L // 보정했을 때의 선명도
private var result = -1L
// 500

private val map = Array(500) { LongArray(500) { 0 } }
private val isVisited = Array(500) { BooleanArray(500) }

private val dirX = arrayOf(-1, 1, 0, 0)
private val dirY = arrayOf(0, 0, -1, 1)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\DFS&BFS 부수기\\res\\d.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    K = st.nextToken().toInt()
    X = st.nextToken().toLong()

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())

        for (j in 0 until M) {
            map[i][j] = st.nextToken().toLong()
        }
    }

    // 모든 구역에 선명도의 값을 수정해보면서 값을 체크해보는거임
    // 뭐든지 1번은 완탐이다.
    DFS(0, 0, 0)

    if (result == Long.MAX_VALUE) {
        println(0)
    } else {
        println(result)
    }
} // End of main

private fun DFS(xIndex: Int, yIndex: Int, depth: Int) {
    if (depth == K) {
        // 하나의 조합이 완성됨.
        var min = Long.MAX_VALUE
        val isCalced = Array(N) { BooleanArray(M) }

        for (i in 0 until N) {
            for (j in 0 until M) {
                // 차이값의 가장 큰 값을 찾기
                min = Math.min(heightDiff(i, j, isCalced), min)
            }
        }
        result = Math.max(min, result)
        return
    }

    for (i in xIndex until N) {
        for (j in yIndex until M) {
            if (isVisited[i][j]) continue

            isVisited[i][j] = true
            val temp = map[i][j]
            map[i][j] = X
            DFS(i, j + 1, depth + 1)
            map[i][j] = temp
            isVisited[i][j] = false
        }
    }
} // End of DFS


// 계산할때도 내부에 계산했는지 여부를 체크하는 배열이 하나 있으면 4가지 방향을 모두 탐색하지 않아도됨.
// 이미 계산이 됬는지 여부를 확인하는 배열을 만들자.
// 하나의 조합이 완성이 됬을 때 마다 새롭게 생성되는 배열이어야 함
// 양방향 모두 계산이 되었는지를 확인할 수 있어야함

// 만들어진 조합에서 가장 높은 차이값 구하기
private fun heightDiff(x: Int, y: Int, isCalced: Array<BooleanArray>): Long {
    var min = Long.MAX_VALUE
    for (i in 0 until 4) {
        val nowX = x + dirX[i]
        val nowY = y + dirY[i]

        if (!ranggeCheck(nowX, nowY)) continue
        if (isCalced[nowX][nowY]) continue

        min = Math.min(Math.abs(map[x][y] - map[nowX][nowY]), min)
    }

    isCalced[x][y] = true
    return min
} // End of heightDiff

private fun ranggeCheck(nowX: Int, nowY: Int): Boolean {
    return nowX >= 0 && nowX < N && nowY >= 0 && nowY < M
} // End of ranggeCheck
