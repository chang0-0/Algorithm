package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import kotlin.math.ceil

// input
private lateinit var br: BufferedReader

// variables
private var N = 0


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\a.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    N = br.readLine().toInt()
    while (N-- > 0) {
        if (check(br.readLine())) {
            sb.append(1).append('\n')
        } else {
            sb.append(0).append('\n')
        }
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun check(str: String): Boolean {
    val len = str.length
    var third: Int = ceil(len.toDouble() / 3.0).toInt()

    var S = str.substring(0, third)
    var rev = S.reversed()
    var tail = S.substring(1, S.length)
    var tailRev = rev.substring(1, rev.length)

    if (str == S + rev + S) {
        return true
    } else if (str == S + tailRev + S) {
        return true
    } else if (str == S + rev + tail) {
        return true
    } else if (str == S + tailRev + tail) {
        return true
    }



    return false
} // End of check