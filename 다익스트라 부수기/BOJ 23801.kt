package BOJ_23801

import java.io.File
import java.util.PriorityQueue
import java.util.StringTokenizer


// https://www.acmicpc.net/problem/23801
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private var X = 0
private var Z = 0
private lateinit var adjList: MutableList<MutableList<Edge>>
private const val INF = Long.MAX_VALUE / 4

private data class Edge(val node: Int, val weight: Long) : Comparable<Edge> {
    override fun compareTo(o: Edge): Int {
        return weight.compareTo(o.weight)
    }
} // End of Edge class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_23801\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // 1번 -> 13번
    // 들러야하는 곳
    val from = dijkstra(X)
    val to = dijkstra(Z)

    var ans = INF
    var p = br.readLine().toInt()
    StringTokenizer(br.readLine()).run {
        while (p-- > 0) {
            val y = nextToken().toInt()

            if (from[y] != INF && to[y] != INF) {
                val distSum = from[y] + to[y]
                ans = Math.min(ans, distSum)
            }
        }
    }

    if (ans == INF) {
        sb.append(-1)
    } else {
        sb.append(ans)
    }

    return sb.toString()
} // End of solve()

private fun dijkstra(start: Int): LongArray {
    val pque = PriorityQueue<Edge>()
    val memo = LongArray(N + 1) { INF }

    pque.offer(Edge(start, 0))
    memo[start] = 0

    while (pque.isNotEmpty()) {
        val cur = pque.poll()

        if (cur.weight > memo[cur.node]) continue

        adjList[cur.node].forEach { next ->
            if (memo[next.node] > memo[cur.node] + next.weight) {
                memo[next.node] = memo[cur.node] + next.weight
                pque.offer(Edge(next.node, memo[next.node]))
            }
        }
    }

    return memo
} // End of dijkstra()

private fun input() {
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    adjList = mutableListOf()

    repeat(N + 1) {
        adjList.add(mutableListOf())
    }

    repeat(M) {
        StringTokenizer(br.readLine()).run {
            val u = nextToken().toInt()
            val v = nextToken().toInt()
            val w = nextToken().toLong()

            adjList[u].add(Edge(v, w))
            adjList[v].add(Edge(u, w))
        }
    }

    StringTokenizer(br.readLine()).run {
        X = nextToken().toInt()
        Z = nextToken().toInt()
    }
} // End of input()
