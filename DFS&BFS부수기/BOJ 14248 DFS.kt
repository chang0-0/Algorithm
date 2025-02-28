package BOJ_14248

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/14248
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var S = 0
private lateinit var arr: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14248\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    DFS(S)
    var ans = 0
    for (i in 1..N) if (isVisited[i]) ans++

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun DFS(idx: Int) {
    if (isVisited[idx]) return
    isVisited[idx] = true

    val next = idx + arr[idx]
    if (next in 1..N) {
        DFS(next)
    }

    val next2 = idx - arr[idx]
    if (next2 in 1..N) {
        DFS(next2)
    }
} // End of DFS()

private fun input() {
    N = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    arr = IntArray(N + 1) { idx ->
        if (idx == 0) 0
        else st.nextToken().toInt()
    }
    S = br.readLine().toInt()
    isVisited = BooleanArray(N + 1)
} // End of input()
