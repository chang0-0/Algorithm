package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter


// input
private lateinit var br: BufferedReader

// variables
private var N = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\b.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    if (N == 2 || (N % 2 == 0 && N % 6 != 0)) {
        sb.append(-1)
        return sb.toString()
    }

    var positions = IntArray(N)
    for (i in 0 until N) {
        positions[i] = (2 * i + 1) % N
    }

    positions.forEach {
        sb.append(it).append(' ')
    }

    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()
} // End of input()
