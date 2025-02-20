package BOJ_2446

import java.io.File

// https://www.acmicpc.net/problem/2446
// input
private var br = System.`in`.bufferedReader()


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2446\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var N = br.readLine().toInt()
    var idx = N
    var star = 0
    var blank = 0

    while (idx > 0) {
        star = (idx * 2) - 1
        repeat(blank) {
            sb.append(' ')
        }

        repeat(star) {
            sb.append('*')
        }

        idx--
        blank++
        sb.append('\n')
    }

    idx += 2
    blank -= 2
    while (idx <= N) {
        star = (idx * 2) - 1
        repeat(blank) {
            sb.append(' ')
        }

        repeat(star) {
            sb.append('*')
        }

        idx++
        blank--
        sb.append('\n')
    }


    return sb.toString()
} // End of solve()