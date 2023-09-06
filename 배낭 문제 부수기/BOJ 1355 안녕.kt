package BOJ_1355

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// input
private lateinit var br: BufferedReader

// variables
private const val MAX_HEALTH = 100
private var N = 0
private lateinit var memo: Array<IntArray>
private lateinit var claps: Array<Clap>

private data class Clap(var health: Int = 0, var happy: Int = 0)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1355\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    sb.append(knapsack(MAX_HEALTH, N))
    return sb.toString()
} // End of solve()

private fun knapsack(health: Int, idx: Int): Int {
    if (health <= 0 || idx == 0) return 0

    if (memo[health][idx] != -1) return memo[health][idx]

    // 선택하지 않고 그냥 통과
    memo[health][idx] = knapsack(health, idx - 1)

    if (health - claps[idx].health > 0) {
        memo[health][idx] =
            memo[health][idx].coerceAtLeast(knapsack(health - claps[idx].health, idx - 1) + claps[idx].happy)
    }

    return memo[health][idx]
} // End of knapsack()

private fun input() {
    N = br.readLine().toInt()

    memo = Array(MAX_HEALTH + 1) { IntArray(N + 1) { -1 } }
    claps = Array(N + 1) { Clap(0, 0) }

    val st1 = StringTokenizer(br.readLine())
    val st2 = StringTokenizer(br.readLine())

    repeat(N) { idx ->
        claps[idx + 1] = Clap(
            st1.nextToken().toInt(),
            st2.nextToken().toInt()
        )
    }
} // End of input()
