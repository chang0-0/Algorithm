package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import kotlin.math.pow

//
// input
private lateinit var br: BufferedReader

// variables
private var N = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\a.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var sum = 1
    var sum3 = 1.0
    for (i in 2..N) {
        sum += i
        sum3 += i.toDouble().pow(3.0)
    }

    sb.append(sum).append('\n').append(sum.toDouble().pow(2.0).toInt()).append('\n').append(sum3.toInt())

    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
} // End of input()
