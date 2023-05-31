package 자료구조_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    큐에 하나씩 넣고 큐의 전체 합을 계속 가지고 있어야됨 (다리의 최대 하중)
    시간은 계속해서 증가.

    모든 트럭들이 다리를 건너는 최단시간을 출력하라
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0 // 다리를 건너는 트럭의 수
private var W = 0 // 다리의 길이
private var L = 0 // 다리의 최대하중
private lateinit var trucks: Deque<Int> // 트럭들

private data class Truck @JvmOverloads constructor(
    var weight: Int, // 트럭의 무게
    var time: Int // 트럭이 다리에 들어가 있는 시간 (현재 위치를 의미할 수 도 있음
) // End of Truck data class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\자료구조_부수기\\res\\13335.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    init()

    val bridgeQue: Queue<Truck> = LinkedList()
    var time = 0
    while (trucks.isNotEmpty() || bridgeQue.isNotEmpty()) {
        // 현재 다리의 하중을 파악
        var nowWeight = 0
        if (bridgeQue.isNotEmpty()) {
            nowWeight = nowBridgeWeight(bridgeQue)
        }

        // 다음 들어갈 차량의 무게와 현재 다리 하중의 합이 최대하중을 넘기지 않는지를 체크
        if (trucks.isNotEmpty() && nowWeight + trucks.peekLast() <= L) {
            // 최대하중을 넘지 않을 경우 다리에 차량을 넣음
            bridgeQue.offer(Truck(trucks.pollLast(), 1))
        }


        if (bridgeQue.isNotEmpty()) {
            val peek = bridgeQue.peek()
            // 시간이 같은 트럭이 있으면 다리를 빠져나감
            if (peek.time == W) {
                bridgeQue.poll()
            }

            // 전체적으로 시간을 증가시킴
            bridgeQue.forEach {
                it.time++
            }
        }

        // 시간은 1씩해서 계속해서 증가
        time++
    }

    sb.append(++time)

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun nowBridgeWeight(bridge: Queue<Truck>): Int {
    var nowWeight = 0
    bridge.forEach {
        nowWeight += it.weight
    }

    return nowWeight
} // End of nowBridgeWeight

private fun init() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    W = st.nextToken().toInt()
    L = st.nextToken().toInt()

    trucks = LinkedList()

    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        trucks.offerFirst(st.nextToken().toInt())
    }
} // End of init
