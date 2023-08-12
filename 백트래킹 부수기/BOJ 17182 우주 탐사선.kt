package BOJ_17182

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    모든 행성을 탐사하는데 걸리는 최소 시간을 계산하라.
    탐사 후 다시 시작 행성으로 돌아올 필요는 없으며, 이미 방문한 행성도 중복해서 갈 수 있다.
    모든 행성을 탐사하기 위한 최소시간을 출력한다.
 */

// input
private lateinit var br: BufferedReader

// variables
private const val INF = Int.MAX_VALUE
private var N = 0
private var K = 0
private var ans = INF

private lateinit var adjList: MutableList<MutableList<Node>>
private lateinit var dist: Array<IntArray>
private lateinit var comb: IntArray
private lateinit var isVisited: BooleanArray

private data class Node(var num: Int, var weight: Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    } // End of compareTo()
} // End of Node class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_17182\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    for (i in 0 until N) {
        dijkstra(i)
    }

    isVisited[K] = true
    DFS(K, 0, 0, 0)
    sb.append(ans)

    return sb.toString()
} // End of solve()

private fun dijkstra(startNode: Int) {
//    val comparable = object : Comparator<Node> {
//        override fun compare(o1: Node?, o2: Node?): Int {
//            return o1!!.weight - o2!!.weight
//        }
//    }

    val pque = PriorityQueue<Node>()
    dist[startNode][startNode] = 0
    pque.offer(Node(startNode, 0))

    while (pque.isNotEmpty()) {
        val pollNode = pque.poll()

        for (nextNode in adjList[pollNode.num]) {
            if (dist[startNode][nextNode.num] > nextNode.weight + dist[startNode][pollNode.num]) {
                dist[startNode][nextNode.num] = nextNode.weight + dist[startNode][pollNode.num]
                pque.offer(Node(nextNode.num, dist[startNode][nextNode.num]))
            }
        }
    }
} // End of dijkstra()

private fun DFS(num: Int, depth: Int, index: Int, sum: Int) {
    if (sum >= ans) return
    else if (depth == N - 1) {
        ans = Math.min(ans, sum)
        return
    }

    for (i in 0 until N) {
        if (isVisited[i]) continue
        if (i == num) continue
        isVisited[i] = true
        //comb[depth] = dist[num][i]
        DFS(i, depth + 1, index, sum + dist[num][i])
        isVisited[i] = false
    }
} // End of DFS()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt() // 행성의 개수
        K = nextToken().toInt() // 발사되는 행성의 위치
    }

    adjList = ArrayList()
    repeat(N) {
        adjList.add(ArrayList())
    }

    comb = IntArray(N - 1)
    isVisited = BooleanArray(N)

    dist = Array(N) { IntArray(N) { INF } }

    for (i in 0 until N) {
        StringTokenizer(br.readLine()).run {
            for (j in 0 until N) {
                val temp = nextToken().toInt()
                if (j == i) continue

                adjList[i].add(Node(j, temp))
            }
        }
    }
} // End of input()
