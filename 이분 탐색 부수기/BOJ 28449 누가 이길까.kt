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

    val hiSize = HIArr.size
    val arcSize = ARCArr.size
    for (i in 0 until hiSize) {
        binarySearch(0, arcSize - 1, HIArr[i])
    }


    return sb.toString()
} // End of solve()

private fun binarySearch(low: Int, high: Int, find: Int): Int { // 인덱스를 찾는거임.
    if (low > high) {
        return -1
    }

    // 인덱스를 이분탐색해서 나랑 가장 가까운 값을 찾아야함
    val mid = (low + high) / 2
    if (ARCArr[mid] > find) {
        val temp = binarySearch()

    } else {

    }


} // End of binarySearch

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

    println(HIArr.sort())
    println(ARCArr.sort())
} // End of input()
