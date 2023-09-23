package BOJ_30045

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// https://www.acmicpc.net/problem/30045
// input
private lateinit var br: BufferedReader

// variables
private const val OI = "OI"
private const val ZERO_ONE = "01"
private var N = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_30045\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var ans = 0
    while (N-- > 0) {
        val str = br.readLine()
        if (KMP(str, "01") || KMP(str, "OI")) {
            ans++
        }
    }

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun getPartialMatch(pattern: String): IntArray {
    val m = pattern.length
    val pi = IntArray(m)
    var begin = 1
    var matched = 0
    while (begin + matched < m) {
        if (pattern[begin + matched] == pattern[matched]) {
            matched++
            pi[begin + matched - 1] = matched
        } else {
            if (matched == 0) {
                begin++
            } else {
                begin += matched - pi[matched - 1]
                matched = pi[matched - 1]
            }
        }
    }

    return pi
} // End of getPartialMatch()

private fun KMP(text: String, pattern: String): Boolean {
    val n = text.length
    val m = pattern.length
    val pi = getPartialMatch(pattern)
    var begin = 0
    var matched = 0

    while (begin <= n - m) {
        if (matched < m && text[begin + matched] == pattern[matched]) {
            matched++
            if (matched == m) return true
        } else {
            if (matched == 0) {
                begin++
            } else {
                begin += matched - pi[matched - 1]
                matched = pi[matched - 1]
            }
        }
    }
    return false
} // End of KMP()

private fun input() {
    N = br.readLine().toInt()
} // End of input()
