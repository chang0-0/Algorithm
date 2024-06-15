package BOJ_1239

import java.io.BufferedReader
import java.io.File
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/1239
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var max = 0
private lateinit var arr: IntArray
private lateinit var comb: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1239\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // 50이라는 값이 있으면 무조건 1,
    // 51이상의 값이 있으면 불가능
    arr.forEach {
        if (it >= 51) {
            sb.append(0)
            return sb.toString()
        } else if (it == 50) {
            sb.append(1)
            return sb.toString()
        }
    }

    /*
       1 1 48 1 1 48 수열에서
       연결해서 50을 만들 수 있는 가장 많은 방법
       1 1 48
       1 48 1
       48 1 1

       총 3가지가 나온다.
     */

    max = 0
    isVisited = BooleanArray(N)
    comb = IntArray(N)
    DFS(0)

    sb.append(max)
    return sb.toString()
} // End of solve()

private fun DFS(idx: Int) {
    if (idx == N) {
        twoPointer(0, 1, comb[0], 0)
        return
    }

    for (i in 0 until N) {
        if (isVisited[i]) continue
        isVisited[i] = true
        comb[idx] = arr[i]
        DFS(idx + 1)
        isVisited[i] = false
    }
} // End of DFS()

private fun twoPointer(left: Int, right: Int, sum: Int, count: Int): Int {
    if (right == N) {
        max = Math.max(max, count)
        return max
    }

    var count = count
    var sum = sum
    var left = left
    var right = right

    if (sum == 50) {
        count++
        sum += comb[right++]
        sum -= comb[left++]
    } else if (sum > 50) {
        sum -= comb[left++]
    } else {
        sum += comb[right++]
    }

    return twoPointer(left, right, sum, count)
} // End of twoPointer()

private fun input() {
    N = br.readLine().toInt()

    val st = StringTokenizer(br.readLine())
    arr = IntArray(N) { idx ->
        st.nextToken().toInt()
    }
} // End of input()
