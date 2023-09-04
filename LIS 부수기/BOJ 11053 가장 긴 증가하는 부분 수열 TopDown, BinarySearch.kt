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

    sb.append(LIS())
    return sb.toString()
} // End of solve()

private fun LIS(): Int {
    val list = ArrayList<Int>()
    list.add(arr[0])

    for (i in 0 until N) {
        topDown(list, i)
    }

    return list.size
} // End of LIS()

private fun topDown(list: ArrayList<Int>, n: Int): Int {
    if (memo[n] != -1) return memo[n]

    if (list[list.size - 1] < arr[n]) {
        // 마지막에 있는 값이 다음 값 보다 작은 경우, 바로 넣을 수 있음,
        list.add(arr[n])
        memo[n] = list.size
        return memo[n]
    } else {
        // 마지막에 있는 값이 다음에 들어올 값 보다 작을 경우, list에서 어디에 들어갈 수 있는지 찾아야함.
        val idx = binarySearch(list, arr[n], 0, list.size - 1)
        list[idx] = arr[n]
        memo[n] = idx + 1
        return memo[n]
    }
} // End of topDown

private fun binarySearch(list: ArrayList<Int>, target: Int, low: Int, high: Int): Int {
    if (low > high) return low

    val mid = (low + high) / 2
    if (list[mid] < target) {
        return binarySearch(list, target, mid + 1, high)
    } else {
        return binarySearch(list, target, low, mid - 1)
    }
} // End of binarySearch

private fun input() {
    N = br.readLine().toInt()

    StringTokenizer(br.readLine()).run {
        arr = IntArray(N) {
            nextToken().toInt()
        }
    }

    memo = IntArray(N) { -1 }
} // End of input()
