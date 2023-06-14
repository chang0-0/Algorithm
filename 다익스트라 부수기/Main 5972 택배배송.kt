package 다익스트라_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    결과 -> 최소 여물 출력
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0 // 헛간 수
private var M = 0 // 소들의 길
private const val INF = Int.MAX_VALUE

private lateinit var adjustList: MutableList<MutableList<Node2>>
private lateinit var dist: IntArray

private data class Node2(var nodeNum: Int, var cost: Int) : Comparable<Node2> {
    override fun compareTo(other: Node2): Int {
        return cost - other.cost
    } // End of compareTo
} // End of Node2 class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\다익스트라_부수기\\5972.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    dijkstra()

    sb.append(dist[N])

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun dijkstra() {
    val pq = PriorityQueue<Node2>()
    val isVisited = BooleanArray(N + 1)
    dist[1] = 0
    pq.offer(Node2(1, 0))

    while (pq.isNotEmpty()) {
        val pollNode = pq.poll()

        if (isVisited[pollNode.nodeNum]) continue
        isVisited[pollNode.nodeNum] = true

        adjustList[pollNode.nodeNum].forEach { nextNode ->
            if (!isVisited[nextNode.nodeNum] && dist[nextNode.nodeNum] > dist[pollNode.nodeNum] + nextNode.cost) {
                dist[nextNode.nodeNum] = dist[pollNode.nodeNum] + nextNode.cost
                pq.offer(Node2(nextNode.nodeNum, dist[nextNode.nodeNum]))
            }
        }
    }
} // End of dijkstra

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    dist = IntArray(N + 1) { INF }

    adjustList = ArrayList()
    repeat(N + 1) {
        adjustList.add(ArrayList())
    }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()

        adjustList[a].add(Node2(b, c))
        adjustList[b].add(Node2(a, c))
    }
} // End of input