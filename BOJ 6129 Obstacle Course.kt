package BOJ_6129

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    X는 통과 할 수 없다
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private const val INF = Int.MAX_VALUE
private lateinit var startCoor: Coordinate
private lateinit var endCoor: Coordinate

private lateinit var map: Array<CharArray>
private val dirX = arrayOf(1, 0, -1, 0)
private val dirY = arrayOf(0, -1, 0, 1)

private data class Coordinate(var x: Int, var y: Int, var beforeDir: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_6129\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(BFS(startCoor.x, startCoor.y))
    return sb.toString()
} // End of solve

private fun BFS(x: Int, y: Int): Int {
    val isVisited = Array(N) { Array(N) { IntArray(4) { INF } } }
    val que: Queue<Coordinate> = LinkedList()


    // 이전 방향을 기준으로 01이 되거나 23이 되거나 둘 중에 하나로 방향이 바뀌면 Count
    for (i in 0 until 4) {
        que.offer(Coordinate(x, y, i))
        isVisited[x][y][i] = 0
    }

    while (que.isNotEmpty()) {
        val pollCoor = que.poll()

        for (dir in 0 until 4) {
            if (Math.abs(pollCoor.beforeDir - dir) == 2) continue

            val nextX = dirX[dir] + pollCoor.x
            val nextY = dirY[dir] + pollCoor.y

            var dirCount = 1
            if (dir == pollCoor.beforeDir) {
                dirCount = 0
            }

            if (!rangeCheck(nextX, nextY) || map[nextX][nextY] == 'x') continue

            if (isVisited[nextX][nextY][pollCoor.beforeDir] + dirCount < isVisited[nextX][nextY][i]) {
                isVisited[nextX][nextY][dir] = isVisited[nextX][nextY][pollCoor.beforeDir] + dirCount
                que.offer(Coordinate(nextX, nextY, dir))
            }
        }
    }

    var min = Int.MAX_VALUE
    for (i in 0 until 4) {
        min = Math.min(min, isVisited[endCoor.x][endCoor.y][i])
    }

    return min
} // End of BFS

private fun rangeCheck(nextX: Int, nextY: Int): Boolean {
    return nextX in 0 until N && nextY in 0 until N
} // End of rangeCheck

private fun input() {
    N = br.readLine().toInt()

    map = Array(N) { CharArray(N) }
    for (i in 0 until N) {
        val temp = br.readLine()

        for (j in 0 until N) {
            map[i][j] = temp[j]

            if (map[i][j] == 'A') {
                startCoor = Coordinate(i, j, 0)
            } else if (map[i][j] == 'B') {
                endCoor = Coordinate(i, j, 0)
            }
        }
    }
} // End of input
