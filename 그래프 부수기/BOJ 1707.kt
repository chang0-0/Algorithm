package BOJ_1707

import java.io.*
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/1707
// input
private var br = System.`in`.bufferedReader()

// variables
private var V = 0
private var E = 0
private lateinit var adjList: MutableList<MutableList<Int>>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1707\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    val t = br.readLine().toInt()
    repeat(t) {
        input()

        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val color = IntArray(V + 1) { -1 }
    println("adjList : $adjList")

    var startNode = 1
    while (startNode < V) {
        println("startNode : $startNode, color : ${color.toList()}")

        if (color[startNode] == -1) {
            if (!BFS(startNode, color)) {
                sb.append("NO").append('\n')
                return sb.toString()
            }
        }

        startNode++
    }

    // 결론적으로 이분 그래프일 경우,
    // 0또는 1로 칠해져야 합니다.
    println("color : ${color.toList()}")

    sb.append("YES").append('\n')
    return sb.toString()
} // End of solve()

private fun BFS(startNode: Int, color: IntArray): Boolean {
    val que = ArrayDeque<Int>()
    que.addLast(startNode)
    color[startNode] = 0

    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        for (v in adjList[cur]) {
            if (color[v] == -1) {
                // 다음 노드가 -1이면, 진행
                color[v] = 1 - color[cur]
                que.addLast(v)
            } else if (color[v] == color[cur]) {
                // 다음 진행하는 노드가 같은 색상일 경우 더 이상 진행하지 않는다.
                return false
            }
        }
    }

    return true
} // End of BFS()

private fun input() {
    var st = StringTokenizer(br.readLine())
    V = st.nextToken().toInt()
    E = st.nextToken().toInt()

    adjList = mutableListOf()
    repeat(V + 1) {
        adjList.add(mutableListOf())
    }

    repeat(E) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        adjList[a].add(b)
        adjList[b].add(a)
    }
} // End of input()
