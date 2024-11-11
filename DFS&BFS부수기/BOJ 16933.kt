package BOJ_16933

import java.io.*
import java.util.StringTokenizer


// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private var K = 0
private lateinit var board: Array<IntArray>


private const val INF = Int.MAX_VALUE / 2
private val dirX = intArrayOf(-1, 0, 1, 0)
private val dirY = intArrayOf(0, 1, 0, -1)

private data class Coordinate(var x: Int, var y: Int, var brokenCount: Int, var count: Int, var isDay: Boolean)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_16933\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val ret = BFS()
    if (ret == INF) {
        sb.append(-1)
    } else {
        sb.append(ret)
    }

    return sb.toString()
} // End of solve()

private fun BFS(): Int {
    val que = ArrayDeque<Coordinate>()
    var ans = INF
    val memo = Array(N) { Array(M) { IntArray(K + 1) { INF } } }
    que.addFirst(Coordinate(0, 0, 0, 1, true))
    memo[0][0][0] = 1


    // 벽은 낮에만 부술 수 있다는 점을 생각할 것
    while (que.isNotEmpty()) {
        val cur = que.removeLast()

        if (memo[cur.x][cur.y][cur.brokenCount] < cur.count) continue

        if (cur.x == N - 1 && cur.y == M - 1) {
            // 시작하는 칸과 끝나는 칸도 포함해서 센다. 라는 문제의 조건에 맞게 마지막에 + 1을 해준다.
            ans = Math.min(ans, cur.count)
            continue
        }

        for (i in 0 until 4) {
            val nX = dirX[i] + cur.x
            val nY = dirY[i] + cur.y

            if (!isAbleCheck(nX, nY)) continue

            if (board[nX][nY] == 1 && cur.brokenCount + 1 <= K) {
                if (cur.isDay) {
                    if (memo[nX][nY][cur.brokenCount + 1] > memo[cur.x][cur.y][cur.brokenCount] + 1) {
                        memo[nX][nY][cur.brokenCount + 1] = memo[cur.x][cur.y][cur.brokenCount] + 1
                        que.addFirst(Coordinate(nX, nY, cur.brokenCount + 1, memo[nX][nY][cur.brokenCount + 1], false))
                    }
                } else {
                    if (memo[nX][nY][cur.brokenCount + 1] > memo[cur.x][cur.y][cur.brokenCount] + 2) {
                        // 밤이기 때문에 벽을 부술수 없음
                        // 이동하지 않고 같은 칸에 머물러 있는 경우 대기시간 포함 + 2를 한다.
                        memo[nX][nY][cur.brokenCount + 1] = memo[cur.x][cur.y][cur.brokenCount] + 2
                        que.addFirst(Coordinate(nX, nY, cur.brokenCount + 1, memo[nX][nY][cur.brokenCount + 1], false))
                    }
                }
            } else if (board[nX][nY] == 0) {
                if (memo[nX][nY][cur.brokenCount] > memo[cur.x][cur.y][cur.brokenCount] + 1) {
                    memo[nX][nY][cur.brokenCount] = memo[cur.x][cur.y][cur.brokenCount] + 1
                    que.addFirst(Coordinate(nX, nY, cur.brokenCount, memo[nX][nY][cur.brokenCount], !cur.isDay))
                }
            }
        }
    }

    return ans
} // End of BFS()

private fun isAbleCheck(x: Int, y: Int): Boolean {
    return x in 0 until N && y in 0 until M
} // End of isAbleCheck()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
        K = nextToken().toInt()
    }

    board = Array(N) {
        val temp = br.readLine().toCharArray()

        IntArray(M) {
            temp[it].digitToInt()
        }
    }
} // End of input()
