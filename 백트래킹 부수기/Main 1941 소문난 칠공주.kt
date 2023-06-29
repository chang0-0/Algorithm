package 백트래킹_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

/*
    7명의 자리는 가로나 세로로 인접해 있어야 한다.
    화합과 번영을 위해서 반드시 이다솜파의 학생들로만 구성될 필요는 없다.
    그러나 생존을 위해서 이다솜파가 반드시 우위를 점해야 한다.
    7명의 학생 중 이다솜파의 학생이 적어도 4명 이상은 반드시 포함되어야 한다.

    S가 최소 4개 이상 즉, Y는 최대 3개
    7개를 인접

    5*5 행렬
    S는 이다솜파의 학생
    Y는 임도연파의 학생을 나타냄
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 5
private var ans = 0

private var map = Array(5) { CharArray(5) }
private var isVisited = Array(5) { BooleanArray(5) }
private var wholeIsVisited = Array(5) { BooleanArray(5) }
private var checkArray = CharArray(7)
private var dirX = arrayOf(-1, 1, 0, 0)
private var dirY = arrayOf(0, 0, -1, 1)


fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\백트래킹_부수기\\res\\1941.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()

    map.forEach {
        println(it.contentToString())
    }

    // 백트래킹의 핵심은 가지치기
    for (i in 0 until N) {
        for (j in 0 until N) {
            wholeIsVisited[i][j] = true
            isVisited[i][j] = true
            println("DFS($i,$j,${0})")
            DFS(i, j, 0)
            isVisited[i][j] = false
            //wholeIsVisited[i][j] = false
        }
    }

    // 끝나고 난 후 isVisited가 전체 다시 false로 되어있어야 함
    isVisited.forEach {
        println(it.contentToString())
    }

    wholeIsVisited.forEach {
        println(it.contentToString())
    }

    sb.append(ans)
    bw.write(sb.toString())
    bw.close()
} // End of main

private fun DFS(startX: Int, startY: Int, index: Int) {
    if (index >= 4) {
        // 필수조건 : S가 최소 4개는 있어야 한다, -> Y가 4개가 되면 실패.
        // 즉, 4개까지만 조합해 보고 최소한으로 가능한지 불가능한지 판단이 가능하다.

        if (isPossible(index)) {
            println("checkArray : ${checkArray.contentToString()}")
            ans++
        }

        if (index == 7) return
    }

    for (i in 0 until 4) {
        val nextX = startX + dirX[i]
        val nextY = startY + dirY[i]
        println("nextX : $nextX , nextY : $nextY")

        if (!rangeCheck(nextX, nextY)) continue
        if (isVisited[nextX][nextY]) continue
        if (wholeIsVisited[nextX][nextY]) continue

        checkArray[index] = map[nextX][nextY]
        isVisited[nextX][nextY] = true
        DFS(nextX, nextY, index + 1)
        isVisited[nextX][nextY] = false
    }
} // End of DFS

private fun isPossible(checkSize: Int): Boolean {
    // 4개 까지만 해도 판단이 가능함.
    var sCnt = 0
    var yCnt = 0

    for (i in 0 until checkSize) {
        val temp = checkArray[i]
        if (temp == 'S') {
            sCnt++
            if (sCnt >= 4) {
                return true
            }
        } else {
            yCnt++
            if (yCnt >= 4) {
                return false
            }
        }
    }

    if (sCnt >= 4) {
        return true
    } else {
        return false
    }
} // End of isPossible

private fun rangeCheck(nextX: Int, nextY: Int): Boolean {
    return nextX < N && nextX >= 0 && nextY < N && nextY >= 0
} // End of rangeCheck

private fun input() {
    for (i in 0 until N) {
        val temp = br.readLine()
        for (j in 0 until N) {
            map[i][j] = temp[j]
        }
    }
} // End of input