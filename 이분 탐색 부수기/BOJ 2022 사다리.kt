package BOJ_2022_사다리

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var X = 0.0
private var Y = 0.0
private var C = 0.0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2022_사다리\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    sb = StringBuilder()

    input()

    solve()

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {
    val left: Double = 0.0
    val right: Double = Math.min(X, Y)


} // End of solve

private fun binarySearch(low: Double, high: Double): Double {


    if (high - low >= 0.001) return -1.0
    val mid = (low + high) / 2


    return 0.0
} // End of binarySearch


private fun input() {
    val st = StringTokenizer(br.readLine())
    X = st.nextToken().toDouble()
    Y = st.nextToken().toDouble()
    C = st.nextToken().toDouble()
} // End of input
