package 문자열_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    페이지 번호는 1부터 시작한다.
    앞의 수를 low, 뒤의 수를 high라고 한다. 만약 low > high인 경우에는 이 범위는 인쇄하지 않는다.
    또, 인쇄 범위가 문서의 범위를 넘어가는 경우에는 출력할 수 있는 페이지만 출력한다. 페이지 번호는 1부터 시작한다.
    인쇄 범위는 겹칠 수 있다. 겹치는 페이지는 한 번만 인쇄한다

    인쇄 범위를 넘어서는 경우 출력할 수 있는 페이지만 출력한다.
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var str = ""

private lateinit var isVisited: BooleanArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\문자열_부수기\\4821.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()


    while (true) {
        if (!input()) break

        solve()

        sb.append(check()).append('\n')
    }


    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {
    val commaSt = StringTokenizer(str, ",")

    while (commaSt.hasMoreTokens()) {
        val temp = commaSt.nextToken()

        val hypenSt = StringTokenizer(temp, "-")
        val low = hypenSt.nextToken()
        if (low.length > N.toString().length) {
            continue
        }

        val lowNum = low.toInt()
        if (lowNum > N) {
            continue
        }

        if (!hypenSt.hasMoreTokens()) {
            if (!isVisited[lowNum]) {
                isVisited[lowNum] = true
            }
            continue
        }

        var high = hypenSt.nextToken()
        if (high.length > N.toString().length) {
            high = N.toString()
        }

        var highNum = high.toInt()
        if (highNum > N) {
            highNum = N
        }
        if (lowNum > highNum) {
            continue
        }

        for (i in lowNum..highNum) {
            if (!isVisited[i]) {
                isVisited[i] = true
            }
        }
    }
} // End of solve

private fun check(): Int {
    var page = 0
    for (i in 1..N) {
        if (isVisited[i]) {
            page++
        }
    }

    return page
} // End of check

private fun input(): Boolean {
    N = br.readLine().toInt()
    if (N == 0) {
        return false
    }

    str = br.readLine()
    isVisited = BooleanArray(1_001)
    return true
} // End of input