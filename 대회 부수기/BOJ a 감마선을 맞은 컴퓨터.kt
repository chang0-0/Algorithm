package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/contest/problem/1151/1
// input
private lateinit var br: BufferedReader

// variables
private const val N = 15
private lateinit var board: Array<CharArray>

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

    var flag = false
    for (temp in board) {
        for (char in temp) {
            when (char) {
                'w' -> {
                    sb.append("chunbae")
                    flag = true
                    break
                }

                'b' -> {
                    sb.append("nabi")
                    flag = true
                    break
                }

                'g' -> {
                    sb.append("yeongcheol")
                    flag = true
                    break
                }
            }
        }
        if (flag) break
    }

    return sb.toString()
} // End of solve()

private fun input() {
    board = Array(N) {
        StringTokenizer(br.readLine()).run {
            CharArray(N) {
                nextToken()[0]
            }
        }
    }
} // End of input()
