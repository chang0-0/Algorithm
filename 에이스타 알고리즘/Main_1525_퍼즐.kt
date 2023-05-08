import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

/*
    0은 빈칸으로 나타낸다.
    정리된 상태를 만들 수 있는지 판단하고, 정리된 상태로 만드는 최소한의 이동 횟수를 출력하라.

    최소 이동 횟수를 출력하고, 이동이 불가능한 경우 -1을 출력한다.
 */

private const val N = 3
private lateinit var br: BufferedReader
private lateinit var bw: BufferedWriter
private lateinit var st: StringTokenizer

private val dirX = arrayOf(-1, 1, 0, 0)
private val dirY = arrayOf(0, 0, -1, 1)
private val arr = Array(3) { CharArray(3) }

private val pq: PriorityQueue<Node2> = PriorityQueue()
private val visitedMap = HashMap<Int, Int>()
private val impossibleSet = HashSet<Int>()

private data class Node2(var data: String, var g: Int, var f: Int) : Comparable<Node2> {
    override fun compareTo(other: Node2): Int {
        if (f == other.f) {
            g.compareTo(other.g)
        }
        return f.compareTo(other.f)
    } // End of compareTo
} // End of Node2 class

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\Free PJT Algorithm\\untitled\\src\\main\\resources\\1525.txt"
    br = BufferedReader(File(path).bufferedReader())
    bw = BufferedWriter(OutputStreamWriter(System.`out`))

    setData()

    aStartAlgorithm()

    if (visitedMap.containsKey("123456789".toInt())) {
        bw.write(visitedMap.getValue("123456789".toInt()).toString())
    } else {
        visitedMap.keys.forEach {
            impossibleSet.add(it)
        }
        bw.write("-1")
    }

    bw.close()
} // End of main

private fun aStartAlgorithm() {
    while (!pq.isEmpty()) {
        val pollNode = pq.poll()
        val numberData = pollNode.data
        val sharpIndex = numberData.indexOf("9")

        val cr = sharpIndex / 3
        val cc = sharpIndex % 3

        if (impossibleSet.contains(numberData.toInt())) {
            return
        }

        var data = ""
        for (i in 0 until 4) {
            val nowX = cr + dirX[i]
            val nowY = cc + dirY[i]

            if (rangeCheck(nowX, nowY)) {
                var next = java.lang.StringBuilder(numberData)
                next = swap(cr, cc, nowX, nowY, next)
                data = next.toString()

                if (visitedMap.containsKey(data.toInt())) {
                    continue
                } else {
                    val g = pollNode.g
                    val heuristicValue = getHeuristicValue(data)
                    val f = g + heuristicValue
                    pq.offer(Node2(data, g + 1, f))
                    visitedMap[data.toInt()] = g + 1
                }
            }
        }

        if (visitedMap.containsKey("123456789".toInt())) {
            return
        }
    }
} // End of aStartAlgorithm

private fun swap(cr: Int, cc: Int, nowX: Int, nowY: Int, next: StringBuilder): StringBuilder {
    val currentRC = cr * 3 + cc
    val nextRC = nowX * 3 + nowY
    val temp = next[currentRC]
    next.setCharAt(currentRC, next[nextRC])
    next.setCharAt(nextRC, temp)
    return next
} // End of swap

private fun getHeuristicValue(data: String): Int {
    var count = 0
    for (i in data.indices) {
        if ("123456789"[i] != data[i]) {
            count++
        }
    }
    return count
} // End of getHeuristicValue

private fun rangeCheck(nowX: Int, nowY: Int): Boolean {
    return nowX < N && nowX >= 0 && nowY < N && nowY >= 0
} // End of rangeCheck

private fun setData() {
    var boardStr = ""
    for (x in 0 until N) {
        st = StringTokenizer(br.readLine())
        for (y in 0 until N) {
            arr[x][y] = st.nextToken()[0]
            if (arr[x][y] == '0') {
                arr[x][y] = '9'
            }
            boardStr += arr[x][y]
        }
    }

    pq.offer(Node2(boardStr, 0, 0))
    visitedMap[boardStr.toInt()] = 0
} // End of setData
