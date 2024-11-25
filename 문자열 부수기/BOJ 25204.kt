package BOJ_25204

import java.io.*
import java.util.PriorityQueue

// https://www.acmicpc.net/problem/25204
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_25204\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    var T = br.readLine().toInt()
    while (T-- > 0) {
        input()

        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val comp = object : Comparator<String> {
        override fun compare(o1: String, o2: String): Int {
            if (o2.startsWith(o1)) {
                return -1
            }

            if (o1.startsWith(o2)) {
                return 1
            }

            val o1Len = o1.length
            val o2Len = o2.length
            val minLen = Math.min(o1Len, o2Len)

            for (i in 0 until minLen) {
                if (o1[i] != o2[i]) {
                    if (o1[i] == '-' && o2[i] != '-') {
                        // 붙임표가 들어간 문자열이 사전순에서 뒤진다
                        return 1
                    } else if (o1[i] != '-' && o2[i] == '-') {
                        return -1
                    }

                    val c1 = Character.toUpperCase(o1[i])
                    val c2 = Character.toUpperCase(o2[i])

                    if (c1 != c2) {
                        return c1 - c2
                    }

                    return o1.compareTo(o2)
                    break
                }
            }

            return o1.compareTo(o2)
        }
    }
    val pque = PriorityQueue(comp)

    repeat(N) {
        val temp = br.readLine()
        pque.offer(temp)
    }

    while (pque.isNotEmpty()) {
        sb.append(pque.poll()).append('\n')
    }

    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
} // End of input()
