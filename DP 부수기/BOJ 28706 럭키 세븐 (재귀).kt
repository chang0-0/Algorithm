package BOJ_28706

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter


// https://www.acmicpc.net/problem/28706
// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var N = 0
private var flag = false
private lateinit var cmd: Array<Operation>
private lateinit var memo: Array<BooleanArray>

private data class Operation(var op1: Char, var num1: Int, var op2: Char, var num2: Int)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_28706\\res.txt"
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
} // End of main()

private fun solve() {
    calc(0, 1)

    when (flag) {
        true -> {
            sb.append("LUCKY")
        }

        else -> {
            sb.append("UNLUCKY")
        }
    }
    sb.append('\n')
} // End of solve()

private fun calc(depth: Int, num: Int) {
    if (depth == N) {
        if (num == 0) flag = true
        return
    }

    if (memo[depth][num] || flag) return
    memo[depth][num] = true

    if (cmd[depth].op1 == '+') {
        calc(depth + 1, (num + cmd[depth].num1) % 7)
    } else {
        calc(depth + 1, (num * cmd[depth].num1) % 7)
    }

    if (cmd[depth].op2 == '+') {
        calc(depth + 1, (num + cmd[depth].num2) % 7)
    } else {
        calc(depth + 1, (num * cmd[depth].num2) % 7)
    }
} // End of calc()

private fun input() {
    N = br.readLine().toInt()
    flag = false

    memo = Array(N) { BooleanArray(7) }
    cmd = Array(N) { Operation(' ', 0, ' ', 0) }

    for (i in 0 until N) {
        val temp = br.readLine()
        cmd[i] = Operation(temp[0], temp[2] - '0', temp[4], temp[6] - '0')
    }
} // End of input()
