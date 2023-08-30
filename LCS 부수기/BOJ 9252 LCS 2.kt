package BOJ_9252

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// https://www.acmicpc.net/problem/9252
// input
private lateinit var br: BufferedReader

// variables
private var s1 = ""
private var s2 = ""
private var N = 0
private var M = 0

private lateinit var memo: Array<Array<Memo>>

private data class Memo(var cnt: Int = -1, var str: String = "")

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_9252\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val temp = LCS(N, M)
    if (temp.cnt == 0) {
        sb.append(0)
    } else {
        sb.append(temp.cnt).append('\n').append(temp.str)
    }

    return sb.toString()
} // End of solve()

private fun LCS(n: Int, m: Int): Memo {
    if (n == 0 || m == 0) return Memo(0, "")

    if (memo[n][m].cnt != -1) return memo[n][m]

    if (s1[n - 1] == s2[m - 1]) {
        // 같을 때
        val temp = LCS(n - 1, m - 1)
        memo[n][m].cnt = temp.cnt + 1
        memo[n][m].str += temp.str + s1[n - 1]
    } else {
        // 다를 때
        val temp1 = LCS(n - 1, m)
        val temp2 = LCS(n, m - 1)

        if (temp1.cnt > temp2.cnt) {
            memo[n][m].cnt = temp1.cnt
            memo[n][m].str = temp1.str
        } else {
            memo[n][m].cnt = temp2.cnt
            memo[n][m].str = temp2.str
        }
    }

    return memo[n][m]
} // End of LCS


private fun input() {
    s1 = br.readLine()
    s2 = br.readLine()

    N = s1.length
    M = s2.length

    memo = Array(N + 1) { Array(M + 1) { Memo() } }
} // End of input()
