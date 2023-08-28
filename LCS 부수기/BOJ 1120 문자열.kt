package BOJ_1120

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    공통 부분 문자열 찾기
 */

// https://www.acmicpc.net/problem/1120
// input
private lateinit var br: BufferedReader

// variables
private var A = ""
private var B = ""

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1120\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()


    return sb.toString()
} // End of solve()

private fun LCS() {

} // End of LCS()

private fun input() {
    StringTokenizer(br.readLine()).run {
        A = nextToken()
        B = nextToken()
    }
} // End of input()

/*
    A의 길이는 B보다 작거나 같다.

    1. B에서 A와 같은 가장 긴 부분 문자열을 찾는다.


*/