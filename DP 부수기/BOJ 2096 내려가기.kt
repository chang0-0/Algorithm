package BOJ_2096

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max
import kotlin.math.min

// https://www.acmicpc.net/problem/2096
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private lateinit var maxMemo: Array<IntArray>
private lateinit var minMemo: Array<IntArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2096\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(max(maxMemo[N][0], max(maxMemo[N][1], maxMemo[N][2]))).append(' ')
        .append(min(minMemo[N][0], min(minMemo[N][1], minMemo[N][2])))
    return sb.toString()
} // End of solve()

private fun DP(i: Int, first: Int, second: Int, third: Int) {
    // 0 max
    maxMemo[i][0] = maxMemo[i - 1][0] + first
    maxMemo[i][1] = maxMemo[i - 1][0] + second

    // 0 min
    minMemo[i][0] = minMemo[i - 1][0] + first
    minMemo[i][1] = minMemo[i - 1][0] + second

    // 1 max
    // 기존의 값이 최대인지, 새로운 새로값이 최대인지 확인해서 갱신
    maxMemo[i][0] = max(maxMemo[i][0], maxMemo[i - 1][1] + first)
    maxMemo[i][1] = max(maxMemo[i][1], maxMemo[i - 1][1] + second)
    maxMemo[i][2] = maxMemo[i - 1][1] + third

    // 1 min
    minMemo[i][0] = min(minMemo[i][0], minMemo[i - 1][1] + first)
    minMemo[i][1] = min(minMemo[i][1], minMemo[i - 1][1] + second)
    minMemo[i][2] = minMemo[i - 1][1] + third


    // 2 max
    maxMemo[i][1] = max(maxMemo[i][1], maxMemo[i - 1][2] + second)
    maxMemo[i][2] = max(maxMemo[i][2], maxMemo[i - 1][2] + third)

    // 2 min
    minMemo[i][1] = min(minMemo[i][1], minMemo[i - 1][2] + second)
    minMemo[i][2] = min(minMemo[i][2], minMemo[i - 1][2] + third)
} // End of DP()

private fun input() {
    N = br.readLine().toInt()
    maxMemo = Array(N + 1) { IntArray(3) }
    minMemo = Array(N + 1) { IntArray(3) }

    for (i in 1..N) {
        StringTokenizer(br.readLine()).run {
            val first = nextToken().toInt()
            val second = nextToken().toInt()
            val third = nextToken().toInt()

            DP(i, first, second, third)
        }
    }
} // End of input()
