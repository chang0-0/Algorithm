package BOJ_2563

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// https://www.acmicpc.net/problem/2563
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private lateinit var arr: Array<IntArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2563\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var sum = 0
    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()

        for (j in x until x + 10) {
            for (k in y until y + 10) {
                if (arr[j][k] == 1) continue
                arr[j][k] = 1
                sum++;
            }
        }
    }

    sb.append(sum)
    return sb.toString()
} // End of solve()

private fun input() {
    N = Integer.parseInt(br.readLine())
    arr = Array(101) { IntArray(101) }
} // End of input()
