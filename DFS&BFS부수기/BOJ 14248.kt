package BOJ_14248

import java.io.*
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/14248
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var S = 0
private lateinit var arr: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14248\\res.txt"
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
    val que = ArrayDeque<Pair<Int, Int>>()
    val isVisited = BooleanArray(N + 1)

    que.addLast(Pair(S, 0))
    isVisited[S] = true

    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        var next = cur.first + arr[cur.first]
        if (next in 1..N && !isVisited[next]) {
            que.addLast(Pair(next, cur.second + 1))
            isVisited[next] = true
        }

        next = cur.first - arr[cur.first]
        if (next in 1..N && !isVisited[next]) {
            que.addLast(Pair(next, cur.second + 1))
            isVisited[next] = true
        }
    }

    var count = 0
    for (i in 1..N) {
        if (isVisited[i]) count++
    }

    return count
} // End of BFS()

private fun input() {
    N = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    arr = IntArray(N + 1)

    for (i in 1..N) {
        arr[i] = st.nextToken().toInt()
    }

    S = br.readLine().toInt()
} // End of input()
