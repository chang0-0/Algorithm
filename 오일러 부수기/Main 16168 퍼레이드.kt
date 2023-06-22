package 오일러_경로_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*
import kotlin.system.exitProcess

/*
    민원을 받지 않으면서 모든 구간을 지나도록 작성
 */

// input
private lateinit var br: BufferedReader
private lateinit var bw: BufferedWriter

// variables
private var V = 0
private var E = 0
private const val INF = Int.MAX_VALUE

private lateinit var adjacencyList: MutableList<MutableList<Int>>
private lateinit var isVisited: Array<IntArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\오일러_경로_부수기\\16168.txt"
    br = BufferedReader(File(path).bufferedReader())
    bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()
    for (i in 1..V) {
        DFS(i, i, 0)
    }

    bw.write("NO")
    bw.close()
} // End of main

private fun DFS(node: Int, num: Int, count: Int) {
    if (count == V) {
        bw.write("YES")
        exitProcess(0)
    }

    adjacencyList[node].forEach { nextNode ->
        if (isVisited[node][nextNode] != 0 || isVisited[nextNode][node] != 0) {
            isVisited[node][nextNode] = isVisited[nextNode][node]
            isVisited[nextNode][node] = num
            DFS(nextNode, node, count + 1)
        }
    }
} // End of DFS

private fun input() {
    var st = StringTokenizer(br.readLine())
    V = st.nextToken().toInt() // 지점의 개수
    E = st.nextToken().toInt() // 연결 구간의 개수

    isVisited = Array(V + 1) { IntArray(V + 1) }

    // 단방향 그래프
    adjacencyList = ArrayList()
    repeat(V + 1) {
        adjacencyList.add(ArrayList())
    }

    repeat(E) {
        st = StringTokenizer(br.readLine())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        adjacencyList[u].add(v)
        adjacencyList[v].add(u)

    }
} // End of input