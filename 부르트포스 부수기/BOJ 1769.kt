package BOJ_1769

import java.io.File

// https://www.acmicpc.net/problem/1769
// input
private var br = System.`in`.bufferedReader()

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_1769\\res.txt"
    br = File(path).bufferedReader()
    val bw = System.out.bufferedWriter()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val X: String = br.readLine()

    // 한자리 수로 만들기
    var chArr = X.toCharArray()
    var size = chArr.size
    var count = 0

    while (size > 1) {
        var sum = 0
        chArr.forEach {
            sum += Character.getNumericValue(it)
        }

        chArr = sum.toString().toCharArray()
        size = chArr.size
        count++
    }

    sb.append(count).append('\n')
    if (Character.getNumericValue(chArr[0]) >= 0 && Character.getNumericValue(chArr[0]) % 3 == 0) {
        sb.append("YES")
    } else {
        sb.append("NO")
    }

    return sb.toString()
} // End of solve()
