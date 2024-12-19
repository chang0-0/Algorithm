package BOJ_1325

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/1325
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private var max = 0
private lateinit var isVisited: Array<BooleanArray>
private lateinit var counts: IntArray
private lateinit var adjList: MutableList<MutableList<Int>>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1325\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    for (i in 1..N) {
        BFS(i);
    }

    for(i in  1..N) {
        if(counts[i] == max) {
            sb.append(i).append(' ')
        }
    }

    return sb.toString()
} // End of solve()

private fun BFS(node: Int) {
    val que = ArrayDeque<Int>()
    que.addFirst(node)

    while (que.isNotEmpty()) {
        val cur = que.removeLast()

        if (isVisited[node][cur]) continue
        isVisited[node][cur] = true
        counts[node]++

        for (next in adjList[cur]) {
            if (isVisited[node][next]) continue

            if (next > node) que.addFirst(next)
            else {
                for (i in 1..N) {
                    if (isVisited[node][i]) continue
                    if (isVisited[next][i]) {
                        isVisited[node][i] = true
                        counts[node]++
                    }
                }
            }
        }
    }

    max = Math.max(max, counts[node])
} // End of BFS()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    adjList = mutableListOf()
    max = -1
    isVisited = Array(N + 1) { BooleanArray(N + 1) }
    counts = IntArray(N + 1)

    repeat(N + 1) {
        adjList.add(mutableListOf())
    }

    repeat(M) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        adjList[b].add(a)
    }
} // End of input()
