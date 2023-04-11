package 프로그래머스

/*
    a : 콜라를 받기 위해 마트에 주어야하는 병 수
    b : 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b,
    n : 상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어진다.

    상빈이가 받을 수 있는 콜라의 병 수를 return 하는 프로그램
 */

fun main() {
    val a = 3
    val b = 1
    val n = 20
    println(solution(a, b, n))
} // End of main

private fun solution(a: Int, b: Int, n: Int): Int {
    var answer = 0

    var total = n
    while (total >= a) {
        val temp = (total / a) * b
        val mod = total % a

        total = temp + mod
        answer += temp
    }

    return answer
} // End of solution