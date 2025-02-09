package BOJ_4889

import java.io.File

// https://www.acmicpc.net/problem/4889
// input
private var br = System.`in`.bufferedReader()

// variables
private var str = ""
private lateinit var sb: StringBuilder

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_4889\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()
    sb = StringBuilder()

    var case = 1
    while (true) {
        str = br.readLine()
        if (str.contains('-')) break;
        sb.append(case++).append(". ")
        solve()
    }

    bw.write(sb.toString())
    bw.close()
} // End of main()

private fun solve() {

    str = str.replace("{}", "")
    var openCount = 0
    var ans = 0

    for (ch in str) {
        if (ch == '{') {
            openCount++
        } else if (ch == '}') {
            if (openCount > 0) {
                openCount--
            } else {
                ans++
                openCount++
            }
        }
    }

    ans += openCount / 2
    sb.append(ans).append('\n')
} // End of solve()
