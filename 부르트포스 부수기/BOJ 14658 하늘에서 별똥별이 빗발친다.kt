package BOJ_14658

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.max

/*
    최대한 많은 별똥별을 튕겨내도록 배치
    트램펄린으로 최대한 많은 별똥별을 튕겨낼 때, 지구에 부딪히는 별똥별의 개수를 구한다.
 */


// https://www.acmicpc.net/problem/14658
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0
private var K = 0
private var L = 0
private var ans = Int.MIN_VALUE

private lateinit var xSet: HashSet<Int>
private lateinit var ySet: HashSet<Int>

private data class Coordinate(var x: Int, var y: Int)
private lateinit var dropArr: Array<Coordinate>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_14658\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    find()

    sb.append(K - ans)
    return sb.toString()
} // End of solve()

private fun find() {
    xSet.forEach { x ->
        val endX = x + L
        ySet.forEach { y ->
            val endY = y + L
            var count = 0
            dropArr.forEach {
                if (it.x in x..endX) {
                    if (it.y in y..endY) {
                        count++
                    }
                }

                ans = max(ans, count)
            }
        }
    }
} // End of find()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt() // 별똥별이 떨어지는 가로길이
        M = nextToken().toInt() // 세로길이
        L = nextToken().toInt() // 트램펄린의 한변의 길이
        K = nextToken().toInt() // 별똥별의 수
    }

    dropArr = Array(K) { Coordinate(0, 0) }
    xSet = HashSet()
    ySet = HashSet()

    // 떨어지는 별똥별의 위치의 좌표
    for (i in 0 until K) {
        StringTokenizer(br.readLine()).run {
            val x = nextToken().toInt()
            val y = nextToken().toInt()

            xSet.add(x)
            ySet.add(y)
            dropArr[i] = Coordinate(x, y)
        }
    }
} // End of input()
