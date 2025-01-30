package BOJ_2890

import java.io.*
import java.util.StringTokenizer

// https://www.acmicpc.net/problem/2890
// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var M = 0

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2890\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val list = mutableListOf<Pair<Int, Int>>() // 카약 번호, 결승선 앞에 남은 개수
    for (i in 1..N) {
        val temp = br.readLine()
        var dist = 0
        var num = -1
        for (j in M - 2 downTo 1) {
            if (temp[j] == '.') {
                dist++
            } else {
                num = temp[j].digitToInt()
                break
            }
        }

        if (num != -1) {
            list.add(Pair(num, dist))
        }
    }

    list.sortBy { it.second }
    var rank = 0
    val ans = IntArray(10)
    var pre = -1

    for (i in 0 until 9) {
        if (pre != list[i].second) {
            ans[list[i].first] = ++rank
        } else {
            ans[list[i].first] = rank
        }
        pre = list[i].second
    }

    for (i in 1 until 10) {
        sb.append(ans[i]).append('\n')
    }

    return sb.toString()
} // End of solve()

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }
} // End of input()

/*
20 50
S..................................222...........F
S................................................F
S..................................777...........F
S............................111.................F
S................................................F
S................................................F
S................................................F
S....................................444.........F
S666.............................................F
S..................999...........................F
S................................................F
S................................................F
S333.............................................F
S................................................F
S888.............................................F
S................................................F
S................................................F
S555.............................................F
S................................................F
S................................................F
 */