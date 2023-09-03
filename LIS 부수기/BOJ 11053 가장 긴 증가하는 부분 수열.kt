package BOJ_11053

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/11053
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private lateinit var arr: IntArray
private lateinit var memo: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_11053\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var max = -1
    for (i in N - 1 downTo 0) {
        max = Math.max(max, LIS(i))

        println(memo.contentToString())
    }

    sb.append(max)
    return sb.toString()
} // End of solve()

private fun LIS(idx: Int): Int {
    if (memo[idx] != -1) return memo[idx]

    memo[idx] = 1

    for (i in N - 1 downTo idx + 1) {
        if (arr[idx] < arr[i]) {
            memo[idx] = Math.max(memo[idx], LIS(i) + 1)
        }
    }

    return memo[idx]
} // End of LIS()

private fun input() {
    N = br.readLine().toInt()

    StringTokenizer(br.readLine()).run {
        arr = IntArray(N) {
            nextToken().toInt()
        }
    }

    memo = IntArray(N) { -1 }
} // End of input()
