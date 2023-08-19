package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.math.BigInteger
import kotlin.math.pow


// input
private lateinit var br: BufferedReader

// variables
fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\a.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    solve()
} // End of main()

private fun solve() {
    val kStr = br.readLine()!!

    val decimalPart = kStr.substringAfter(".")
    var numerator: Long
    var denominator: Long

    if (decimalPart.all { it == decimalPart[0] }) {
        // 모든 숫자가 동일한 경우 (예: 0.33333)
        numerator = decimalPart[0].toString().toLong()
        denominator = "9".repeat(decimalPart.length).toLong()
    } else {
        numerator = decimalPart.toLong()
        denominator = 10.0.pow(decimalPart.length).toLong()
    }

    val gcd = gcd(numerator, denominator)

    val reducedNumerator = numerator / gcd
    val reducedDenominator = denominator / gcd

    println("YES")
    println("$reducedNumerator $reducedDenominator")
} // End of solve()

fun gcd(a: Long, b: Long): Long {
    if (b == 0L) return a
    return gcd(b, a % b)
}
