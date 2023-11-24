package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter


// input
private lateinit var br: BufferedReader
private const val KOREA = "KOREA"

// variables
private var S = ""

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

    var seqIdx = 0
    var count = 0

    for (i in 0 until S.length) {
        if (S[i] == KOREA[seqIdx]) {
            seqIdx++

            if (seqIdx == KOREA.length) {
                count++
                seqIdx = 0
            }
        }
    }

    sb.append(count)
    return sb.toString()
} // End of solve()

private fun input() {
    S = br.readLine()
} // End of input()
