package BOJ_19951

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/19951
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_19951\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main

private fun solve(): String {
    val sb = StringBuilder()

    val heights = IntArray(N + 1)
    StringTokenizer(br.readLine()).run {
        for (i in 1..N) {
            heights[i] = nextToken().toInt()
        }
    }

    val prefixSums = IntArray(N + 2)
    for (i in 0 until M) {
        StringTokenizer(br.readLine()).run {
            val a = nextToken().toInt()
            val b = nextToken().toInt()
            val k = nextToken().toInt()
            // 구간 마킹하기
            prefixSums[a] += k
            prefixSums[b + 1] -= k
        }

        println("prefixSums : ${prefixSums.contentToString()}")
    }

    println("마킹 결과 : ${prefixSums.contentToString()}")

    // 마킹 부분 누적합 구하기
    for (i in 0..N) {
        prefixSums[i + 1] += prefixSums[i]
    }

    println("누적 합 결과 : ${prefixSums.contentToString()}")

    for (i in 1..N) {
        heights[i] += prefixSums[i]
        sb.append(heights[i]).append(' ')
    }

    return sb.toString()
} // End of solve()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }
} // End of input()
