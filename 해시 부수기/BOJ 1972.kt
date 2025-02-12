package BOJ_1972

import java.io.File

// https://www.acmicpc.net/problem/1972
// input
private var br = System.`in`.bufferedReader()

// variables
private lateinit var chArr: CharArray
private const val SUR = "is surprising."
private const val NOT_SUR = "is NOT surprising."

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1972\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    while (true) {
        val temp = br.readLine()
        if (temp == "*") break
        chArr = temp.toCharArray()

        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val N = chArr.size
    var flag = true
    var ret = SUR

    loopI@ for (i in 1 until N) {
        val hashSet = HashSet<String>()

        for (j in 0 until N - i) {
            val a = chArr[j]
            val b = chArr[j + i]

            val temp = a.toString() + b.toString()
            if (!hashSet.add(temp)) {
                flag = false
                break@loopI
            }
        }
    }

    if (!flag) ret = NOT_SUR


    sb.append("${String(chArr)} $ret").append('\n')
    return sb.toString()
} // End of solve()
