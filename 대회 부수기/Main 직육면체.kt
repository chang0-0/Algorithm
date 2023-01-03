package `대회 부수기`

/*
    P는 항상 소수이다.
    직육면체를 채울 수 있으면 1을 출력, 없을 경우 0을 출력한다.
 */

import java.util.*
import java.io.*
import java.lang.StringBuilder

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\대회 부수기\\res\\d.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val T = br.readLine().toInt()
    for (i in 0 until T) {
        val st = StringTokenizer(br.readLine())
        var sameCount = 0

        val A = st.nextToken().toInt()
        val B = st.nextToken().toInt()
        val C = st.nextToken().toInt()
        val P = st.nextToken().toInt() // 항상 소수이다. (소수라서 문제 풀기 편했음)

        if (A % P == 0) sameCount++

        if (B % P == 0) sameCount++

        if (C % P == 0) sameCount++

        // P의 배수가 2번 이상나올 경우 직육면체를 채울 수 있다고 판단.
        if (sameCount >= 2) {
            sb.append(1).append('\n')
        } else {
            sb.append(0).append('\n')
        }
    }


    bw.write(sb.toString())
    bw.close()
} // End of main