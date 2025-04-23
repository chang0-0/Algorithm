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
    repeat(T) {
        input()

        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val comp = object : Comparator<String> {
        override fun compare(o1: String, o2: String): Int {
            val o1Len = o1.length
            val o2Len = o2.length
            val minLen = Math.min(o1Len, o2Len)

            for (i in 0 until minLen) {
                if (o1[i] != o2[i]) {
                    if (o1[i] == '-' && o2[i] != '-') {
                        return 1
                    } else if (o1[i] != '-' && o2[i] == '-') {
                        return -1
                    }

                    val upper1 = Character.toUpperCase(o1[i])
                    val upper2 = Character.toUpperCase(o2[i])

                    if (upper1 != upper2) {
                        return upper1 - upper2
                    }

                    return o1.compareTo(o2)
                    break
                }
            }

            return o1.compareTo(o2)
        }
    }

    val que = PriorityQueue<String>(comp)
    repeat(N) {
        que.offer(br.readLine())
    }

    while (que.isNotEmpty()) {
        sb.append(que.poll()).append('\n')
    }


    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
} // End of input()
