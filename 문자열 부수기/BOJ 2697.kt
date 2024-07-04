package BOJ_2697

import java.io.BufferedReader
import java.io.File


// https://www.acmicpc.net/problem/2697
// input
private var br = System.`in`.bufferedReader()

// variables
private const val BIG = "BIGGEST"

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_2697\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    var t = br.readLine().toInt()
    while (t-- > 0) {
        bw.write(solve())
    }

    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    val str = br.readLine()
    val n = str.length
    val chArr = str.toCharArray()
    val numBuilder = StringBuilder()

    for (i in n - 1 downTo 1) {
        // i와 i + 1을 비교해서 i + 1이 더 작은 값일 경우 중단
        val point = Character.getNumericValue(chArr[i])
        var next = Character.getNumericValue(chArr[i - 1])

        if (point > next) {
            // next와 차이가 가장 적게나는 값이랑 교환하기
            val tempArr = str.substring(i, n).toCharArray()
            tempArr.sort()
            val tempArrLen = tempArr.size

            for (j in 0 until tempArrLen) {
                if (Character.getNumericValue(tempArr[j]) > next) {
                    // next보다 가장 작은 차이의 큰 값 발견하면 swap
                    val temp = tempArr[j]
                    tempArr[j] = chArr[i - 1]
                    chArr[i - 1] = temp
                    break
                }
            }

            for (j in 0 .. i - 1) {
                numBuilder.append(chArr[j])
            }

            tempArr.forEach {
                numBuilder.append(it)
            }
            break
        }
    }

    if (numBuilder.isEmpty()) {
        sb.append(BIG)
    } else {
        sb.append(numBuilder.toString())
    }

    sb.append('\n')
    return sb.toString()
} // End of solve()