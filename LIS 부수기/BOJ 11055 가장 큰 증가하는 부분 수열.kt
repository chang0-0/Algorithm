package BOJ_11055

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/11055
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private lateinit var arr: IntArray
private lateinit var memo: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_11055\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // 증가하는 부분 수열중에 서 합이 가장 큰 친구를 찾아라.
    val list = ArrayList<Int>()
    list.add(arr[0])
    memo[0] = arr[0]

    for (i in 0 until N) {
        LIS(i, list)
    }
    println(memo.contentToString())

    sb.append(memo.max())
    return sb.toString()
} // End of solve()

private fun LIS(n: Int, list: ArrayList<Int>): Int {
    if (memo[n] != 0) return memo[n]

    memo[n] = 0
    if (list[list.size - 1] < arr[n]) {
        list.add(arr[n])
        memo[n] = list.sum()
    } else {
        val idx = binarySearch(list, 0, list.size - 1, arr[n])
        list[idx] = arr[n]
        memo[n] = list.sum()
    }

    return memo[n]
} // End of LIS()

private fun binarySearch(list: ArrayList<Int>, low: Int, high: Int, target: Int): Int {
    if (low > high) return low

    val mid = (low + high) / 2
    return if (list[mid] < target) {
        binarySearch(list, mid + 1, high, target)
    } else {
        binarySearch(list, low, mid - 1, target)
    }
} // End of binarySearch()

private fun input() {
    N = br.readLine().toInt()

    StringTokenizer(br.readLine()).run {
        arr = IntArray(N) {
            nextToken().toInt()
        }
    }

    memo = IntArray(N)
} // End of input()
