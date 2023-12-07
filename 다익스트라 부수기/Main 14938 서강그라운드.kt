package BOJ_14938

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private const val INF = Int.MAX_VALUE / 4

private var N = 0
private var M = 0
private var R = 0
private var ans = 0

private lateinit var items: IntArray
private lateinit var adjList: MutableList<MutableList<Node>>

private data class Node(var num: Int, var weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    } // End of weight
} // End of Node class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14938\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    for (i in 1..N) {
        ans = Math.max(dijkstra(i), ans)
    }

    sb.append(ans)
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun dijkstra(start: Int): Int {
    val pque = PriorityQueue<Node>()
    val dist = IntArray(N + 1) { INF }
    val isVisited = BooleanArray(N + 1) { false }

    pque.offer(Node(start, 0))
    dist[start] = 0

    while (pque.isNotEmpty()) {
        val current = pque.poll()

        if (current.weight > dist[current.num]) continue
        if (isVisited[current.num]) continue
        isVisited[current.num] = true

        adjList[current.num].forEach { next ->
            if (dist[next.num] > dist[current.num] + next.weight) {
                dist[next.num] = dist[current.num] + next.weight
                pque.offer(Node(next.num, dist[next.num]))
            }
        }
    }

    var res = 0
    for (i in 1..N) {
        if (dist[i] <= M) {
            res += items[i]
        }
    }

    return res
} // End of dijkstra

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 지역의 개수
    M = st.nextToken().toInt() // 수색범위
    R = st.nextToken().toInt() // 길의 개수

    adjList = ArrayList()
    repeat(N + 1) {
        adjList.add(ArrayList())
    }
    items = IntArray(N + 1)

    st = StringTokenizer(br.readLine())
    for (i in 1..N) {
        items[i] = st.nextToken().toInt()
    }

    for (i in 0 until R) {
        st = StringTokenizer(br.readLine())

        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val weight = st.nextToken().toInt()
        adjList[start].add(Node(end, weight))
        adjList[end].add(Node(start, weight))
    }
} // End of input
