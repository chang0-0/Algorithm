package `정수론 & 조합론 부수기`

import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\정수론 & 조합론 부수기\\res\\25342.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var T = br.readLine().toInt()
    while (T-- > 0) {
        val N = br.readLine().toLong()

        val tmp1: Long = LCM(LCM(N - 3, N - 2), N - 1)
        val tmp2: Long = LCM(LCM(N - 2, N - 1), N)

        if (N % 2 == 0L) {
            println(
                Math.max(Math.max(tmp1, tmp2), LCM(LCM(N - 3, N - 1), N))
            )
        } else {
            println(
                Math.max(Math.max(tmp1, tmp2), LCM(LCM(N - 3, N - 2), N))
            )
        }
    }
} // End of main

private fun GCD(a: Long, b: Long): Long {
    if (a % b == 0L) return b
    return GCD(b, a % b)
} // End of GCD

private fun LCM(a: Long, b: Long): Long {
    return (a * b) / GCD(a, b)
} // End of LCM