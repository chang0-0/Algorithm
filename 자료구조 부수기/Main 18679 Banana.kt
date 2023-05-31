package 자료구조_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private lateinit var wordArr: Array<Word>

private data class Word @JvmOverloads constructor(
    var name: String? = "",
    var mean: String? = ""
) // End of Word class

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\자료구조_부수기\\res\\18679.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    init()

    val T = br.readLine().toInt()
    for (t in 0 until T) {
        val K = br.readLine().toInt()
        val str = br.readLine()

        val st = StringTokenizer(str)
        for (i in 0 until K) {
            // 단어하나가 넘어올 때 마다 의미 찾기
            val temp = findMean(st.nextToken())

            sb.append(temp).append(' ')
        }

        sb.append('\n')
    }

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun findMean(name: String): String {
    wordArr.forEach {
        if (it.name == name) {
            return it.mean!!
        }
    }

    return ""
} // End of findMean

private fun init() {
    N = br.readLine().toInt()
    wordArr = Array(N) { Word() }

    var st: StringTokenizer
    for (i in 0 until N) {
        st = StringTokenizer(br.readLine(), " = ")
        wordArr[i] = Word(st.nextToken(), st.nextToken())
    }
} // End of init
