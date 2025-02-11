package BOJ_31791

import java.io.File
import java.util.PriorityQueue
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/31791
// input
private var br = System.`in`.bufferedReader()

// variables
private lateinit var board: Array<CharArray>
private var N = 0
private var M = 0
private var tg = 0
private var tb = 0
private var X = 0
private var B = 0

private lateinit var birusArr: Array<Coordinate>
private val dirX = intArrayOf(-1, 0, 1, 0)
private val dirY = intArrayOf(0, 1, 0, -1)

private const val INF = Int.MAX_VALUE / 2

private data class Coordinate(val x: Int, val y: Int, val time: Int = 0) : Comparable<Coordinate> {
    override fun compareTo(o: Coordinate): Int {
        return time - o.time
    }
}

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_31791\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val ret = BFS()
    if (ret.isEmpty()) {
        sb.append(-1)
    } else {
        // list 정렬
        ret.sortWith { o1, o2 ->
            if (o1.x == o2.x) {
                o1.y - o2.y
            }
            o1.x - o2.x
        }

        ret.forEach {
            sb.append(it.x).append(' ').append(it.y).append('\n')
        }
    }

    return sb.toString()
} // End of solve()

private fun BFS(): MutableList<Coordinate> {
    val que = PriorityQueue<Coordinate>()
    val dist = Array(N) { IntArray(M) { INF } }

    birusArr.forEach { it ->
        que.offer(Coordinate(it.x, it.y, 0))
        dist[it.x][it.y] = 0
    }

    while (que.isNotEmpty()) {
        val cur = que.poll()

        if (dist[cur.x][cur.y] < cur.time) continue

        for (i in 0 until 4) {
            val nX = dirX[i] + cur.x
            val nY = dirY[i] + cur.y

            if (!isAbleCheck(nX, nY)) continue

            if (board[nX][nY] == '.' && dist[nX][nY] > dist[cur.x][cur.y] + 1 && dist[cur.x][cur.y] + 1 <= tg) {
                dist[nX][nY] = dist[cur.x][cur.y] + 1
                que.offer(Coordinate(nX, nY, dist[nX][nY]))
            } else if (board[nX][nY] == '#' && dist[nX][nY] > dist[cur.x][cur.y] + (tb + 1) && dist[cur.x][cur.y] + (tb + 1) <= tg) {
                dist[nX][nY] = dist[cur.x][cur.y] + (tb + 1)
                que.offer(Coordinate(nX, nY, dist[nX][nY]))
            }

        }
    }

    val list = mutableListOf<Coordinate>()
    dist.forEachIndexed { i, it ->
        it.forEachIndexed { j, it2 ->
            if (it2 == INF) {
                list.add(Coordinate(i + 1, j + 1))
            }
        }
    }

    return list
} // End of BFS()

private fun isAbleCheck(x: Int, y: Int): Boolean {
    return x in 0 until N && y in 0 until M
} // End of isAbleCheck()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    tg = st.nextToken().toInt()
    tb = st.nextToken().toInt()
    X = st.nextToken().toInt()
    B = st.nextToken().toInt()

    birusArr = Array(X) { Coordinate(0, 0, 0) }
    var idx = 0

    board = Array(N) { i ->
        val str = br.readLine()
        CharArray(M) { j ->
            val temp = str[j]

            if (temp == '*') {
                birusArr[idx++] = Coordinate(i, j)
            }

            temp
        }
    }
} // End of input()
