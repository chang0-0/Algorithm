package BOJ_26122

import java.io.*

// https://www.acmicpc.net/problem/26122
// input
private var br = System.`in`.bufferedReader()

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_26122\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    var N = br.readLine().toInt()
    var str = br.readLine()
    var pre = str[0]
    var nLength = 0
    var sLength = 0
    var min = 0
    var ans = 0

    if (pre == 'N') {
        nLength++
    } else {
        sLength++
    }

    for (i in 1 until N) {
        if (sLength != 0 && nLength != 0 && str[i] != pre) {
            min = Math.min(sLength, nLength)
            ans = Math.max(ans, min * 2)

            if (str[i] == 'S') {
                sLength = 0
            } else {
                nLength = 0
            }
        }

        if (str[i] == 'S') {
            sLength++
        } else if (str[i] == 'N') {
            nLength++
        }

        pre = str[i]
    }


    min = Math.min(sLength, nLength)
    ans = Math.max(ans, min * 2)
    sb.append(ans)
    return sb.toString()
} // End of solve()
