package 이분_탐색_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    일반 케이크 대신 롤 케이크를 준비했다.
    롤 케이크에는 장식인 존재해서 특정 위치만 자를 수 있다.
    파이에 올 친구의 수 만큼 준비하고 싶어서, 가장 작은 조각의 크기를 미리 알아보기로 했다.
    몇 명이 참석하는지 알려주지 않는다. 그래서 몇 개의 수를 목록에 적어, 가 수만큼 조각을 만들었을 때 가장 작은 조각의 길이의 최댓값을 구하라
 */

private lateinit var br: BufferedReader

private var N = 0 // 자르는 횟수가 담긴 목록의 길이
private var M = 0 // 자를 수 있는 지점이 5군데가 있다고 하자.
private var L = 0

private lateinit var cutPointArr: IntArray
private lateinit var cutArr: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\이분_탐색_부수기\\17179.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    // 예를 들어 70cm


    bw.write(sb.toString())
    bw.close()
} // End of main

private fun input() {
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 횟수가 담긴 목록의 길이
    M = st.nextToken().toInt() // 자를 수 있는 지점의 개수
    L = st.nextToken().toInt() // 케이크 길이의 정수

    cutPointArr = IntArray(M)
    cutArr = IntArray(N)

    for (i in 0 until M) {
        cutPointArr[i] = br.readLine().toInt()
    }

    for (i in 0 until N) {
        cutArr[i] = br.readLine().toInt()
    }

    println(cutPointArr.contentToString())

} // End of input
