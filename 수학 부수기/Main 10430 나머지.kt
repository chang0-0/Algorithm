package 수학_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val path =
        "C:\\Users\\Samsung\\Desktop\\자바 알고리즘 워크스페이스\\KotlinAlgo\\KotlinAlgo\\src\\main\\kotlin\\수학_부수기\\res\\10430.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val st = StringTokenizer(br.readLine())
    val A = st.nextToken().toInt()
    val B = st.nextToken().toInt()
    val C = st.nextToken().toInt()

    sb.append((A + B) % C).append('\n')
    sb.append(((A % C) + (B % C)) % C).append('\n')
    sb.append((A * B) % C).append('\n')
    sb.append(((A % C) * (B % C)) % C).append('\n')


    bw.write(sb.toString())
    bw.close()
} // End of main