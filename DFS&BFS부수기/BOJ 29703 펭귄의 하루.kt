package BOJ_29703

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    문자열은 S, H, E, D, F로 이루어져 있고,

    H는 펭귄의 집
    S는 펭귄의 현재위치
    E는 안전구역
    D는 이동할 수 없는 구역,
    F는 펭귄이 먹이를 구할 수 있는 물고기 서식지

    펭귄이 물고기 서식지를 들러 집에 도착할 수 있는 최소시간을 출력
    만약 집에 도착할 수 없다면 -1을 출력한다.
 */

// https://www.acmicpc.net/problem/29703
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0
private lateinit var start: Penguin
private lateinit var map: Array<CharArray>

private var dirX = arrayOf(-1, 1, 0, 0)
private var dirY = arrayOf(0, 0, -1, 1)

private data class Penguin(var x: Int = 0, var y: Int = 0, var fishCnt: Int = 0, var time: Int = 0)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_29703\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val ans = BFS()
    if (ans == -1) {
        sb.append(-1)
    } else {
        sb.append(ans)
    }
    return sb.toString()
} // End of solve()


private fun BFS(): Int {
    var ans = -1
    val que: LinkedList<Penguin> = LinkedList()
    que.offer(start)

    val isVisitedBefore = Array(N) { BooleanArray(M) }
    val isVisitedAfter = Array(N) { BooleanArray(M) }

    isVisitedBefore[start.x][start.y] = true

    while (que.isNotEmpty()) {
        val nowCoor = que.poll()

        for (i in 0 until 4) {
            val nextX = dirX[i] + nowCoor.x
            val nextY = dirY[i] + nowCoor.y
            var next = ' '

            if (nowCoor.fishCnt >= 1) {
                if (!ableCheck(nextX, nextY, isVisitedAfter)) continue
                next = map[nextX][nextY]
                when (next) {
                    'F' -> {
                        que.offer(Penguin(nextX, nextY, nowCoor.fishCnt + 1, nowCoor.time + 1))
                        isVisitedAfter[nextX][nextY] = true
                    }

                    'H' -> {
                        ans = nowCoor.time + 1
                        return ans
                    }

                    else -> {
                        que.offer(Penguin(nextX, nextY, nowCoor.fishCnt, nowCoor.time + 1))
                        isVisitedAfter[nextX][nextY] = true
                    }
                }
            } else {
                if (!ableCheck(nextX, nextY, isVisitedBefore)) continue
                next = map[nextX][nextY]

                when (next) {
                    'F' -> {
                        que.offer(Penguin(nextX, nextY, nowCoor.fishCnt + 1, nowCoor.time + 1))
                        isVisitedAfter[nextX][nextY] = true
                    }

                    'H' -> {
                        que.offer(Penguin(nextX, nextY, nowCoor.fishCnt, nowCoor.time + 1))
                        isVisitedBefore[nextX][nextY] = true
                    }

                    else -> {
                        que.offer(Penguin(nextX, nextY, nowCoor.fishCnt, nowCoor.time + 1))
                        isVisitedBefore[nextX][nextY] = true
                    }
                }
            }
        }
    }

    return ans
} // End of BFS

private fun ableCheck(nextX: Int, nextY: Int, isVisited: Array<BooleanArray>): Boolean {
    return nextX in 0 until N && nextY in 0 until M && !isVisited[nextX][nextY] && map[nextX][nextY] != 'D'
} // End of ableCheck

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    map = Array(N) {
        br.readLine().toCharArray()
    }

    repeat(N) { x ->
        repeat(M) { y ->
            if (map[x][y] == 'S') {
                start = Penguin(x, y)
            }
        }
    }
} // End of input()
