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
private val memo = Array(101) { Array(10001) { -1 } }

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

    println(DP(0, X))
} // End of main

private fun DP(index: Int, totalLength: Int): Int {
    if (memo[index][totalLength] != -1) {
        return memo[index][totalLength]
    } else if (totalLength == 0) {
        return 1
    } else if (index == N) {
        return 0
    }

    memo[index][totalLength] = 0

    for (i in 0..pipeArr[index].quantity) {
        if (pipeArr[index].length * i <= totalLength) {
            memo[index][totalLength] += DP(index + 1, totalLength - pipeArr[index].length * i)
        }
    }

    return memo[index][totalLength]
} // End of DFS