package BOJ_6127

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var K = 0

private lateinit var map: Array<IntArray>
private lateinit var arr: Array<Pair<Int, Int>>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_6127\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main

private fun solve(): String {
    val sb = StringBuilder()

    var ans = 0
    for (i in 1..N) {
        for (j in 1..N) {
            // arr 배열의 모든 요소가 해당 조건을 만족하는지 검사하는 함수
            ans += if (arr.all { (x, y) -> i == x || j == y || i - j == x - y || i + j == x + y }) {
                1
            } else {
                0
            }
        }
    }

    sb.append(ans)
    return sb.toString()
} // End of solve

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        K = nextToken().toInt()
    }

    map = Array(N + 1) { IntArray(N + 1) }

    arr = Array(K) { Pair(0, 0) }
    for (i in 0 until K) {
        StringTokenizer(br.readLine()).run {
            arr[i] = Pair(nextToken().toInt(), nextToken().toInt())
        }
    }
} // End of input
