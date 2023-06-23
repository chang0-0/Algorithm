package 오일러_경로_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    민원을 받지 않으면서 모든 구간을 지나도록 작성
 */

// input
private lateinit var br: BufferedReader
private lateinit var bw: BufferedWriter

// variables
private var V = 0
private var E = 0

private lateinit var adjacencyList: MutableList<MutableList<Int>>
private lateinit var isVisited: BooleanArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\오일러_경로_부수기\\16168.txt"
    br = BufferedReader(File(path).bufferedReader())
    bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    if (input() == "NO") {
        bw.write("NO")
        bw.close()
        return
    }

    var count = 0
    for (i in 1..V) {
        if (isVisited[i]) continue
        DFS(i)
        count++
        if (count > 1) break
    }

    if (count != 1) sb.append("NO")
    else sb.append("YES")

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DFS(node: Int) {
    if (isVisited[node]) return
    isVisited[node] = true

    adjacencyList[node].forEach {
        DFS(it)
    }
} // End of DFS

private fun check(degree: IntArray): String {
    var odd = 0
    for (i in 1..V) {
        if (degree[i] % 2 != 0) {
            odd++
        }
    }

    if (odd == 0 || odd == 2) {
        return "YES"
    } else {
        return "NO"
    }
} // End of check

private fun input(): String {
    var st = StringTokenizer(br.readLine())
    V = st.nextToken().toInt() // 지점의 개수
    E = st.nextToken().toInt() // 연결 구간의 개수

    isVisited = BooleanArray(V + 1)
    val degree = IntArray(V + 1)

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
        degree[u]++
        degree[v]++
    }

    return check(degree)
} // End of input
