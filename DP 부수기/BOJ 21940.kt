package BOJ_21940

import java.io.File
import java.util.PriorityQueue
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/21940
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private var K = 0

private const val INF = Int.MAX_VALUE / 2
private lateinit var times: Array<IntArray>
private lateinit var adjList: MutableList<MutableList<Edge>>
private lateinit var friends: IntArray

private data class Edge(var num: Int = 0, var time: Int = 0) : Comparable<Edge> {

    override fun compareTo(o: Edge): Int {
        return time - o.time
    }
} // End of Edge class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_21940\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    for (i in 1..N) {
        dijkstra(i, times[i])
    }

    times.forEach {
        println(it.contentToString())
    }

    val list = ArrayList<Int>()
    var ans = INF
    for (i in 1..N) {
        var sum = 0
        var flag = true
        for (num in friends) {
            if (times[num][i] == INF || times[i][num] == INF) {
                flag = false
                break
            }
            sum = Math.max(sum, times[num][i] + times[i][num])
        }

        if (flag) {
            if (ans > sum) {
                ans = sum
                list.clear()
                list.add(i)
            } else {
                list.add(i)
            }
        }
    }

    list.sort()
    list.forEach {
        sb.append(it).append(' ')
    }

    return sb.toString()
} // End of solve()

private fun dijkstra(start: Int, times: IntArray) {
    val pque = PriorityQueue<Edge>()

    pque.offer(Edge(start, 0))
    times[start] = 0

    pque.offer(Edge(start, 0))
    while (pque.isNotEmpty()) {
        val cur = pque.poll();

        if (cur.time > times[cur.num]) continue

        for (next in adjList[cur.num]) {
            if (times[next.num] > cur.time + next.time) {
                times[next.num] = cur.time + next.time
                pque.offer(Edge(next.num, times[next.num]))
            }
        }
    }
} // End of dijkstra()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    adjList = ArrayList()
    repeat(N + 1) {
        adjList.add(ArrayList())
    }
    times = Array(N + 1) { IntArray(N + 1) { INF } }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val t = st.nextToken().toInt()
        adjList[a].add(Edge(b, t))
    }

    K = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    friends = IntArray(K) {
        st.nextToken().toInt()
    }
} // End of input()
