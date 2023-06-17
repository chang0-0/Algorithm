package DP_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// input
private lateinit var br: BufferedReader

// variables
private var N = 0L
private var memo = LongArray(36)


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\DP_부수기\\res\\13699.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()
    memo[0] = 1

    sb.append(DP(N))

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DP(num: Long): Long {
    if (memo[num.toInt()] > 0) return memo[num.toInt()]

    var res = 0L
    for (i in 0 until num) {
        res += DP(i) * DP(num.toInt() - (i + 1))
    }

    memo[num.toInt()] = res
    return memo[num.toInt()]
} // End of DP

private fun input() {
    N = br.readLine().toLong()
} // End of input
