package 이분_탐색_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

/*
    입력으로 주어진 각각 선분 마다, 선분 위에 입력으로 주어진 점이 몇 개 있는지 출력한다.
    두 점이 같은 좌표를 가지는 경우는 없다.
    M개의 줄에 선분의 시작점과 끝점이 주어진다.
 */

// input
private lateinit var br: BufferedReader
private lateinit var st: StringTokenizer

// variables
private var N = 0
private var M = 0

private lateinit var points: IntArray
private lateinit var coordinates: Array<Coordinate>

private data class Coordinate(var start: Int, var end: Int)


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\이분_탐색_부수기\\11663.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()
    points.sort()

    for (i in 0 until M) {
        var minIdx = Int.MAX_VALUE
        var maxIdx = Int.MIN_VALUE

        lowerBinarySearch(0, N - 1, coordinates[i].start)

        upperBinarySearch(0, N - 1, coordinates[i].end)

    }



    bw.write(sb.toString())
    bw.close()
} // End of main

private fun lowerBinarySearch(low: Int, high: Int, target: Int) {
    if (low > high) return

    var mid = (low + high) / 2
    if (target < points[mid]) {
        //var min = Math.min(min, mid)
    }
} // End of lowerBinarySearch

private fun upperBinarySearch(low: Int, high: Int, target: Int) {
    if (low > high) return


} // End of upperBinarySearch

private fun input() {
    st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    points = IntArray(N)
    st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        points[i] = st.nextToken().toInt()
    }

    coordinates = Array(M) { Coordinate(0, 0) }
    for (i in 0 until M) {
        st = StringTokenizer(br.readLine())
        coordinates[i] = Coordinate(st.nextToken().toInt(), st.nextToken().toInt())
    }
} // End of input
