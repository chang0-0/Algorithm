package BOJ_3020

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var N = 0
private var H = 0
private var ansCnt = Int.MAX_VALUE
private var ansHeight = 0

private lateinit var arr: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_3020\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    sb = StringBuilder()

    input()

    solve()

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {
    println(arr.contentToString())

    // 가장 적게 부수고 지나갈 수 있는 높이를 구하자.
    // 결국에 이분탐색을 통해서 높이를 구하는게 문제임
    binarySearch(0, H)

    sb.append(ansCnt).append(' ').append(ansHeight)
} // End of solve

private fun binarySearch(low: Int, high: Int): Int {
    if (low > high) {
        return -1
    }

    val mid = (low + high) / 2
    val count = check(mid)


    // 기존의 정답 보다 새로운 벽 부순 개수가 더 적을 경우
    // 갱신, 높이 더 높여보기
    if (count < ansCnt) {
        ansCnt = count
        ansHeight = mid

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

private fun check(height: Int): Int {
    // 파괴해야하는 장애물의 개수 파악
    var count = 0
    arr.forEachIndexed { index, it ->
        if (index % 2 == 0) {
            if (it >= height) count++
        } else {
            println(it)
        }
    }

    return count
} // End of check

private fun input() {
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    H = st.nextToken().toInt()

    arr = IntArray(N)

    // 종유석, 석순이 번갈아가면서 등장한다.
    for (i in 0 until N) {
        arr[i] = br.readLine().toInt()
    }
} // End of input