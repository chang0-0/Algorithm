import java.util.*
import java.io.*

/*
각 도시별로 홍보하는데 드는 비용과, 그 떄 몇 명의 호텔 고객이 늘어나는지에 대한 정보가 있다.
호텔 고객을 적어도 C명 늘리기 위해 형택이가 투자해야 하는 돈의 최솟값을 작성하라
 */

private var N = 0
private var C = 0
private val arr = Array(21) { Customer() }
private val memo = IntArray(100_001)
// memo[비용] = 최대 고객
// C를 처음 넘는 비용이 정답.

private data class Customer(var cost: Int = 0, var customers: Int = 0)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\배낭 문제 부수기\\res\\1106.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    C = st.nextToken().toInt()
    N = st.nextToken().toInt()

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        arr[i].cost = st.nextToken().toInt()
        arr[i].customers = st.nextToken().toInt()
    }

    println(DP(C, N))
} // End of main

private fun DP(customer: Int, cityNum: Int): Int {

    var min = 100 * 1000

    if (customer <= 0) {
        return 0
    } else if (memo[customer] > 0) {
        return memo[customer]
    } else {
        for (i in 0 until cityNum) {
            val cost = DP(customer - arr[i].customers, cityNum) + arr[i].cost
            if (cost < min) {
                min = cost
            }
        }

        memo[customer] = min
        return min
    }

} // End of DP
