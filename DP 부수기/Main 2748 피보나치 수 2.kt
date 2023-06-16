package DP_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// input
private lateinit var br: BufferedReader

// variables
private var N = 0

private var memo = LongArray(91) { -1 }

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\DP_부수기\\res\\2748.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    memo[0] = 0
    memo[1] = 1

    DP()

    sb.append(memo[N])

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DP() {
    for(i in 2.. N) {
        memo[i] = memo[i - 1] + memo[i - 2]
    }
} // End of DP

private fun input() {
    N = br.readLine().toInt()
} // End of input
