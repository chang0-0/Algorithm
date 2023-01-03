package `대회 부수기`

import java.util.*
import java.io.*

private const val MOD = 1_000_000_007
private var N = 0
private val counting = IntArray(10)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\대회 부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())

    N = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    // 중복되는 카드가 있는지. 파악
    for (i in 0 until N) {
        counting[st.nextToken().toInt()]++
    }

    /*
        ⭐ 각 원소별 등장 횟수 + 1 을 모두 곱한 값 - 1

        ⭐ 각 원소가 하나씩 골라지는 경우에서 모든 원소가 안 골라지는 경우를 뺀 거에요

        ⭐ 같은 숫자 카드가 여러장 있을 때, 아무것도 안뒤집어 보거나
        한 번만 뒤집어봐야 하니까 경우의 수를 생각해 보시면
        1 + 개수가 됩니다.
        1장씩 있는 애들은 뽑던지 말던지라서 * 2 하면 됩니다.
        근데 이렇게 하면 모두 안뽑는 케이스가 있어서 마지막에 -1 해줍니다

     */

    println(counting.contentToString())

    var result = 1
    for (i in 1..N) {
        if (counting[i] > 1) {
            // 중복되는 값이 있는 경우,
            result = (result * (1 + counting[i])) % MOD
        } else {
            // 중복이 없는 경우
            result = (result * 2) % MOD
        }
    }

    println(result - 1)
} // End of main
