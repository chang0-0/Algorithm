package BOJ_28450

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min


// https://www.acmicpc.net/problem/28450
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0
private var H = 0

private lateinit var memo: Array<LongArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_28450\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()


    memo.forEach {
        println(it.contentToString())
    }
    println("")
    println("")

    for (n in N - 1 downTo 0) {
        for (m in M - 1 downTo 0) {
            if (n == N - 1 && m == M - 1) continue

            if (n == N - 1) memo[n][m] += memo[n][m + 1]
            else if (m == M - 1) memo[n][m] += memo[n + 1][m]
            else memo[n][m] += min(memo[n + 1][m], memo[n][m + 1])
        }
    }

    memo.forEach {
        println(it.contentToString())
    }

    if (memo[0][0] > H) {
        sb.append("NO")
    } else {
        sb.append("YES").append('\n').append(memo[0][0])
    }

    return sb.toString()
} // End of solve()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    memo = Array(N) { LongArray(M) }
    for (i in 0 until N) {
        StringTokenizer(br.readLine()).run {
            for (j in 0 until M) {
                memo[i][j] = nextToken().toLong()
            }
        }
    }

    H = br.readLine().toInt()
} // End of input()
