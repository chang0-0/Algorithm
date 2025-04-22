package BOJ_1464

import java.io.*

// https://www.acmicpc.net/problem/1464
// input
private var br = System.`in`.bufferedReader()


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1464\\res.txt"
    val bw = System.out.bufferedWriter()
    br = File(path).bufferedReader()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val S = br.readLine()
    val N = S.length
    val builder = StringBuilder()
    builder.append(S[0])

    for (i in 1 until N) {
        val cur = S[i]

        if (builder.toString() + cur > cur + builder.toString()) {
            builder.insert(0, cur)
        } else {
            builder.append(cur)
        }
    }

    sb.append(builder.toString())
    return sb.toString()
} // End of solve()