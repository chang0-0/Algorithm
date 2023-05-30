package 문자열_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\코틀린 알고리즘\\Kotlin_Algo\\src\\main\\kotlin\\문자열_부수기\\res\\28135.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val N = br.readLine().toInt()

    var cnt = 0
    for (i in 1..N) {
        cnt++

        val str = (i - 1).toString()
        if (str.contains("50")) cnt++
    }
    sb.append(cnt)

    bw.write(sb.toString())
    bw.close()
} // End of main