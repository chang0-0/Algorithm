package BOJ_2022_사다리

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.pow
import kotlin.math.sqrt

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var X = 0.0
private var Y = 0.0
private var C = 0.0
private var ans = 0.0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2022_사다리\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    sb = StringBuilder()

    input()

    solve()

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {
    binarySearch(0.0, X.coerceAtMost(Y))
    sb.append("%.3f".format(ans))
} // End of solve

private fun binarySearch(low: Double, high: Double) {
    if (high - low < 0.001) {
        ans = (low + high) / 2.0
        return
    }
    val mid: Double = (low + high) / 2.0

    val a: Double = sqrt(X.pow(2.0) - mid.pow(2.0))
    val b: Double = sqrt(Y.pow(2.0) - mid.pow(2.0))
    val cal: Double = (a * b) / (a + b)

    return if (cal >= C) {
        binarySearch(mid, high)
    } else {
        binarySearch(low, mid)
    }
} // End of binarySearch

private fun input() {
    val st = StringTokenizer(br.readLine())
    X = st.nextToken().toDouble()
    Y = st.nextToken().toDouble()
    C = st.nextToken().toDouble()
} // End of input
