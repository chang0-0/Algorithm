package BOJ_28358

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private val days = arrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
private val numbers = IntArray(10)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_28358\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    sb = StringBuilder()

    val t = br.readLine().toInt()
    repeat(t) {
        input()

        solve()
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve() {
    var count = 0
    for (i in 1..12) {
        var temp = i.toString()
        var flag = false

        temp.forEach {
            if (numbers[it - '0'] == 1) {
                flag = true
                return@forEach
            }
        }

        if (flag) continue
        for (j in 1..days[i]) {
            temp = j.toString()
            flag = false

            temp.forEach {
                if (numbers[it - '0'] == 1) {
                    flag = true
                    return@forEach
                }
            }

            if (flag) {
                continue
            } else {
                count++
            }
        }
    }

    sb.append(count).append('\n')
} // End of solve

private fun input() {
    val st = StringTokenizer(br.readLine())
    for (i in 0 until 10) {
        numbers[i] = st.nextToken().toInt()
    }
} // End of input