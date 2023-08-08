package BOJ_1789

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// input
private lateinit var br: BufferedReader

// variables
private var S = 0L

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1789\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main

private fun solve(): String {
    val sb = StringBuilder()

    var sum = 0L
    var count = 0
    var idx = 1

    while (true) {
        sum += idx
        idx++

        if (sum > S) break
        count++
    }

    sb.append(count)
    return sb.toString()
} // End of solve

private fun input() {
    S = br.readLine().toLong()
} // End of input
