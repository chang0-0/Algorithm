package BOJ_2573_빙산

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    빙산이 두 덩어리 이상으로 분리되는 최초의 시간을 구하는 프로그램을 작성하라.
    전부 다 녹을 때까지 두 덩어리 이상이 되지 않을경우 0을 출력한다.
 */

// input
private lateinit var br: BufferedReader

// variabels
private var N = 0
private var M = 0
private var ans = 0

private lateinit var map: Array<IntArray>
private lateinit var copyMap: Array<IntArray>

private var dirX = arrayOf(-1, 1, 0, 0)
private var dirY = arrayOf(0, 0, -1, 1)

private data class Coordinate(var x: Int, var y: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2573_빙산\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    // 시작하면서 일단 덩어리가 몇 개 인지 체크
    var year = 0
    when (partCount()) {
        0, in 2..100 -> {
            ans = year
        }

        else -> {
            // 무한 반복
            for (i in generateSequence { 0 }) {
                year++
                // 1. 빙하 녹이기.
                meltingIceberg()

                // 2. 덩어리 개수 확인하기
                when (partCount()) {
                    0 -> {
                        // 덩어리가 0개
                        ans = 0
                        break
                    }

                    in 2..100 -> {
                        // 덩어리가 2개 이상
                        ans = year
                        break
                    }
                }

                // 3. 녹은 빙하가 적용된 지도 갱신
                mapCopy()
            }
        }
    }


    sb.append(ans)
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun meltingIceberg() {
    for (i in 0 until N) {
        for (j in 0 until M) {
            val tmp = map[i][j]
            if (tmp != 0) {
                for (k in 0 until 4) {
                    var nextX = dirX[k] + i
                    var nextY = dirY[k] + j

                    if (rangeCheck(nextX, nextY) && map[nextX][nextY] == 0) {
                        // 얼음을 녹이는 건 copyMap에 적용
                        copyMap[i][j]--
                        if (copyMap[i][j] == 0) break
                    }
                }
            }
        }
    }

} // End of meltingIceberg


private fun BFS(x: Int, y: Int, isVisited: Array<BooleanArray>) {
    val que: Queue<Coordinate> = LinkedList()
    que.offer(Coordinate(x, y))
    isVisited[x][y] = true

    while (que.isNotEmpty()) {
        val pollCoor = que.poll()

        for (i in 0 until 4) {
            val nextX = dirX[i] + pollCoor.x
            val nextY = dirY[i] + pollCoor.y

            // 갈 수 없거나, 이미 방문, 0일 경우 que에 넣지 않음
            if (rangeCheck(nextX, nextY) && !isVisited[nextX][nextY] && copyMap[nextX][nextY] != 0) {
                isVisited[nextX][nextY] = true
                que.offer(Coordinate(nextX, nextY))
            }
        }
    }
} // End of BFS

private fun partCount(): Int {
    // 빙산의 덩어리 개수를 파악하는 메소드
    var result = 0
    val isVisited = Array(N) { BooleanArray(M) }

    for (i in 0 until N) {
        for (j in 0 until M) {
            if (!isVisited[i][j] && copyMap[i][j] > 0) {
                // 덩어리가 2개 이상이 되었을 때, 바로 return
                BFS(i, j, isVisited)
                if (++result >= 2) {
                    return result
                }
            }
        }
    }

    // 덩어리가 0 Or 1 return
    return result
} // End of partCount

private fun mapCopy() {
    for (i in 0 until N) {
        for (j in 0 until M) {
            map[i][j] = copyMap[i][j]
        }
    }
} // End of mapCopy

private fun rangeCheck(nextX: Int, nextY: Int): Boolean {
    return nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
}

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    map = Array(N) { IntArray((M)) }
    copyMap = Array(N) { IntArray((M)) }

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until M) {
            map[i][j] = st.nextToken().toInt()
            copyMap[i][j] = map[i][j]
        }
    }
} // End of input
