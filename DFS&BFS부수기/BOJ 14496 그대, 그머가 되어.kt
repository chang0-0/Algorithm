package BOJ_14496

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/14496
// input
private lateinit var br: BufferedReader

// variables
private var A = 0
private var B = 0
private var N = 0
private var M = 0
private const val INF = Int.MAX_VALUE / 4
private lateinit var adjList: MutableList<MutableList<Int>>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14496\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

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
    val pque = PriorityQueue<Int>()
    pque.offer(A)
    val isVisited = BooleanArray(N + 1)
    val dist = IntArray(N + 1) { INF }
    dist[A] = 0

    while (pque.isNotEmpty()) {
        val nowNode = pque.poll()

        if (isVisited[nowNode]) continue
        isVisited[nowNode] = true

        for (nextNode in adjList[nowNode]) {
            if (dist[nextNode] > dist[nowNode] + 1) {
                dist[nextNode] = dist[nowNode] + 1
                pque.offer(nextNode)
            }
        }
    }

    return if (dist[B] == INF) {
        -1
    } else {
        dist[B]
    }
} // End of BFS()

private fun input() {
    StringTokenizer(br.readLine()).run {
        A = nextToken().toInt()
        B = nextToken().toInt()
    }

    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    adjList = ArrayList()
    repeat(N + 1) {
        adjList.add(ArrayList())
    }

    repeat(M) {
        StringTokenizer(br.readLine()).run {
            val u = nextToken().toInt()
            val v = nextToken().toInt()

            adjList[u].add(v)
            adjList[v].add(u)
        }
    }
} // End of input()
