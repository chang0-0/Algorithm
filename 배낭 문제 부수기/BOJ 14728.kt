package BOJ_14728

import java.io.*
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/14728
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var T = 0

private lateinit var arr: Array<IntArray>
private lateinit var memo: Array<IntArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14728\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(topDown(N, T))
    return sb.toString()
} // End of solve()

private fun topDown(n: Int, t: Int): Int {
    if (n == 0 || t == 0) return 0;

    if (memo[n][t] != -1) return memo[n][t]

    if (t - arr[n - 1][0] >= 0) {
        memo[n][t] = Math.max(topDown(n - 1, t), topDown(n - 1, t - arr[n - 1][0]) + arr[n - 1][1])
    } else {
        memo[n][t] = Math.max(memo[n][t], topDown(n - 1, t))
    }

    return memo[n][t]
} // End of topDown()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    T = st.nextToken().toInt()

    arr = Array(N) {
        st = StringTokenizer(br.readLine())
        IntArray(2) {
            st.nextToken().toInt()
        }
    }

    memo = Array(N + 1) {
        IntArray(10001) {
            -1
        }
    }
} // End of input()
