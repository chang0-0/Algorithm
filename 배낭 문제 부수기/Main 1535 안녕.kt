import java.util.*
import java.io.*

// 1번 부터 N번까지 세준이가 i번 사람에게 인사를 하면 L[i] 만큼의 체력을 잃고, J[i] 만큼의 기쁨을 얻는다.
// 세준이는 각각의 사람에게 최대 1번만 말할 수 있다.
// 세준이가 얻을 수 있는 최대의 기쁨을 계산
// 세준이의 체력은 100이고 기쁨은 0으로 시작

private var N = 0
private val L = IntArray(21)
private val J = IntArray(21)
private val memo = Array(21) { Array(101) { 0 } }

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\배낭 문제 부수기\\res\\1535.txt"
    val br = BufferedReader(File(path).bufferedReader())

    N = br.readLine().toInt()

    // 각각의 사람에게 인사를 할 떄, 잃는 체력이 1번 사람부터 순서대로 들어오고, 셋째 줄에는 각각의 사람에게 인사를 할 때,
    // 얻는 기쁨이 1번 사람부터 순서대로 들어온다. 체력과 기쁨은 100보다 작거나 같은 자연수 또는 0이다.
    var st = StringTokenizer(br.readLine())
    for (i in 1..N) {
        L[i] = st.nextToken().toInt()
    }

    st = StringTokenizer(br.readLine())
    for (i in 1..N) {
        J[i] = st.nextToken().toInt()
    }

    for (i in 1..N) {
        for (j in 1..99) {
            if (L[i] <= j) {
                // i한테 인사하는 경우 중 최대값
                memo[i][j] = Math.max(memo[i - 1][j], memo[i - 1][j - L[i]] + J[i])
            } else {
                memo[i][j] = memo[i - 1][j]
            }
        }
    }

    println(memo[N][99])
} // End of main