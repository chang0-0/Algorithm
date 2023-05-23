package 이분탐색_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
   mid는 막걸리를 K명 인원에게 분배할 수 있는 최대양이 된다.

   N개의 주전자에 mid만큼 분배해서 남는 양
   즉, 하나의 주전자에서 mid미만의 양이 남을 경우 버린다.
 */

private var N = 0
private var K = 0
private lateinit var potArr: LongArray
private var result = Long.MIN_VALUE

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\코틀린 알고리즘\\Kotlin_Algo\\src\\main\\kotlin\\이분탐색_부수기\\res\\13702.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 주전자의 개수
    K = st.nextToken().toInt() // 은상이를 포함한 친구들의 수
    potArr = LongArray(N)

    for (i in 0 until N) {
        potArr[i] = br.readLine().toLong()
    }
    potArr.sort()

    binarySearch(1, potArr[N - 1])

    sb.append(result)
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun binarySearch(low: Long, high: Long): Long {
    if (low > high) {
        return -1
    }

    val mid : Long = (low + high) / 2
    val cnt = check(mid)

    if (K <= cnt) {
        result = Math.max(result, mid)
        val temp = binarySearch(mid + 1, high)
        if (temp == -1L) {
            return mid
        } else {
            return temp
        }
    } else {
        return binarySearch(low, mid - 1)
    }
} // End of binarySearch

private fun check(mid: Long): Long {
    var cnt = 0L
    potArr.forEach { pot ->
        cnt += pot / mid
    }
    return cnt
} // End of check
