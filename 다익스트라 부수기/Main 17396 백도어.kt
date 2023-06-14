package 다익스트라_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    0번째 분기점은 현재 유섭이의 챔피언이 있는 곳을 N-1, 번째 분기점은 상대편 넥서스를 의미하며
    유섭이의 챔피언은 총 N개의 분기점에 위치할 수 있다.
    0번째 분기점은 현재 유섭이의 챔피언이 있는 곳을, N-1 번째 분기점은 상대편 넥서스를 의미하며 나머지

    연결은 양방향이며, 한 분기점에서 다른 분기점으로 가는 간선은 최대 1개 존재한다.
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0 // 분기점의 수
private var M = 0 // 분기점들을 잇는 길의 수
private var ans = 0
private const val INF = Long.MAX_VALUE

private lateinit var isShowingArr: IntArray
private lateinit var adjustList: MutableList<MutableList<Node>>
private lateinit var dist: LongArray

private data class Node(
    var nodeNum: Int,
    var time: Long
) : Comparable<Node> { // End of compare
    override fun compareTo(other: Node): Int {
        return time compareTo other.time
    }
} // End of Node class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\다익스트라_부수기\\17396.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    // input
    input()

    dijkstra(0)

    if (dist[N - 1] == Long.MAX_VALUE) {
        sb.append(-1)
    } else {
        sb.append(dist[N - 1])
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun dijkstra(startNodeNum: Int) {
    val isVisited = BooleanArray(N)
    val pq = PriorityQueue<Node>()
    dist = LongArray(N) { INF }

    dist[startNodeNum] = 0
    pq.offer(Node(startNodeNum, 0))

    while (pq.isNotEmpty()) {
        val pollNode = pq.poll()
        val pollStartNodeNum = pollNode.nodeNum
        if (isShowingArr[pollStartNodeNum] == 1 && pollStartNodeNum != N - 1) continue

        if (!isVisited[pollStartNodeNum]) {
            isVisited[pollStartNodeNum] = true

            val size = adjustList[pollStartNodeNum].size
            for (i in 0 until size) {
                val nextNodeNum = adjustList[pollStartNodeNum][i]
                if (!isVisited[nextNodeNum.nodeNum] && dist[nextNodeNum.nodeNum] > (dist[pollStartNodeNum] + nextNodeNum.time)) {
                    dist[nextNodeNum.nodeNum] = dist[pollStartNodeNum] + nextNodeNum.time
                    pq.offer(Node(nextNodeNum.nodeNum, dist[nextNodeNum.nodeNum]))
                }
            }
        }
    }

} // End of dijkstra

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    adjustList = ArrayList()
    for (i in 0..N) {
        adjustList.add(ArrayList())
    }

    isShowingArr = IntArray(N)
    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        isShowingArr[i] = st.nextToken().toInt()
    }

    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt() // a 분기점
        val b = st.nextToken().toInt() // b 분기점
        val t = st.nextToken().toLong() // 걸리는 시간

        adjustList[a].add(Node(b, t))
        adjustList[b].add(Node(a, t))
    }
} // End of input
