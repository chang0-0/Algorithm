package BOJ_1504

import java.io.File
import java.util.PriorityQueue
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/1504
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var E = 0
private var U = 0
private var V = 0
private const val INF = Int.MAX_VALUE
private lateinit var adjList: MutableList<MutableList<Edge>>

private data class Edge(var n: Int, var w: Int) : Comparable<Edge> {
    override fun compareTo(o: Edge): Int {
        return w - o.w
    }
} // End of Edge class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1504\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val ret1 = dijkstra(U)
    val ret2 = dijkstra(V)

    var ans = INF
    if (ret1[1] != INF && ret1[V] != INF && ret2[N] != INF) {
        // 1 -> U -> V -> N
        ans = Math.min(ans, ret1[1] + ret1[V] + ret2[N])
    }

    if (ret2[1] != INF && ret2[U] != INF && ret1[N] != INF) {
        // 1 -> V -> U -> N
        ans = Math.min(ans, ret2[1] + ret2[U] + ret1[N])
    }

    if (ans >= INF) {
        sb.append(-1)
    } else {
        sb.append(ans)
    }

    return sb.toString()
} // End of solve()

private fun dijkstra(start: Int): IntArray {
    val que = PriorityQueue<Edge>()
    val memo = IntArray(N + 1) { INF }

    que.offer(Edge(start, 0))
    memo[start] = 0

    while (que.isNotEmpty()) {
        val cur = que.poll()

        if (cur.w > memo[cur.n]) continue

        adjList[cur.n].forEach { next ->
            if (memo[next.n] > memo[cur.n] + next.w) {
                memo[next.n] = memo[cur.n] + next.w
                que.offer(Edge(next.n, memo[next.n]))
            }
        }
    }

    return memo
} // End of dijkstra()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        E = nextToken().toInt()
    }

    adjList = mutableListOf()
    repeat(N + 1) {
        adjList.add(mutableListOf())
    }

    repeat(E) {
        StringTokenizer(br.readLine()).run {
            val u = nextToken().toInt()
            val v = nextToken().toInt()
            val w = nextToken().toInt()

            adjList[u].add(Edge(v, w))
            adjList[v].add(Edge(u, w))
        }
    }

    StringTokenizer(br.readLine()).run {
        U = nextToken().toInt()
        V = nextToken().toInt()
    }
} // End of input()
