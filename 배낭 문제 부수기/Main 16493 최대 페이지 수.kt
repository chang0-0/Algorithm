import java.util.*
import java.io.*

private var N = 0
private var M = 0
private lateinit var books: Array<Book>

data class Book(
    var day: Int = 0,
    var page: Int = 0
) // End of Book class

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\배낭 문제 부수기\\res\\16493.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 남은 기간
    M = st.nextToken().toInt() // 챕터 수
    books = Array(M) { Book() }

    // 남은 N일 동안, 책의 각 챕터 당 그 챕터를 전부 읽는데 소요되는 일 수와 페이지 수가 주어질 때, N일간 읽을 수 있는 최대 페이지 수를 구하시오
    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        books[i].day = st.nextToken().toInt()
        books[i].page = st.nextToken().toInt()
    }

    println(DFS(0, 0, 0))
} // End of main

// 읽는다와 안읽는다의 가지로 분리하기.
private fun DFS(index: Int, day: Int, totalPages: Int): Int {
    if (index == M && day <= N) {
        return totalPages
    } else if (day > N) {
        // 연체 될 경우 무조건 return
        return 0
    }

    var ans = 0
    // 책을 읽었을 경우
    ans = Math.max(ans, DFS(index + 1, day + books[index].day, totalPages + books[index].page))

    // 책을 읽지 않았을 경우
    ans = Math.max(ans, DFS(index + 1, day, totalPages))

    return ans
} // End of DFS