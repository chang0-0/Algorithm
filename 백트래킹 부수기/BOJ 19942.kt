package BOJ_19942

import java.io.File
import java.util.*

// https://www.acmicpc.net/problem/19942
// input
private var br = System.`in`.bufferedReader()


// variables
private var N = 0
private const val M = 5
private var ans = 0
private lateinit var board: Array<IntArray>
private lateinit var minArr: IntArray
private lateinit var comb: ArrayDeque<Int>
private lateinit var ansList: MutableList<Int>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_19942\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    DFS(0, 0, 0)

    if (ans == Int.MAX_VALUE) {
        sb.append(-1)
    } else {
        sb.append(ans).append('\n')
        ansList.forEach {
            sb.append(it).append(' ')
        }
    }

    return sb.toString()
} // End of solve()

private fun DFS(idx: Int, depth: Int, cost: Int) {
    if (cost >= ans) return

    if (check()) {
        ans = Math.min(ans, cost)
        ansList = mutableListOf()
        comb.forEach {
            ansList.add(it + 1)
        }
    }
    if (depth == N) return


    for (i in idx until N) {
        comb.addLast(i)
        DFS(i + 1, depth + 1, cost + board[i][4])
        comb.removeLast()
    }
} // End of DFS()

private fun check(): Boolean {
    var arr = IntArray(4)

    comb.forEach { it ->
        for (i in 0 until 4) {
            arr[i] += board[it][i]
        }
    }

    for (i in 0 until 4) {
        if (arr[i] < minArr[i]) return false
    }

    return true
} // End of check()

private fun input() {
    N = br.readLine().toInt()

    var st = StringTokenizer(br.readLine())
    minArr = IntArray(4) {
        st.nextToken().toInt()
    }

    board = Array(N) {
        st = StringTokenizer(br.readLine())
        IntArray(M) {
            st.nextToken().toInt()
        }
    }

    ans = Int.MAX_VALUE
    comb = ArrayDeque()
} // End of input()
