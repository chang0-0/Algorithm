package BOJ_1039

import java.io.*
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/1039
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var K = 0
private lateinit var chArr: CharArray
private const val MAX = 1_000_001

private data class Num(val num: Int, val count: Int)

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
    val que = ArrayDeque<Num>()
    val memo = Array(MAX) { BooleanArray(K + 1) }
    var max = Int.MIN_VALUE
    que.addLast(Num(N, 0))

    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        if (memo[cur.num][cur.count]) continue
        memo[cur.num][cur.count] = true
        if (cur.count == K) {
            max = Math.max(max, cur.num)
            continue
        }

        val str = cur.num.toString()
        val len = str.length
        for (i in 0 until len - 1) {
            for (j in i + 1 until len) {
                if (i == 0 && str[j] == '0') continue

                val swapNum = swap(str, i, j)
                que.addLast(Num(swapNum, cur.count + 1))
            }
        }
    }

    return if (max == Int.MIN_VALUE) {
        -1
    } else {
        max
    }
} // End of BFS()

private fun swap(num: String, i: Int, j: Int): Int {
    val chArr = num.toCharArray()

    val temp = chArr[i]
    chArr[i] = chArr[j]
    chArr[j] = temp
    return String(chArr).toInt()
} // End of swap()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        K = nextToken().toInt()
    }

    chArr = N.toString().toCharArray()
} // End of input()
