package BOJ_2056

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/2056
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private lateinit var adjList: MutableList<MutableList<Int>>
private lateinit var inDegree: IntArray
private lateinit var times: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2056\\res.txt"
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
    val que = ArrayDeque<Int>()
    var ans = 0
    val ret = IntArray(N + 1)

    for (i in 1..N) {
        if (inDegree[i] == 0) {
            que.addLast(i)
            ret[i] = times[i]
        }
    }

    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        for (next in adjList[cur]) {
            inDegree[next]--

            ret[next] = Math.max(ret[next], ret[cur] + times[next]) // next 작업 시간 갱신
            if (inDegree[next] == 0) {
                que.addLast(next)
            }
        }
    }

    ret.forEach {
        ans = Math.max(ans, it)
    }

    return ans
} // End of BFS()

private fun input() {
    N = br.readLine().toInt()

    adjList = mutableListOf()
    times = IntArray(N + 1)
    inDegree = IntArray(N + 1)
    repeat(N + 1) {
        adjList.add(mutableListOf())
    }

    repeat(N) { idx ->
        StringTokenizer(br.readLine()).run {
            val time = nextToken().toInt()
            val count = nextToken().toInt()

            times[idx + 1] = time
            inDegree[idx + 1] = count
            repeat(count) {
                adjList[nextToken().toInt()].add(idx + 1)
            }
        }
    }

} // End of input()
