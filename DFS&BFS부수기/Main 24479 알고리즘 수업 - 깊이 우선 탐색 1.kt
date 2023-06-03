package DFS

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸댜.
    모든 간선의(u, v) 쌍의 값은 서로 다르다.
    양방향 간선

    모든 간선의 (u, v)쌍의 값은 서로 다르다.

    첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다.
    i번째 줄에는 정점 i의 방문 순서를 출력한다.
    시작 정점의 방문 순서는 1이다.

    시작 정점에서 방문할 수 없는 경우 0을 출력한다.

    인접 정점은 오름차순으로 방문한다.
 */

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var N = 0 // 정점의 수
private var M = 0 // 간선의 수
private var R = 0 // 시작 정점

// 방문 여부 체크
private lateinit var isVisited: IntArray
private var visitCount = 1

// adjust List
private lateinit var adjustList: MutableList<ArrayList<Int>>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\DFS\\res\\24479.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    sb = StringBuilder()

    // input
    input()

    DFS(R)
    for (i in 1..N) {
        sb.append(isVisited[i]).append('\n')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DFS(index: Int) {
    isVisited[index] = visitCount++// 방문 여부

    val size = adjustList[index].size
    for (i in 0 until size) {
        if (isVisited[adjustList[index][i]] == 0) {
            DFS(adjustList[index][i])
        }
    }
} // End of DfS

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 정점의 수
    M = st.nextToken().toInt() // 간선의 수
    R = st.nextToken().toInt() // 시작 정점

    isVisited = IntArray(N + 1) // 0 ~ M

    adjustList = ArrayList()
    for (i in 0..N) {
        adjustList.add(ArrayList())
    }

    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt() // 정점
        val v = st.nextToken().toInt() // 정점

        adjustList[u].add(v)
        adjustList[v].add(u)
    }

    for (i in 1..N) {
        adjustList[i].sort()
    }
} // End of input
