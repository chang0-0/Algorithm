package BOJ_1464

import java.io.*


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
    val deque = ArrayDeque<Char>()
    deque.addLast(S[0])

    val len = S.length
    for (i in 1 until len) {
        val cur = S[i]

        if (cur <= deque.first()) {
            deque.addFirst(cur)
        } else {
            deque.addLast(cur)
        }
    }

    deque.forEach {
        sb.append(it)
    }

    return sb.toString()
} // End of solve()
