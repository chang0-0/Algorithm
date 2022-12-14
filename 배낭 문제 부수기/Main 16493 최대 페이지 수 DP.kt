import java.util.*
import java.io.*

private var N = 0
private var M = 0
private var result = 0
private val memo = Array(22) { Array(302) { 0 } }
private val books = Array(22) { Book2() }

private data class Book2(var day: Int = 0, var page: Int = 0)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\배낭 문제 부수기\\res\\16493.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 남은 기간
    M = st.nextToken().toInt() // 챕터 수

    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        books[i].day = st.nextToken().toInt()
        books[i].page = st.nextToken().toInt()
    }

    DP()
    println(result)
} // End of main

private fun DP() {
    for (i in 0..M) {
        for (j in N downTo 0) {
            if (j - books[i].day >= 0) {
                memo[i + 1][j] = Math.max(memo[i][j], memo[i][j - books[i].day] + books[i].page)
            } else {
                memo[i + 1][j] = memo[i][j]
            }

            result = Math.max(result, memo[i][j])
        }
    }
} // End of DP
