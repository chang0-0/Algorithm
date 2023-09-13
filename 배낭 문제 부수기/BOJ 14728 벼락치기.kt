package BOJ_14728

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/14728
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var T = 0

private lateinit var memo: Array<IntArray> // memo[단원][시간] = 점수
private lateinit var arr: Array<Exam>

private data class Exam(var time: Int = 0, var score: Int = 0)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14728\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(knapsack(N, T))
    return sb.toString()
} // End of solve()

private fun knapsack(n: Int, t: Int): Int {
    if (n == 0 || t <= 0) return 0
    if (memo[n][t] != -1) return memo[n][t]

    memo[n][t] = knapsack(n - 1, t)
    if (t >= arr[n].time) {
        memo[n][t] = memo[n][t].coerceAtLeast(knapsack(n - 1, t - arr[n].time) + arr[n].score)
    }

    return memo[n][t]
} // End of knapsack

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt() // 시험 단원의 개수
        T = nextToken().toInt() // 시험까지 남은 시간
    }

    arr = Array(N + 1) { Exam() }
    for (i in 1..N) {
        StringTokenizer(br.readLine()).run {
            arr[i] = Exam(
                nextToken().toInt(), // 단원별 공부 시간
                nextToken().toInt(), // 문제의 배점
            )
        }
    }

    memo = Array(N + 1) { IntArray(T + 1) { -1 } }
} // End of input()
