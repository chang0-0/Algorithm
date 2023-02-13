import java.util.*
import java.io.*

private lateinit var arr : IntArray
private lateinit var memo : IntArray

fun main() {
    val path = "C:\\Users\\Samsung\\Desktop\\코틀린 알고리즘\\src\\main\\kotlin\\DP 부수기\\res\\1912.txt"
    val br = BufferedReader(File(path).bufferedReader())

    var N = br.readLine().toInt()
    arr = IntArray(N)
    memo = IntArray(N)

    val st = StringTokenizer(br.readLine())
    for(i in 0 until N) arr[i] = st.nextToken().toInt()

    memo[0] = arr[0]
    var max = arr[0]

    for(i in 1 until N) {
        memo[i] = Math.max(memo[i-1] + arr[i], arr[i])

        max = Math.max(max, memo[i])
    }

    print(max)
} // End of main