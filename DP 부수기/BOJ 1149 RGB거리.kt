package BOJ_1149

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

/*
    규칙 1번 집의 색은 2번 집과 같지 않아야 한다.
    N번 집의 색은 N - 1번 집의 색과 같지 않아야 한다.
    i번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

    쉽게 얘기해서 색깔이 번갈아서 나와야됨.
    이전에 R이 나오면 다음은 G, B가 될 수 있고,
    G가 나왔으면 다음은 R, B가 나올 수 있다.
 */

// https://www.acmicpc.net/problem/1149
// input
private lateinit var br: BufferedReader

// variables
private var N = 0

private lateinit var memo: Array<IntArray> // i번쨰 집을 j색으로 칠할 때의 최소비용을 저장
private lateinit var red: IntArray
private lateinit var green: IntArray
private lateinit var blue: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1149\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // 초기 설정 -> 시작은 첫 번째 집 색깔 별로 칠한 값이 가장 낮은 값으로 기본 설정됨
    memo[1][0] = red[1]
    memo[1][1] = green[1]
    memo[1][2] = blue[1]
    DP()

    sb.append(min(memo[N][0], min(memo[N][1], memo[N][2])))
    return sb.toString()
} // End of solve()

private fun DP() {
    for (i in 2..N) {
        println("========================================")
        memo.forEach {
            println(it.contentToString())
        }

        memo[i][0] = min(memo[i - 1][1], memo[i - 1][2]) + red[i]
        // 빨간색으로 칠했을 떄 최소 비용 구하기,
        // 빨간색 최소 비용을 구하려면 이전에 집이 빨간색이 아닌 집 중에 선택해야 한다.
        // 초록색과 파란색으로 칠해진 집 중에 최소값을 선택한다

        memo[i][1] = min(memo[i - 1][0], memo[i - 1][2]) + green[i] // 초록색으로 칠했을 때 최소 비용
        memo[i][2] = min(memo[i - 1][0], memo[i - 1][1]) + blue[i] // 파란색으로 칠했을 때 최소 비용
    }

    println("========================================")
    memo.forEach {
        println(it.contentToString())
    }
} // End of DP()

private fun input() {
    N = br.readLine().toInt()

    memo = Array(N + 1) { IntArray(3) }
    red = IntArray(N + 1)
    green = IntArray(N + 1)
    blue = IntArray(N + 1)

    for (i in 1..N) {
        StringTokenizer(br.readLine()).run {
            red[i] = nextToken().toInt()
            green[i] = nextToken().toInt()
            blue[i] = nextToken().toInt()
        }
    }
} // End of input()
