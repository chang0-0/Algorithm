import java.util.*
import java.io.*
import java.lang.StringBuilder

/*
    다이나믹 롤러를 개발 했다.
    통로는 1 * N 길이의 일자 형태를 가지고 있고, 통로의 바닥은 1 * 1 타일로 가득 차 있다. 각 타일은 잉크지수와 점도지수를 가지고 있다.

    두 번째 줄에 잉크지수가 주어지고, 세 번쨰 줄에 점도지수가 주어진다.
 */

private var N = 0
private var inkArr = IntArray(50_001)
private var viscoArr = IntArray(50_001)
private var result = IntArray(50_001)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\이분 탐색 부수기\\res\\17393.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    N = br.readLine().toInt()

    var st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        inkArr[i] = st.nextToken().toInt()
    }

    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        viscoArr[i] = st.nextToken().toInt()
    }

    for(i in 0 until N) {
        sb.append(result[i]).append(' ')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun binarySearch(start: Int, end: Int) {


} // End of binarySearch