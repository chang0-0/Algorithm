package BOJ_15657

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// input
private lateinit var br: BufferedReader
private lateinit var sb: StringBuilder

// variables
private var N = 0
private var M = 0

private lateinit var arr: IntArray
private lateinit var comb: IntArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_15657\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    sb = StringBuilder()

    DFS(0, 0)
    return sb.toString()
} // End of solve()

private fun DFS(depth: Int, idx: Int) {
    if (depth == M) {
        comb.forEach {
            sb.append(it).append(' ')
        }
        sb.append('\n')

        return
    }

    for (i in idx until N) {
        comb[depth] = arr[i]
        DFS(depth + 1, i)
    }
} // End of DFS()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    arr = IntArray(N)
    comb = IntArray(M)
    StringTokenizer(br.readLine()).run {
        for (i in 0 until N) {
            arr[i] = nextToken().toInt()
        }
    }
    arr.sort()
} // End of input()
