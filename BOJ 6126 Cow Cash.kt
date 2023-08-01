package BOJ_6126

/*
    주어진 동전 V개를 통해서 금액 N을 맞출 수 있는 방법을 계산하는 프로그램을 만들어라.
 */

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var V = 0L
private var N = 0L

private lateinit var coins: LongArray
private lateinit var memo: LongArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_6126\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main

private fun solve(): String {
    val sb = StringBuilder()
    println("coins : ${coins.contentToString()}")

    memo[0] = 1
    for (i in 0 until V) {
        println("============================= i : $i =============================")
        for (j in coins[i.toInt()]..N) {
            println("j : $j")
            println("memo[$j - ${coins[i.toInt()]}] : ${memo[(j - coins[i.toInt()]).toInt()]}")


            memo[j.toInt()] += memo[(j - coins[i.toInt()]).toInt()]
        }
        println(memo.contentToString())
    }

    sb.append(memo[N.toInt()])
    return sb.toString()
} // End of solve

private fun solve2(n1: Long, coinsArr: LongArray): Long {
    if (n1 == 0L) return 1

    var ans = 0L
    for (coin in coinsArr) {
        if (n1 - coin >= 0) {
            ans += solve2(n1 - coin, coinsArr)
        }
    }

    return ans
} // End of solve2

private fun input() {
    StringTokenizer(br.readLine()).run {
        V = nextToken().toLong()
        N = nextToken().toLong()
    }

    coins = LongArray(V.toInt())
    memo = LongArray((N + 1).toInt())

    for (i in 0 until V) {
        coins[i.toInt()] = br.readLine().toLong()
    }
} // End of input