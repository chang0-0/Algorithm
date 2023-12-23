package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var jinjuCost = 0
private lateinit var arr: IntArray

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

    sb.append(jinjuCost).append('\n')

    var count = 0
    arr.forEach {
        if (jinjuCost < it) {
            count++
        }
    }

    sb.append(count)
    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
    arr = IntArray(N)

    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        val dest = st.nextToken()
        val cost = st.nextToken().toInt()

        if (dest == "jinju") {
            jinjuCost = cost
        }

        arr[i] = cost
    }
} // End of input()
