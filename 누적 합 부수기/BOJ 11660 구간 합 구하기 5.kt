package BOJ_11660

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0

private lateinit var board: Array<IntArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_11660\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main

private fun solve(): String {
    val sb = StringBuilder()

    StringTokenizer(br.readLine()).also {
        println(it)
        println(it.nextToken())
    }


    repeat(M) {
        StringTokenizer(br.readLine()).run {
            val r1 = nextToken().toInt()
            val c1 = nextToken().toInt()
            val r2 = nextToken().toInt()
            val c2 = nextToken().toInt()


        }
    }

    return sb.toString()
} // End of solve

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    board = Array(N) { IntArray(N) }

    for (i in 0 until N) {
        StringTokenizer(br.readLine()).run {
            for (j in 0 until N) {
                board[i][j] = nextToken().toInt()
            }
        }
    }
} // End of input