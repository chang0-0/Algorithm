package BOJ_28449

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    이분탐색을 통해서 각 값의 중앙값을 찾는다.

    그리고 중앙을 기준으로 낮은 값들은 내가 다 이기는 값이 되고,
    높은 값들은 지는 값들이 된다.

 */


// https://www.acmicpc.net/problem/28449
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0
private lateinit var HIArr: IntArray
private lateinit var ARCArr: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_28449\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()
    var hiWin = 0L
    var draw = 0L
    var arcWin = 0L

    for (i in 0 until M) {
        val lower = lowerBound(0, N, ARCArr[i])
        val upper = upperBound(0, N, ARCArr[i])
        val d = upper - lower

        draw += d
        hiWin += N - upper
        arcWin += upper - d
    }

    sb.append(hiWin).append(' ').append(arcWin).append(' ').append(draw)
    return sb.toString()
} // End of solve()

private fun lowerBound(low: Int, high: Int, target: Int): Int {
    if (low == high) return low

    val mid = (low + high) / 2
    return if (HIArr[mid] < target) {
        lowerBound(mid + 1, high, target)
    } else lowerBound(low, mid, target)
} // End of lowerBound()

// 찾고자 하는 값 이하의 값 중 가장 큰 값을 갖는 요소의 인덱스 + 1 을 반환
fun upperBound(low: Int, high: Int, target: Int): Int {
    if (low == high) return low

    val mid = (low + high) / 2
    return if (HIArr[mid] <= target) {
        upperBound(mid + 1, high, target)
    } else upperBound(low, mid, target)
} // End of upperBound()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    StringTokenizer(br.readLine()).run {
        HIArr = IntArray(N) {
            nextToken().toInt()
        }
    }

    StringTokenizer(br.readLine()).run {
        ARCArr = IntArray(M) {
            nextToken().toInt()
        }
    }

    HIArr.sort()
} // End of input()
