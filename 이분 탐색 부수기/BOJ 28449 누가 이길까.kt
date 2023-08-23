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

    var win: Long = 0
    var draw: Long = 0
    var lose: Long = 0

    val hiSize = HIArr.size
    val arcSize = ARCArr.size
    for (i in 0 until hiSize) {
        val lower = lowerBound(HIArr[i])
        val upper = upperBound(HIArr[i])

        win += lower
        draw += upper - lower
    }

    lose = N * M - (win + draw)

    sb.append(win).append(' ').append(lose).append(' ').append(draw)
    return sb.toString()
} // End of solve()

private fun lowerBound(low: Int, high: Int, target: Int): Int {
    if ()

} // End of lowerBound()

private fun upperBound(target: Int): Int {

} // End of upperBound

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
    ARCArr.sort()

    println(HIArr.binarySearch(1))
    println(ARCArr.binarySearch(1))


} // End of input()
