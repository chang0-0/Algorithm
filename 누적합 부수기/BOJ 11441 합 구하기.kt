package BOJ_11441

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0

private lateinit var arr: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_11441\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main

private fun solve(): String {
    val sb = StringBuilder()

    repeat(M) {
        StringTokenizer(br.readLine()).run {
            val start = nextToken().toInt()
            val end = nextToken().toInt()

            sb.append(arr[end] - arr[start - 1]).append('\n')
        }
    }

    return sb.toString()
} // End of solve

private fun input() {
    N = br.readLine().toInt()

    arr = IntArray(N + 1)
    StringTokenizer(br.readLine()).run {
        for (i in 1..N) {
            arr[i] = arr[i - 1] + nextToken().toInt()
        }
    }

    M = br.readLine().toInt()
} // End of input
