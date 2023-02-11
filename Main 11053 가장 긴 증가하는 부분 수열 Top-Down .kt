import java.io.*
import java.util.*

private lateinit var memo : IntArray
private lateinit var arr : IntArray

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\DP 부수기\\res\\11053.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var A = br.readLine().toInt()
    memo = IntArray(A)
    arr = IntArray(A)

    val st = StringTokenizer(br.readLine())
    for(i in 0 until A) arr[i] = st.nextToken().toInt()

    for(i in 0 until A) DP(i)

    var max = memo[0]
    for(i in 1 until A) max = Math.max(max, memo[i])

    print(max)
} // End of main

private fun DP(N : Int) : Int{

    if(memo[N] == 0) {
        memo[N] = 1

        for(i in N-1 downTo 0) {
            if(arr[i] < arr[N]) memo[N] = Math.max(memo[N], DP(i)+1)
        }
    }

    return memo[N]
} // End of DP