package BOJ_10836

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

// input
private lateinit var br: BufferedReader

// variables
private var M = 0 // 가로 세로 크기
private var N = 0 // 날짜 수

// private lateinit var map: Array<Array<Growth>>
private lateinit var map2: Array<IntArray>
private lateinit var growthArray: Array<IntArray>


// 좌 좌상 상
private val dirX = arrayOf(0, -1, -1)
private val dirY = arrayOf(-1, -1, 0)

private data class Growth(var value: Int = 0, var growthValue: Int = 0)


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_10836\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main

private fun solve(): String {
    val sb = StringBuilder()

    // N일 동안 반복
    var idx = 0
    repeat(N) {
        firstGrowth(idx)

        idx++
    }

    // 출력
    for (i in 0 until M) {
        for (j in 0 until M) {
            if (j == 0) {
                sb.append(map2[i][j]).append(' ') // 가장 왼쪽열과 가장 위쪽 행
            } else {
                sb.append(map2[0][j]).append(' ') // 그 외에는 해당 열의 가장 위쪽 행 애벌래의 크기를 가진다
            }
        }
        sb.append('\n')
    }

    return sb.toString()
} // End of solve

private fun firstGrowth(idx: Int) {
    // 가장 왼쪽 열 아래 부터 가장 위쪽 행 오른쪽 끝까지 진행
    var zeroValue = growthArray[idx][0]

    var x = 0
    var y = 0
    if (zeroValue == M) {
        x = 0
        y = 0
    } else if (zeroValue < M) {
        x = M - zeroValue
        y = 1
    } else if (zeroValue > M) {
        x = 0
        y = zeroValue - M
    }

    var oneValue = growthArray[idx][1]
    while (oneValue-- > 0) {
        if (x > 0) {
            x -= 1
            y = 0
        } else {
            x = 0
            y += 1
        }

        map2[x][y] += 1
    }

    var twoValue = growthArray[idx][2]
    while (twoValue-- > 0) {
        if (x > 0) {
            x -= 1
            y = 0
        } else {
            x = 0
            y += 1
        }

        map2[x][y] += 2
    }
} // End of firstGrowth

private fun input() {
    var st = StringTokenizer(br.readLine())
    M = st.nextToken().toInt()
    N = st.nextToken().toInt()

    //map = Array(M) { Array(M) { Growth(1, 0) } }
    map2 = Array(M) { IntArray(M) { 1 } }

    growthArray = Array(N) { IntArray(3) }
    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        growthArray[i][0] = st.nextToken().toInt()
        growthArray[i][1] = st.nextToken().toInt()
        growthArray[i][2] = st.nextToken().toInt()
    }
} // End of input
