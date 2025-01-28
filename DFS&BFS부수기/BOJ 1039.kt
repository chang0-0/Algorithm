package BOJ_1039

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/1039
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var K = 0
private lateinit var chArr: CharArray
private const val MAX = 1_000_001
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
    var ans = -1

    que.addLast(Swap(String(chArr), 0))


    while (que.isNotEmpty()) {
        val cur = que.removeFirst()

        if (cur.count == K) {
            ans = Math.max(ans, cur.num.toInt())
        }
        if (memo[cur.num.toInt()][cur.count]) continue
        memo[cur.num.toInt()][cur.count] = true

        for (i in 0 until N - 1) {
            for (j in i + 1 until N) {
                if (i == 0 && cur.num[j] == '0') continue
                if (cur.count + 1 > K) continue

                val swapNum = swap(cur.num, i, j)
                que.addLast(Swap(swapNum, cur.count + 1))
            }
        }
    }

    return ans
} // End of BFS()

private fun swap(str: String, i: Int, j: Int): String {
    val arr = str.toCharArray()
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp

    return String(arr)
} // End of swap()

private fun input() {
    StringTokenizer(br.readLine()).run {
        chArr = nextToken().toCharArray()
        N = chArr.size
        K = nextToken().toInt()
    }
} // End of input()
