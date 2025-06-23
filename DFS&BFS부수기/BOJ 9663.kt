package BOJ_9663

import java.io.File

// https://www.acmicpc.net/problem/9663
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var ans = 0
private lateinit var comb: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_9663\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    DFS(0, 0)

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun DFS(depth: Int, idx: Int) {
    if (depth == N) {
        ans++
        return
    }

    for (i in idx until N) {
        comb[depth] = i
        if (check(depth)) {
            DFS(depth + 1, idx)
        }
    }
} // End of DFS()

private fun check(depth: Int): Boolean {
    for (i in 0 until depth) {
        if (comb[depth] == comb[i]) return false // 세로에 겹치는 곳이 있는지 찾기
        if (Math.abs(comb[depth] - comb[i]) == Math.abs(depth - i)) return false // 대각선 같은 곳 찾기
    }

    return true
} // End of check()

private fun input() {
    N = br.readLine().toInt()
    comb = IntArray(N)
} // End of input()
