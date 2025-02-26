package BOJ_9024

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var N = 0
private var K = 0
private lateinit var arr: IntArray


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_9024\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    sb = StringBuilder()

    val t = br.readLine().toInt()
    repeat(t) {
        input()

        solve()
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {
    var ans = 0
    var minIndex = 0
    var maxIndex = N - 1
    var ret = Int.MAX_VALUE

    while (minIndex < maxIndex) {
        val sum = arr[minIndex] + arr[maxIndex]
        val temp = abs(K - sum)

        if (temp < ret) {
            ret = temp
            ans = 1
        } else if (temp == ret) {
            ans++
        }

        if (sum > K) {
            maxIndex--
        } else {
            minIndex++
        }
    }

    sb.append(ans).append('\n')
} // End of solve

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    K = st.nextToken().toInt()

    arr = IntArray(N)
    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
    }

    arr.sort()
} // End of input
