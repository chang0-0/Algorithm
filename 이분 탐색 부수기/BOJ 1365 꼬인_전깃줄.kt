package BOJ_1365

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var N = 0
private lateinit var arr: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1365\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    sb = StringBuilder()

    input()

    solve()

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {
    println(arr.contentToString())


} // End of solve

private fun binarySearch(low: Int, high: Int) {


} // End of binarySearch

private fun input() {
    N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    arr = IntArray(N)
    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }
} // End of input