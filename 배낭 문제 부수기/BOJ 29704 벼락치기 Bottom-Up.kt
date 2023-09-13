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

    knapsack()
    sb.append(sum - memo[N][T])
    return sb.toString()
} // End of solve()

private fun knapsack() {
    for (i in 1..N) {
        for (j in 1..T) {
            memo[i][j] = memo[i - 1][j]
            if (arr[i].day <= j) {
                memo[i][j] = memo[i][j].coerceAtLeast(memo[i - 1][j - arr[i].day] + arr[i].penalty)
            }
        }
    }
} // End of knapsack

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

    memo = Array(N + 1) { IntArray(T + 1) }
} // End of input()
