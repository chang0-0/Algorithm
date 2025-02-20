package BOJ_2447

import java.io.*

// https://www.acmicpc.net/problem/2447
// input
private var br = System.`in`.bufferedReader()

private lateinit var chArr: Array<CharArray>
private var N = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2447\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()
    N = br.readLine().toInt()
    chArr = Array(N) { CharArray(N) }

    makeStar(0, 0, N, false)
    repeat(N) { i ->
        println(chArr[i])
    }

    return sb.toString()
} // End of solve()

private fun makeStar(x: Int, y: Int, N: Int, blank: Boolean) {
    if (blank) {
        for (i in x until x + N) {
            for (j in y until y + N) {
                chArr[i][j] = ' '
            }
        }
        return
    }

    if (N == 1) {
        chArr[x][y] = '*'
        return
    }

    val size = N / 3
    var count = 0
    var i = x
    while (i < x + N) {
        var j = y
        while (j < y + N) {
            count++
            if (count == 5) {
                makeStar(i, j, size, true)
            } else {
                makeStar(i, j, size, false)
            }
            j += size
        }
        i += size
    }
} // End of star()