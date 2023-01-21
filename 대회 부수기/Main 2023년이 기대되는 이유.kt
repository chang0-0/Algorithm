package `대회 부수기`

/*
    값을 분리하지 않았을 때, 최대값 -> N의 값

    값이 1 OR 0으로만 이루어져 있다면, 답은 무수히 많다가 됨.
    1 & 10의 배수

    각 테스트 케이스에 대해, m의 개수를 출력하라
    만약 그러한 m이 무수히 많다면 Hello를 출력한다.
 */

import java.util.*
import java.io.*

private var N = 0

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\대회 부수기\\res\\a.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val T = br.readLine().toInt()
    for (i in 0 until T) {
        N = br.readLine().toInt()

        if (N == 1) {
            sb.append("Hello, BOJ 2023!").append('\n')
            continue
        } else if (N % 10 == 0) {
            sb.append("Hello, BOJ 2023!").append('\n')
            continue
        }

        sb.append(1).append('\n')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main
