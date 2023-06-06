package DFS

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.math.BigInteger
import java.util.*

/*
    모든 노드의 깊이 * 방문 순서의 총 합을 구하라
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0 // 정점의 수
private var M = 0 // 간선의 수
private var R = 0 // 시작 정점
private var orderCount = 0 // 방문 순서

private lateinit var adjustList: MutableList<MutableList<Int>> // 인접리스트

private lateinit var depthArray: IntArray // 노드의 깊이 배열
private lateinit var orderArray: IntArray // 방문 순서 배열

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\DFS\\res\\24483.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    DFS(R, 0)

    var ans: BigInteger = BigInteger.valueOf(0)
    for (i in 1..N) {
        ans += BigInteger.valueOf(orderArray[i] * depthArray[i].toLong())
    }

    sb.append(ans)
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DFS(nodeNum: Int, depth: Int) {
    orderArray[nodeNum] = ++orderCount
    depthArray[nodeNum] = depth

    val size = adjustList[nodeNum].size
    for (i in 0 until size) {
        val nextNodeNum = adjustList[nodeNum][i]

        if (orderArray[nextNodeNum] == 0) {
            DFS(nextNodeNum, depth + 1)
        }
    }
} // End of DFS

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()
    R = st.nextToken().toInt()

    depthArray = IntArray(N + 1) { -1 }
    orderArray = IntArray(N + 1)

    adjustList = ArrayList()
    for (i in 0..N) {
        adjustList.add(ArrayList())
    }

    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()

        // 양방향 간선
        adjustList[u].add(v)
        adjustList[v].add(u)
    }

    // 오름차순 정렬
    for (i in 1..N) {
        adjustList[i].sort()
    }
} // End of input
