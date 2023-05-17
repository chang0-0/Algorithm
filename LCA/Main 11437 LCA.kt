import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

private var N = 0
private var M = 0

private var isVisited: BooleanArray = BooleanArray(50_001)
private var parent: IntArray = IntArray(50_001)
private var depth: IntArray = IntArray(50_001)

// 인접리스트
private lateinit var adjustList: MutableList<MutableList<Node>>

// 인접 행렬
private var graph: Array<Node> = Array(50_001) { Node(null, null) }

private data class Node(
    var v: Int?, var link: Node?
) // End of Node class

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\Free PJT Algorithm\\untitled\\src\\main\\resources\\11437.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()
    var st: StringTokenizer


    N = br.readLine().toInt()
    parent = IntArray(N + 1)
    depth = IntArray(N + 1)
    isVisited = BooleanArray(N + 1)
    graph = Array(N + 1) { Node(null, null) }

    // 인접리스트 초기화
    adjustList = ArrayList()
    for (i in 1 until N) {
        adjustList.add(ArrayList())
    }

    for (i in 1 until N) {
        st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        graph[start] = Node(end, graph[start])
        graph[end] = Node(start, graph[end])
    }

    // DFS를 통해서 노드의 깊이를 먼저 구한다.
    DFS(1, 0)

    M = br.readLine().toInt()
    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        sb.append(LCA(st.nextToken().toInt(), st.nextToken().toInt()))
        sb.append('\n')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DFS(v: Int, d: Int) {
    isVisited[v] = true
    depth[v] = d

//    graph[v].let { temp ->
//        while (temp.link != null && temp.v != null) {
//            println("temp.link : ${temp.link}")
//            if (!isVisited[temp.v!!]) {
//                parent[temp.v!!] = v
//                DFS(temp.v!!, d + 1)
//            }
//            temp = temp.link!!
//        }
//    }

    var temp2: Node
    graph[v]?.let { temp ->
        var current = temp
        while (current.link != null && current.v != null) {
            if (!isVisited[current.v!!]) {
                parent[current.v!!] = v
                DFS(current.v!!, d + 1)
            }
            current = current.link as Node
        }
    }

} // End of DFS

private fun LCA(node1: Int, node2: Int): Int {
    var node1 = node1
    var node2 = node2

    // 트리의 높이가 다르면 높이를 같을 때까지 맞춰줌.
    while (depth[node1] != depth[node2]) {
        if (depth[node1] > depth[node2]) {
            node1 = parent[node1]
        } else {
            node2 = parent[node2]
        }
    }

    // 둘의 부모가 다르면 같을 때까지 반복해서 찾음
    while (node1 != node2) {
        node1 = parent[node1]
        node2 = parent[node2]
    }

    return node1
} // End of LCA
