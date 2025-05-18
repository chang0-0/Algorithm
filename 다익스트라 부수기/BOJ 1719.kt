package BOJ_1719

import java.io.*
import java.util.PriorityQueue
import java.util.StringTokenizer


// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private lateinit var adjList: ArrayList<ArrayList<Edge>>
private const val INF = Int.MAX_VALUE

private data class Edge(val num: Int, val time: Int) : Comparable<Edge> {
    override fun compareTo(o: Edge): Int = time.compareTo(o.time)
}


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1719\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    for (i in 1..N) {
        val ret = dijkstra(i)

        for (j in 1..N) {
            if (ret[j] == i) {
                sb.append('-')
            } else {
                sb.append(ret[j])
            }
            sb.append(' ')
        }

        sb.append('\n')
    }

    return sb.toString()
} // End of solve()

private fun dijkstra(start: Int): IntArray {
    val que = PriorityQueue<Edge>()
    val memo = IntArray(N + 1) { INF }
    val isVisited = BooleanArray(N + 1)
    val pre = IntArray(N + 1) { start }

    que.offer(Edge(start, 0))
    memo[start] = 0

    while (que.isNotEmpty()) {
        val cur = que.poll()

        if (memo[cur.num] < cur.time) continue
        if (isVisited[cur.num]) continue
        isVisited[cur.num] = true

        for (next in adjList[cur.num]) {
            if (memo[next.num] > memo[cur.num] + next.time) {
                memo[next.num] = memo[cur.num] + next.time

                if (start == cur.num) {
                    pre[next.num] = next.num
                } else {
                    pre[next.num] = pre[cur.num]
                }
                que.offer(Edge(next.num, memo[next.num]))
            }
        }
    }

    return pre
} // End of dijkstra()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    adjList = arrayListOf()
    repeat(N + 1) {
        adjList.add(arrayListOf())
    }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        adjList[a].add(Edge(b, c))
        adjList[b].add(Edge(a, c))
    }
} // End of input()
