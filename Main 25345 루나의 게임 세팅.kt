import java.util.*
import java.io.*

private const val mod = 1000000007
private lateinit var memo : Array<IntArray>
fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\정수론 & 조합론 부수기\\res\\25345.txt"
    val br = BufferedReader(File(path).bufferedReader())
    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()
    memo = Array(2001){IntArray(2001)}

    DP(N)
    var comb = memo[N][K]
    for(i in 1 until K) comb = comb * 2 % mod
    print(comb)
} // End of main

private fun DP(N : Int) {
    for(i in 0..N) {
        memo[i][0] = 1
        for(j in 1..i) memo[i][j] = (memo[i-1][j-1] + memo[i-1][j]) % mod
    }
} // End of DP