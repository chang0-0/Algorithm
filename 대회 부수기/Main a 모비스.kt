package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

fun main() {
    val path =
        "C:\\Users\\Samsung\\Desktop\\자바 알고리즘 워크스페이스\\KotlinAlgo\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val chArr = BooleanArray(26)

    val inputArr = br.readLine().toCharArray()
    inputArr.forEach {
        chArr[it.toInt() - 65] = true
    }

    if (chArr[12] && chArr[14] && chArr[1] && chArr[8] && chArr[18]) {
        sb.append("YES")
    } else {
        sb.append("NO")
    }

    bw.write(sb.toString())
    bw.close()
} // End of main