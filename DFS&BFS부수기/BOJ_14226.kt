package BOJ_14226

import java.io.File
import java.util.LinkedList
import java.util.Queue

// https://www.acmicpc.net/problem/14226
// input
private var br = System.`in`.bufferedReader()

// variables
private var S = 0
private const val MAX = 1001

private data class Emoticon(val time: Int, val clipBoard: Int, val count: Int)

private const val INF = -1

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14226\\res.txt"
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
    val que: Queue<Emoticon> = LinkedList()
    val memo = Array(MAX) { IntArray(MAX) { INF } } // memo[clipBoard][count] : 해당 상태에 도달하기 위한 최소 시간

    que.offer(Emoticon(0, 0, 1))
    memo[0][1] = 0

    // MAX 벗어날 수 있음
    while (que.isNotEmpty()) {
        val cur = que.poll()

        if (cur.count == S) return cur.time

        // 클립보드 덮어쓰기
        if (memo[cur.count][cur.count] == INF) {
            memo[cur.count][cur.count] = cur.count + 1
            que.offer(Emoticon(cur.time + 1, cur.count, cur.count))
        }

        // 클립보드 내용 붙여넣기
        if (cur.clipBoard > 0 && cur.count + cur.clipBoard < MAX && memo[cur.clipBoard][cur.count + cur.clipBoard] == INF) {
            memo[cur.clipBoard][cur.count + cur.clipBoard] = cur.time + 1
            que.offer(Emoticon(cur.time + 1, cur.clipBoard, cur.count + cur.clipBoard))
        }

        // 삭제
        if (cur.count > 0 && memo[cur.clipBoard][cur.count - 1] == INF) {
            memo[cur.clipBoard][cur.count - 1] = cur.time + 1
            que.offer(Emoticon(cur.time + 1, cur.clipBoard, cur.count - 1))
        }
    }

    return -1
} // End of BFS()

private fun input() {
    S = br.readLine().toInt()
} // End of input()
