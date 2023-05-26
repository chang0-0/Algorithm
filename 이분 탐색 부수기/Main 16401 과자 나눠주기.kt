package 이분탐색_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

private var N = 0
private var M = 0
private lateinit var arr: IntArray

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\코틀린 알고리즘\\Kotlin_Algo\\src\\main\\kotlin\\이분탐색_부수기\\res\\16401.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    var st = StringTokenizer(br.readLine())
    M = st.nextToken().toInt() // 조카의 수
    N = st.nextToken().toInt() // 과자의 수
    arr = IntArray(N)

    var max = Int.MIN_VALUE
    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        arr[i] = st.nextToken().toInt()
        max = Math.max(max, arr[i])
    }

    var result = binarySearch(1, max)
    if(result == -1) {
        result = 0
    }

    sb.append(result)
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun binarySearch(low: Int, high: Int): Int {
    if (low > high) {
        return -1
    }

    val mid = (low + high) / 2
    val cnt = countCheck(mid)
    // 과자를 나눠서 나온 갯수가 조카의 수 보다 많을 때
    // 갯수를 줄여야 하기 때문에 mid값이 더 높아져야 함
    if (cnt >= M) {
        val temp = binarySearch(mid + 1, high)
        if (temp == -1) {
            return mid
        } else {
            return temp
        }
    } else {
        return binarySearch(low, mid - 1)
    }
} // End of binarySearch

private fun countCheck(mid: Int): Int {
    var count = 0
    arr.forEach {
        count += it / mid
    }
    return count
} // End of check
