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
private lateinit var memo: Array<Array<Int?>> // memo[N + 1][K + 1] = value

internal data class Thing(var weight: Int = 0, var value: Int = 0)

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

    sb.append(knapsack(N - 1, K))
    return sb.toString()
} // End of solve()

private fun knapsack(n: Int, k: Int): Int {
    if (n < 0 || k <= 0) return 0

    if (memo[n][k] != null) return memo[n][k]!!

    // 물건을 배낭에 넣지 않고 통과
    memo[n][k] = knapsack(n - 1, k)

    // 다음 물건을 배낭에 넣을 수 있는지 확인 후
    // 넣을 수 있을 경우에는 집어 넣음
    if (k - arr[n].weight >= 0) {
        // 기존에 있던 값과 비교해서 새로운 값이 더 클 경우 갱신하는 구조를 가짐
        memo[n][k] = memo[n][k]!!.coerceAtLeast(knapsack(n - 1, k - arr[n].weight) + arr[n].value)
    }

    return memo[n][k]!!
} // End of knapsack()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        K = nextToken().toInt()
    }

    arr = Array(N) { Thing() }
    for (i in 0 until N) {
        StringTokenizer(br.readLine()).run {
            arr[i] = Thing(
                nextToken().toInt(),
                nextToken().toInt()
            )
        }
    }

    memo = Array(N + 1) { Array(K + 1) { null } }
} // End of input()
