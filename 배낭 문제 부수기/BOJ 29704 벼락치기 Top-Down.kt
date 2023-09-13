package BOJ_29704

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/29704
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var T = 0
private var sum = 0
private lateinit var arr: Array<Problem>
private lateinit var memo: Array<IntArray>

data class Problem(var day: Int = 0, var penalty: Int = 0)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_29704\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(sum - knapsack(N, T))
    memo.forEach {
        println(it.contentToString())
    }

    return sb.toString()
} // End of solve()

private fun knapsack(n: Int, t: Int): Int {
    println("knapsack($n, $t)")

    if (n == 0 || t <= 0) return 0
    if (memo[n][t] != -1) return memo[n][t]


    memo[n][t] = knapsack(n - 1, t)
    if (t >= arr[n].day) {
        memo[n][t] = Math.max(memo[n][t], knapsack(n - 1, t - arr[n].day) + arr[n].penalty)
    }

    memo.forEach {
        println(it.contentToString())
    }

    println("memo[$n][$t] = ${memo[n][t]}")

    return memo[n][t]
} // End of knapsack()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        T = nextToken().toInt()
    }

    arr = Array(N + 1) { Problem() }
    for (i in 1..N) {
        StringTokenizer(br.readLine()).run {
            arr[i] = Problem(
                nextToken().toInt(),
                nextToken().toInt()
            )
        }
        sum += arr[i].penalty
    }

    memo = Array(N + 1) { IntArray(T + 1) { -1 } }
} // End of input()
