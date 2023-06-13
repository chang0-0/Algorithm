package 문자열_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter


/*
    유지니가 메모한 문자 집합의 순서대로이고, 한 글자부터 암호가 풀릴 때까지 모두 대입해본다.
    문자의 종류는 최대 100가지이고, 공백은 사용할 수 없다. 대소문자를 구분한다. 암호의 길이는 최대 1,000,000자이다.
 */

// input
private lateinit var br: BufferedReader

// variables
private const val MOD = 900_528
private var str = ""
private var password = ""
private var charsMap = HashMap<Char, Int>()


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\문자열_부수기\\1394.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    // input
    input()

    sb.append(solve())

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve(): Int {
    val strLen = str.length
    val passwordLen = password.length

    for (i in 0 until strLen) {
        charsMap[str[i]] = i + 1
    }

    var ans = 0
    for (i in 0 until passwordLen) {
        ans *= str.length

        val num: Char = password[i]
        ans += charsMap.getValue(num)
        ans %= MOD
    }

    return ans
} // End of solve

private fun input() {
    str = br.readLine()
    password = br.readLine()
} // End of input
