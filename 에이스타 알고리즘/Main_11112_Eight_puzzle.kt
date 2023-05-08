import java.io.*
import java.util.*

private var N = 0
private lateinit var br: BufferedReader
private lateinit var bw: BufferedWriter
private lateinit var st: StringTokenizer

private val dirX = arrayOf(-1, 1, 0, 0)
private val dirY = arrayOf(0, 0, -1, 1)
private val board = Array(3) { CharArray(3) }

private val pq: PriorityQueue<Node> = PriorityQueue()
private val visitedMap = HashMap<Int, Int>()
private val impossibleSet = HashSet<Int>()

private data class Node constructor(var data: String, var g: Int, var f: Int) :
    Comparable<Node> {
    // End of Node class
    override fun compareTo(other: Node): Int {
        if (f == other.f) {
            return g.compareTo(other.g)
        }
        return f.compareTo(other.f)
    } // End of compareTo
} // End of Node class

fun main() {
    val path = "C:\\Users\\multicampus\\Desktop\\Free PJT Algorithm\\untitled\\src\\main\\resources\\11112.txt"
    br = BufferedReader(File(path).bufferedReader())
    bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val sb = StringBuilder()

    N = br.readLine().toInt()
    while (N-- > 0) {
        br.readLine() // 빈 줄 통과

        setData()

        aStarAlgorithm()

        if (visitedMap.containsKey("123456789".toInt())) {
            bw.write(visitedMap.getValue("123456789".toInt()).toString() + "\n")
        } else {
            visitedMap.keys.forEach {
                impossibleSet.add(it)
            }
            bw.write("impossible" + "\n")
        }
    }

    bw.close()
} // End of main

private fun aStarAlgorithm() {
    // 우선순위 큐가 비어있지 않으면 계속해서 반복한다.
    while (!pq.isEmpty()) {
        val pollNode = pq.poll()
        val numberData = pollNode.data
        val sharpIndex = numberData.indexOf("9")

        val cr = sharpIndex / 3
        var cc = sharpIndex % 3

        if (impossibleSet.contains(numberData.toInt())) {
            return
        }

        var data = ""
        for (i in 0 until 4) {
            val nowX = cr + dirX[i]
            val nowY = cc + dirY[i]

            if (rangeCheck(nowX, nowY)) {
                var next = StringBuilder(numberData)
                next = swap(cr, cc, nowX, nowY, next)
                data = next.toString()

                if (visitedMap.containsKey(data.toInt())) {
                    continue
                } else {
                    val g = pollNode.g
                    val heuristicValue = getHeuristicValue(data)
                    val f = g + heuristicValue
                    pq.offer(Node(data, g + 1, f))
                    visitedMap[data.toInt()] = g + 1
                }
            }
        }

        if (visitedMap.containsKey("123456789".toInt())) {
            // 순서대로 정렬된 키 값이 있으면 곧 바로 종료함
            return
        }
    }
} // End of aStartAlgorithm

private fun getHeuristicValue(data: String): Int {
    var count = 0
    for (i in data.indices) {
        if ("123456789"[i] != data[i]) {
            count++
        }
    }
    return count
} // End of getHeuristicValue

private fun swap(cr: Int, cc: Int, nowX: Int, nowY: Int, next: StringBuilder): StringBuilder {
    val currentRC = cr * 3 + cc
    val nextRC = nowX * 3 + nowY
    val temp = next[currentRC]
    next.setCharAt(currentRC, next[nextRC])
    next.setCharAt(nextRC, temp)
    return next
} // End of swap

private fun rangeCheck(nowX: Int, nowY: Int): Boolean {
    return nowX < 3 && nowX >= 0 && nowY < 3 && nowY >= 0
} // End of rangeCheck

private fun setData() {
    visitedMap.clear()
    pq.clear()

    var boardStr = ""
    for (r in 0 until 3) {
        board[r] = br.readLine().toCharArray()
        for (c in 0 until 3) {
            if (board[r][c] == '#') {
                // #으로 된 빈 공간을 9초 치환을 해준다.
                board[r][c] = '9'
            }
            boardStr += board[r][c]
        }
    }
    pq.offer(Node(boardStr, 0, 0))
    visitedMap[boardStr.toInt()] = 0
} // End of setData
