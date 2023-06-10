package 문자열_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

/*
    소떡소떡을 팰린드롬으로 만들기 위해서 마법을 최소 몇 번 사용해야 하는지 출력하라.

    마법을 통해서 소세지를 떡으로 바꾸거나 떡을 소세로 바꿀 수 있다.
    팰린드롬으로 바꾸기 위해서는 최소 몇 번의 마법을 사용해야 하나?

    팰린드롬 특징을 파악하자
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0 // 소떡소떡의 길이
private var ans = 0
private var str = ""
private lateinit var chArr: CharArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\문자열_부수기\\25630.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    var left = ""
    var right = ""

    for (i in 0 until N / 2) {
        left += str[i]
        right += str[N - 1 - i]
    }

    for (i in 0 until N / 2) {
        if (left[i] != right[i]) {
            ans++
        }
    }

    sb.append(ans)

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun check(left: String, right: String): Int {
    var minCount = 0

    // left의 방향을 바꿔서 right와 다른 개수를 파악해야 함
    val leftLen = left.length
    for (i in leftLen - 1 downTo 0) {
        if (left[i] != right[(leftLen - 1) - i]) {
            minCount++
        }
    }

    return minCount
} // End of check

private fun input() {
    N = br.readLine().toInt()
    str = br.readLine()
    chArr = str.toCharArray()
} // End of input