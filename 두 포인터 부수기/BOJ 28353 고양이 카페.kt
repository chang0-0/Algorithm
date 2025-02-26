package BOJ28353

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
private var K = 0
private lateinit var arr: IntArray


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ28353\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    sb = StringBuilder()

    input()

    solve()
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {
    var count = 0
    var minIndex = 0
    var maxIndex = N - 1

    while (minIndex < maxIndex) {
        val temp = arr[minIndex] + arr[maxIndex]
        if (temp > K) {
            // 양 끝의 합이 K를 넘었을 때 높은 값을 줄이기.
            maxIndex--
        } else if (temp < K) {
            // 양 끝의 합이 K보다 작을 때, minIndex를 올리고, maxIndex는 내리는 과정
            count++
            minIndex++
            maxIndex--
        } else {
            count++
            minIndex++
            maxIndex--
        }
    }

    sb.append(count)
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