package BOJ_30090

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/30090
// input
private lateinit var br: BufferedReader

// variables
private const val INF = Int.MAX_VALUE / 16
private var N = 0
private lateinit var deque: Deque<String>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_30090\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(DFS("", 0))
    return sb.toString()
} // End of solve()

private fun DFS(current: String, depth: Int): Int {
    if (depth == N) {
        return current.length
    }

    var minLen = INF
    for (i in depth until N) {
        val temp = deque.pollFirst()
        val matchLen = check(current, temp)
        minLen = minLen.coerceAtMost(DFS(current + temp.substring(matchLen), depth + 1))
        deque.offerLast(temp)
    }

    return minLen
} // End of DFS()

private fun check(a: String, b: String): Int {
    val aLen = a.length
    val bLen = b.length

    val min = aLen.coerceAtMost(bLen)
    for (i in min downTo 1) {
        if (a.substring(aLen - i) == b.substring(0, i)) {
            // substring이 모두 일치하면 일치하는 최대 길이 return
            return i
        }
    }

    return 0
} // End of check()

private fun input() {
    N = br.readLine().toInt()
    deque = LinkedList()
    repeat(N) {
        deque.offer(br.readLine())
    }
} // End of input()
