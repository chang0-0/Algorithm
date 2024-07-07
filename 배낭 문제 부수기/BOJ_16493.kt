package BOJ_14536

import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/16493
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0

private lateinit var memo: Array<IntArray>
private lateinit var arr: Array<IntArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14536\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()
    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // N일 동안 읽을 수 있는 최대페이지를 구하자
    sb.append(topDown(N, M))
    return sb.toString()
} // End of solve()

private fun topDown(n: Int, m: Int): Int {
    if (n == 0 || m == 0) return 0

    if (memo[n][m] != -1) return memo[n][m]

    // 최대 페이지 수 구하기
    // 해당 챕터 읽기, 해당 챕터는 읽지 않기
    if (n - arr[m - 1][0] >= 0) {
        memo[n][m] = Math.max(memo[n][m], Math.max(topDown(n, m - 1), topDown(n - arr[m - 1][0], m - 1) + arr[m - 1][1]))
    } else {
        memo[n][m] = topDown(n, m - 1)
    }

    return memo[n][m]
} // End of topDown()

private fun input() {
    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    memo = Array(N + 1) {
        IntArray(M + 1) { -1 }
    }

    arr = Array(M) {
        st = StringTokenizer(br.readLine())
        IntArray(2) {
            st.nextToken().toInt()
        }
    }
} // End of input()
