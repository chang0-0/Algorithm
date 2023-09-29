package Leet_118

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

// https://leetcode.com/problems/pascals-triangle/
// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private lateinit var pascal: Array<IntArray>
private lateinit var ans: MutableList<MutableList<Int>>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\Leet_118\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()
    makePascal()
    println(ans)

    return sb.toString()
} // End of solve()

private fun makePascal() {
    for (i in 0..N) {
        pascal[i][0] = 1
        ans[i].add(1)
        for (j in 1..i) {
            pascal[i][j] = (pascal[i - 1][j - 1] + pascal[i - 1][j])
            ans[i].add(pascal[i][j])
        }
    }
} // End of makePascal()

private fun input() {
    N = br.readLine().toInt()
    pascal = Array(N + 1) { IntArray(N + 1) }
    ans = ArrayList()
    repeat(N + 1) {
        ans.add(ArrayList())
    }
} // End of input()
