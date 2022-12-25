package `정수론 & 조합론 부수기`

import java.util.*
import java.io.*

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\정수론 & 조합론 부수기\\res\\2609.txt"
    val br = BufferedReader(File(path).bufferedReader())

    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toLong()
    val M = st.nextToken().toLong()

    val gcd = GCD(N, M)
    val lcm = LCM(N, M, gcd)
    println(gcd)
    println(lcm)
} // End of main

private fun GCD(a: Long, b: Long): Long {
    if (a % b == 0L) return b
    return GCD(b, a % b)
} // End of GCD

private fun LCM(N: Long, M: Long, gcd: Long): Long {
    return (N * M) / gcd
} // End of LCM