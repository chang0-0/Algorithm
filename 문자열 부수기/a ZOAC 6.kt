package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter


// input
private lateinit var br: BufferedReader

// variables
private const val OI = "OI"
private const val ZERO_ONE = "01"
private var N = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\a.txt"
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

        if (KMP(str, OI, 0, 0, getPartialMatch(OI)) || KMP(str, ZERO_ONE, 0, 0, getPartialMatch(ZERO_ONE))) {
            ans++
        }
    }

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun getPartialMatch(pattern: String): IntArray {
    val m = pattern.length
    val pi = IntArray(m)
    computePi(pattern, 1, 0, pi)
    return pi
}

private fun computePi(pattern: String, begin: Int, matched: Int, pi: IntArray) {
    var matchCnt = matched

    if (begin + matchCnt == pattern.length) return

    if (pattern[begin + matchCnt] == pattern[matchCnt]) {
        matchCnt++
        pi[begin + matchCnt - 1] = matched
        computePi(pattern, begin, matchCnt, pi)
    } else {
        if (matched == 0) {
            computePi(pattern, begin + 1, 0, pi)
        } else {
            computePi(pattern, begin + matchCnt - pi[matchCnt - 1], pi[matchCnt - 1], pi)
        }
    }
} // End of computePi()

private fun KMP(text: String, pattern: String, begin: Int, matched: Int, pi: IntArray): Boolean {
    var matchCnt = matched

    if (begin > text.length - pattern.length) return false

    if (matchCnt < pattern.length && text[begin + matchCnt] == pattern[matchCnt]) {
        matchCnt++
        if (matchCnt == pattern.length) return false
        return KMP(text, pattern, begin, matchCnt, pi)
    } else {
        if (matchCnt == 0) {
            return KMP(text, pattern, begin + 1, 0, pi)
        } else {
            return KMP(text, pattern, begin + matchCnt - pi[matchCnt - 1], pi[matchCnt - 1], pi)
        }
    }
} // End fo KMP()

private fun input() {
    N = br.readLine().toInt()
} // End of input()
