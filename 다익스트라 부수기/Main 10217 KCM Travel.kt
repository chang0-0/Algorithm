package 다익스트라_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    M원까지의 비용만을 여행비로써 부담해주겠다고 한다.
    인천에서 LA까지 M원 이하로 사용하면서 도착할 수 있는 가장 빠른 길을 차선책으로 택하기로 했다.

    첫 번째 줄에 테스트 케이스의 수를 의미하는 자연수 T가 주어진다.

    인천은 언제나 1번 도시고, LA는 언제나 N번 도시이다.
    1번에서 출발해서 N까지 가장 빠르게 갈 수 있는 길 찾기

    테스트 케이스당 한 줄에 찬민이 LA에 도착하는 데 걸리는 가장 짧은 소요시간을 출력한다. -> 다익스트라 문제.
    
    최소비용을 통해서 1번 부터 N번까지 어떻게 갈 수 있냐를 해결해야 하는 문제이므로 다익스트라문제이다.
    그러나 무작정 간선을 통해서 이동할 수 있냐 없냐가 핵심이 아니라
    정해진 비용인 M의 값으로만 N번 노드에 도착할 수 있냐 없냐도 고려해야됨
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0 // 공항의 수
private var M = 0 // 총 지원비용
private var K = 0 // 티켓정보의 수
private const val INF = Int.MAX_VALUE / 4
private var ans = 0

private var memo: Array<IntArray> = Array(101) { IntArray(10001) } // memo[공항(노드)[비용(cost)] <- time이 저장됨
private lateinit var adjustList: MutableList<MutableList<Airport>>

private data class Airport(var arrivalAirport: Int, var cost: Int, var time: Int) : Comparable<Airport> {
    // 정렬 기준 : 시간이 최우선 이고, 시간이 같을 경우, 비용이 적은 순서로 정렬함
    override fun compareTo(other: Airport): Int {
        return time - other.time
    } // End of compareTo
} // End of Airport class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\DP_부수기\\res\\10217.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    var T = br.readLine().toInt()
    while (T-- > 0) {
        input()

        dijkstra()

        for (i in 1..M) {
            ans = Math.min(ans, memo[N][i])
        }

        if (ans == INF) {
            sb.append("Poor KCM").append('\n')
        } else {
            sb.append(ans).append('\n')
        }
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun dijkstra() {
    val pque = PriorityQueue<Airport>()
    pque.offer(Airport(1, 0, 0)) // 도착공항, 비용, 시간

    ans = INF
    while (pque.isNotEmpty()) {
        val poll = pque.poll()
        val arrivalAirport = poll.arrivalAirport
        val cost = poll.cost
        val time = poll.time

        if (ans <= memo[arrivalAirport][cost]) {
            continue
        }

        for (next in adjustList[arrivalAirport]) {
            val nextAirport = next.arrivalAirport
            val nextTime = time + next.time
            val nextCost = cost + next.cost

            if (nextCost > M) continue

            val memoTime = memo[arrivalAirport][cost] + next.time
            if (ans <= memoTime) continue
            if (nextAirport == N) {
                ans = memoTime
                continue
            }

            if (memoTime < memo[nextAirport][nextCost]) {
                if (memo[nextAirport][nextCost] == INF) {
                    pque.offer(Airport(nextAirport, nextCost, memoTime))
                }
                memo[nextAirport][nextCost] = memoTime
            }
        }
    }
} // End of dijkstra

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    K = st.nextToken().toInt()

    memo = Array(N + 1) { IntArray(M + 1) { INF } }

    adjustList = ArrayList()
    for (i in 0..N) {
        adjustList.add(ArrayList())
    }

    for(i in 0 .. M) {
        memo[1][i] = 0
    }

    while (K-- > 0) {
        st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt() // 티켓의 출발 공항
        val v = st.nextToken().toInt() // 도착 공항
        val c = st.nextToken().toInt() // 비용
        val d = st.nextToken().toInt() // 소요시간

        adjustList[u].add(Airport(v, c, d))
    }
} // End of input
