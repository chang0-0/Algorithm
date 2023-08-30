package BOJ_9252

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// https://www.acmicpc.net/problem/9252
// input
private lateinit var br: BufferedReader

// variables
private var s1 = ""
private var s2 = ""
private var N = 0
private var M = 0

private lateinit var memo: Array<IntArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_9252\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    println("s1 : $s1 , s2 : $s2")

    LCS(N, M)

    memo.forEach {
        println(it.contentToString())
    }

    return sb.toString()
} // End of solve()

private fun LCS(n: Int, m: Int): Int {
    println("LCS($n, $m)")

    if (n == 0 || m == 0) return 0

    if (memo[n][m] != -1) return memo[n][m]

    if (s1[n - 1] == s2[m - 1]) {
        // 같을 때
        memo[n][m] = LCS(n - 1, m - 1) + 1
    } else {
        // 다를 때
        memo[n][m] = LCS(n - 1, m).coerceAtLeast(LCS(n, m - 1))
    }

    return memo[n][m]
} // End of LCS


private fun input() {
    s1 = br.readLine()
    s2 = br.readLine()

    N = s1.length
    M = s2.length

    memo = Array(N + 1) { IntArray(M + 1) { -1 } }
} // End of input()
