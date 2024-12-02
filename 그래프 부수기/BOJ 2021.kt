package BOJ_2021

import java.io.*
import java.util.PriorityQueue
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/2021
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var L = 0
private lateinit var stationList: MutableList<MutableList<Int>>
private lateinit var lineList: MutableList<MutableList<Int>>
private var start = 0
private var dst = 0

private data class Subway(var line: Int, var node: Int, var transfer: Int) : Comparable<Subway> {
    override fun compareTo(o: Subway): Int {
        return transfer - o.transfer
    }
} // End of Subway class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2021\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(BFS())
    return sb.toString()
} // End of solve()

private fun BFS(): Int {
    val que = PriorityQueue<Subway>()
    val visitedLine = BooleanArray(L)
    val visitedNode = BooleanArray(N + 1)

    for (l in stationList[start]) {
        visitedLine[l] = true
        que.offer(Subway(l, start, 0))
    }

    while (que.isNotEmpty()) {
        val cur = que.poll()

        if (cur.node == dst) return cur.transfer

        for (nextNode in lineList[cur.line]) {
            // 같은 노선의 다른 역으로 이동, 환승 X
            if (visitedNode[nextNode]) continue
            visitedNode[nextNode] = true
            que.offer(Subway(cur.line, nextNode, cur.transfer))

            for (nextLine in stationList[nextNode]) {
                // 다른 노선으로 환승
                if (visitedLine[nextLine]) continue
                visitedLine[nextLine] = true
                que.offer(Subway(nextLine, nextNode, cur.transfer + 1))
            }
        }
    }

    return -1
} // End of BFS()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    L = st.nextToken().toInt()

    stationList = mutableListOf()
    lineList = mutableListOf()
    repeat(L) {
        lineList.add(mutableListOf())
    }
    repeat(N + 1) {
        stationList.add(mutableListOf())
    }

    for (i in 0 until L) {
        st = StringTokenizer(br.readLine())
        var temp = 0

        while (true) {
            temp = st.nextToken().toInt()
            if (temp == -1) break
            stationList[temp].add(i)
            lineList[i].add(temp)
        }
    }

    st = StringTokenizer(br.readLine())
    start = st.nextToken().toInt()
    dst = st.nextToken().toInt()
} // End of input()
