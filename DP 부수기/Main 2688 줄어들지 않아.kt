package DP_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

/*
    어떤 숫자가 줄어들지 않는다는 것은 그 숫자의 각 자리 수보다 그 왼쪽 자리 수가 작거나 같을 때 이다.
    예를 들어, 1234는 줄어들지 않음
    줄어들지 않는 4자리 수를 예를 들어 보면 0011, 1111, 1112, 1122, 2223이 있다.
    N이 주어졌을 때 줄어들지 않는 N자리 수의 개수를 구하는 프로그램을 작성하시오.
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var memo = Array(65) { LongArray(10) }

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\DP_부수기\\res\\2688.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    for (i in 0..9) {
        memo[1][i] = 1
    }

    for (i in 2..64) {
        for (j in 0..9) {
            for (k in j..9) {
                memo[i][j] += memo[i - 1][k]
            }
        }
    }

    var T = br.readLine().toInt()
    while (T-- > 0) {
        input()

        var ans = 0L
        for (i in 0..9) {
            ans += memo[N][i]
        }

        sb.append(ans).append('\n')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main


private fun input() {
    N = br.readLine().toInt()
} // End of input
