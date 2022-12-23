package `다익스트라 부수기`

import java.util.*
import java.io.*

/*
    첫 번째 줄에 상근이가 배달을 마치는데 필요한 가장 빠른 시간을 출력한다.
    A : 상근이가 배달을 시작하는 교차로, 
    B : 상근이가 배달을 마치는 교차로, 
    K : 고둘라가 출발한 시간과 상근이가 출발한 시간의 차이
    G : 고둘라가 방문하는 교차로의 개수

    G개의 정수가 주어진다.
    고둘라가 방문하는 교차로, 각 도로를 최대 한 번만 이동한다.

    M개 줄에는 도로의 정보를 나타내는 세 정수 U, V, L이 주어진다.
    교차로 U와 V를 연결하는 도로를 이동하는데 L분이 걸린다는 뜻이다.

    경로 정보를 갱신화는 과정에서 통제된 구간을 통제된 시간에 들어갔을 경우 대기시간을 추가하면 된다.
 */

private const val INF = Integer.MAX_VALUE
private var N = 0
private var M = 0
private var A = 0
private var B = 0
private var K = 0
private var G = 0

private var kingVisitArr = IntArray(1001)
private var timeArr = Array(1001) { Array(1001) { 0 } }
private var goArray = Array(1001) { Array(1001) { Go() } }
private var dist = IntArray(1001) { INF }

// 인접리스트
private lateinit var crossList: ArrayList<ArrayList<Cross>>

private data class Cross(var road: Int = 0, var time: Int = 0) : Comparable<Cross> {
    override fun compareTo(other: Cross): Int {
        return time - other.time
    }
} // End of Cross class

private data class Go(var start: Int = 0, var end: Int = 0) // End of Go class

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\다익스트라 부수기\\res\\2982.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    init()

    st = StringTokenizer(br.readLine())
    A = st.nextToken().toInt() // 상근이가 배달을 시작하는 교차로
    B = st.nextToken().toInt() // 상근이가 배달을 마치는 교차로
    K = st.nextToken().toInt() // 고둘라가 출발한 시간과 상근이가 출발 시간의 차이
    G = st.nextToken().toInt() // 고둘라가 방문하는 교차로의 개수

    st = StringTokenizer(br.readLine())
    for (i in 0 until G) {
        kingVisitArr[i] = st.nextToken().toInt()
    }

    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val time = st.nextToken().toInt()

        crossList[start].add(Cross(end, time))
        crossList[end].add(Cross(start, time))

        timeArr[start][end] = time
        timeArr[end][start] = time
    }

    var sum = 0
    // 왕이 방문하는 구간의 시간 계산
    for (i in 0 until G - 1) {
        val s = kingVisitArr[i]
        val e = kingVisitArr[i + 1]

        goArray[s][e].start = sum
        goArray[e][s].start = sum

        goArray[s][e].end = sum + timeArr[s][e]
        goArray[e][s].end = sum + timeArr[e][s]
        sum += timeArr[s][e]
    }
    println("sum : $sum")

    dijkstra()
    // 마지막에 도착한 시간에서 K의 시간차이를 빼줌
    println(dist[B] - K)
} // End of main

private fun dijkstra() {
    val pque = PriorityQueue<Cross>()

    // 시간차이가 나는 K부터 상근이는 출발하게 됨
    dist[A] = K
    pque.offer(Cross(A, K))
    while (!pque.isEmpty()) {
        val pollCross = pque.poll()

        println("pollCross : $pollCross")

        crossList.get(pollCross.road).forEach {
            if (dist[pollCross.road] >= goArray[pollCross.road][it.road].start && dist[pollCross.road] <= goArray[pollCross.road][it.road].end) {
                dist[it.road] = goArray[pollCross.road][it.road].end + it.time
                pque.offer(Cross(it.road, dist[it.road]))
            } else {
                if (dist[it.road] > dist[pollCross.road] + it.time) {
                    dist[it.road] = dist[pollCross.road] + it.time
                    pque.offer(Cross(it.road, dist[it.road]))
                }
            }
        }
    }

} // End of dijkstra

private fun init() {
    crossList = ArrayList()
    for (i in 0 until N + 1) {
        crossList.add(ArrayList())
    }
} // End of init