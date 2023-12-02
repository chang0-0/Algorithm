package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// https://www.acmicpc.net/contest/problem/1212/2
// input
private lateinit var br: BufferedReader

// variables
private const val UOSPC = "uospc"
private var N = 0
private var S = ""

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\b.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

/*
    이 문제는 주어진 문자열 S에서 "uospc"라는 문자열을 가능한 한 많이 추출하는 것이 목표입니다.
    이를 위해 문자열 S의 문자들을 재배열할 수 있습니다. 따라서 이 문제는 각 문자의 빈도수를 세고,
    이를 기반으로 "uospc"라는 문자열을 몇 번 만들 수 있는지 계산하는 방식으로 접근하는 것이 적합합니다.

    문자열 S에서 각 문자('u', 'o', 's', 'p', 'c')의 빈도수를 계산합니다.
    "uospc"를 구성하는 각 문자의 빈도수 중 최소값을 찾습니다.
    이 값이 바로 주어진 문자열에서 "uospc"를 만들 수 있는 최대 횟수입니다.
    예를 들어, "suspicion"에서 'u', 'o', 's', 'p', 'c'의 빈도수는 각각 1, 1, 2, 1, 1입니다.
     이 중 최소값은 1이므로 "uospc"를 1번 만들 수 있습니다.

    "processyourpurchase"에서 각 문자의 빈도수는 'u'가 2번, 'o'가 2번, 's'가 3번, 'p'가 2번, 'c'가 2번 등장합니다.
    이 경우 최소값은 2이므로 "uospc"를 2번 만들 수 있습니다.
 */

private fun solve(): String {
    val sb = StringBuilder()

    val arr = IntArray(26)
    S.forEach {
        val temp = it.toInt() - 97
        arr[temp]++
    }

    var min = 1001
    for (i in 0 until 26) {
        if (i == 20 || i == 18 || i == 2 || i == 14 || i == 15) {
            min = min.coerceAtMost(arr[i])
        }
    }

    sb.append(min)
    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
    S = br.readLine()
} // End of input()
