package DFS

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    시작 정점 R의 깊이는 0이고 방문 되지 않은 노드의 깊이는 -1로 출력하라
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0 // 정점의 수
private var M = 0 // 간선의 수
private var R = 0 // 시작 정점 번호

private lateinit var isVisited: IntArray
private lateinit var adjustList: MutableList<MutableList<Int>>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\DFS\\res\\24481.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    input()

    DFS(R, -1)

    for (i in 1..N) {
        sb.append(isVisited[i]).append('\n')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DFS(nodeNum: Int, depth: Int) {
    isVisited[nodeNum] = depth + 1

    val size = adjustList[nodeNum].size
    for (i in 0 until size) {
        val nextNodeNum = adjustList[nodeNum][i]
        if (isVisited[nextNodeNum] != -1) continue
        DFS(nextNodeNum, depth + 1)
    }

} // End of DFS

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 정점의 수
    M = st.nextToken().toInt() // 간선의 수
    R = st.nextToken().toInt() // 시작 정점

    isVisited = IntArray(N + 1) { -1 }

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
