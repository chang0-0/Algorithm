package BOJ_11779

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    출발 도시에서 도착 도시까지 가는데 최소 비용
    최소비용을 갖는 경로에 포함되는 도시의 개수
    방문하는 도시를 순서대로 출력

 */

// https://www.acmicpc.net/problem/11779
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0
private var start = 0
private var end = 0
private const val INF = Int.MAX_VALUE / 4

private lateinit var adjList: MutableList<MutableList<Node>>
private lateinit var dist: IntArray

private data class Node(var node: Int, var time: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_11779\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    dijkstra()

    val deque: Deque<Int> = LinkedList()


    return sb.toString()
} // End of solve()

private fun dijkstra() {
    val pque = PriorityQueue<Node>()
    pque.offer(Node(start, 0))
    dist[start] = 0

    while (pque.isNotEmpty()) {
        val nowNode = pque.poll()

        for (nextNode in adjList[nowNode.node]) {
            if (dist[nextNode.node] > dist[nowNode.node] + nextNode.time) {
                dist[nextNode.node] = dist[nowNode.node] + nextNode.time
                pque.offer(Node(nextNode.node, dist[nextNode.node]))
            }
        }
    }
} // End of dijkstra()

private fun input() {
    N = br.readLine().toInt() // 도시의 개수
    M = br.readLine().toInt() // 버스의 개수

    dist = IntArray(N + 1) { INF }
    adjList = ArrayList()
    repeat(N + 1) {
        adjList.add(ArrayList())
    }

    repeat(M) {
        StringTokenizer(br.readLine()).run {
            val u = nextToken().toInt()
            val v = nextToken().toInt()
            val w = nextToken().toInt()

            adjList[u].add(Node(v, w))
        }
    }

    StringTokenizer(br.readLine()).run {
        start = nextToken().toInt()
        end = nextToken().toInt()
    }
} // End of input()
