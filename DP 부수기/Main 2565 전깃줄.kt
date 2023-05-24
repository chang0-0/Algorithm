package DP_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// https://www.acmicpc.net/problem/2565

private var N = 0
private lateinit var memo: IntArray
private lateinit var wire: Array<IntArray>

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\코틀린 알고리즘\\Kotlin_Algo\\src\\main\\kotlin\\DP_부수기\\res\\2565.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()


    N = br.readLine().toInt()
    memo = IntArray(N) { -1 } // 연결가능한 전선의 수를 저장
    wire = Array(N) { IntArray(2) }

    for (i in 0 until N) {
        val st = StringTokenizer(br.readLine())

        wire[i][0] = st.nextToken().toInt() // A 전봇대
        wire[i][1] = st.nextToken().toInt() // B 전봇대
    }

    println("wire")
    wire.forEach {
        println(it.contentToString())
    }

    // 정렬 구현체
    // A 전봇대를 기준으로 정렬
    Arrays.sort(wire) { o1, o2 -> o1!![0] - o2!![0] }

    var max = 0
    val size = memo.size

    for (i in 0 until N) {
        max = Math.max(DP(i, size), max)
    }
    println("완성된 memo : ${memo.contentToString()}")

    sb.append(N - max)
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DP(idx: Int, size: Int): Int {
    println("DP($idx)")
    // 탐색하지 않았던 위치라면
    if (memo[idx] == -1) {
        memo[idx] = 1 // 최솟값 1로 초기화

        for (i in idx + 1 until size) {
            if (wire[idx][1] < wire[i][1]) {
                memo[idx] = Math.max(memo[idx], DP(i, size) + 1)
            }
        }
    }

    return memo[idx]
} // End of DP
