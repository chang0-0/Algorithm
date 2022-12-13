import java.util.*
import java.io.*

/*
 파이프를 모아서 원하는 길이로 만들어야 한다.
 가지고 있는 파이프 길이와 그 수량을 알고 있을 때, 파이프를 적당히 합쳐서 X만큼의 길이를 만드는 방법 수를 구하시오.
 파이프를 합치는 순서는 고려하지 않는다.
 */


private var N = 0
private var X = 0
private val pipeArr = Array(101) { Pipe() }
private val memo = Array(101) { Array(10001) { 0 } }

private data class Pipe(var length: Int = 0, var quantity: Int = 0)

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\배낭 문제 부수기\\res\\15817.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var st = StringTokenizer(br.readLine())
    N = st.nextToken().toInt() // 파이프의 종류 수
    X = st.nextToken().toInt() // 합친 파이프의 길이

    for (i in 0 until N) {
        st = StringTokenizer(br.readLine())
        pipeArr[i].length = st.nextToken().toInt()
        pipeArr[i].quantity = st.nextToken().toInt()
    }

    for (i in 0 until N) {
        for (j in 0..X) {
            memo[i][j] = -1 // i번째 파이프를 사용해서 j 길이를 만든다.
        }
    }

    println(DP(0, 0))
} // End of main

private fun DP(index: Int, totalLength: Int): Int {

    if (totalLength == X) {
        return 1
    }
    if (totalLength > X) {
        return 0
    }
    if (index == N) {
        return 0
    }

    var ret = memo[index][totalLength]
    if (ret != -1) {
        return ret
    }

    ret = 0
    for (i in 0..pipeArr[index].quantity) {
        ret += DP(index + 1, totalLength + pipeArr[index].length * i)
    }

    return ret
} // End of DFS