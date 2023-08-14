package 대회_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter


// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var flag = false

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\대회_부수기\\res\\f.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var t = br.readLine().toInt()
    while (t-- > 0) {
        input()

        solve()
    }

    bw.write("")
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // 순서대로 선택했을 때, 두개의 선택지 중에 하나를 선택해야 함 이렇게 해서 7의 배수를 만들 수 있는지를 확인하기

    var sum1 = 1
    var sum2 = 1
    var sum3 = 1
    var sum4 = 1

    for (i in 0 until N) {
        val str = br.readLine()

        val first = str.subSequence(0, 3)
        val second = str.subSequence(4, 7)

    }


    return sb.toString()
} // End of solve()

private fun DFS(depth: Int, sum: Int) {
    if (depth == N) {
        // 선택지를 모든 고른 결과가 7의 배수가 되어야 함

        return
    }


} // End of DFS()

private fun input() {
    N = br.readLine().toInt()
    flag = false
} // End of input()
