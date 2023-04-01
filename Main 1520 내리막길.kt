import java.util.*
import java.io.*;

private lateinit var arr : Array<Array<Int>>
private lateinit var memo : Array<Array<Int>>
private val dirX = arrayOf(0, 0, -1, 1)
private val dirY = arrayOf(-1, 1, 0, 0)
private var N = 0; private var M = 0
private var nowX = 0; private var nowY = 0

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\DFS&BFS 부수기\\res\\1520.txt"
    val br = BufferedReader(File(path).bufferedReader())
    var st = StringTokenizer(br.readLine())

    M = st.nextToken().toInt()
    N = st.nextToken().toInt()
    arr = Array(M){Array(N) {0}}
    memo = Array(M){Array(N) {-1}}

    for(i in 0 until M) {
        st = StringTokenizer(br.readLine())
        for(j in 0 until N) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    println(DFS(0, 0))
} // End of main

private fun DFS(x : Int, y : Int) : Int {

    if(x == M-1 && y == N-1) return 1

    if(memo[x][y] != -1) return memo[x][y] // -1이 아닐 경우, 이미 방문을 했음을 의미함

    memo[x][y] = 0
    for(i in 0 until 4) {
        nowX = x + dirX[i]
        nowY = y + dirY[i]

        if(!rangeCheck()) continue
        if(arr[x][y] > arr[nowX][nowY]) memo[x][y] += DFS(nowX, nowY)
    }

    return memo[x][y]
} // End of DFS

private fun rangeCheck() : Boolean {
    return nowX < M && nowX >= 0 && nowY < N && nowY >= 0
} // End of rangeCheck