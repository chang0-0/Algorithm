package BOJ_15644

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*

    최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지, 또 어떻게 기울여야 하는지 구하는 프로그램을 작성하시오.

    기울이면 끝까지 간다!!

    첫째 줄에 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지, 둘째 줄에 어떻게 기울여야 하는지 순서대로 출력한다. 왼쪽으로 기울이기는 'L', 오른쪽으로 기울이기는 'R', 위로 기울이기는 'U', 아래로 기울이기는 'D'로 출력하며, 공백없이 한 줄에 모두 출력한다.
    가능한 방법이 여러 가지면, 아무거나 출력한다.
    만약, 10번 이하로 움직여서 빨간 구슬을 구멍을 통해 빼낼 수 없으면 -1을 출력한다.
 */

// input
private lateinit var br: BufferedReader

// variables
private var N = 0
private var M = 0

private lateinit var map: Array<CharArray>
private val dirX = arrayOf(-1, 1, 0, 0) // 상 하 좌 우
private val dirY = arrayOf(0, 0, -1, 1)

private lateinit var blueBallCoor: Coordinate
private lateinit var redBallCoor: Coordinate
private lateinit var holeCoor: Coordinate


private data class Coordinate(var x: Int, var y: Int, var move: String = "")

fun main() {
    val path = "C:\\Users\\bigyo\\Desktop\\알고리즘\\KotlinAlgo\\src\\main\\kotlin\\BOJ_15644\\res.txt"
    br = BufferedReader(File(path).bufferedReader())
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    input()

    bw.write(solve())
    bw.close()
} // End of main

private fun solve(): String {
    val sb = StringBuilder()

    val ret = BFS()
    if (ret == "") {
        sb.append(-1)
    } else {
        sb.append(ret.length).append('\n').append(ret)
    }

    return sb.toString()
} // End of solve

private fun BFS(): String {
    var ret = ""
    val redQue: Queue<Coordinate> = LinkedList()
    val redIsVisited = Array(N) { BooleanArray(M) }
    redQue.offer(Coordinate(redBallCoor.x, redBallCoor.y, ""))
    redIsVisited[redBallCoor.x][redBallCoor.y] = true


    val blueQue: Queue<Coordinate> = LinkedList()
    val blueIsVisited = Array(N) { BooleanArray(M) }
    blueQue.offer(Coordinate(blueBallCoor.x, blueBallCoor.y, ""))
    blueIsVisited[blueBallCoor.x][blueBallCoor.y] = true

    // 벽에 부딪힐 때 까지 가는게 아니라.
    // 기울여서 다른 방향으로 이동할 수 있으면 진행하는 거임
    // 그러므로 한 칸 이동하고 다음 방향에 머가 있는지 검사를 계속 진행해야된다.
    /*
        #######################
        ##
        ######      ######
        #######     ######
        ########    ######
     */

    map.forEach {
        println(it.contentToString())
    }
    println("==========================================================")
    println("==========================================================")


    while (redQue.isNotEmpty()) {
        // 빨간공
        val redPoll = redQue.poll()

        var bluePoll = Coordinate(0, 0, "")
        if (blueQue.isNotEmpty()) {
            bluePoll = blueQue.poll()
        }

        var redFlag = false
        var blueFlag = false

        for (dir in 0 until 4) {
            val redNextX = redPoll.x + dirX[dir]
            val redNextY = redPoll.y + dirY[dir]
            var redNextMove = redPoll.move
            redFlag = false
            blueFlag = false


            //println("redNextX : $redNextX, redNextY : $redNextY ")
            if (map[redNextX][redNextY] == '#' || map[redNextX][redNextY] == 'B' || redIsVisited[redNextX][redNextY]) continue


            var beforeDir: Char
            if (redPoll.move.isEmpty()) {
                beforeDir = ' '
            } else {
                beforeDir = redPoll.move[redPoll.move.length - 1]
            }

            when (dir) {
                0 -> {
                    if (beforeDir != 'U' || beforeDir == ' ') {
                        redNextMove += 'U'
                    }
                }

                1 -> {
                    if (beforeDir != 'D' || beforeDir == ' ') {
                        redNextMove += 'D'
                    }
                }

                2 -> {
                    if (beforeDir != 'L' || beforeDir == ' ') {
                        redNextMove += 'L'
                    }
                }

                3 -> {
                    if (beforeDir != 'R' || beforeDir == ' ') {
                        redNextMove += 'R'
                    }
                }
            }


            if (map[redNextX][redNextY] == '.' && redNextMove.length <= 10) {
                // .이면 계속 진행할 수 있음
                // 이전까지 이동한 마지막 방향이 다음 방향 이동할 방향과 같다면 굳이 방향을 적어줄 필요가 없음

                println("redPoll.x : ${redPoll.x} : redPoll.y : ${redPoll.y}")
                //println("redNextX : $redNextX, redNextY : $redNextY , redNextMove : $redNextMove , value : ${map[redNextX][redNextY]}")

                map[redPoll.x][redPoll.y] = '.'
                map[redNextX][redNextY] = 'R'

                map.forEach {
                    println(it.contentToString())
                }
                println("==========================================================")
                println("==========================================================")

                redIsVisited[redNextX][redNextY] = true
                redQue.offer(Coordinate(redNextX, redNextY, redNextMove))
            }

            if (map[redNextX][redNextY] == 'O') {
                // 구멍에 들어가면 redQue는 clear
                ret = redNextMove
                redFlag = true
                redQue.clear()
            }


            val blueNextX = bluePoll.x + dirX[dir]
            val blueNextY = bluePoll.y + dirY[dir]
            println("blueNextX : $blueNextX , blueNextY : $blueNextY")
            println("value : ${map[blueNextX][blueNextY]}")

            if (map[blueNextX][blueNextY] == '#' || map[blueNextX][blueNextY] == 'R' || blueIsVisited[blueNextX][blueNextY]) continue
            //println("blueNextX : $blueNextX , blueNextY : $blueNextY , value : ${map[blueNextX][blueNextY]}")

            if (map[blueNextX][blueNextY] == '.') {
                map.forEach {
                    println(it.contentToString())
                }
                println("==========================================================")
                println("==========================================================")

                map[bluePoll.x][bluePoll.y] = '.'
                map[blueNextX][blueNextY] = 'B'

                blueIsVisited[blueNextX][blueNextY] = true
                blueQue.offer(Coordinate(blueNextX, blueNextY))
            }

            if (map[blueNextX][blueNextY] == 'O') {
                blueQue.clear()
                return ""
            }
        }


        if (redFlag) {
            return ret
        }
    }

    return ret
} // End of BFS

private fun rangeCheck(nextX: Int, nextY: Int): Boolean {
    return nextX in 0 until N && nextY >= 0 && nextY < M
} // End of rangeCheck

private fun input() {
    StringTokenizer(br.readLine()).run {
        N = nextToken().toInt()
        M = nextToken().toInt()
    }

    map = Array(N) { CharArray(M) }
    for (i in 0 until N) {
        val temp = br.readLine()

        for (j in 0 until M) {
            map[i][j] = temp[j]

            if (map[i][j] == 'B') {
                blueBallCoor = Coordinate(i, j)
            } else if (map[i][j] == 'R') {
                redBallCoor = Coordinate(i, j)
            } else if (map[i][j] == 'O') {
                holeCoor = Coordinate(i, j)
            }
        }
    }
} // End of input