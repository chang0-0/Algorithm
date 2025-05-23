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
    val N = S.length

    val que = ArrayDeque<Char>()
    que.addLast(S[0])

    for (i in 1 until N) {
        val cur = S[i]

        if (cur <= que.first()) {
            que.addFirst(cur)
        } else {
            que.addLast(cur)
        }
    }

    que.forEach {
        sb.append(it)
    }

    return sb.toString()
} // End of solve()