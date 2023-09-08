package BOJ_2748

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// https://www.acmicpc.net/problem/2748
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private lateinit var memo: LongArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2748\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(DFS(N))
    return sb.toString()
} // End of solve()

private fun DFS(n: Int): Long {
    if (n <= 0) return 0
    if (n == 1) return 1
    if (memo[n] != -1L) return memo[n]

    memo[n] = 0
    memo[n] = DFS(n - 1) + DFS(n - 2)
    return memo[n]
} // End of DFS

private fun input() {
    N = br.readLine().toInt()

    memo = LongArray(N + 1) { -1 }
} // End of input()
