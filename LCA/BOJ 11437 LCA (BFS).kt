package BOJ_11437

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/11437
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0

private lateinit var adjList: MutableList<MutableList<Int>>
private lateinit var depths: IntArray
private lateinit var parents: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_11437\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    BFS(1)
    repeat(M) {
        StringTokenizer(br.readLine()).run {
            val a = nextToken().toInt()
            val b = nextToken().toInt()

            sb.append(LCA(a, b)).append('\n')
        }
    }

    return sb.toString()
} // End of solve()

private fun BFS(node: Int) {
    val que = LinkedList<Int>()
    que.offer(node)
    parents[node] = node
    depths[node] = 0

    while (que.isNotEmpty()) {
        val nowNode = que.poll()

        for (nextNode in adjList[nowNode]) {
            if (nextNode == parents[nowNode]) continue

            parents[nextNode] = nowNode
            depths[nextNode] = depths[nowNode] + 1
            que.offer(nextNode)
        }
    }
} // End of BFS()

private fun LCA(a: Int, b: Int): Int {
    var node1 = a
    var node2 = b

    while (depths[node1] != depths[node2]) {
        if (depths[node1] > depths[node2]) {
            node1 = parents[node1]
        } else {
            node2 = parents[node2]
        }
    }

    while (node1 != node2) {
        node1 = parents[node1]
        node2 = parents[node2]
    }

    return node1
} // End of LCA()

private fun input() {
    N = br.readLine().toInt()

    adjList = ArrayList()
    repeat(N + 1) {
        adjList.add(ArrayList())
    }
    depths = IntArray(N + 1)
    parents = IntArray(N + 1)

    repeat(N - 1) {
        StringTokenizer(br.readLine()).run {
            val u = nextToken().toInt()
            val v = nextToken().toInt()

            adjList[u].add(v)
            adjList[v].add(u)
        }
    }

    M = br.readLine().toInt()
} // End of input()
