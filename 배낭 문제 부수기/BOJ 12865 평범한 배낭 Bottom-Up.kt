package BOJ_12865

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/12865
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var K = 0
private lateinit var arr: Array<Thing>
private lateinit var memo: Array<IntArray> // memo[N][K] = value

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_12865\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    knapsack()
    sb.append(memo[N - 1][K])
    return sb.toString()
} // End of solve()

private fun knapsack() {
    for (n in 1..N) {
        for (k in 0..K) {
            // 선택하지 않고 그냥 통과. (이전의 값을 그대로 들고감)
            memo[n][k] = memo[n - 1][k]

            // 무게를 계산해서 넘지 않을 경우, 최대값으로 갱신
            if (k - arr[n].weight >= 0) {
                memo[n][k] = Math.max(memo[n][k], memo[n - 1][k - arr[n].weight] + arr[n].value)
            }
        }
    }
} // End of knapsack()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        K = nextToken().toInt()
    }

    arr = Array(N + 1) { Thing() }
    for (i in 1..N) {
        StringTokenizer(br.readLine()).run {
            arr[i] = Thing(
                nextToken().toInt(),
                nextToken().toInt()
            )
        }
    }

    memo = Array(N + 1) { IntArray(K + 1) }
} // End of input()
