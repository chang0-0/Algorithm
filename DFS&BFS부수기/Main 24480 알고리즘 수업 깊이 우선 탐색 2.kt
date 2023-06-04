package DFS

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var N = 0 // 정점의 수
private var M = 0 // 간선의 수
private var R = 0 // 시작 정점
private var visitCounting = 0

// 방문 여부 체크
private lateinit var isVisited: IntArray

// 인접 리스트
private lateinit var adjustList: MutableList<MutableList<Int>>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\DFS\\res\\24480.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    input()

    DFS(R)
    for (i in 1..N) {
        sb.append(isVisited[i]).append('\n')
    }


    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DFS(nodeNum: Int) {
    isVisited[nodeNum] = ++visitCounting

    val size = adjustList[nodeNum].size
    for (i in 0 until size) {
        val next = adjustList[nodeNum][i]
        if (isVisited[next] == 0) {
            DFS(next)
        }
    }

} // End of DFS

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 정점의 수
    M = st.nextToken().toInt() // 간선의 수
    R = st.nextToken().toInt() // 시작 정점

    isVisited = IntArray(N + 1)

    // 인접리스트 초기화
    adjustList = ArrayList()
    for (i in 0..N) {
        adjustList.add(ArrayList())
    }

    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()

        adjustList[u].add(v)
        adjustList[v].add(u)
    }

    // 내림차순 정렬
    for (i in 1..N) {
        Collections.sort(adjustList[i], Collections.reverseOrder())
    }
} // End of input