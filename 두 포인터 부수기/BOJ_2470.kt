package BOJ_2470

import java.io.*
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/2470
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private lateinit var arr: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2470\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    arr.sort()
    var left = 0
    var right = N - 1
    var minDiff = Int.MAX_VALUE
    var baseLeft = 0
    var baseRight = 0

    while (left < right) {
        val sum = arr[left] + arr[right]
        val diff = Math.abs(sum)

        if (diff < minDiff) {
            minDiff = diff
            baseLeft = arr[left]
            baseRight = arr[right]
        }

        if (sum < 0) {
            left++
        } else if (sum > 0) {
            right--
        } else {
            baseLeft = arr[left]
            baseRight = arr[right]
            break
        }
    }

    sb.append(baseLeft).append(' ').append(baseRight)
    return sb.toString()
} // End of solve()

private fun input() {
    N = br.readLine().toInt()

    var st = StringTokenizer(br.readLine())
    arr = IntArray(N) {
        st.nextToken().toInt()
    }
} // End of input()
