package BOJ_23826

import java.io.BufferedReader
import java.io.File
import java.util.StringTokenizer


// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private lateinit var arr: Array<WIFI>

private data class WIFI(var x: Int, var y: Int, var e: Int, var sum: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_23826\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var max = 0
    for (i in 1..N) {
        var sum = Math.max(0, calc(arr[0].x, arr[i].x, arr[0].y, arr[i].y, arr[0].e))

        for (j in 1..N) {
            sum -= Math.max(0, calc(arr[i].x, arr[j].x, arr[i].y, arr[j].y, arr[j].e))
        }

        max = Math.max(max, sum)
    }

    if(max > 0) {
        sb.append(max)
    } else {
        sb.append("IMPOSSIBLE")
    }

    return sb.toString()
} // End of solve()

private fun calc(a: Int, c: Int, b: Int, d: Int, p: Int): Int {
    return Math.max(0, p - (Math.abs(a - c) + Math.abs(b - d)))
} // End of calc()

private fun input() {
    N = br.readLine().toInt()

    arr = Array<WIFI>(N + 1) {
        var st = StringTokenizer(br.readLine())
        WIFI(
            st.nextToken().toInt(),
            st.nextToken().toInt(),
            st.nextToken().toInt(),
            0
        )
    }
} // End of input()
