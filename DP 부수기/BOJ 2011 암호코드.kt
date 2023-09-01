package BOJ_2011

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// https://www.acmicpc.net/problem/2011
// input
private lateinit var br: BufferedReader

// variables
private const val MOD = 1_000_000
private var S = ""
private var N = 0

private lateinit var memo: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2011\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // 암호를 해석할 수 없는 경우에는 0을 출력한다.
    if (S[0] == '0') {
        sb.append(0)
    } else {
        sb.append(DP(N) % MOD)
    }

    return sb.toString()
} // End of solve()

private fun DP(n: Int): Int {
    if (n == 0 || n == 1) return 1

    if (memo[n] != -1) return memo[n]

    memo[n] = 0
    if (S[n - 1] > '0') {
        memo[n] += DP(n - 1)
    }

    val temp = S.substring(n - 2, n).toInt()
    if (temp in 10..26) {
        // 2개의 문자열을 합한 값이 10에서 26시이일 경우
        // 문자 하나를 만들 수 있음
        memo[n] += DP(n - 2)
    }

    memo[n] %= MOD
    return memo[n]
} // End of DP

private fun input() {
    S = br.readLine()
    N = S.length

    memo = IntArray(N + 1) { -1 }
} // End of input()
