package 자료구조_부수기

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    게임은 N * N 정사각 보드위에서 진해오디고, 몇몇 칸에서는 사과가 놓여져 있다.
    보드의 상하좌우 끝에 벽이 있다. 게임이 시작할 때 뱀은 맨위 맨좌측에 위치하고 뱀의 길이는 1이다.
    뱀은 처음에 오른쪽을 향한다.
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0

private lateinit var map: Array<IntArray>
private lateinit var snakeDirs: Array<Direction>
private lateinit var snakeList: MutableList<Coordinates>

private data class Direction(var time: Int, var direction: Char)
private data class Snake(var head: Int, var tail: Int)
private data class Coordinates(var x: Int, var y: Int)

private var dirX = arrayOf(1, -1, 0, 0) // 동 서 남 북
private var dirY = arrayOf(0, 0, 1, -1)

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\자료구조_부수기\\res\\3190.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val sb = StringBuilder()

    input()
    sb.append(solve())

    bw.write(sb.toString())
    bw.close()
} // End of main

private fun solve(): Int {
    var ans = 0
    var dirTime = 0
    snakeList.add(Coordinates(0, 0))
    var snakeDir = Coordinates(0, 0)

    while (true) {
        var nowX = snakeDir.x + dirX[dirTime]
        var nowY = snakeDir.y + dirY[dirTime]

        if (finishCheck(nowX, nowY)) {
            return ans
        }

        if (map[nowX][nowY] == 1) {
            map[nowX][nowY] = 0
            snakeList.add(Coordinates(nowX, nowY))
        } else {
            snakeList.add(Coordinates(nowX, nowY))
            snakeList.removeAt(0)
        }

        snakeDirs.forEach {
            // 이동시간이 됬을 때
            if (it.time == ans) {
                if (it.direction == 'D') {
                    dirTime += 1
                    if (dirTime == 4) {
                        dirTime = 0
                    }
                } else {
                    dirTime -= 1
                    if (dirTime == -1) {
                        dirTime = 3
                    }
                }
            }
        }

        

        ans++
        if (ans == 40) break
    }

    return ans
} // End of solve

private fun input() {
    N = br.readLine().toInt()
    map = Array(N + 1) { IntArray(N + 1) }
    snakeList = ArrayList()

    var st: StringTokenizer
    var K = br.readLine().toInt()
    while (K-- > 0) {
        st = StringTokenizer(br.readLine())
        map[st.nextToken().toInt()][st.nextToken().toInt()] = 1
    }

    var L = br.readLine().toInt()
    snakeDirs = Array(L) { Direction(0, ' ') }

    var idx = 0
    while (L-- > 0) {
        st = StringTokenizer(br.readLine())
        snakeDirs[idx].time = st.nextToken().toInt()
        snakeDirs[idx].direction = st.nextToken()[0]
        idx++
    }
} // End of input

private fun finishCheck(nowX: Int, nowY: Int): Boolean {
    // 벽에 닿으면 종료
    if (nowX < 0 || nowX >= N || nowY < 0 || nowY >= N) return true


    return false
} // End of rangeCheck