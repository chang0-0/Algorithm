package BOJ_1039

import java.io.*
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/1039
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0
private var K = 0
private var nStr = ""
private val MAX = 1_000_001

private data class Swap(val num: String, val count: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1039\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(BFS())
    return sb.toString()
} // End of solve()

private fun BFS(): Int {
    val que = ArrayDeque<Swap>()
    val memo = Array(MAX) { BooleanArray(K + 1) }
    var max = Int.MIN_VALUE

    que.addLast(Swap(nStr, 0))

    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        if (memo[cur.num.toInt()][cur.count]) continue
        memo[cur.num.toInt()][cur.count] = true
        if (cur.count == K) {
            max = Math.max(cur.num.toInt(), max)
            continue
        }


        for (i in 0 until M - 1) {
            for (j in i + 1 until M) {
                if (i == 0 && cur.num[j] == '0') continue

                val swapNum = check(i, j, cur.num)
                que.addLast(Swap(swapNum, cur.count + 1))
            }
        }
    }

    return if (max == Int.MIN_VALUE) {
        return -1
    } else {
        return max
    }
} // End of BFS()

private fun check(i: Int, j: Int, str: String): String {
    val chArr = str.toCharArray()

    val temp = chArr[i]
    chArr[i] = chArr[j]
    chArr[j] = temp

    return String(chArr)
} // End of check()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        K = nextToken().toInt()
    }

    nStr = N.toString()
    M = nStr.length
} // End of input()
