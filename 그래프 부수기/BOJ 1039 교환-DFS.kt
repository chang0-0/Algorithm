package BOJ_1039

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*


// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var K = 0
private var ans = 0
private lateinit var memo: Array<BooleanArray>

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1039\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    DFS(N.toString(), 0)

    sb.append(ans)
    return sb.toString()
} // End of solve()

private fun DFS(current: String, count: Int) {
    val currentInt = current.toInt()
    if (count == K) {
        ans = ans.coerceAtLeast(currentInt)
        return
    }

    if (memo[currentInt][count]) return
    memo[currentInt][count] = true

    val len = current.length
    for (i in 0 until len - 1) {
        for (j in i + 1 until len) {
            if (i == 0 && current[j] == '0') continue

            val swapped = swap(current, i, j)
            DFS(swapped, count + 1)
        }
    }
} // End of DFS()

private fun swap(str: String, i: Int, j: Int): String {
    val chArr = str.toCharArray()
    val temp = chArr[i]
    chArr[i] = chArr[j]
    chArr[j] = temp
    return String(chArr)
} // End of swap()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        K = nextToken().toInt()
    }

    ans = -1
    memo = Array(1_000_001) { BooleanArray(K + 1) }
} // End of input()
