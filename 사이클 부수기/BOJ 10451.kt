package BOJ_10451

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/10451
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private const val MAX = 1_001
private val arr = IntArray(MAX)
private lateinit var isVisited: BooleanArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_10451\\res.txt"
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


    var ans = 0
    for (i in 1..N) {
        if (isVisited[i]) continue
        val ret = DFS(i, i)
        if (ret) ans++
    }

    sb.append(ans).append('\n')
    return sb.toString()
} // End of solve()

private fun DFS(node: Int, target: Int): Boolean {
    if (isVisited[node] && target == node) {
        return true
    }

    val next = arr[node]
    isVisited[next] = true
    if (DFS(next, target)) {
        return true
    } else {
        return false
    }
} // End of DFS()

private fun input() {
    N = br.readLine().toInt()

    isVisited = BooleanArray(N + 1)
    StringTokenizer(br.readLine()).run {
        for (i in 0 until N) {
            arr[i + 1] = nextToken().toInt()
        }
    }
} // End of input()
