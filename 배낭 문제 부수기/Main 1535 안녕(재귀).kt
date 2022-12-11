import java.util.*
import java.io.*

private var N = 0
private val health = IntArray(21)
private val pleasure = IntArray(21)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\배낭 문제 부수기\\res\\1535.txt"
    val br = BufferedReader(File(path).bufferedReader())

    N = br.readLine().toInt()

    var st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        health[i] = st.nextToken().toInt()
    }

    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        pleasure[i] = st.nextToken().toInt()
    }

    println(solve(0, 0, 0))
} // End of main

private fun solve(index: Int, nowHelth: Int, total: Int): Int {
    if (nowHelth >= 100) {
        return 0
    } else if (index == N) {
        return total
    }

    var ans = 0

    // 인사를 했을 때,
    ans = Math.max(ans, solve(index + 1, nowHelth + health[index], total + pleasure[index]))

    // 인사를 안 했을 때,
    ans = Math.max(ans, solve(index + 1, nowHelth, total))

    return ans
} // End of solve