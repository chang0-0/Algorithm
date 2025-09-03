package BOJ_1719

import java.io.*
import java.util.PriorityQueue
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/1719
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private val INF = Integer.MAX_VALUE
private lateinit var adjList: MutableList<MutableList<Coordinate>>

private data class Coordinate(val num: Int, val time: Int) : Comparable<Coordinate> {
    override fun compareTo(o: Coordinate): Int {
        return time - o.time
    }
} // End of Coordinate class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1719\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()


    for (i in 1..N) {
        val ret = BFS(i)

        for (j in 1..N) {
            if (j == i) {
                sb.append('-')
            } else {
                sb.append(ret[j])
            }
            sb.append(' ')
        }
        sb.append('\n')
    }


    return sb.toString()
} // End of solve()

private fun BFS(start: Int): IntArray {
    val que = PriorityQueue<Coordinate>()
    val dist = IntArray(N + 1) { INF }
    val preVisited = IntArray(N + 1) { INF }
    val isVisited = BooleanArray(N + 1)

    que.offer(Coordinate(start, 0))
    dist[start] = 0
    preVisited[start] = start

    while (que.isNotEmpty()) {
        val cur = que.poll()

        if (dist[cur.num] < cur.time) continue
        if (isVisited[cur.num]) continue
        isVisited[cur.num] = true

        for (next in adjList[cur.num]) {
            if (dist[next.num] > dist[cur.num] + next.time) {

                if (start == cur.num) {
                    preVisited[next.num] = next.num
                } else {
                    preVisited[next.num] = preVisited[cur.num]
                }

                dist[next.num] = dist[cur.num] + next.time
                que.offer(Coordinate(next.num, dist[next.num]))
            }
        }
    }


    return preVisited
} // End of BFS()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    adjList = mutableListOf()
    repeat(N + 1) {
        adjList.add(mutableListOf())
    }

    repeat(M) {
        StringTokenizer(br.readLine()).run {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            val c = nextToken().toInt()

            adjList[a].add(Coordinate(b, c))
            adjList[b].add(Coordinate(a, c))
        }
    }
} // End of input()
