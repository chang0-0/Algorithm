import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

/*
    가장 끝에 0의 개수가 M개인 N! 중에서 가장 작은 N을 출력한다.
    그러한 N이 없는 경우에는 -1을 출력한다.

    정수론과 이분탐색의 문제.

    탐색 범위가 넓어서 시간이 빡빡하기 때문에 탐색에서는 이분 탐색을 활용해야 한다.
    하지만, 이 문제의 핵심은 0의 개수를 어떻게 효율적으로 빠르게 찾을 것인가 가 핵심 포인트인 문제이다.

    증명 //
    N!의 오른쪽 0의 개수 === N!의 인수 중 10의 배수의 개수
    === 2 * 5의 배수의 개수
    === 소인수 2와 5의 배수의 개수
    === 소인수 5의 배수의 개수

    즉, N!의 0의 개수 === 1 ~ N! 5의 배수의 개수(=== 소인수 5의 배수의 개수)
 */


// input
private lateinit var br: BufferedReader

// variables
private var M = 0
private var ans: Long = Long.MAX_VALUE

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\이분_탐색_부수기\\11687.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    // input
    input()

    // binarySearch
    binarySearch(1, (M * 5).toLong())

    if (ans == Long.MAX_VALUE)
        sb.append(-1)
    else {
        sb.append(ans)
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun binarySearch(low: Long, high: Long): Long {
    if (low > high) {
        return -1L
    }

    val mid = (low + high) / 2
    val result = check(mid)

    if (result >= M) {
        // 기존의 정답 보다 새로운 mid의 값이 더 클 때, (mid를 낮춰야 할 때)
        if(result.toInt() == M) {
            ans = Math.min(ans, mid)
        }

        val temp = binarySearch(low, mid - 1)
        return if (temp == -1L) {
            mid
        } else {
            temp
        }
    } else {
        return binarySearch(mid + 1, high)
    }
} // End of binarySearch

// 0의 개수를 확인하는 함수
private fun check(mid: Long): Long {
    var zeroCount = 0L
    var tempMid = mid

    while (tempMid >= 5) {
        zeroCount += (tempMid / 5)
        tempMid /= 5
    }
    return zeroCount
} // End of check

private fun input() {
    M = br.readLine().toInt()
} // End of input
