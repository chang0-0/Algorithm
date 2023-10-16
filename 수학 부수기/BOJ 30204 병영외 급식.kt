package BOJ_30204

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/30204
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var K = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_30204\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var sum = 0
    StringTokenizer(br.readLine()).run {
        for (i in 0 until N) {
            sum += nextToken().toInt()
        }
    }

    if (sum % K == 0) {
        sb.append(1)
    } else {
        sb.append(0)
    }

    return sb.toString()
} // End of solve()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        K = nextToken().toInt()
    }
} // End of input()
