package BOJ_30804

import java.io.BufferedReader
import java.io.File

// https://www.acmicpc.net/problem/30804
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var max = 0
private lateinit var arr: IntArray
private lateinit var map: HashMap<Int, Int>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_30804\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    twoPointer(0, 0, 0, 0, true)

    sb.append(max)
    return sb.toString()
} // End of solve()

private fun twoPointer(left: Int, right: Int, kind: Int, sum: Int, rightUp: Boolean) {
    var left = left
    var right = right
    var kind = kind
    var sum = sum

    if (right == N) {
        max = Math.max(max, sum)
        return
    }

    if (rightUp && map[arr[right]] == null) {
        map[arr[right]] = 1
        kind++
        sum++
    } else if (rightUp) {
        map[arr[right]] = map[arr[right]]!! + 1
        sum++
    }

    if (kind == 3) {
        // 과일의 종류가 3개 이상이 될 경우
        // 전체 탕후루 개수에서 마지막 과일 종류의 개수를 뺀다.
        val num = arr[left]
        map[num] = map[num]!! - 1
        if (map[num] == 0) {
            map.remove(num)
            kind--
        }
        sum--
        left++
        // 과일의 종류가 2개가 될 때까지 왼쪽만 증가
        twoPointer(left, right, kind, sum, false)
    } else {
        right++
        // 과일의 종류가 2개일 경우 오른쪽 증가,
        // 오른쪽이 증가될때는 rightUp을 통해서 boolean 값으로 오른쪽이 증가되었음을 표시
        twoPointer(left, right, kind, sum, true)
    }
} // End of twoPointer()

private fun input() {
    N = br.readLine().toInt()

    max = 1
    arr = IntArray(N)
    map = HashMap()
    val s = br.readLine()
    for (i in 0 until N) {
        arr[i] = s[(i shl 1)] - '0'
    }
} // End of input()
