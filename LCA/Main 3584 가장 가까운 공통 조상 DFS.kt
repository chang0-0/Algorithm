package LCA

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

private var N = 0

private lateinit var adjustList: MutableList<MutableList<Int>>

private var isVisited = BooleanArray(10_001)
private var isParent = BooleanArray(10_001)
private var depths = IntArray(10_001)
private var parents = IntArray(10_001)

private var resultStart = 0
private var resultEnd = 0

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\Free PJT Algorithm\\untitled\\src\\main\\resources\\3584.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    var st: StringTokenizer

    var T = br.readLine().toInt()
    while (T-- > 0) {
        N = br.readLine().toInt()
        init()

        for (i in 1 until N) {
            st = StringTokenizer(br.readLine())
            val start = st.nextToken().toInt() // 부모 노드
            val end = st.nextToken().toInt() // 자식 노드

            // 자식이 되지 않는 노드를 찾는 배열
            isParent[end] = true

            adjustList[start].add(end)
            adjustList[end].add(start)
        }

        var rootNode = 0
        for (i in 1 until N) {
            if (!isParent[i]) {
                rootNode = i
                break
            }
        }

        st = StringTokenizer(br.readLine())
        resultStart = st.nextToken().toInt()
        resultEnd = st.nextToken().toInt()

        DFS(rootNode, 0)
        sb.append(LCA(resultStart, resultEnd)).append('\n')

        // 사용했던 배열 전부 초기화
        clear()
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DFS(vertex: Int, depth: Int) {
    isVisited[vertex] = true
    depths[vertex] = depth

    adjustList[vertex].forEach {
        if (!isVisited[it]) {
            parents[it] = vertex
            DFS(it, depth + 1)
        }
    }
} // End of DFS

private fun LCA(node1: Int, node2: Int): Int {
    var n1 = node1
    var n2 = node2

    while (depths[n1] != depths[n2]) {
        if (depths[n1] > depths[n2]) {
            n1 = parents[n1]
        } else {
            n2 = parents[n2]
        }
    }

    while (n1 != n2) {
        n1 = parents[n1]
        n2 = parents[n2]
    }

    return n1
} // End of LCA

private fun clear() {
    isVisited.fill(false)
    isParent.fill(false)
    parents.fill(0)
    depths.fill(0)
} // End of clear

private fun init() {
    adjustList = ArrayList()
    for (i in 0..N) {
        adjustList.add(ArrayList())
    }
} // End of init
