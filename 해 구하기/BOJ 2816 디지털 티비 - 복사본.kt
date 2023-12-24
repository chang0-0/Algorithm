package BOJ_2816

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    버튼을 눌러야 하는 순서를 출력

 */

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var N = 0
private lateinit var list: MutableList<Int>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2816\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    sb = StringBuilder()

    input()

    solve()

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {
    if (list[0] > list[1]) list[1]++

    for (i in 0 until 2) {
        for (j in 0 until list[i]) {
            sb.append(1)
        }
        if (i == 1) list[1]--
        for (j in 0 until list[i]) {
            sb.append(4)
        }
    }

} // End of solve

private fun input() {
    N = br.readLine().toInt()

    list = LinkedList()
    repeat(N) {
        list.add(0)
    }

    for (i in 0 until N) {
        val temp = br.readLine()

        if (temp == "KBS1") {
            list[0] = i
        } else if (temp == "KBS2") {
            list[1] = i
        }
    }
} // End of input
