package BOJ_12731

import java.io.BufferedReader
import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/12731
// input
private var br = System.`in`.bufferedReader()

// variables
private var T = 0
private var NA = 0
private var NB = 0

private lateinit var aTob: Array<Time>
private lateinit var bToa: Array<Time>

private data class Time(var start: Int, var end: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_12731\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    val N = br.readLine().toInt()
    for (i in 1..N) {
        input()

        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    return sb.toString()
} // End of solve()

private fun input() {
    T = br.readLine().toInt()

    var st = StringTokenizer(br.readLine())
    var timeToken : StringTokenizer
    NA = st.nextToken().toInt()
    NB = st.nextToken().toInt()

    println("NA : $NA , NB : $NB")

    aTob = Array<Time>(NA) {
        st = StringTokenizer(br.readLine())
        var temp = st.nextToken()
        timeToken = StringTokenizer(temp, ":")

        val startM = timeToken.nextToken().toInt() + timeToken.nextToken().toInt() * 60

        temp = st.nextToken()
        timeToken = StringTokenizer(temp, ":")
        val endM = timeToken.nextToken().toInt() + timeToken.nextToken().toInt() * 60

        Time(
            startM,
            endM
        )
    }

    bToa = Array<Time>(NB) {
        st = StringTokenizer(br.readLine())
        var temp = st.nextToken()
        timeToken = StringTokenizer(temp, ":")

        val startM = timeToken.nextToken().toInt() + timeToken.nextToken().toInt() * 60

        temp = st.nextToken()
        timeToken = StringTokenizer(temp, ":")
        val endM = timeToken.nextToken().toInt() + timeToken.nextToken().toInt() * 60

        Time(
            startM,
            endM
        )
    }

    println("aTob : ${aTob.contentToString()} , bToa : ${bToa.contentToString()}")

} // End of input()
