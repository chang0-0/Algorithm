package `대회 부수기`

import java.util.*
import java.io.*

private var N = 0
private var K = 0
private var X = 0
private val memo = Array(82) { BooleanArray(19_901) }

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\대회 부수기\\res\\26607.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 사람의 수
    K = st.nextToken().toInt() // 뽑을 인원
    X = st.nextToken().toInt() // 수치의 합

    memo[0][0] = true
    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        val power = st.nextToken().toInt()
        val intell = st.nextToken().toInt()

        for (j in K downTo 1) {
            for (k in power..X * K) {
                memo[j][k] = memo[j][k] or memo[j - 1][k - power]
            }
        }
    }

    var ans = 0
    for (i in 0..X * K) {
        if (memo[K][i]) {
            ans = Math.max(ans, i * (X * K - i))
        }
    }

    println(ans)
} // End of main
