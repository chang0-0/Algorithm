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
private lateinit var arr: Array<IntArray>
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

    maxMemo[1][0] = arr[1][0]
    minMemo[1][0] = arr[1][0]

    maxMemo[1][1] = arr[1][1]
    minMemo[1][1] = arr[1][1]

    maxMemo[1][2] = arr[1][2]
    minMemo[1][2] = arr[1][2]
    DP()

    sb.append(max(maxMemo[N][0], max(maxMemo[N][1], maxMemo[N][2]))).append(' ')
        .append(min(minMemo[N][0], min(minMemo[N][1], minMemo[N][2])))

    return sb.toString()
} // End of solve()

private fun DP() {
    for (i in 2..N) {
        // 0 max
        maxMemo[i][0] = maxMemo[i - 1][0] + arr[i][0]
        maxMemo[i][1] = maxMemo[i - 1][0] + arr[i][1]

        // 0 min
        minMemo[i][0] = minMemo[i - 1][0] + arr[i][0]
        minMemo[i][1] = minMemo[i - 1][0] + arr[i][1]

        // 1 max
        // 기존의 값이 최대인지, 새로운 새로값이 최대인지 확인해서 갱신
        maxMemo[i][0] = max(maxMemo[i][0], maxMemo[i - 1][1] + arr[i][0])
        maxMemo[i][1] = max(maxMemo[i][1], maxMemo[i - 1][1] + arr[i][1])
        maxMemo[i][2] = maxMemo[i - 1][1] + arr[i][2]

        // 1 min
        minMemo[i][0] = min(minMemo[i][0], minMemo[i - 1][1] + arr[i][0])
        minMemo[i][1] = min(minMemo[i][1], minMemo[i - 1][1] + arr[i][1])
        minMemo[i][2] = minMemo[i - 1][1] + arr[i][2]


        // 2 max
        maxMemo[i][1] = max(maxMemo[i][1], maxMemo[i - 1][2] + arr[i][1])
        maxMemo[i][2] = max(maxMemo[i][2], maxMemo[i - 1][2] + arr[i][2])

        // 2 min
        minMemo[i][1] = min(minMemo[i][1], minMemo[i - 1][2] + arr[i][1])
        minMemo[i][2] = min(minMemo[i][2], minMemo[i - 1][2] + arr[i][2])
    }
} // End of DP()

private fun input() {
    N = br.readLine().toInt()
    arr = Array(N + 1) { IntArray(3) }

    for (i in 1..N) {
        StringTokenizer(br.readLine()).run {
            for (j in 0 until 3) {
                arr[i][j] = nextToken().toInt()
            }
        }
    }

    maxMemo = Array(N + 1) { IntArray(3) }
    minMemo = Array(N + 1) { IntArray(3) }
} // End of input()
