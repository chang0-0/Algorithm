package BOJ_1464

import java.io.*

// https://www.acmicpc.net/problem/1464
// input
private var br = System.`in`.bufferedReader()

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1464\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val S = br.readLine()
    val n = S.length

    if (n == 0) {
        sb.append("")
        return sb.toString()
    } else if (n == 1) {
        sb.append(S)
        return sb.toString()
    }
    val result = StringBuilder()
    result.append(S[0])

    for (i in 1 until n) {
        val cur = S[i]
        val option1Str = cur + result.toString()
        val option2Str = result.toString() + cur
        println("option1Str : $option1Str, option2Str : $option2Str")

        if (option1Str < option2Str) {
            // option1Str.compareTo(option2Str) < 0
            // 왼쪽 문자열이 사전순으로 더 빠르다.
            result.insert(0, cur)
            println("${option1Str.compareTo(option2Str)}, 여기1")
        } else {
            // 오른쪽 문자열이 사전순으로 더 빠르다.
            result.append(cur)
            println("${option1Str.compareTo(option2Str)} 여기2")
        }
    }

    sb.append(result.toString())
    return sb.toString()
} // End of solve()
