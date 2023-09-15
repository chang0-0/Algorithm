package BOJ_25195

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0
private var S = 0
private lateinit var adjList: MutableList<MutableList<Int>>
private lateinit var fans: MutableList<Int>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_25195\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()


    if (BFS()) {
        sb.append("yes")
    } else {
        sb.append("Yes")
    }
    return sb.toString()
} // End of solve()

private fun BFS(): Boolean {
    val que = LinkedList<Int>()
    val isVisited = BooleanArray(N + 1)
    que.offer(1)
    isVisited[1] = true

    while (que.isNotEmpty()) {
        val nowNode = que.poll()

        if (fans.contains(nowNode)) return false
        else if (adjList[nowNode].isEmpty()) return true

        for (nextNode in adjList[nowNode]) {
            if (fans.contains(nextNode) || isVisited[nextNode]) continue

            isVisited[nextNode] = true
            que.offer(nextNode)
        }
    }

    return false
} // End of BFS()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    adjList = ArrayList()
    repeat(N + 1) {
        adjList.add(ArrayList())
    }

    repeat(M) {
        StringTokenizer(br.readLine()).run {
            adjList[nextToken().toInt()].add(nextToken().toInt())
        }
    }

    S = br.readLine().toInt()
    fans = ArrayList()
    StringTokenizer(br.readLine()).run {
        repeat(S) {
            fans.add(nextToken().toInt())
        }
    }
} // End of input()
