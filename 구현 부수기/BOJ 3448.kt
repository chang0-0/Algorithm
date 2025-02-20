package BOJ_3448

import java.io.File

// https://www.acmicpc.net/problem/3448
// input
private var br = System.`in`.bufferedReader()

// variables
private lateinit var str: StringBuilder
private const val TEXT = "Efficiency ratio is "

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_3448\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    val T = br.readLine().toInt()

    repeat(T) {
        str = StringBuilder()
        while (true) {
            val temp = br.readLine()
            if (temp.isNullOrEmpty()) break
            str.append(temp)
        }

        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val target = str.toString()
    val len = target.length.toDouble()
    val count = target.count { it == '#' }.toDouble()

    val temp = (len - count) / len * 100
    val ans = "%.1f".format(temp)
    val ansToInt = ans.toDouble().toInt()


    sb.append(
        "$TEXT${
            if (ans != "$ansToInt.0") {
                "%.1f".format(temp)
            } else {
                "$ansToInt"
            }
        }%.\n"
    )

    return sb.toString()
} // End of solve()