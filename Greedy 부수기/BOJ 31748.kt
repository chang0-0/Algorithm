package BOJ_31748

import java.io.BufferedReader
import java.io.File
import java.util.StringTokenizer

// input
private var br = System.`in`.bufferedReader()

// variables
private var N = 0
private var K = 0
private lateinit var chArr: CharArray

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_31748\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = System.out.bufferedWriter()

    input()

    bw.write(solve())
    bw.close()
} // End of main()

private fun solve(): String {
    val sb = StringBuilder()

    // 앞쪽을 최대한 A로 만들고 나머지를 뒤에서 처리하는 방식

    var idx = 0
    while (K > 0) {
        if (idx == N - 1) {
            K %= 26
            if (K > ('Z' + 1) - chArr[idx]) {
                // A로 만들 수 있으면 회전해서 A에서 시작
                K -= ('Z' + 1) - chArr[idx]
                chArr[idx] = 'A'
            }

            // 나머지 K횟수 활용
            chArr[idx] = (chArr[idx] + K).toChar()
            K = 0 // K 모두 소진 처리
        } else {
            if (chArr[idx] == 'A') {
                idx++
                continue
            }

            val count = ('Z' + 1) - chArr[idx]
            if (count <= K) {
                chArr[idx] = 'A'
                K -= count
                idx++
            } else {
                idx++
            }
        }
    }

    chArr.forEach {
        sb.append(it)
    }

    return sb.toString()
} // End of solve()

private fun input() {
    val st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt()
    K = st.nextToken().toInt()
    chArr = br.readLine().toCharArray()
} // End of input()
