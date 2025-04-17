package BOJ_32197

import java.io.File
import java.util.PriorityQueue
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/32197
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private var A = 0
private var B = 0

private const val INF = Int.MAX_VALUE
private lateinit var adjList: ArrayList<ArrayList<Pair<Int, Int>>>

private data class Train(val num: Int, val count: Int, val state: Int) : Comparable<Train> {
    override fun compareTo(o: Train): Int = count - o.count
} // End of Train class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_32197\\res.txt"
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
    val que = PriorityQueue<Train>()
    val memo = Array(N + 1) { IntArray(2) { INF } }

    memo[A][0] = 0
    memo[A][1] = 0
    que.offer(Train(A, 0, 0))
    que.offer(Train(A, 0, 1))

    while (que.isNotEmpty()) {
        val cur = que.poll()

        if (cur.count > memo[cur.num][cur.state]) continue

        for (next in adjList[cur.num]) {
            val nextCost = cur.count + if (next.second == cur.state) 0 else 1

            if (memo[next.first][next.second] > nextCost) {
                memo[next.first][next.second] = nextCost
                que.offer(Train(next.first, nextCost, next.second))
            }
        }
    }

    return Math.min(memo[B][0], memo[B][1])
} // End of BFS()

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
        val s = st.nextToken().toInt()
        val t = st.nextToken().toInt()
        val e = st.nextToken().toInt()

        adjList[s].add(Pair(t, e))
        adjList[t].add(Pair(s, e))
    }

    st = StringTokenizer(br.readLine())
    A = st.nextToken().toInt()
    B = st.nextToken().toInt()
} // End of input()
