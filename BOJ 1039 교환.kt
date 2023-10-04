package BOJ_1039

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/1039
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var K = 0
private var ans = 0
private lateinit var memo: Array<BooleanArray>

private data class Pair(var num: Int, var k: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1039\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    BFS()
    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun BFS(): Int {
    val que: Queue<Pair> = LinkedList()
    que.offer(Pair(N, 0))

    while (que.isNotEmpty()) {
        val nowNode = que.poll()

        if (nowNode.k == K) {
            ans = ans.coerceAtLeast(nowNode.num)
            continue
        }

        val strNum = nowNode.num.toString()
        val len = strNum.length
        for (i in 0 until len - 1) {
            for (j in i + 1 until len) {
                if (i == 0 && strNum[j] == '0') continue

                val swapped = swap(strNum, i, j)
                val swappedNum = swapped.toInt()

                if (memo[swappedNum][nowNode.k + 1]) continue
                memo[swappedNum][nowNode.k + 1] = true
                que.offer(Pair(swappedNum, nowNode.k + 1))
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
} // End of swap

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        K = nextToken().toInt()
    }

    ans = -1
    memo = Array(1_000_001) { BooleanArray(K + 1) }
} // End of input()
