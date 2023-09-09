package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter


// input
private lateinit var br: BufferedReader

// variables
private const val DK = "DKSH"
private var S = ""
private lateinit var chArr: CharArray
private lateinit var memo: Array<IntArray>

private var N = 0
private var M = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\a.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var ans = 0
    for (i in 1..N) {
        for (j in 1..M) {
            if (LCS(i, j) == DK.length) {
                ans++
            }
        }
    }

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun LCS(n: Int, m: Int): Int {
    if (n == 0 || m == 0) return 0

    if (memo[n][m] != -1) return memo[n][m]

    if (chArr[n - 1] == DK[m - 1]) {
        memo[n][m] = LCS(n - 1, m - 1) + 1
    } else {
        memo[n][m] = 0
    }

    return memo[n][m]
} // End of topDown()

private fun input() {
    S = br.readLine()
    chArr = S.toCharArray()
    N = S.length
    M = DK.length
    memo = Array(N + 1) { IntArray(M + 1) { -1 } }
} // End of input()
