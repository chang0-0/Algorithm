package 문자열_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// Input
private lateinit var br: BufferedReader

// Variables
private var N = 0
private lateinit var candyArr: IntArray
private val pQue: PriorityQueue<Int> = PriorityQueue(reverseOrder())

private var evenNumCount = 0 // 짝수
private var oddNumCount = 0 // 홀수


fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\코틀린 알고리즘\\Kotlin_Algo\\src\\main\\kotlin\\문자열_부수기\\res\\28062.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    init()

    /*
        예외 : 사탕을 홀수 개로만 가져갈 수 있다면 0을 출력한다.
    
        1. 짝수의 묶음은 (있으면) 일단 다 모두 더함
        2. 홀수가 2개 이상일 경우 가장 큰 홀수를 짝수개 만큼 더함
        3. 짝수가 없거나 홀수가 2개 미만일 경우 0을 출력한다.
     */

    var ans = 0
    if (evenNumCount == 0 && oddNumCount == 1) {
        // 사탕을 짝수개로 나눌 수 없는 경우
        println(0)
        return
    }

    if (oddNumCount <= 1) {
        while (pQue.isNotEmpty()) {
            val pollNum = pQue.poll()

            if (pollNum % 2 == 0) {
                // 짝수는 모두 더함
                ans += pollNum
            }
        }
    } else {
        var mod = oddNumCount - (oddNumCount % 2)

        while (pQue.isNotEmpty()) {
            val pollNum = pQue.poll()

            if (pollNum % 2 == 0) {
                // 짝수는 모두 더함
                ans += pollNum
            } else if (mod > 0 && pollNum % 2 == 1) {
                // 홀수
                ans += pollNum
                mod--
            }
        }
    }

    sb.append(ans)

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun init() {
    N = br.readLine().toInt()
    candyArr = IntArray(N)

    val st = StringTokenizer(br.readLine())
    for (i in 0 until N) {
        val temp = st.nextToken().toInt()
        pQue.offer(temp)

        if (temp % 2 == 1) {
            oddNumCount++
        } else {
            evenNumCount++
        }
    }
} // End of init