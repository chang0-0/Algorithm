package BOJ_2816

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2816\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    sb = StringBuilder()

    input()

    solve()

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {

} // End of solve

private fun input() {

} // End of input