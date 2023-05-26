package 기하학_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

fun main() {
    val path =
        "C:\\Users\\Samsung\\Desktop\\자바 알고리즘 워크스페이스\\KotlinAlgo\\KotlinAlgo\\src\\main\\kotlin\\기하학_부수기\\res\\27323.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    sb.append(br.readLine().toInt() * br.readLine().toInt())

    bw.write(sb.toString())
    bw.close()
} // End of main